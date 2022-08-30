package DOD_GUI;
import DestroyOrDefend.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class DefendersWindow {

    private   Scene scene;
    private int[] counters = new int[14];
    public static int idx = 0;

    public void WindowBuild(Stage DefenceStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("DefendersWindow.fxml"));
        DefenceStage.setTitle("Defenders Units");
        scene = new Scene(root, 950, 540);
        DefenceStage.setScene(scene);
        DefenceStage.setResizable(false);
        DefenceStage.show();

        MenuButton MB = (MenuButton) scene.lookup("#MenuButton1");
        Pane p_Def = (Pane) scene.lookup("#p_DEFENCE");

        int sz = PlayersNumberWindow.DefendersNum;
        MenuItem MI[] = new MenuItem[sz];

        for (int i = 0; i < MI.length; i++) {
            MI[i] = new MenuItem();
            MI[i].setOnAction(e -> {
                setINFteam(e);
            });
        }

        for (int i = 0; i < MI.length; i++) {
            MI[i].setText("Team " + (i + 1));
            MB.getItems().add(MI[i]);
        }
        URL im = getClass().getResource("/Resources/M1.jpg");
        p_Def.setStyle("-fx-background-image: url('" + im + "');-fx-background-position: center center;-fx-background-repeat: stretch;-fx-background-size:cover");

    }
    private void setArmor(MouseEvent e) {
    }
    private void setINFteam(ActionEvent actionEvent) {

        MenuItem it = (MenuItem) actionEvent.getSource();
        idx = Integer.parseInt(String.valueOf(it.getText().charAt(5)));

        if (idx!= 0 && Game.defenders.get(idx-1).units.size() == 0)
        { scene.lookup("#bt_RESET1").setDisable(true); }

        Arrays.fill(counters,0);

        for(int i=0;i < Game.defenders.get(idx-1).units.size();i++){

            if (Game.defenders.get(idx-1).units.get(i).type == 3) {
                counters[1]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 2) {
                counters[2]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 4) {
                counters[3]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 0){
                counters[4]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 1){
                counters[5]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 6){
                counters[6]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 8){
                counters[8]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 9){
                counters[9]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 10){
                counters[10]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 11){
                counters[11]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 12){
                counters[12]++;
            }
            if (Game.defenders.get(idx-1).units.get(i).type == 13){
                counters[13]++;
            }



        }

        for (int i = 1; i <= 12 ; i++) {
            Label lb = (Label) scene.lookup("#lb"+ i );
            if(counters[i] > 0)
            lb.setText(String.valueOf(counters[i]));
            else lb.setText("");
        }
        if(idx != 0)
        ((Label)(scene.lookup("#POINTS1"))).setText(String.valueOf(Game.defenders.get(idx-1).points));
    }

}
