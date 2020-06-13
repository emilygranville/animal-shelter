package shelter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
	private final String url;
	private final String username;
	private final String password;
	
	public PetDAO(String url, String username, String password) {
		super();
	    
	    this.url = url;
	    this.username = username;
	    this.password = password;
	}
	
	public Pet getPet(int id) throws SQLException {
		final String sql = "SELECT * FROM pets WHERE pet_id = ?";
		
		Pet pet = null;
		Connection conn = getConnection();
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    
	    pstmt.setInt(1, id);
	    ResultSet rs = pstmt.executeQuery();
	    
	    if (rs.next()) {
	        String name = rs.getString("name");
	        String type = rs.getString("type");
	        int age = rs.getInt("age");
	        String breed = rs.getString("breed");
	        String description = rs.getString("description");
	        boolean shots = rs.getBoolean("shots");
	        boolean good_with_kids = rs.getBoolean("good_with_kids");
	        boolean interest = rs.getBoolean("interest");
	        String interestName = rs.getString("interest_name");
	        int interestPhoneNum = rs.getInt("interest_phone_num");
	        String interestEmail = rs.getString("interest_email_address");
	        
	        pet = new Pet(id, name, type, age, breed, description, shots, good_with_kids, interest,
	  	      interestName, interestPhoneNum, interestEmail);
	      }
	      
	      rs.close();
	      pstmt.close();
	      conn.close();
	      
	      return pet;
	}
	
	public List<Pet> getPets() throws SQLException {
		final String sql = "SELECT * FROM pets ORDER BY pet_id ASC";
		
		List<Pet> pets = new ArrayList<Pet>();
	    Connection conn = getConnection();
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    while (rs.next()) {
	        int id = rs.getInt("pet_id");
	        String name = rs.getString("name");
	        String type = rs.getString("type");
	        int age = rs.getInt("age");
	        String breed = rs.getString("breed");
	        String description = rs.getString("description");
	        boolean shots = rs.getBoolean("shots");
	        boolean good_with_kids = rs.getBoolean("good_with_kids");
	        boolean interest = rs.getBoolean("interest");
	        String interestName = rs.getString("interest_name");
	        int interestPhoneNum = rs.getInt("interest_phone_num");
	        String interestEmail = rs.getString("interest_email_address");
	        
	        pets.add(new Pet(id, name, type, age, breed, description, shots, good_with_kids, interest,
	          interestName, interestPhoneNum, interestEmail));
	      }
	      
	      rs.close();
	      stmt.close();
	      conn.close();
	      
	      return pets;
	}
	
	public boolean insertPet(Pet pet) throws SQLException {
		final String sql = "INSERT INTO pets (name, type, age, breed, description, shots, " +
		  "good_with_kids, interest, interest_name, interest_phone_num, interest_email_address) " +
		  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    
	    Connection conn = getConnection();
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    
	    pstmt.setString(1, pet.getName());
	    pstmt.setString(2, pet.getType());
	    pstmt.setInt(3, pet.getAge());
	    pstmt.setString(4, pet.getBreed());
	    pstmt.setString(5, pet.getDescription());
	    pstmt.setBoolean(6, pet.hasShots());
	    pstmt.setBoolean(7, pet.isGoodWithKids());
	    pstmt.setBoolean(8, pet.hasInterest());
	    pstmt.setString(9, pet.getInterestName());
	    pstmt.setInt(10, pet.getInterestPhoneNum());
	    pstmt.setString(11, pet.getInterestEmail());
	    int affected = pstmt.executeUpdate();
	    
	    pstmt.close();
	    conn.close();
	    
	    return affected == 1;
	}
	
	public boolean insertPet(String name, String type, int age, String breed,
	  String description, boolean shots, boolean goodWithKids, boolean interest, 
	  String interestName, int interestPhoneNum, String interestEmail)
	  throws SQLException {
		final String sql = "INSERT INTO pets (name, type, age, breed, description, shots, " +
		  "good_with_kids, interest, interest_name, interest_phone_num, interest_email_address) " +
		  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    
	    Connection conn = getConnection();
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    
	    pstmt.setString(1, name);
	    pstmt.setString(2, type);
	    pstmt.setInt(3, age);
	    pstmt.setString(4, breed);
	    pstmt.setString(5, description);
	    pstmt.setBoolean(6, shots);
	    pstmt.setBoolean(7, goodWithKids);
	    pstmt.setBoolean(8, interest);
	    pstmt.setString(9, interestName);
	    pstmt.setInt(10, interestPhoneNum);
	    pstmt.setString(11, interestEmail);
	    int affected = pstmt.executeUpdate();
	    
	    pstmt.close();
	    conn.close();
	    
	    return affected == 1;
	}
	
	public boolean updatePet(Pet pet) throws SQLException {
		final String sql = "UPDATE pets SET name = ?, type = ?, age = ?, breed = ?, " +
		  "description = ?, shots = ?, good_with_kids = ?, interest = ?, interest_name = ?, " +
		  "interest_phone_num = ?, interest_email_address = ? " +
		  "WHERE book_id = ?";
		
		Connection conn = getConnection();
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, pet.getName());
	    pstmt.setString(2, pet.getType());
	    pstmt.setInt(3, pet.getAge());
	    pstmt.setString(4, pet.getBreed());
	    pstmt.setString(5, pet.getDescription());
	    pstmt.setBoolean(6, pet.hasShots());
	    pstmt.setBoolean(7, pet.isGoodWithKids());
	    pstmt.setBoolean(8, pet.hasInterest());
	    pstmt.setString(9, pet.getInterestName());
	    pstmt.setInt(10, pet.getInterestPhoneNum());
	    pstmt.setString(11, pet.getInterestEmail());
	    int affected = pstmt.executeUpdate();
	    
	    pstmt.close();
	    conn.close();
	    
	    return affected == 1;
	}
	
	public boolean deletePet(Pet pet) throws SQLException {
		final String sql = "DELETE FROM pets WHERE pet_id = ?";
		
		Connection conn = getConnection();
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    
	    pstmt.setInt(1, pet.getId());
	    int affected = pstmt.executeUpdate();
	    
	    pstmt.close();
	    conn.close();
	    
	    return affected == 1;
	}
	
	private Connection getConnection() throws SQLException {
		final String driver = "com.mysql.cj.jdbc.Driver";
	    
	    try {
	      Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    
	    return DriverManager.getConnection(url, username, password);
	}
}
