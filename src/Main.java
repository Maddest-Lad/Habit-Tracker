//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

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
        //model.saveData();

        // Load Data
        model.loadData();
        System.out.println(model);

    }

}