public class Main {
    public static void main(String[] args) {
        FitnessTracker myTracker = new FitnessTracker("User");
        
        // Meaningful progress: adding initial data
        myTracker.addExercise(new Exercise("Running", 30, 300));
        myTracker.addExercise(new Exercise("Weightlifting", 45, 200));
        
        myTracker.displaySummary();
    }
}