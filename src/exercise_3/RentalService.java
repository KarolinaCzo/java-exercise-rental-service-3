package exercise_3;
import exercise_3.model.Vehicle;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RentalService {
    private String name;
    private String address;
    private Collection<Vehicle> stock;

    public RentalService(String name, String address, Collection<Vehicle> stock) {
        this.name = name;
        this.address = address;
        this.stock = stock;
    }

    public void run() {
        // Using Scanner to get input from user
        Scanner input = new Scanner(System.in);

        // User input
        int userInput = -1;

        // Car rental menu
        System.out.println("Menu \n" +
                "0 - exit \n" +
                "1 - print available cars \n" +
                "2 - rent a car \n" +
                "3 - return a car \n" +
                "4 - print rented cars \n");
        System.out.println("Please provide one of the numbers above: \n");

        while (userInput != 0) {
            try {
                userInput = input.nextInt();

                switch (userInput) {
                    case 0:
                        System.out.println("Bye");
                        break;
                    case 1:
                        printAvailableCars();
                        break;
                    case 2:
                        rentACar();
                        break;
                    case 3:
                        returnACar();
                        break;
                    case 4:
                        printRentedCars();
                        break;
                    case 5:
                        System.out.println("Option 5");
                        break;
                    default:
                        System.out.println("Option " + userInput + " is not available. " + "Please choose one of the following: \n" +
                                "0 - exit \n" +
                                "1 - print available cars \n" +
                                "2 - rent a car \n" +
                                "3 - return a car \n" +
                                "4 - print rented cars \n");
                }
            } catch (Exception exception){
                System.out.println("Invalid input. Please provide a number: \n");
                input.next();
            }
        }
    }

    public void printAvailableCars() {
        Collection<Vehicle> availableCars = stock.stream()
                .filter(Vehicle::isAvailable)
                .collect(Collectors.toList());
        if (availableCars.size() == 0) {
            System.out.println("No cars available.");
        } else {
            System.out.println("Available cars:");
            availableCars.forEach(it -> it.printDetails());
        }
    }

    public void rentACar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Provide the number of car you want to rent: ");
        int carId = input.nextInt();
        try {
        Collection<Vehicle> availableCars = stock.stream()
                .filter(Vehicle::isAvailable)
                .collect(Collectors.toList());
        Optional<Vehicle> foundCar = availableCars.stream().filter(it -> it.getId() == carId).findAny();

            foundCar.get().rent();
            System.out.println("You rented a car!");
        } catch (Exception exception){
            System.out.println("Car with provided number doesn't exist.");
        }
    }

    public void returnACar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Provide the number of a car you wish to return: ");
        int carId = input.nextInt();
        try{
        Collection<Vehicle> rentedCars = stock.stream()
                .filter(vehicle -> !vehicle.isAvailable())
                .collect(Collectors.toList());
        Optional<Vehicle> foundCar = rentedCars.stream().filter(it -> it.getId() == carId).findAny();

            foundCar.get().returnVehicle();
            System.out.println("You returned a car!");
        } catch(Exception exception) {
            System.out.println("Car with provided number doesn't exist or wasn't rented.");
        }
    }

    public void printRentedCars() {
        Collection<Vehicle> rentedCars = stock.stream()
                .filter(vehicle -> !vehicle.isAvailable())
                .collect(Collectors.toList());
        if (rentedCars.size() == 0) {
            System.out.println("No cars were rented.");
        } else {
            System.out.println("Rented cars:");
            rentedCars.forEach(it -> it.printDetails());
        }
    }
}
