package code_base;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;

public class sudoku_controller {
    @FXML
    GridPane host;

    @FXML
    Button btn_back;
    @FXML
    Button btn_load;
    @FXML
    Button btn_clear;

    int numrows = 9;
    int numcols = 9;
    int current_board = 0;
    private int[] currently_selected = new int[]{-1, -1};
    String highlight = "#07F4AC";
    String border = "2px";
    String border_color="#808B96";
    int [][] board_01 = new int[][]{
            {0, 0, 0, 2, 6, 0, 7, 0, 1},
            {6, 8, 0, 0, 7, 0, 0, 9, 0},
            {1, 9, 0, 0, 0, 4, 5, 0, 0},
            {8, 2, 0, 1, 0, 0, 0, 4, 0},
            {0, 0, 4, 6, 0, 2, 9, 0, 0},
            {0, 5, 0, 0, 0, 3, 0, 2, 8},
            {0, 0, 9, 3, 0, 0, 0, 7, 4},
            {0, 4, 0, 0, 5, 0, 0, 3, 6},
            {7, 0, 3, 0, 1, 8, 0, 0, 0}};

    public void initialize() {
        for (int x = 0; x < numcols; x++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setFillHeight(true);
            rowConstraints.setValignment(VPos.CENTER);
            rowConstraints.setVgrow(Priority.SOMETIMES);
            host.getRowConstraints().add(rowConstraints);
            if((x == 2) ||(x == 2) ){

            }
        }
        for (int y = 0; y < numrows; y++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setFillWidth(true);
            columnConstraints.setHalignment(HPos.CENTER);
            columnConstraints.setHgrow(Priority.SOMETIMES);
            host.getColumnConstraints().add(columnConstraints);

        }
        //host.setStyle("-fx-border-color:#FF0000");
        for(int x = 0 ; x < numrows; x++){
            for(int y = 0 ; y < numcols; y++){
                add_label(x,y,board_01[x][y]);
            }
        }
    }


    public void back() {
        Stage thisStage = (Stage) btn_back.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
            Scene scene = new Scene(root);
            thisStage.setScene(scene);
            thisStage.show();
            thisStage.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear(){

    }

    public void fetch_board(){
        String path = "source.txt";
        File file = new File(path);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while((line= br.readLine())!=null){
                sb.append(line);
                sb.append("\n");
            }
            fr.close();

            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void highlight(Label me){

        me.setStyle("-fx-border-color:"+highlight+"; -fx-border-radius:5px; -fx-border-width:5px; -fx-padding:10;");
        System.out.println(me.getText());
    }

    public void un_highlight(int [] current){
        Label cell = get_cell(current, host);
        cell.setStyle("-fx-border-color:"+border_color+"; -fx-border-radius:5px; -fx-border-width:"+border+"; -fx-padding:15;");
    }

    public Label get_cell(int [] location, GridPane grid){
        for(Node node : grid.getChildren()){
            if((grid.getColumnIndex(node) == location[1])&&(grid.getRowIndex(node) == location[0])){
                return (Label) node;
            }
        }
      return null;
    }

    public void add_label(int colIndex, int rowIndex, int content){
        Label cell = new Label();
        cell.setText(String.valueOf(content));
        cell.setOnMouseClicked(e -> {
            if(currently_selected[0] != -1){
               un_highlight(currently_selected);
            }
            highlight(cell);
            System.out.println("clicked at :"+colIndex+" , "+rowIndex);
            currently_selected[0] = colIndex;
            currently_selected[1] = rowIndex;
        });
        cell.setStyle("-fx-border-color:"+border_color+"; -fx-border-radius:5px; -fx-border-width:"+border+"; -fx-padding:15;");
        host.add(cell,rowIndex,colIndex);
    }
    @FXML
    private void write(ActionEvent event){
        Button btn = (Button) event.getSource();
        //System.out.println(btn.getText());
        if(currently_selected[0] == -1){
            return;
        }
        Label cell = get_cell(currently_selected,host);
        cell.setText(btn.getText());



    }


}