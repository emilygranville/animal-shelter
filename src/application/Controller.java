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
		
		final String action = request.getParameter("action") != null
		  ? request.getParameter("action")
		  : request.getParameter("submit").toLowerCase();
	  
		  
		final int id = Integer.parseInt(request.getParameter("id").trim());
			
		Pet pet = dao.getPet(id);
		switch (action) {
//			case "adoption_request":
//				String interestName = "";
//		    	int interestPhoneNum = 0;
//		    	String interestEmail = "";
//		    	pet.adoptionRequest(interestName, interestPhoneNum, interestEmail);
//		    	break;
		    case "save":
		    	String name = request.getParameter("name");
				String type = request.getParameter("type");
				int age = Integer.parseInt(request.getParameter("age"));
				String breed = request.getParameter("breed");
				String description = request.getParameter("description");
				boolean shots = Boolean.parseBoolean(request.getParameter("shots"));
				boolean good_with_kids = Boolean.parseBoolean(request.getParameter("goodWithKids"));
				boolean interest = Boolean.parseBoolean(request.getParameter("interest"));
				String interestName = request.getParameter("interestName");
				int interestPhoneNum = Integer.parseInt(request.getParameter("interestPhoneNum"));
				String interestEmail = request.getParameter("interestEmail");
								
				pet.setName(name);
				pet.setType(type);
				pet.setAge(age);
				pet.setBreed(breed);
				pet.setDescription(description);
				pet.setShots(shots);
				pet.setGoodWithKids(good_with_kids);
				pet.setInterest(interest);
				pet.setInterestPhoneNum(interestPhoneNum);
				pet.setInterestName(interestName);
				pet.setInterestEmail(interestEmail);
		      
				break;
		    case "delete":
		    	deletePet(id, request, response);
		    	return;
		}

		    dao.updatePet(pet);
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
		    RequestDispatcher dispatcher = request.getRequestDispatcher("petform.jsp");
		    dispatcher.forward(request, response);
		  }
	}
}


