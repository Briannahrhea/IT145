
public class Monkey extends RescueAnimal {
	private String species, tailLength, height, bodyLength;
	// constructor extends from parent class
	public Monkey() {}
	
	public Monkey(String name, String gender, String age, String weight, String species, String tail, String height, String bodyLength, String acquisitionDate, String acquisitionCountry, String train, boolean reserve, String serviceCountry) {
		super();
		super.setName(name);
		super.setAnimalType("Monkey");
		super.setGender(gender);
		super.setAge(age);
		super.setWeight(weight);
		super.setAcquisitionDate(acquisitionDate);
		super.setAcquisitionLocation(acquisitionCountry);
		super.setTrainingStatus(train);
		super.setReserved(reserve);
		super.setInServiceCountry(serviceCountry);;
		// super.set refer to parent class RescueAnimal
		this.species = species;
		this.tailLength = tail;
		this.height = height;
		this.bodyLength = bodyLength;
		// this. are attributes to monkey only
	}
	// accessors and mutators to get and set data
	public String getSpecies() {
		return species;
	}
	
	public void setSpecies(String monkeySpecies) {
		species = monkeySpecies;
	}
	
	public String getTailLength() {
		return tailLength;
	}
	
	public void setTailLength(String monkeyTailLength) {
		tailLength = monkeyTailLength;
	}
	
	public String getHeight() {
		return height;
	}
	
	public void setHeight(String monkeyHeight) {
		height = monkeyHeight;
	}
	
	public String getBodyLength() {
		return bodyLength;
	}
	
	public void setBodyLength(String monkeyBodyLength) {
		bodyLength = monkeyBodyLength;
	}
	
}

