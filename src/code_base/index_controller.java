package code_base;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class index_controller {
    @FXML
    Button sudoku;

    public void open_sudoku(){
        Stage thisStage = (Stage) sudoku.getScene().getWindow();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("sudoku.fxml"));
            Scene  scene = new Scene (root);
            thisStage.setScene(scene);
            thisStage.show();
            thisStage.centerOnScreen();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
