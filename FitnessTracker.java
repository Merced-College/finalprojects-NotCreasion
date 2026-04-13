import java.util.ArrayList;

public class FitnessTracker {
    private ArrayList<Exercise> workoutLog;
    private String userName;

    public FitnessTracker(String userName) {
        this.userName = userName;
        this.workoutLog = new ArrayList<>();
    }

    public void addExercise(Exercise e) {
        workoutLog.add(e);
        System.out.println("Added: " + e.getName());
    }

    public int getTotalCalories() {
        int total = 0;
        for (Exercise e : workoutLog) {
            total += e.getCalories();
        }
        return total;
    }

    public void displaySummary() {
        System.out.println("\n--- " + userName + "'s Fitness Summary ---");
        for (Exercise e : workoutLog) {
            System.out.println(e.toString());
        }
        System.out.println("Total Calories Burned: " + getTotalCalories());
    }
}