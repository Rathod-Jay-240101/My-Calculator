package mycalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MyCalculator extends Application {

    public static void main(String args[]) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
        Scene scene = new Scene(root);
        Image image = new Image("mycalculator/MyCalculator.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.setTitle("My Calculator");
        stage.show();
    }

}
