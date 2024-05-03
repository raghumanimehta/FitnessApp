package Workouts;

import java.sql.Time;
import java.util.Date;

public class WeightLifting implements Workout {

    private Time time;
    private int caloriesBurned;
    private int heartRate;
    private int weightLifted; // The amount of weight lifted during the workout.
    private int repetitions; // The number of repetitions performed.
    private Date date;
    private Time duration;


    @Override
    public int countCalories() {
        return this.caloriesBurned;
    }

    @Override
    public Time getDuration() {
        return this.time;
    }

    @Override
    public int getHeartRate() {
        return this.heartRate;
    }

    @Override
    public String getType() {
        return "Weightlifting";
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    public Time getTime() {
        return this.time;
    }

    public int getWeightLifted() {
        return this.weightLifted;
    }

    public int getRepetitions() {
        return this.repetitions;
    }

    public int totalMassMoved() {
        return (this.repetitions * this.weightLifted);
    }
}