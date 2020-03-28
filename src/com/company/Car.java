package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Car implements Cloneable {

    // Variables
    private String brand;
    private String model;
    private Colour colour;
    private int horsepower;
    private Gearbox gearbox;
    private boolean hasNavigationSystem;
    private int serialNumber;

    // Constructor
    public Car(String brand, String model, Colour colour, int horsepower,
               Gearbox gearbox, boolean hasNavigationSystem, int serialNumber) {
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.horsepower = horsepower;
        this.gearbox = gearbox;
        this.hasNavigationSystem = hasNavigationSystem;
        this.serialNumber = serialNumber;
    }

    // Methods
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setHasNavigationSystem(boolean hasNavigationSystem) {
        this.hasNavigationSystem = hasNavigationSystem;
    }

    public boolean isHasNavigationSystem() {
        return hasNavigationSystem;
    }

    public void orderDataBase (ArrayList<Car> cars, Car customCar) {
        Random randomSerialnumber = new Random();
        boolean inList = false;
        for (Car car : cars) {
            if (similarityCheck(car, customCar)) {
                try {
                    Car cloneCar = car.clone();
                    cloneCar.setSerialNumber(randomSerialnumber.nextInt((10000 - 1000) + 1) + 1000);
                    cars.add(cloneCar);
                    System.out.println("Similar car found in data base. Car cloned and added to data base.");
                    inList = true;
                    break;
                } catch (CloneNotSupportedException ex) {
                    System.out.println("Clone Error");
                }
            }
        }
        if (!inList) {
            customCar.setSerialNumber(randomSerialnumber.nextInt((10000 - 1000) + 1) + 1000);
            cars.add(customCar);
            System.out.println("Car added to data base.");
        }
    }

    public boolean similarityCheck(Car car, Car customCar) {
        return (car.getColour().equals(customCar.getColour()) && car.getHorsepower() == customCar.getHorsepower() &&
                car.getGearbox().equals(customCar.getGearbox()) &&
                car.isHasNavigationSystem() == customCar.isHasNavigationSystem());
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car)super.clone();
    }

    @Override
    public String toString() {
        return "brand= '" + brand + '\'' +
                ", model= '" + model + '\'' +
                ", colour= " + colour +
                ", horsepower= " + horsepower +
                ", gearbox= " + gearbox +
                ", hasNavigationSystem= " + hasNavigationSystem +
                ", serialNumber= '" + serialNumber + '\'';
    }
}
