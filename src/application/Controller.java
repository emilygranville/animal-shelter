package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.Pet;
import shelter.PetDAO;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PetDAO dao;
  
	public void init() {
	    final String url = getServletContext().getInitParameter("JDBC-URL");
	    final String username = getServletContext().getInitParameter("JDBC-USERNAME");
	    final String password = getServletContext().getInitParameter("JDBC-PASSWORD");
	
	    dao = new PetDAO(url, username, password);
	}
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		doGet(request, response);
	}
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		final String action = request.getServletPath();
  	
		try {
			switch (action) {
				case "/add":
				case "/edit":
					showEditForm(request, response); break;
				case "/insert":
					insertPet(request, response); break;
				case "/update":
					updatePet(request, response); break;
				default:
					viewPets(request, response); break;
			}   
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	private void insertPet(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
	  
	    String name = request.getParameter("name");
	    String type = request.getParameter("type");
	    int age = Integer.parseInt(request.getParameter("age").trim());
	    String breed = request.getParameter("breed");
	    String description = request.getParameter("description");
	    boolean shots = Boolean.parseBoolean(request.getParameter("shots"));
	    boolean goodWithKids = Boolean.parseBoolean(request.getParameter("goodWithKids"));
	    boolean interest = Boolean.parseBoolean(request.getParameter("interest"));
	    if (interest) {
	    	String interestName = request.getParameter("interestName");
		    Integer interestPhoneNum = Integer.parseInt(request.getParameter("interestPhoneNum").trim());
		    String interestEmail = request.getParameter("interestEmail");
		  	
		    if (interestName == null || interestPhoneNum == null || interestEmail == null) {
		    	dao.insertPet(name, type, age, breed, description, shots, goodWithKids, interest);
		    } else {
		    	dao.insertPet(name, type, age, breed, description, shots, goodWithKids, interest, 
		    	  interestName, interestPhoneNum.intValue(), interestEmail);
		    }
	    } else {
	    	dao.insertPet(name, type, age, breed, description, shots, goodWithKids, interest);
	    }
	    
	    response.sendRedirect(request.getContextPath() + "/");
	}
  
	private void viewPets(HttpServletRequest request, HttpServletResponse response)
	  throws SQLException, ServletException, IOException {
		List<Pet> pets = dao.getPets();
		request.setAttribute("pets", pets);
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("inventory.jsp");
		dispatcher.forward(request, response);
	}
 
	private void updatePet(HttpServletRequest request, HttpServletResponse response)
	  throws SQLException, ServletException, IOException {
		
		final String action = request.getParameter("subaction") != null ? request.getParameter("subaction")
		: request.getParameter("submit").toLowerCase();
		
		switch (action) {
			case "adoption_request":
			    final int adoptionId = Integer.parseInt(request.getParameter("id"));
			    final String interestName = request.getParameter("interestName");
			    final int interestPhone = Integer.parseInt(request.getParameter("interestPhoneNum"));
			    final String interestEmail = request.getParameter("interestEmail");
	
			    System.out.println("Adopting a Pet");
			    System.out.println(adoptionId);
			    System.out.println(interestName);
			    System.out.println(interestPhone);
			    System.out.println(interestEmail);
			    
			    Pet adoptionPet = dao.getPet(adoptionId);
			    adoptionPet.adoptionRequest(interestName, interestPhone, interestEmail);
			    dao.updatePetInterest(adoptionPet);
			    
			    break;
			case "save":
			    final int saveId = Integer.parseInt(request.getParameter("id"));
			    final String name = request.getParameter("name");
			    final String type = request.getParameter("type");
			    final int age = Integer.parseInt(request.getParameter("age"));
			    final String breed = request.getParameter("breed");
			    final String description = request.getParameter("description");
			    final boolean shots = Boolean.parseBoolean(request.getParameter("shots"));
			    final boolean kidFriendly = Boolean.parseBoolean(request.getParameter("goodWithKids"));
			    final boolean hasInterest = Boolean.parseBoolean(request.getParameter("interest"));
	
			    System.out.println("Saving a Pet");
			    System.out.println(saveId);
			    System.out.println(name);
			    System.out.println(type);
			    System.out.println(age);
			    System.out.println(breed);
			    System.out.println(description);
			    System.out.println(shots);
			    System.out.println(kidFriendly);
			    System.out.println(hasInterest);
			    
			    Pet savePet = dao.getPet(saveId);
			    savePet.setName(name);
			    savePet.setType(type);
			    savePet.setAge(age);
			    savePet.setBreed(breed);
			    savePet.setDescription(description);
			    savePet.setShots(shots);
			    savePet.setGoodWithKids(kidFriendly);
			    savePet.setInterest(hasInterest);
			    
			    dao.updatePet(savePet);
			    if (!hasInterest) {
			    	savePet.adoptionRemoval();
			    	dao.updatePetInterest(savePet);
			    }
			    
			    break;
			case "delete":
			    final int deleteId = Integer.parseInt(request.getParameter("id"));
	
			    System.out.println("Deleting a Pet");
			    System.out.println(deleteId);
			    
			    deletePet(deleteId, request, response);
		}
		    //dao.updatePet(pet);
		    response.sendRedirect(request.getContextPath() + "/");
	}
		    
	private void deletePet(final int id, HttpServletRequest request, HttpServletResponse response)
	  throws SQLException, ServletException, IOException {	
		dao.deletePet(dao.getPet(id));	
		response.sendRedirect(request.getContextPath() + "/");
	}
  
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	  throws SQLException, ServletException, IOException {
		try {
			final int id = Integer.parseInt(request.getParameter("id").trim());
		    
		    Pet pet = dao.getPet(id);
		    request.setAttribute("pet", pet);
		} finally {
		
			final String action = request.getParameter("action");
			if (action == null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("petform.jsp");
			    dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("interestinfo.jsp");
			    dispatcher.forward(request, response);
			}
		}
	}
}


