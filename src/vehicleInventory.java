import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class vehicleInventory {
    public static void main(String[] args) {
        System.out.println("** Welcome to the Vehicle Inventory Manager! **");
        System.out.println("");
        try {
            while (true) { //create while loop to ask for user input and execute desired task
                System.out.println("Enter one of the following options: 'Add', 'Update', 'Remove', 'Get Info'; to end: 'Done'"); //Asks for user input
                Scanner scan = new Scanner(System.in);
                String userCommand = scan.nextLine();

                if (userCommand.equalsIgnoreCase("Add")) { //executes addVehicle method and adds a new vehicle to the inventory (arraylist)
                    Automobile.addVehicle();
                } else if (userCommand.equalsIgnoreCase("Update")) { //executes updateVehicle method and updates a vehicle from the inventory (arraylist)
                    Automobile.updateVehicle();
                } else if (userCommand.equalsIgnoreCase("Remove")) { //executes removeVehicle method and removes a vehicle from the inventory (arraylist)
                    Automobile.removeVehicle();
                } else if (userCommand.equalsIgnoreCase("Get Info")) { //executes getInventory method and lists all the vehicles in the inventory (arraylist)
                    Automobile.getInventory();
                } else if (userCommand.equalsIgnoreCase("Done")) { //end the program if Done is input by the user
                    break;
                } else {
                    System.out.println("Please enter a valid input.");
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        // Ask if the user wants to print the information to a file
        try {
            System.out.print("Do you want to print the information to a file? (Y/N): ");
            Scanner scnr = new Scanner(System.in);
            String answer = scnr.next();

            if (answer.equalsIgnoreCase("Y")) {
                Automobile.printFile();
            } else {
                System.out.println("File will not be printed.");
            }
        } catch (Exception exception) {
            System.out.println("An error occurred: " + exception.getMessage());
        }
    }
}
