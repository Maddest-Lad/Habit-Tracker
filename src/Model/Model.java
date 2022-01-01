package Model;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Dev
public class Model implements Serializable {

    private static final transient String FILENAME = "data.dat";
    private Set<Habit> habits;

    public Model() throws IOException, ClassNotFoundException {
        File tempFile = new File(FILENAME);

        // Load Serialized Data
        if (tempFile.exists())
        {
            loadData();
        } else
        {
            habits = new HashSet<Habit>();
        }
    }

    private void loadData() throws IOException, ClassNotFoundException {
        loadData(FILENAME);
    }

    private void loadData(String filename) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.habits = (Set<Habit>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException exp) {
            exp.printStackTrace();
        }
    }


    public void saveData() throws IOException {
        File tempFile = new File(FILENAME);

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
