interface HeartRateMonitor {
    void displayHeartRate(String patientName, int heartRate);

    default void displayHealthTips() {
        System.out.println("Heart tips: rest well, hydrate, and monitor abnormal pulse rates.");
    }
}

interface TemperatureMonitor {
    void displayTemperature(String patientName, double temperature);

    default void displayHealthTips() {
        System.out.println("Temperature tips: keep the patient hydrated and observe fever symptoms.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.matches("PAT[0-9]{3}");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    @Override
    public void displayHeartRate(String patientName, int heartRate) {
        System.out.println(patientName + " heart rate: " + heartRate + " bpm");
    }

    @Override
    public void displayTemperature(String patientName, double temperature) {
        System.out.println(patientName + " temperature: " + temperature + " C");
    }

    @Override
    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }
}

public class SmartHealthcareMonitoringSystem {
    public static void main(String[] args) {
        String[] patientNames = {"Neha", "Rohan", "Isha"};
        String[] patientIds = {"PAT101", "PAT205", "PX300"};
        int[] heartRates = {78, 112, 64};
        double[] temperatures = {98.6, 100.4, 97.9};

        HealthMonitoringSystem monitoringSystem = new HealthMonitoringSystem();
        monitoringSystem.displayHealthTips();

        for (int i = 0; i < patientNames.length; i++) {
            boolean validId = TemperatureMonitor.isPatientIdValid(patientIds[i]);
            System.out.println(patientNames[i] + " ID " + patientIds[i] + " -> " + (validId ? "valid" : "invalid"));

            if (validId) {
                monitoringSystem.displayHeartRate(patientNames[i], heartRates[i]);
                monitoringSystem.displayTemperature(patientNames[i], temperatures[i]);
            }
        }

        System.out.println("Final health report:");
        for (int i = 0; i < patientNames.length; i++) {
            boolean validId = TemperatureMonitor.isPatientIdValid(patientIds[i]);
            String status = validId && heartRates[i] >= 60 && heartRates[i] <= 100 && temperatures[i] <= 99.5
                    ? "Stable"
                    : "Needs attention";
            System.out.println(patientNames[i] + " -> " + status);
        }
    }
}
