package exercise_3.model;
import java.util.Objects;

public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private double price;
    private boolean isAvailable;

    public Vehicle(int id, String brand, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.isAvailable = true;
    }

    public void rent() { this.setAvailable(false); }

    public void returnVehicle() { this.setAvailable(true); }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void printDetails() {
        System.out.println("Number: " + this.id + " Brand: " + this.brand + " Model: " + this.model);
    }
}

