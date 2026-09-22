    # Smart Home Configuration — Builder Pattern

## Project Description

This project demonstrates the Builder design pattern using a Smart Home configuration system.

A smart home has many required and optional settings. Creating it with a long constructor is difficult because parameters can be confused. The Builder pattern makes object creation readable, flexible, and safe.

## Individual Variant

- Domain: Smart Home System
- Required preset: VACATION
- Constraint:
    - VACATION mode requires a smart lock.
    - VACATION mode requires a motion sensor.
    - VACATION mode requires emergency notifications.
    - A vacation longer than 7 days requires automatic water shutoff.

## Technologies

- Java 17
- Maven
- JUnit 5
- IntelliJ IDEA
- Git and GitHub

## Main Classes

### SmartHomeConfiguration

The main immutable object containing the smart home settings.

Required properties:

- home name;
- owner name;
- room count;
- home mode.

Optional properties:

- target temperature;
- smart lock;
- motion sensor;
- camera count;
- smoke detector;
- water leak sensor;
- automatic water shutoff;
- energy-saving mode;
- vacation days;
- notification settings.

### Builder

The nested `Builder` class provides a fluent API for creating a configuration:

```java
SmartHomeConfiguration home =
        new SmartHomeConfiguration.Builder(
                "Smart Villa",
                "Vilgelm",
                5,
                HomeMode.VACATION
        )
        .targetTemperature(18.0)
        .smartLockEnabled(true)
        .motionSensorEnabled(true)
        .cameraCount(2)
        .automaticWaterShutoffEnabled(true)
        .vacationDays(14)
        .notifications(
                new NotificationSettings(
                        "+7 777 123 45 67",
                        true,
                        true
                )
        )
        .build();
```

## Default Values

| Property | Default value |
|---|---:|
| Target temperature | `22.0` |
| Smart lock | `false` |
| Motion sensor | `false` |
| Camera count | `0` |
| Smoke detector | `true` |
| Water leak sensor | `false` |
| Automatic water shutoff | `false` |
| Energy saving | `false` |
| Vacation days | `0` |
| Notifications | disabled |

## Validation

The Builder checks:

- home name is not empty;
- owner name is not empty;
- room count is between 1 and 50;
- target temperature is between 5 and 35;
- camera count is not negative;
- vacation days are between 0 and 365;
- mode and notification settings are not null;
- VACATION mode has the required security devices;
- long vacations have automatic water shutoff.

Invalid data causes an `IllegalArgumentException`.

## Presets

`SmartHomeDirector` creates three ready configurations:

1. `BASIC`
2. `ENERGY_SAVING`
3. `VACATION`

## Tests

The project contains 12 JUnit tests covering:

- correct object creation;
- default values;
- invalid single fields;
- VACATION mode constraints;
- automatic water shutoff;
- the VACATION preset.

Run all tests:

```bash
mvn clean test
```

Expected result:

```text
Tests run: 12, Failures: 0, Errors: 0
BUILD SUCCESS
```

## UML Diagram

[View the Builder UML diagram](docs/builder-uml.md)

## Project Structure

```text
src/
├── main/java/com.example.smarthome/
│   ├── HomeMode.java
│   ├── Main.java
│   ├── NotificationSettings.java
│   ├── SmartHomeConfiguration.java
│   └── SmartHomeDirector.java
└── test/java/com.example.smarthome/
    └── SmartHomeConfigurationTest.java
```

## Author

Vilgelm Feller  