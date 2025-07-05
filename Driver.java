import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Instance variables (if needed)
    private static ArrayList <Monkey> monkeyList = new ArrayList<>();
    // add monkey species
        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    
    // while loop for menu items, input.nextInt() accesses user input and assigns choice to action
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		initializeDogList();
		initializeMonkeyList();

		while (true) {
			displayMenu();
			String userInput = input.nextLine();

			if (userInput.equals("1")) {
				intakeNewDog(input);
			} else if (userInput.equals("2")) {
				intakeNewMonkey(input);
			} else if (userInput.equals("3")) {
				reserveAnimal(input);
			} else if (userInput.equals("4")) {
				printAnimals("dog");
			} else if (userInput.equals("5")) {
				printAnimals("monkey");
			} else if (userInput.equals("6")) {
				printAnimals("available");
			} else if (userInput.equalsIgnoreCase("q")) {
				System.out.println("Exiting application...");
				System.exit(0);
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}


    	
    
    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    // followed structure of DogList above, input monkey for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("George", "male", "5", "25", "Capuchin", "12", "12", "12", "11 April 2023", "USA", "reserved", true, "United States");
    	
    	monkeyList.add(monkey1);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
        // used attributes from Dog.java to create list
        System.out.print("Breed: ");
    	String breed = scanner.nextLine();
    	
    	System.out.print("Gender (male/female): ");
    	String gender = scanner.nextLine();
    	
    	System.out.print("Age (in years): ");
    	String age = scanner.nextLine();
    	
    	System.out.print("Weight: ");;
    	String weight = scanner.nextLine();
    	
    	System.out.print("Acquisition date: ");
    	String acqDate = scanner.nextLine();
    	
    	System.out.print("Acquisition country: ");
    	String country1 = scanner.nextLine();
    	
    	System.out.print("Training status: ");
    	String status = scanner.nextLine();
    	
    	System.out.print("Reserved (1 for true, 0 for false): ");
    	String choice = scanner.nextLine();
    	boolean reserved;
    	if(choice.equals("1"))
    		reserved = true;
    	else
    		reserved = false;
    	// boolean above refers back to choice options, choice 1 intakes new dog; rest do not apply
    	
    	System.out.println("In service country: ");
    	String country2 = scanner.nextLine();
    	// add entries and new dog to list, notify user of update
    	Dog newDog = new Dog(name, breed, gender, age, weight, acqDate, country1, status, reserved, country2);
    	dogList.add(newDog);
    	System.out.println("Your entry has been added to the dog list.");
    }

    	// same structure as above with modifications implementing Monkey.java attributes
        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("Name: ");
            String name = scanner.nextLine();
            
            for(Monkey monkey: monkeyList) {
            	if(monkey.getName().equalsIgnoreCase(name)) {
            		System.out.println("\n\nThis Monkey is already in our system\n\n");
            		return;
            	}
            }
            System.out.print("Gender: ");
        	String gender = scanner.nextLine();
        	
        	System.out.print("Age: ");
        	String age = scanner.nextLine();
        	
        	System.out.print("Weight: ");;
        	String weight = scanner.nextLine();
        	
        	System.out.print("Species: ");
        	String species = scanner.nextLine();
        	
        	System.out.print("Tail Length: ");
        	String tailLength = scanner.nextLine();
        	
        	System.out.print("Height: ");
        	String height = scanner.nextLine();
        	
        	System.out.print("Body Length: ");
        	String bodyLength = scanner.nextLine();
        	
        	System.out.print("Acquisition date: ");
        	String acqDate = scanner.nextLine();
        	
        	System.out.print("Acquisition country: ");
        	String country1 = scanner.nextLine();
        	
        	System.out.print("Training status: ");
        	String status = scanner.nextLine();
        	
        	System.out.print("Reserved (1 for true, 0 for false): ");
        	String choice = scanner.nextLine();
        	boolean reserved;
        	if(choice.equals("1"))
        		reserved = true;
        	else
        		reserved = false;
        	
        	System.out.println("In service country: ");
        	String country2 = scanner.nextLine();
        // add entries and monkey to list, notify user of updated entry
        	Monkey newMonkey = new Monkey(name, gender, age, weight, species, tailLength, height, bodyLength, acqDate, country1, status, reserved, country2);
        	monkeyList.add(newMonkey);
            System.out.println("Your entry has been added to the monkey list.");
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Dog or Monkey: ");
            String input = scanner.nextLine();
            
            System.out.println("Service country: ");
            String serviceCountry = scanner.nextLine();
            
            if(input.equalsIgnoreCase("dog")) {
            	int flag = 0;      
            			
				for(Dog dog: dogList) {
            		if(dog.getInServiceLocation().equalsIgnoreCase(serviceCountry)) {
            			if(! dog.getReserved()) {
            				dog.setReserved(true);;
            				System.out.println("Dog " + dog.getName() + " is now reserved");
            				flag = 1;
            			}
            		}
				}
				if(flag ==0)
					System.out.println("No dogs found to reserve");
            }
            else if (input.equalsIgnoreCase("monkey")) {
            	int flag = 0;
				// monkey reservation is not working the way it should, UPDATE resolved did not initialize monkey flag
            	for(Monkey monkey: monkeyList) {
            		if(monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry)) {
            			if(! monkey.getReserved()) {
            				monkey.setReserved(true);
            				System.out.println("Monkey " + monkey.getName() + " is now reserved");
            				flag = 1;
            			}
            		}
            	}
            	if(flag == 0)
            		System.out.println("No animal found to reserve");
            }
            else {
            	System.out.println("Wrong animal type");
            }

        }
      
            			

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String listType) {
        	if(listType.equalsIgnoreCase("dog")) {
        		for(Dog dog: dogList) {
        			System.out.println("Dog Name: " + dog.getName() + " Gender: " + dog.getGender() + " Age: " + dog.getAge() + " Weight: " + dog.getWeight() + "\nAcquisition Date: " + dog.getAcquisitionDate() + "\nAcquisition Country: " + dog.getAcquisitionLocation() + "\nReserved: " + dog.getReserved() + "\nTraining Status: " + dog.getTrainingStatus() + "\nService Country: " + dog.getInServiceLocation());
        			System.out.println("");
        		}
        	}
        	else 
        		if(listType.equalsIgnoreCase("monkey")) {
        			for(Monkey monkey: monkeyList) {
        				System.out.println("Monkey Name: " + monkey.getName() + " Gender: " + monkey.getGender() + " Age: " + monkey.getAge() + " Weight: " + monkey.getWeight() + "\nSpecies: " + monkey.getSpecies() + " Tail Length: " + monkey.getTailLength() + " Height: " + monkey.getHeight() + " Body Length: " + monkey.getBodyLength() + "\nAcquisition Date: " + monkey.getAcquisitionDate() + "\nAcquisition Location: " + monkey.getAcquisitionLocation() + "\nReserved: " + monkey.getReserved() + "\nTraining Status: " + monkey.getTrainingStatus() + "\nService country: " + monkey.getInServiceLocation());
        				System.out.println("");
        			}
        		}
        	else 
        		if(listType.equalsIgnoreCase("available")) {
        			for(Dog dog: dogList) { 
        				if(dog.getTrainingStatus().equalsIgnoreCase("in service") && (! dog.getReserved()))	 {
        					System.out.println("Dog " + dog.getName() + " Gender: " + dog.getGender() + " Age: " + dog.getAge() + " Weight: " + dog.getWeight() +  "\nAcquisition Date: " + dog.getAcquisitionDate() + "\nAcquisition Country: " + dog.getAcquisitionLocation() + "\nReserved: " + dog.getReserved() + "\nTraining Status: " + dog.getTrainingStatus() + "\nService Country: " + dog.getInServiceLocation());
        				}
        			}
        			for(Monkey monkey: monkeyList) {
        				if(monkey.getTrainingStatus().equalsIgnoreCase("in service") && (! monkey.getReserved())) { 
        					System.out.println("Monkey " + monkey.getName() + " Gender: " + monkey.getGender() + " Age: " + monkey.getAge() + " Weight: " + monkey.getWeight() + "\nSpecies: " + monkey.getSpecies() + " Tail Length: " + monkey.getTailLength() + " Height: " + monkey.getHeight() + " Body Length: " + monkey.getBodyLength() + "\nAcquisition Date: " + monkey.getAcquisitionDate() + "\nAcquisition Location: " + monkey.getAcquisitionLocation() + "\nReserved: " + monkey.getReserved() + "\nTraining Status: " + monkey.getTrainingStatus() + "\nService country: " + monkey.getInServiceLocation());
        				}
        			}
        		}
        		else {
        			System.out.println("Wrong list type");
        		}
        }
}

