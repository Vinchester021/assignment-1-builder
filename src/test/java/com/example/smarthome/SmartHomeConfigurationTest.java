package com.example.smarthome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeConfigurationTest {

    private NotificationSettings enabledNotifications() {
        return new NotificationSettings(
                "+7 777 123 45 67",
                true,
                true
        );
    }

    @Test
    void shouldCreateBasicConfiguration() {
        SmartHomeConfiguration home =
                new SmartHomeConfiguration.Builder(
                        "My Home",
                        "Vilgelm",
                        3,
                        HomeMode.BASIC
                )
                        .build();

        assertEquals("My Home", home.getHomeName());
        assertEquals("Vilgelm", home.getOwnerName());
        assertEquals(3, home.getRoomCount());
        assertEquals(HomeMode.BASIC, home.getMode());
    }

    @Test
    void shouldUseDefaultValues() {
        SmartHomeConfiguration home =
                new SmartHomeConfiguration.Builder(
                        "My Home",
                        "Vilgelm",
                        3,
                        HomeMode.BASIC
                )
                        .build();

        assertEquals(22.0, home.getTargetTemperature());
        assertEquals(0, home.getCameraCount());
        assertTrue(home.isSmokeDetectorEnabled());
        assertFalse(home.isSmartLockEnabled());
        assertFalse(home.isEnergySavingEnabled());
    }

    @Test
    void shouldRejectEmptyHomeName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmartHomeConfiguration.Builder(
                        "",
                        "Vilgelm",
                        3,
                        HomeMode.BASIC
                ).build()
        );
    }

    @Test
    void shouldRejectEmptyOwnerName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmartHomeConfiguration.Builder(
                        "My Home",
                        " ",
                        3,
                        HomeMode.BASIC
                ).build()
        );
    }

    @Test
    void shouldRejectInvalidRoomCount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmartHomeConfiguration.Builder(
                        "My Home",
                        "Vilgelm",
                        0,
                        HomeMode.BASIC
                ).build()
        );
    }

    @Test
    void shouldRejectInvalidTemperature() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmartHomeConfiguration.Builder(
                        "My Home",
                        "Vilgelm",
                        3,
                        HomeMode.BASIC
                )
                        .targetTemperature(40.0)
                        .build()
        );
    }

    @Test
    void shouldRejectNegativeCameraCount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmartHomeConfiguration.Builder(
                        "My Home",
                        "Vilgelm",
                        3,
                        HomeMode.BASIC
                )
                        .cameraCount(-1)
                        .build()
        );
    }

    @Test
    void vacationModeShouldRequireSmartLock() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmartHomeConfiguration.Builder(
                        "Vacation Home",
                        "Vilgelm",
                        4,
                        HomeMode.VACATION
                )
                        .motionSensorEnabled(true)
                        .automaticWaterShutoffEnabled(true)
                        .notifications(enabledNotifications())
                        .vacationDays(14)
                        .build()
        );
    }

    @Test
    void vacationModeShouldRequireMotionSensor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmartHomeConfiguration.Builder(
                        "Vacation Home",
                        "Vilgelm",
                        4,
                        HomeMode.VACATION
                )
                        .smartLockEnabled(true)
                        .automaticWaterShutoffEnabled(true)
                        .notifications(enabledNotifications())
                        .vacationDays(14)
                        .build()
        );
    }

    @Test
    void vacationModeShouldRequireNotifications() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmartHomeConfiguration.Builder(
                        "Vacation Home",
                        "Vilgelm",
                        4,
                        HomeMode.VACATION
                )
                        .smartLockEnabled(true)
                        .motionSensorEnabled(true)
                        .automaticWaterShutoffEnabled(true)
                        .vacationDays(14)
                        .build()
        );
    }

    @Test
    void longVacationShouldRequireWaterShutoff() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmartHomeConfiguration.Builder(
                        "Vacation Home",
                        "Vilgelm",
                        4,
                        HomeMode.VACATION
                )
                        .smartLockEnabled(true)
                        .motionSensorEnabled(true)
                        .notifications(enabledNotifications())
                        .vacationDays(14)
                        .build()
        );
    }

    @Test
    void vacationPresetShouldCreateValidConfiguration() {
        SmartHomeDirector director = new SmartHomeDirector();

        SmartHomeConfiguration home =
                director.createVacationHome(
                        "Smart Villa",
                        "Vilgelm",
                        5,
                        14,
                        "+7 777 123 45 67"
                );

        assertEquals(HomeMode.VACATION, home.getMode());
        assertTrue(home.isSmartLockEnabled());
        assertTrue(home.isMotionSensorEnabled());
        assertTrue(home.isAutomaticWaterShutoffEnabled());
        assertTrue(home.getNotifications().isEnabled());
    }
}