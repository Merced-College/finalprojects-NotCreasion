// Name: Estefania Reyes
// Date: 20 April 2026
// Class: Statistics.java
// Description: Provides statistical calculations and algorithms for the fitness tracker, including sorting, searching, and recursive functions.
//Time Complexity: O(n^2)

import java.util.ArrayList;
import java.util.Stack;

public class Statistics {
    // Sorting algorithm: Bubble Sort for exercises by calories
    /*
    Algorithm: Bubble Sort
    Sorts exercises by calories burned in ascending order.
    Time Complexity: O(n^2)
    */
    public static void sortExercisesByCalories(ArrayList<Exercise> exercises) {
        int n = exercises.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (exercises.get(j).getCalories() > exercises.get(j + 1).getCalories()) {
                    // Swap
                    Exercise temp = exercises.get(j);
                    exercises.set(j, exercises.get(j + 1));
                    exercises.set(j + 1, temp);
                }
            }
        }
    }

    // Searching algorithm: Linear Search for exercise by name
    /*
    Algorithm: Linear Search
    Searches for an exercise by name in the list.
    Time Complexity: O(n)
    */
    public static Exercise findExerciseByName(ArrayList<Exercise> exercises, String name) {
        for (Exercise e : exercises) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    // Recursive function: Calculate factorial (for demonstration, maybe for some stat)
    /*
    Recursive Function: Factorial
    Calculates factorial of a number recursively.
    Used for demonstration of recursion.
    */
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Another algorithm: Calculate average calories using recursion
    /*
    Recursive Algorithm: Average Calories
    Recursively calculates the average calories from a list.
    */
    public static double averageCaloriesRecursive(ArrayList<Exercise> exercises, int index) {
        if (index == exercises.size() - 1) {
            return exercises.get(index).getCalories();
        }
        return (exercises.get(index).getCalories() + (averageCaloriesRecursive(exercises, index + 1) * (exercises.size() - index - 1))) / (exercises.size() - index);
    }

    // Stack for undo operations (example: undo last added exercise)
    private Stack<Exercise> undoStack = new Stack<>();

    public void pushUndo(Exercise e) {
        undoStack.push(e);
    }

    public Exercise popUndo() {
        if (!undoStack.isEmpty()) {
            return undoStack.pop();
        }
        return null;
    }
}