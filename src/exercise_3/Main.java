// Aplikacja: wypożyczalnia aut

package exercise_3;
import exercise_3.model.Car;
import exercise_3.model.Vehicle;
import java.util.ArrayList;
import java.util.Collection;


public class Main {

    private static Collection<Vehicle> createVehicles() {
        Vehicle ford = new Car(100,"Ford", "Fiesta", 49.600 );
        Vehicle mazda = new Car(101,"Mazda", "6", 117.900 );
        Vehicle toyota = new Car(102,"Toyota", "Corolla", 77.900 );
        Vehicle honda = new Car(103,"Honda", "Civic", 78.200 );
        Vehicle hyundai = new Car(104,"Hyundai", "Tucson", 91.300 );
        Vehicle chevrolet = new Car(105,"Chevrolet", "Camaro", 199.900 );
        ArrayList<Vehicle> vehicleCollection = new ArrayList<>();
        vehicleCollection.add(ford);
        vehicleCollection.add(mazda);
        vehicleCollection.add(toyota);
        vehicleCollection.add(honda);
        vehicleCollection.add(hyundai);
        vehicleCollection.add(chevrolet);
        return vehicleCollection;
    }

    public static void main(String[] args) {
        // Create rental service
        Collection<Vehicle> rentalStock = createVehicles();
        RentalService cars4Rent = new RentalService("Cars4Rent", "Białystok", rentalStock);

        // Run rental service menu
        cars4Rent.run();
    }
}

