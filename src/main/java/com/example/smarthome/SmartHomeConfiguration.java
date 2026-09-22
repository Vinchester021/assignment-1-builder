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
