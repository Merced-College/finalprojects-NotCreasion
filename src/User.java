/*
Author: Estefania Reyes
Class: User.java

Description:
Represents a user in the fitness tracker application.
Stores user information and preferences using a HashMap.
*/
import java.util.HashMap;

public class User {
    private String name;
    private int age;
    private double weight; // in kg
    private double height; // in cm
    private HashMap<String, String> preferences; // e.g., "theme" -> "dark"

    public User(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.preferences = new HashMap<>();
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public void addPreference(String key, String value) {
        preferences.put(key, value);
    }

    public String getPreference(String key) {
        return preferences.get(key);
    }

    public double calculateBMI() {
        double heightM = height / 100;
        return weight / (heightM * heightM);
    }

    @Override
    public String toString() {
        return "User: " + name + ", Age: " + age + ", BMI: " + String.format("%.2f", calculateBMI());
    }
}