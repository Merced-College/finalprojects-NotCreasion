// Name: Estefania Reyes
// Date: 20 April 2026
// Class: Goal.java
// Description: Represents a fitness goal for the user, including description, target value, unit, and achievement status.

public class Goal {
    private String description;
    private int targetValue; // e.g., calories to burn, weight to lose
    private String unit; // e.g., "kcal", "kg"
    private boolean achieved;

    public Goal(String description, int targetValue, String unit) {
        this.description = description;
        this.targetValue = targetValue;
        this.unit = unit;
        this.achieved = false;
    }

    // Getters and setters
    public String getDescription() { return description; }
    public int getTargetValue() { return targetValue; }
    public String getUnit() { return unit; }
    public boolean isAchieved() { return achieved; }
    public void setAchieved(boolean achieved) { this.achieved = achieved; }

    @Override
    public String toString() {
        return description + ": " + targetValue + " " + unit + " (" + (achieved ? "Achieved" : "In Progress") + ")";
    }
}