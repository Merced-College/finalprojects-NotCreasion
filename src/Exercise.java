// Name: Estefania Reyes
// Date: 20 April 2026
// Class: Exercise.java
// Description: Represents an individual exercise with name, duration in minutes, and calories burned. Provides getters and a string representation.

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