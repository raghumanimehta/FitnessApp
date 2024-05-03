package Workouts;

import java.sql.Time;
import java.util.Date;

public class Running implements Workout {

    private Time time; // The time taken to complete the run.
    private int distance;
    private int netElevation;
    private int caloriesBurned;
    private int  AvgHeartRate;
    private int spm;
    private double averageSpeed;
    private String route;
    private Date date;
    private Time startTime; // The time when the run started.

    public Running(Time time, int distance, int netElevation, int caloriesBurned, int avgHeartRate, int spm, double averageSpeed, String route, Date date, Time startTime) {
        this.time = time;
        this.distance = distance;
        this.netElevation = netElevation;
        this.caloriesBurned = caloriesBurned;
        this.AvgHeartRate = avgHeartRate;
        this.spm = spm;
        this.averageSpeed = averageSpeed;
        this.route = route;
        this.date = date;
        this.startTime = startTime;
    }

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
        return this.getHeartRate();
    }

    @Override
    public String getType() {
        return "Running";
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public int getDistance() {
        return distance;
    }

    public int getNetElevation() {
        return netElevation;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public int getAvgHeartRate() {
        return AvgHeartRate;
    }

    public int getSpm() {
        return spm;
    }

    public String getRoute() {
        return route;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return new Time(startTime.getTime() + time.getTime());
    }
}
