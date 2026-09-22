package com.example.smarthome;

public class SmartHomeDirector {

    public SmartHomeConfiguration createBasicHome(
            String homeName,
            String ownerName,
            int roomCount
    ) {
        return new SmartHomeConfiguration.Builder(
                homeName,
                ownerName,
                roomCount,
                HomeMode.BASIC
        )
                .build();
    }

    public SmartHomeConfiguration createEnergySavingHome(
            String homeName,
            String ownerName,
            int roomCount
    ) {
        return new SmartHomeConfiguration.Builder(
                homeName,
                ownerName,
                roomCount,
                HomeMode.ENERGY_SAVING
        )
                .targetTemperature(19.0)
                .energySavingEnabled(true)
                .build();
    }

    public SmartHomeConfiguration createVacationHome(
            String homeName,
            String ownerName,
            int roomCount,
            int vacationDays,
            String emergencyPhone
    ) {
        NotificationSettings notifications =
                new NotificationSettings(
                        emergencyPhone,
                        true,
                        true
                );

        return new SmartHomeConfiguration.Builder(
                homeName,
                ownerName,
                roomCount,
                HomeMode.VACATION
        )
                .targetTemperature(18.0)
                .smartLockEnabled(true)
                .motionSensorEnabled(true)
                .cameraCount(2)
                .smokeDetectorEnabled(true)
                .waterLeakSensorEnabled(true)
                .automaticWaterShutoffEnabled(true)
                .energySavingEnabled(true)
                .vacationDays(vacationDays)
                .notifications(notifications)
                .build();
    }
}