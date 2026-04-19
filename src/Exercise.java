public class Exercise {
    private String name;
    private int durationMinutes;
    private int caloriesBurned;

    // Constructor
    public Exercise(String name, int durationMinutes, int caloriesBurned) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.caloriesBurned = caloriesBurned;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getDuration() { return durationMinutes; }
    public int getCalories() { return caloriesBurned; }

    @Override
    public String toString() {
        return name + " for " + durationMinutes + " mins (" + caloriesBurned + " kcal)";
    }
}