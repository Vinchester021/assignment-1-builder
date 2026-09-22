package com.example.smarthome;

public class SmartHomeConfiguration {

    private final String homeName;
    private final String ownerName;
    private final int roomCount;
    private final HomeMode mode;

    private final double targetTemperature;
    private final boolean smartLockEnabled;
    private final boolean motionSensorEnabled;
    private final int cameraCount;
    private final boolean smokeDetectorEnabled;
    private final boolean waterLeakSensorEnabled;
    private final boolean automaticWaterShutoffEnabled;
    private final boolean energySavingEnabled;
    private final int vacationDays;
    private final NotificationSettings notifications;



    private SmartHomeConfiguration(
            String homeName,
            String ownerName,
            int roomCount,
            HomeMode mode,
            double targetTemperature,
            boolean smartLockEnabled,
            boolean motionSensorEnabled,
            int cameraCount,
            boolean smokeDetectorEnabled,
            boolean waterLeakSensorEnabled,
            boolean automaticWaterShutoffEnabled,
            boolean energySavingEnabled,
            int vacationDays,
            NotificationSettings notifications
    ) {
        this.homeName = homeName;
        this.ownerName = ownerName;
        this.roomCount = roomCount;
        this.mode = mode;
        this.targetTemperature = targetTemperature;
        this.smartLockEnabled = smartLockEnabled;
        this.motionSensorEnabled = motionSensorEnabled;
        this.cameraCount = cameraCount;
        this.smokeDetectorEnabled = smokeDetectorEnabled;
        this.waterLeakSensorEnabled = waterLeakSensorEnabled;
        this.automaticWaterShutoffEnabled = automaticWaterShutoffEnabled;
        this.energySavingEnabled = energySavingEnabled;
        this.vacationDays = vacationDays;
        this.notifications = notifications;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public HomeMode getMode() {
        return mode;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public boolean isSmartLockEnabled() {
        return smartLockEnabled;
    }

    public boolean isMotionSensorEnabled() {
        return motionSensorEnabled;
    }

    public int getCameraCount() {
        return cameraCount;
    }

    public boolean isSmokeDetectorEnabled() {
        return smokeDetectorEnabled;
    }

    public boolean isWaterLeakSensorEnabled() {
        return waterLeakSensorEnabled;
    }

    public boolean isAutomaticWaterShutoffEnabled() {
        return automaticWaterShutoffEnabled;
    }

    public boolean isEnergySavingEnabled() {
        return energySavingEnabled;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public NotificationSettings getNotifications() {
        return notifications;
    }

    @Override
    public String toString() {
        return "SmartHomeConfiguration {\n" +
                "  homeName: '" + homeName + "',\n" +
                "  ownerName: '" + ownerName + "',\n" +
                "  roomCount: " + roomCount + ",\n" +
                "  mode: " + mode + ",\n" +
                "  targetTemperature: " + targetTemperature + ",\n" +
                "  smartLockEnabled: " + smartLockEnabled + ",\n" +
                "  motionSensorEnabled: " + motionSensorEnabled + ",\n" +
                "  cameraCount: " + cameraCount + ",\n" +
                "  smokeDetectorEnabled: " + smokeDetectorEnabled + ",\n" +
                "  waterLeakSensorEnabled: " + waterLeakSensorEnabled + ",\n" +
                "  automaticWaterShutoffEnabled: " + automaticWaterShutoffEnabled + ",\n" +
                "  energySavingEnabled: " + energySavingEnabled + ",\n" +
                "  vacationDays: " + vacationDays + ",\n" +
                "  notifications: " + notifications + "\n" +
                '}';
    }


    public static class Builder {

        private final String homeName;
        private final String ownerName;
        private final int roomCount;
        private final HomeMode mode;

        private double targetTemperature = 22.0;
        private boolean smartLockEnabled = false;
        private boolean motionSensorEnabled = false;
        private int cameraCount = 0;
        private boolean smokeDetectorEnabled = true;
        private boolean waterLeakSensorEnabled = false;
        private boolean automaticWaterShutoffEnabled = false;
        private boolean energySavingEnabled = false;
        private int vacationDays = 0;
        private NotificationSettings notifications =
                new NotificationSettings("", false, false);

        public Builder(
                String homeName,
                String ownerName,
                int roomCount,
                HomeMode mode
        ) {
            this.homeName = homeName;
            this.ownerName = ownerName;
            this.roomCount = roomCount;
            this.mode = mode;


        }
        private void validate() {
            if (homeName == null || homeName.isBlank()) {
                throw new IllegalArgumentException("Home name cannot be empty");
            }

            if (ownerName == null || ownerName.isBlank()) {
                throw new IllegalArgumentException("Owner name cannot be empty");
            }

            if (roomCount < 1 || roomCount > 50) {
                throw new IllegalArgumentException(
                        "Room count must be between 1 and 50"
                );
            }

            if (mode == null) {
                throw new IllegalArgumentException("Home mode cannot be null");
            }

            if (targetTemperature < 5 || targetTemperature > 35) {
                throw new IllegalArgumentException(
                        "Target temperature must be between 5 and 35"
                );
            }

            if (cameraCount < 0) {
                throw new IllegalArgumentException(
                        "Camera count cannot be negative"
                );
            }

            if (vacationDays < 0 || vacationDays > 365) {
                throw new IllegalArgumentException(
                        "Vacation days must be between 0 and 365"
                );
            }

            if (notifications == null) {
                throw new IllegalArgumentException(
                        "Notification settings cannot be null"
                );
            }

            if (mode == HomeMode.VACATION) {
                if (!smartLockEnabled) {
                    throw new IllegalArgumentException(
                            "VACATION mode requires smart lock"
                    );
                }

                if (!motionSensorEnabled) {
                    throw new IllegalArgumentException(
                            "VACATION mode requires motion sensor"
                    );
                }

                if (!notifications.isEnabled()) {
                    throw new IllegalArgumentException(
                            "VACATION mode requires emergency notifications"
                    );
                }
            }

            if (vacationDays > 7 && !automaticWaterShutoffEnabled) {
                throw new IllegalArgumentException(
                        "Vacation longer than 7 days requires automatic water shutoff"
                );
            }
        }

        public Builder targetTemperature(double targetTemperature) {
            this.targetTemperature = targetTemperature;
            return this;
        }

        public Builder smartLockEnabled(boolean smartLockEnabled) {
            this.smartLockEnabled = smartLockEnabled;
            return this;
        }

        public Builder motionSensorEnabled(boolean motionSensorEnabled) {
            this.motionSensorEnabled = motionSensorEnabled;
            return this;
        }

        public Builder cameraCount(int cameraCount) {
            this.cameraCount = cameraCount;
            return this;
        }

        public Builder smokeDetectorEnabled(boolean smokeDetectorEnabled) {
            this.smokeDetectorEnabled = smokeDetectorEnabled;
            return this;
        }

        public Builder waterLeakSensorEnabled(boolean waterLeakSensorEnabled) {
            this.waterLeakSensorEnabled = waterLeakSensorEnabled;
            return this;
        }

        public Builder automaticWaterShutoffEnabled(
                boolean automaticWaterShutoffEnabled
        ) {
            this.automaticWaterShutoffEnabled = automaticWaterShutoffEnabled;
            return this;
        }

        public Builder energySavingEnabled(boolean energySavingEnabled) {
            this.energySavingEnabled = energySavingEnabled;
            return this;
        }

        public Builder vacationDays(int vacationDays) {
            this.vacationDays = vacationDays;
            return this;
        }

        public Builder notifications(NotificationSettings notifications) {
            this.notifications = notifications;
            return this;
        }

        public SmartHomeConfiguration build() {
            validate();

            return new SmartHomeConfiguration(
                    homeName,
                    ownerName,
                    roomCount,
                    mode,
                    targetTemperature,
                    smartLockEnabled,
                    motionSensorEnabled,
                    cameraCount,
                    smokeDetectorEnabled,
                    waterLeakSensorEnabled,
                    automaticWaterShutoffEnabled,
                    energySavingEnabled,
                    vacationDays,
                    notifications
            );
        }

    }
}
