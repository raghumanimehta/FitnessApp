package Account;

import Workouts.Workout;
import exceptions.WorkoutNotFoundException;

import java.util.*;

public class Account {

    private String Name;
    private int id;
    private String email; // The email of the account holder.
    private String password; // The password of the account.
    private List<Workout> workouts; // A list of workouts associated with the account.
    private double weight; // The weight of the account holder in kg
    private double height; // The height of the account holder in cm
    private int age; // The age of the account holder in years
    private boolean sex; // sex of the user, true for male and false for female
    private Goal goal; // The goal of the account holder in terms of weight management.
    private Map<Date, List<Workout>> workoutMap; // A map of workouts associated with the account, with the date as the key.

    public enum Goal {
        MAINTAIN_WEIGHT,
        LOSE_WEIGHT,
        GAIN_WEIGHT
    }

    public Account(String name, String email, String password,
                   double weight, double height, int age, Goal goal, boolean sex) {
        Name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.goal = goal;
        this.sex = sex;
        this.workouts = new ArrayList<>();
        this.workoutMap = new HashMap<>();
    }

    // Effects: returns true if the user is overweight
    private boolean isOverweight(){
        double heightInMeters = height / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);
        return bmi > 25;
    }

    private boolean isUnderweight(){
        double heightInMeters = height / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);
        return bmi < 18.5;
    }

    // Effects: returns the daily calorie suggestions for the user.
    public double calculateSuggestedCals() {
        double calories;
        if (sex) { // Male
            calories = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else { // Female
            calories = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        if (goal == Goal.LOSE_WEIGHT) {
            calories -= 500;
        } else if (goal == Goal.GAIN_WEIGHT) {
            calories += 500;
        }
        return calories;
    }

    // Effects: returns the suggested goal of the user
    public Goal suggestGoal() {
        if (isOverweight()) {
            return Goal.LOSE_WEIGHT;
        } else if (isUnderweight()) {
            return Goal.GAIN_WEIGHT;
        } else {
            return Goal.MAINTAIN_WEIGHT;
        }
    }

    // Modifies: this
    // Effects: adds workout to the account ** add the feature to make sure that there can't be two workouts at the same
    //          time and date and to resolve the clash.
    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
        if (workoutMap.containsKey(workout.getDate())) {
            workoutMap.get(workout.getDate()).add(workout);
        } else {
            List<Workout> workoutList = new ArrayList<>();
            workoutList.add(workout);
            workoutMap.put(workout.getDate(), workoutList);
        }
    }

    public void removeWorkout(Workout workout) throws WorkoutNotFoundException {
        if (!this.workouts.contains(workout) && !workoutMap.containsKey(workout.getDate())) {
            throw new WorkoutNotFoundException();
        }
        this.workouts.remove(workout);
        if (workoutMap.containsKey(workout.getDate())) {
            List<Workout> listOfWorkout = workoutMap.get(workout.getDate());
            listOfWorkout.remove(workout);
        }
    }

//
//    public void removeWorkout(Workout workout) {
//        this.workouts.remove(workout);
//        if (workoutMap.containsKey(workout.getDate())) {
//            for (Workout workout1: workoutMap.get(workout.getDate())) {
//                if (workout == workout1) {
//
//                }
//            }
//        }
//    }
}
