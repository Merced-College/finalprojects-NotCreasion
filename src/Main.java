/*
Author: Estefania Reyes
Class: Main.java

Description:
Main entry point for the Fitness Tracker application.
Demonstrates all features including data structures and algorithms.
*/
public class Main {
    public static void main(String[] args) {
        // Create user
        User user = new User("Estefania Reyes", 25, 65.0, 165.0);
        user.addPreference("theme", "dark");

        // Create fitness tracker
        FitnessTracker myTracker = new FitnessTracker("Estefania");
        myTracker.setUser(user);

        // Add exercises
        Exercise run = new Exercise("Running", 30, 300);
        Exercise lift = new Exercise("Weightlifting", 45, 200);
        Exercise swim = new Exercise("Swimming", 40, 250);

        myTracker.addExercise(run);
        myTracker.addExercise(lift);
        myTracker.addExercise(swim);

        // Categorize exercises
        myTracker.categorizeExercise("Cardio", run);
        myTracker.categorizeExercise("Strength", lift);
        myTracker.categorizeExercise("Cardio", swim);

        // Add goals
        Goal goal1 = new Goal("Burn 1000 calories this week", 1000, "kcal");
        Goal goal2 = new Goal("Lose 2 kg", 2, "kg");
        myTracker.addGoal(goal1);
        myTracker.addGoal(goal2);

        // Add pending workouts
        myTracker.addPendingWorkout(new Exercise("Cycling", 50, 400));
        myTracker.addPendingWorkout(new Exercise("Yoga", 60, 150));

        // Demonstrate sorting
        java.util.ArrayList<Exercise> exercises = new java.util.ArrayList<>();
        exercises.add(run);
        exercises.add(lift);
        exercises.add(swim);
        System.out.println("Before sorting:");
        for (Exercise e : exercises) {
            System.out.println(e.getName() + ": " + e.getCalories());
        }
        Statistics.sortExercisesByCalories(exercises);
        System.out.println("After sorting by calories:");
        for (Exercise e : exercises) {
            System.out.println(e.getName() + ": " + e.getCalories());
        }

        // Demonstrate searching
        Exercise found = Statistics.findExerciseByName(exercises, "Running");
        System.out.println("Found exercise: " + (found != null ? found.getName() : "Not found"));

        // Demonstrate recursion
        System.out.println("Factorial of 5: " + Statistics.factorial(5));
        System.out.println("Average calories: " + Statistics.averageCaloriesRecursive(exercises, 0));

        // Display summary
        myTracker.displaySummary();

        // Undo last exercise
        myTracker.undoLastExercise();
        System.out.println("After undo:");
        myTracker.displaySummary();
    }
}