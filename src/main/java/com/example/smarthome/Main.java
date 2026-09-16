package com.example.smarthome;

public class Main {

    public static void main(String[] args) {

        NotificationSettings notifications =
                new NotificationSettings(
                        "+7 777 123 45 67",
                        true,
                        true
                );

        SmartHomeConfiguration home =
                new SmartHomeConfiguration(
                        "Smart Villa",
                        "Vilgelm",
                        5,
                        HomeMode.VACATION,
                        20.0,
                        true,
                        true,
                        4,
                        true,
                        true,
                        true,
                        false,
                        14,
                        notifications
                );

        System.out.println("Smart Home Configuration:");
        System.out.println(home);
    }
}