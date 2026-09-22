package com.example.smarthome;

public class Main {

    public static void main(String[] args) {

        SmartHomeDirector director = new SmartHomeDirector();

        SmartHomeConfiguration basicHome =
                director.createBasicHome(
                        "Basic Apartment",
                        "Vilgelm",
                        2
                );

        SmartHomeConfiguration energySavingHome =
                director.createEnergySavingHome(
                        "Eco House",
                        "Vilgelm",
                        4
                );

        SmartHomeConfiguration vacationHome =
                director.createVacationHome(
                        "Smart Villa",
                        "Vilgelm",
                        5,
                        14,
                        "+7 777 123 45 67"
                );

        System.out.println("=== BASIC PRESET ===");
        System.out.println(basicHome);

        System.out.println("\n=== ENERGY SAVING PRESET ===");
        System.out.println(energySavingHome);

        System.out.println("\n=== VACATION PRESET ===");
        System.out.println(vacationHome);
    }
}