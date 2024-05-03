package Workouts;

import java.sql.Time;
import java.util.Date;

public interface Workout {

    int countCalories();

    Time getDuration(); // To get the duration of the workout.

    int getHeartRate(); // To get the heart rate during the workout.

    String getType(); // To get the type of the workout.

    Date getDate(); // To get the date when the workout was performed.
}

