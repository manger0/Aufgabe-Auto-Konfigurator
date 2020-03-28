package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Aufgabe Auto Konfigurator Mathias Angerer

public class Main {

    public static void main(String[] args) {git

        // Variables
        ArrayList<Car> cars = new ArrayList<>();
        Random serialnumber = new Random();
        Car myBMW = new Car("BMW", "X3", Colour.BLACK, 150, Gearbox.AUTOMATIC,
                true, serialnumber.nextInt((10000 - 1000) + 1) + 1000);
        // Clone of example car
        cars.add(myBMW);
        do {
            try {
                Car configurationCar = myBMW.clone();
                Scanner inputColor = new Scanner(System.in);
                Scanner inputGearbox = new Scanner(System.in);
                Scanner inputHorsepower = new Scanner(System.in);
                Scanner inputNavigationSystem = new Scanner(System.in);
                // Custom car configuration
                System.out.println("Example car: " + myBMW.toString());
                System.out.println("select colour: black - white - grey - silver");
                configurationCar.setColour(colour(inputColor.nextLine()));
                System.out.println("select horsepower: 150 - 200 - 250");
                configurationCar.setHorsepower(inputHorsepower.nextInt());
                System.out.println("select gearbox: automatic - manual");
                configurationCar.setGearbox(gearbox(inputGearbox.nextLine()));
                System.out.println("select navigationsystem: yes - no");
                configurationCar.setHasNavigationSystem(hasNavigationSystem(inputNavigationSystem.nextLine()));
                /* Checking if similar car to custom car is in list.
                If similar car found similar car will be cloned and added to list, else custom car will be added.
                */
                configurationCar.orderDataBase(cars, configurationCar);
            } catch (CloneNotSupportedException ex) {
                System.out.println("Clone Error");
            }

          printCarsToList(cars);

        }while (stopProgram());

        printCarsToList(cars);
    }

    // Methods
    public static void printCarsToList (ArrayList<Car> cars) {
        System.out.println("Total cars in list " + cars.size() + " :");
        for (Object car : cars) {
            System.out.println(car);
        }
    }

    public static boolean stopProgram () {
        Scanner input = new Scanner(System.in);
        System.out.println("Add another car: yes - no");
        return input.nextLine().toLowerCase().equals("yes");
    }

    public static boolean hasNavigationSystem (String answer) {
        switch (answer.toLowerCase()) {
            case "yes": {
                return true;
            }
            case "no": {
                return false;
            }
        }
        return false;
    }

    public static Gearbox gearbox (String gearbox) {
        switch (gearbox.toLowerCase()) {
            case "automatic": {
                return Gearbox.AUTOMATIC;
            }
            case "manual": {
                return Gearbox.MANUAL;
            }
        }
        return null;
    }

    public static Colour colour(String colour) {
        switch (colour.toLowerCase()) {
            case "black": {
                return Colour.BLACK;
            }
            case "white": {
                return Colour.WHITE;
            }
            case "grey": {
                return Colour.GREY;
            }
            case "silver": {
                return Colour.Silver;
            }
        }
        return null;
    }
}
