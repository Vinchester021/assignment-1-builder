# Assignment 1 Report

## Builder Design Pattern — Smart Home System

## 1. Objective

The objective of this project is to demonstrate the Builder design pattern.

The project creates different Smart Home configurations. A smart home contains many required and optional properties, so
using one long constructor makes the code difficult to read and maintain.

## 2. Problem Before Builder

The first version used a constructor with 14 parameters:

```java
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
```

This code has several problems:

- it is difficult to remember the parameter order;
- boolean values such as `true` and `false` are unclear;
- optional values must still be provided;
- adding a new property changes the constructor;
- parameters of the same type can be accidentally swapped;
- validation is difficult to organize.

For example, it is not immediately clear what the fourth `true` value means.

## 3. Solution with Builder

After refactoring, the object is created with a fluent API:

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
                .notifications(notifications)
                .build();
```

Every optional value has a clear method name. The code is easier to read and parameters cannot be confused.

## 4. Builder Pattern Participants

### Product

`SmartHomeConfiguration` is the final object created by the Builder.

It is immutable because its fields are `private final`, and it does not contain setter methods.

### Builder

`SmartHomeConfiguration.Builder` stores temporary configuration values.

It provides:

- required values through its constructor;
- optional values through fluent methods;
- default values;
- validation;
- the `build()` method.

### Director

`SmartHomeDirector` creates ready configurations using the Builder.

It contains three presets:

- `createBasicHome()`;
- `createEnergySavingHome()`;
- `createVacationHome()`.

### Client

`Main` is the client code. It requests configurations from the Director and prints them.

## 5. Required and Optional Properties

### Required properties

1. `homeName`
2. `ownerName`
3. `roomCount`
4. `mode`

Required properties are passed to the Builder constructor.

### Optional properties

1. `targetTemperature`
2. `smartLockEnabled`
3. `motionSensorEnabled`
4. `cameraCount`
5. `smokeDetectorEnabled`
6. `waterLeakSensorEnabled`
7. `automaticWaterShutoffEnabled`
8. `energySavingEnabled`
9. `vacationDays`
10. `notifications`

Optional properties use fluent Builder methods.

## 6. Nested Value Object

`NotificationSettings` is a nested value object containing:

- emergency phone number;
- push notification state;
- SMS notification state.

The method `isEnabled()` returns `true` when push or SMS notifications are enabled.

## 7. Default Values

The Builder provides safe default values:

| Property                |  Default |
|-------------------------|---------:|
| Target temperature      |   `22.0` |
| Smart lock              |  `false` |
| Motion sensor           |  `false` |
| Camera count            |      `0` |
| Smoke detector          |   `true` |
| Water leak sensor       |  `false` |
| Automatic water shutoff |  `false` |
| Energy saving           |  `false` |
| Vacation days           |      `0` |
| Notifications           | disabled |

Because of these defaults, the client only specifies settings that need to be changed.

## 8. Validation Rules

### Single-field validation

The project checks that:

- home name is not empty;
- owner name is not empty;
- room count is between 1 and 50;
- temperature is between 5 and 35;
- camera count is not negative;
- vacation days are between 0 and 365;
- mode is not null;
- notification settings are not null.

### Cross-field validation

The project also checks relationships between fields.

For `VACATION` mode:

- smart lock must be enabled;
- motion sensor must be enabled;
- emergency notifications must be enabled.

When vacation duration is longer than seven days:

- automatic water shutoff must be enabled.

Invalid data causes an `IllegalArgumentException` with a clear message.

## 9. Presets

### BASIC

Uses standard default values for normal home operation.

### ENERGY_SAVING

Uses:

- `ENERGY_SAVING` mode;
- target temperature `19.0`;
- enabled energy saving.

### VACATION

Uses:

- `VACATION` mode;
- target temperature `18.0`;
- smart lock;
- motion sensor;
- cameras;
- smoke detector;
- water leak sensor;
- automatic water shutoff;
- energy saving;
- emergency notifications.

## 10. Clean Code Comparison

| Before Builder                        | After Builder                               |
|---------------------------------------|---------------------------------------------|
| 14 constructor arguments              | 4 required constructor arguments            |
| Unclear boolean values                | Named fluent methods                        |
| Parameter order is important          | Optional methods can be called in any order |
| No default values                     | Safe default values                         |
| Validation is difficult to organize   | Central validation in Builder               |
| Client knows all construction details | Director provides ready presets             |

The Builder version has better readability, maintainability, and safety.

## 11. Testing

The project contains 12 JUnit tests.

The tests check:

- successful creation;
- default values;
- empty home name;
- empty owner name;
- invalid room count;
- invalid temperature;
- negative camera count;
- missing smart lock;
- missing motion sensor;
- missing notifications;
- missing automatic water shutoff;
- valid VACATION preset.

Tests can be executed with:

```bash
mvn clean test
```

## 12. UML Diagram

The UML diagram shows relationships between:

- `SmartHomeConfiguration`;
- `Builder`;
- `NotificationSettings`;
- `HomeMode`;
- `SmartHomeDirector`.

The diagram is located in:

```text
docs/builder-uml.md
```

## 13. Conclusion

The Builder pattern is suitable for objects with many optional properties.

In this project, Builder improved the Smart Home configuration by:

- making object creation readable;
- separating required and optional values;
- providing default values;
- centralizing validation;
- preventing invalid configurations;
- supporting reusable presets through the Director.

The final solution is easier to understand, test, and extend than the original long-constructor version.