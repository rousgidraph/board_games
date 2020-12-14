package code_base;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.AmbientLight;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ResourceBundle;

public class Gridsample  {
    @FXML
    GridPane Grid;
    private int[] currently_selected=new int [] {-1,-1};
    double grid_height = 500;
    double grid_width = 500;
    int numRows = 9;
    int numCols = 9;
    String highlight = "#FF0000";

    public void initialize() {


        for(int i = 0; i <numCols; i++ ){
            ColumnConstraints   colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            colConstraints.setHalignment(HPos.CENTER);
            colConstraints.setFillWidth(true);
            Grid.getColumnConstraints().add(colConstraints);
        }
        for(int y = 0 ; y < numRows; y ++){
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setValignment(VPos.CENTER);
            rowConstraints.setVgrow(Priority.SOMETIMES);
            rowConstraints.setFillHeight(true);
            Grid.getRowConstraints().add(rowConstraints);

        }
        for(int i = 0; i <numRows; i++ ){
            for(int y = 0 ; y < numRows; y ++) {
            addPane(i,y,0);
            }
        }
        Grid.setPrefHeight(grid_height);
        Grid.setPrefWidth(grid_width);
        Grid.setStyle("-fx-border-color:#000;");
    }

    private Label get_cell(int[] location, GridPane grid){
        for(Node node: grid.getChildren()){
            if((GridPane.getColumnIndex(node) == location[0]) && (GridPane.getRowIndex(node) == location[1])){
                return (Label) node;
            }
        }
    return null;
    }

    private void addPane(int colIndex, int rowIndex,int content ) {
        Label pane = new Label();
        pane.setText(String.valueOf(content));
        pane.setOnMouseClicked(e -> {
            if(currently_selected[0] != -1){
                turn_me_off(currently_selected);
            }
            System.out.printf("Mouse entered cell [%d, %d]%n", colIndex, rowIndex);
            turn_me_on(pane);
            currently_selected[0] = colIndex;
            currently_selected[1] = rowIndex;
        });


        pane.setPadding(new Insets(15,15,15,15));
        pane.setStyle("-fx-border-color:#000; -fx-border-radius:5px;");

        Grid.add(pane, colIndex, rowIndex);
    }

    private void turn_me_on(Label me){
       me.setStyle("-fx-border-color:"+highlight+"; -fx-border-radius:5px; -fx-border-width:5; -fx-padding:10;");
        System.out.println(me.getText());
    }

    private void turn_me_off(int [] current){
        Label cell = get_cell(current,Grid);
        cell.setStyle("-fx-border-color:#000; -fx-border-radius:5px;");

    }


}

class cell{
    Pane pane;
    Text text;

    public cell(){
        pane = new Pane();
        text = new Text("5");
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String text) {
        this.text = new Text(text);
    }
}

