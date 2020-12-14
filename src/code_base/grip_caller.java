package code_base;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class grip_caller extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gridsample.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Click the grid");
        stage.setScene(scene);
        stage.show();
    }
}
