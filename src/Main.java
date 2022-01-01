import Model.Model;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Model model = new Model();

        // Create Data
        //Habit A = new Habit("Sleep Before 4", 3, 0);
        //Habit B = new Habit("Read", 3, 3);
        //Habit C = new Habit("Brush Teeth", 3, 2);

        //model.addHabits(A, B, C);
        //System.out.println(model);

        // Load Data
        System.out.println(model);

    }

}