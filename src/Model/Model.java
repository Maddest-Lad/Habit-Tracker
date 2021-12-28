package Model;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Model implements Serializable {

    private static String filename = "data.dat";
    private Set<Habit> habits;

    public Model() throws IOException, ClassNotFoundException {
        File tempFile = new File(filename);

        // Load Serialized Data
        if (tempFile.exists())
        {
            habits = loadData();
        } else
        {
            habits = new HashSet<Habit>();
        }
    }

    public Set<Habit> loadData() throws IOException, ClassNotFoundException {
        File tempFile = new File(filename);
        FileInputStream fis = new FileInputStream(tempFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Set<Habit> habits = (Set<Habit>) ois.readObject();
        ois.close();
        return habits;
    }


    public void saveData() throws IOException {
        File tempFile = new File(filename);

        FileOutputStream fos = new FileOutputStream(tempFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(habits);
        oos.close();
    }

    public void addHabits(Habit... habits) {
        Collections.addAll(this.habits, habits);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Model {" + "\n");
        for (Habit h : habits)
        {
            sb.append("   ").append(h.toString()).append("\n");
        }
        sb.append("}");

        return sb.toString();
    }
}
