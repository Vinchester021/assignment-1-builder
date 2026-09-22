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
                new SmartHomeConfiguration.Builder(
                        "Smart Villa",
                        "Vilgelm",
                        5,
                        HomeMode.VACATION
                )
                        .targetTemperature(20.0)
                        .smartLockEnabled(true)
                        .motionSensorEnabled(true)
                        .cameraCount(4)
                        .smokeDetectorEnabled(true)
                        .waterLeakSensorEnabled(true)
                        .automaticWaterShutoffEnabled(true)
                        .energySavingEnabled(false)
                        .vacationDays(14)
                        .notifications(notifications)
                        .build();

        System.out.println("Smart Home Configuration:");
        System.out.println(home);
    }
}