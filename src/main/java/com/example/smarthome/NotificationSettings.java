package com.example.smarthome;

public class NotificationSettings {

    private final String emergencyPhone;
    private final boolean pushEnabled;
    private final boolean smsEnabled;

    public NotificationSettings(
            String emergencyPhone,
            boolean pushEnabled,
            boolean smsEnabled
    ) {
        this.emergencyPhone = emergencyPhone;
        this.pushEnabled = pushEnabled;
        this.smsEnabled = smsEnabled;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public boolean isPushEnabled() {
        return pushEnabled;
    }

    public boolean isSmsEnabled() {
        return smsEnabled;
    }

    public boolean isEnabled() {
        return pushEnabled || smsEnabled;
    }

    @Override
    public String toString() {
        return "NotificationSettings{" +
                "emergencyPhone='" + emergencyPhone + '\'' +
                ", pushEnabled=" + pushEnabled +
                ", smsEnabled=" + smsEnabled +
                '}';
    }
}