package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Habit implements Serializable {

    public final String name;
    private final int max;
    private int current;
    private ArrayList<TimeData> history;

    // First Time
    public Habit(String name, int max, ArrayList<TimeData> history) {
        this.name = name;
        this.max = max;
        this.current = 0;
        this.history = new ArrayList<>();
    }

    // Otherwise
    public Habit(String name, int max, int current) {
        this.name = name;
        this.max = max;
        this.current = current;
        this.history = new ArrayList<>();
    }

    // Getters / Setters
    public int getCurrent() {
        return current;
    }

    public int getMax() {
        return max;
    }

    public void increment() {
        current += 1;
        current = clamp(current, max);
        log(current);
    }

    public void decrement() {
        current -= 1;
        current = clamp(current, max);
        log(current);
    }

    public void log(int currentState) {
        this.history.add(new TimeData(currentState));
    }

    static int clamp(int val, int max) {
        return Math.max(0, Math.min(max, val));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habit habit = (Habit) o;
        return name.equals(habit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Habit{" +
                "name='" + name + '\'' +
                ", max=" + max +
                ", current=" + current +
                '}';
    }
}

class TimeData {

    public final long timestamp;
    public final int value;

    TimeData(int value) {
        timestamp = new Date().getTime();
        this.value = value;
    }
}
