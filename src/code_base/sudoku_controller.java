package code_base;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class sudoku_controller {
    @FXML
    GridPane host;

    @FXML
    Button btn_back;
    @FXML
    Button btn_load;

    public void back(){
        Stage thisStage = (Stage) btn_back.getScene().getWindow();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
            Scene scene = new Scene(root);
            thisStage.setScene(scene);
            thisStage.show();
            thisStage.centerOnScreen();
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

    public void print_board(){

    host.add(new Text("5"),2,2);
    }

}
