package shelter;

public class Pet {
	private int id;
	private String type;
	private String name;
	private int age;
	private String breed;
	private String description;
	private boolean shots;
	private boolean goodWithKids;
	private boolean interest;
	private String interestName;
	private int interestPhoneNum;
	private String interestEmail;
		
	public Pet(int id, String name, String type, int age, String breed, String description, boolean shots, boolean goodWithKids) {
		super();
		
		this.id = id;
		this.type = type;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.description = description;
		this.shots = shots;
		this.goodWithKids = goodWithKids;
		this.interest = false;
		this.interestName = null;
		this.interestPhoneNum = 0;
		this.interestEmail = null;
	}
	
	public Pet(int id, String name, String type, int age, String breed, String description, boolean shots, boolean goodWithKids, 
	  boolean interest, String interestName, int interestPhoneNum, String interestEmail) {
		super();
		
		this.id = id;
		this.type = type;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.description = description;
		this.shots = shots;
		this.goodWithKids = goodWithKids;
		this.interest = interest;
		this.interestName = interestName;
		this.interestPhoneNum = interestPhoneNum;
		this.interestEmail = interestEmail;
	}
	
	public void setShots(boolean shots) {
		this.shots = shots;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGoodWithKids(boolean goodWithKids) {
		this.goodWithKids = goodWithKids;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}

	public void setInterestPhoneNum(int interestPhoneNum) {
		this.interestPhoneNum = interestPhoneNum;
	}

	public void setInterestEmail(String interestEmail) {
		this.interestEmail = interestEmail;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getBreed() {
		return breed;
	}

	public String getDescription() {
		return description;
	}

	public boolean hasShots() {
		return shots;
	}

	public boolean isGoodWithKids() {
		return goodWithKids;
	}

	public boolean hasInterest() {
		return interest;
	}
	
	public void setInterest(boolean interest) {
		this.interest = interest;
	}

	public String getInterestName() {
		return interestName;
	}

	public int getInterestPhoneNum() {
		return interestPhoneNum;
	}

	public String getInterestEmail() {
		return interestEmail;
	}
	
	public void adoptionRequest(String name, int PhoneNum, String email) {
		if (!interest) {
			this.interest = true;
			this.interestName = name;
			this.interestPhoneNum = PhoneNum;
			this.interestEmail = email;	
		}
	}
}
