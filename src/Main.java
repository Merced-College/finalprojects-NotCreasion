// Name: Estefania Reyes
// Date: 20 April 2026
// Class: Main.java
// Description: Main entry point for the Fitness Tracker application with GUI.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {
    private FitnessTracker tracker;
    private JTextArea outputArea;
    private JTextField exerciseNameField, durationField, caloriesField;
    private JTextField goalDescField, goalValueField, goalUnitField;

    public Main() {
        // Initialize tracker with sample data
        User user = new User("Estefania Reyes", 25, 65.0, 165.0);
        user.addPreference("theme", "dark");
        tracker = new FitnessTracker("Estefania");
        tracker.setUser(user);

        // Add sample exercises
        Exercise run = new Exercise("Running", 30, 300);
        Exercise lift = new Exercise("Weightlifting", 45, 200);
        Exercise swim = new Exercise("Swimming", 40, 250);
        tracker.addExercise(run);
        tracker.addExercise(lift);
        tracker.addExercise(swim);

        // Categorize
        tracker.categorizeExercise("Cardio", run);
        tracker.categorizeExercise("Strength", lift);
        tracker.categorizeExercise("Cardio", swim);

        // Add goals
        Goal goal1 = new Goal("Burn 1000 calories this week", 1000, "kcal");
        Goal goal2 = new Goal("Lose 2 kg", 2, "kg");
        tracker.addGoal(goal1);
        tracker.addGoal(goal2);

        // Add pending
        tracker.addPendingWorkout(new Exercise("Cycling", 50, 400));
        tracker.addPendingWorkout(new Exercise("Yoga", 60, 150));

        // Setup GUI
        setTitle("Fitness Tracker");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 3, 5, 5));

        inputPanel.add(new JLabel("Exercise Name:"));
        exerciseNameField = new JTextField();
        inputPanel.add(exerciseNameField);

        JButton addExerciseBtn = new JButton("Add Exercise");
        inputPanel.add(addExerciseBtn);

        inputPanel.add(new JLabel("Duration (min):"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        inputPanel.add(new JLabel("Calories:"));
        caloriesField = new JTextField();
        inputPanel.add(caloriesField);

        JButton viewSummaryBtn = new JButton("View Summary");
        inputPanel.add(viewSummaryBtn);

        inputPanel.add(new JLabel("Goal Description:"));
        goalDescField = new JTextField();
        inputPanel.add(goalDescField);

        JButton addGoalBtn = new JButton("Add Goal");
        inputPanel.add(addGoalBtn);

        inputPanel.add(new JLabel("Goal Value:"));
        goalValueField = new JTextField();
        inputPanel.add(goalValueField);

        inputPanel.add(new JLabel("Goal Unit:"));
        goalUnitField = new JTextField();
        inputPanel.add(goalUnitField);

        JButton undoBtn = new JButton("Undo Last Exercise");
        inputPanel.add(undoBtn);

        add(inputPanel, BorderLayout.SOUTH);

        // Button actions
        addExerciseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = exerciseNameField.getText();
                    int duration = Integer.parseInt(durationField.getText());
                    int calories = Integer.parseInt(caloriesField.getText());
                    Exercise ex = new Exercise(name, duration, calories);
                    tracker.addExercise(ex);
                    outputArea.append("Added: " + name + "\n");
                    clearExerciseFields();
                } catch (NumberFormatException ex) {
                    outputArea.append("Invalid input for exercise!\n");
                }
            }
        });

        viewSummaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySummary();
            }
        });

        addGoalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String desc = goalDescField.getText();
                    int value = Integer.parseInt(goalValueField.getText());
                    String unit = goalUnitField.getText();
                    Goal goal = new Goal(desc, value, unit);
                    tracker.addGoal(goal);
                    outputArea.append("Added goal: " + desc + "\n");
                    clearGoalFields();
                } catch (NumberFormatException ex) {
                    outputArea.append("Invalid input for goal!\n");
                }
            }
        });

        undoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tracker.undoLastExercise();
                outputArea.append("Undid last exercise\n");
                displaySummary();
            }
        });

        // Initial display
        displaySummary();
    }

    private void displaySummary() {
        outputArea.setText(""); // Clear
        outputArea.append("--- " + tracker.getUserName() + "'s Fitness Summary ---\n");
        if (tracker.getUser() != null) {
            outputArea.append(tracker.getUser().toString() + "\n");
        }
        for (Exercise e : tracker.getWorkoutLog()) {
            outputArea.append(e.toString() + "\n");
        }
        outputArea.append("Total Calories Burned: " + tracker.getTotalCalories() + "\n\n");
        outputArea.append("Goals:\n");
        for (Goal g : tracker.getGoals()) {
            outputArea.append(g.toString() + "\n");
        }
        outputArea.append("\nPending Workouts:\n");
        for (Exercise e : tracker.getPendingWorkouts()) {
            outputArea.append(e.toString() + "\n");
        }
    }

    private void clearExerciseFields() {
        exerciseNameField.setText("");
        durationField.setText("");
        caloriesField.setText("");
    }

    private void clearGoalFields() {
        goalDescField.setText("");
        goalValueField.setText("");
        goalUnitField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}