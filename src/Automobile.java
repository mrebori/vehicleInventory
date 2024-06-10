import javax.swing.*;
import java.io.FileWriter;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Exception.*;

public class Automobile { //default constructor
    public static int itemNumber;
    private static String VIN;
    private static String make;
    private static String model;
    private static String color;
    private static int year;
    private static int mileage;
    public static int nextID;

    //parameterized Constructor
    public Automobile(int itemNumber, String VIN, String make, String model, String color, int year, int mileage) {
        this.itemNumber = itemNumber;
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    static ArrayList<Object> carInventory = new ArrayList<>();

    static Automobile car = new Automobile(itemNumber, VIN, make, model, color, year, mileage);

    static Scanner scn = new Scanner(System.in);

    // adds a new vehicle
    public static String addVehicle() {
        try {
            System.out.println("Please enter the following information:");
            System.out.println("VIN: ");
            VIN = scn.nextLine();
            System.out.println("Make: ");
            make = scn.nextLine();
            System.out.println("Model: ");
            model = scn.nextLine();
            System.out.println("Color: ");
            color = scn.nextLine();
            System.out.println("Year: ");
            year = scn.nextInt();
            System.out.println("Mileage: ");
            mileage = scn.nextInt();
            itemNumber = nextID;
            nextID = 1;
            nextID++;
            int i = 0;

            carInventory.add(car);
            System.out.println(carInventory.get(i));

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "Vehicle added successfully to inventory.";
    }

    //print vehicles in inventory
    public static void getInventory() {  // lists vehicle information)
        try {
            if (carInventory.isEmpty()) {
                System.out.println("No vehicles stored in the inventory,");
            } else {
                for (Object auto : carInventory) {
                    System.out.println(auto);
                    System.out.println(" ");
                }
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    //remove a vehicle
    public static String removeVehicle() {
        try {
            while (true) {
                Scanner itemID = new Scanner(System.in);

                System.out.println("Please enter the Item Number of the vehicle you wish to remove.");
                System.out.println("Item Number: ");

                int itemId = itemID.nextInt();

                if (itemId == (car.itemNumber)) {
                    Automobile.carInventory.remove(car);
                    System.out.println("Vehicle removed successfully.");
                    break;
                } else {
                    System.out.println("Item not found. Please enter valid item number");
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "Vehicle removed successfully.";
    }

    // updates vehicle attributes
    public static String updateVehicle() {
        try {
            System.out.println("Please enter the item number of the vehicle you wish to update.");
            System.out.println("Item #: ");
            itemNumber = scn.nextInt();

            System.out.println("Please enter the following information:");

            System.out.println("VIN: ");
            VIN = scn.nextLine();

            System.out.println("Make: ");
            make = scn.nextLine();

            System.out.println("Model: ");
            model = scn.nextLine();

            System.out.println("Color: ");
            color = scn.nextLine();

            System.out.println("Year: ");
            year = scn.nextInt();

            System.out.println("Mileage: ");
            mileage = scn.nextInt();

            carInventory.add(String.valueOf(itemNumber - 1));

            System.out.println(car);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "Vehicle updated successfully.";
    }

    public static void printFile() {
        try {
            FileWriter writer = new FileWriter("C:\\Documents\\VehicleInventory.txt");
            {
                for (Object Automobile : carInventory) {
                writer.write(Automobile.toString() + System.lineSeparator());
                System.out.println("Inventory has been printed to " + "C:\\Documents\\VehicleInventory.txt");
            }
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
