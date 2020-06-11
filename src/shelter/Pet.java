package shelter;

public class Pet {
	private int petID;
	private String type;
	private String name;
	private int age;
	private String breed;
	private String description;
	private boolean shots;
	private String medicalIssues;
	private boolean goodWithKids;
	//private String image;
	private boolean interestForAdoption;
	private String interestName;
	private int interestPhoneNumber;
	private String interestEmailAddress;
	
	private int lastID = -1;
	
	public Pet(String name, String type, int age, String breed, String description, boolean shots, boolean goodWithKids/*, String image*/) {
		super();
		this.petID = lastID++;
		this.type = type;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.description = description;
		this.shots = shots;
		this.goodWithKids = goodWithKids;
		this.interestForAdoption = false;
		this.interestName = null;
		this.interestPhoneNumber = 0;
		this.interestEmailAddress = null;
	}
	
	public void setShots(boolean shots) {
		this.shots = shots;
	}

	public void setPetID(int petID) {
		this.petID = petID;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMedicalIssues(String medicalIssues) {
		this.medicalIssues = medicalIssues;
	}

	public void setGoodWithKids(boolean goodWithKids) {
		this.goodWithKids = goodWithKids;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}

	public void setInterestPhoneNumber(int interestPhoneNumber) {
		this.interestPhoneNumber = interestPhoneNumber;
	}

	public void setInterestEmailAddress(String interestEmailAddress) {
		this.interestEmailAddress = interestEmailAddress;
	}

	public int getPetID() {
		return petID;
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

	public String getMedicalIssues() {
		return medicalIssues;
	}

	public boolean isGoodWithKids() {
		return goodWithKids;
	}

	public boolean hasInterestForAdoption() {
		return interestForAdoption;
	}
	
	public void setInterest(boolean interest) {
		this.interestForAdoption = interest;
	}

	public String getInterestName() {
		return interestName;
	}

	public int getInterestPhoneNumber() {
		return interestPhoneNumber;
	}

	public String getInterestEmailAddress() {
		return interestEmailAddress;
	}
	
	public void adoptionRequest(String name, int phoneNumber, String emailAddress) {
		this.interestForAdoption = true;
		this.interestName = name;
		this.interestPhoneNumber = phoneNumber;
		this.interestEmailAddress = emailAddress;
	}
}
