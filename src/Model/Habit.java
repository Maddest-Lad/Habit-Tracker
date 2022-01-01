package Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Habit {

    public final String name;
    private final int max;
    private final List<HabitRecord> history;
    private int current;

    public Habit(String name, int max, List<HabitRecord> history) {
        this.name = name;
        this.max = max;
        this.current = 0;
        this.history = new ArrayList<>();
    }

    static int clamp(int val, int max) {
        return Math.max(0, Math.min(max, val));
    }

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
        HabitRecord hr = new HabitRecord(currentState);
        this.history.add(hr);

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

// Data Class
class HabitRecord implements Serializable {

    public final int score;
    public final String date;

    public HabitRecord(int score) {
        this.score = score;
        this.date = LocalDateTime.now().toString();
    }
}
