interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("Trackable data reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    private final String deviceName;
    private final String activity;
    private final int caloriesBurned;

    FitnessDevice(String deviceName, String activity, int caloriesBurned) {
        this.deviceName = deviceName;
        this.activity = activity;
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public void logActivity() {
        System.out.println(deviceName + " logged activity: " + activity);
    }

    @Override
    public void generateReport() {
        System.out.println(deviceName + " report -> activity: " + activity + ", calories: " + caloriesBurned);
    }

    @Override
    public void sendAlert() {
        System.out.println(deviceName + " alert -> target exceeded or attention needed.");
    }
}

public class FitnessTrackerSystem {
    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice("FitPro X", "Running", 420);

        System.out.println("Java classes cannot extend multiple classes, but they can implement multiple interfaces.");
        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();
    }
}
