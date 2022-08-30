package DOD_GUI;

import DestroyOrDefend.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class AttackersWindow {

    private Scene scene;
    private int[] counters = new int[23];
    public static int idx;

    AttackersWindow(){}

    public void WindowBuild(Stage AttackStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AttackersWindow.fxml"));
        AttackStage.setTitle("Attackers Units");

        scene = new Scene(root, 850, 520);
        AttackStage.setScene(scene);
        AttackStage.setResizable(false);
        AttackStage.show();

        MenuButton MB = (MenuButton) scene.lookup("#MenuButton2");
        Pane p_Ata = (Pane) scene.lookup("#p_ATTACK");

        int sz = PlayersNumberWindow.AttackersNum;
        MenuItem MI[] = new MenuItem[sz];

        for (int i = 0; i <MI.length ; i++) {
            MI[i] = new MenuItem();
            MI[i].setOnAction(e->{
                setINFteam(e);
            });

        }
        for (int i=0;i < MI.length; i++) {
            MI[i].setText("Team "+ (i+1) );
            MB.getItems().add(MI[i]);
        }
        URL im = getClass().getResource("/Resources/M1.jpg");
        p_Ata.setStyle("-fx-background-image: url('" + im + "');-fx-background-position: center center;-fx-background-repeat: stretch;-fx-background-size:cover");
    }

    private void setArmor(MouseEvent e) {
    }
    private void setINFteam(ActionEvent actionEvent) {

        MenuItem it = (MenuItem) actionEvent.getSource();
        idx = Integer.parseInt(String.valueOf(it.getText().charAt(5)));

        if (idx!= 0 && Game.attackers.get(idx-1).units.size() == 0)
        { scene.lookup("#bt_RESET2").setDisable(true); }
        Arrays.fill(counters,0);
        for(int i=0;i < Game.attackers.get(idx-1).units.size();i++){

            if (Game.attackers.get(idx-1).units.get(i).type == 3) {
                counters[13]++;
            }
            if (Game.attackers.get(idx-1).units.get(i).type == 2) {

                counters[14]++;
            }
            if (Game.attackers.get(idx-1).units.get(i).type == 4) {
                counters[15]++;
            }
            if (Game.attackers.get(idx-1).units.get(i).type == 5) {
                counters[16]++;
            }
            if (Game.attackers.get(idx-1).units.get(i).type == 7) {
                counters[17]++;
            }
            if (Game.attackers.get(idx-1).units.get(i).type == 8) {
                counters[18]++;
            }
            if (Game.attackers.get(idx-1).units.get(i).type == 9) {
                counters[19]++;
            }
            if (Game.attackers.get(idx-1).units.get(i).type == 10) {
                counters[20]++;
            }
            if (Game.attackers.get(idx-1).units.get(i).type == 11) {
                counters[21]++;
            }
            if (Game.attackers.get(idx-1).units.get(i).type == 12) {
                counters[22]++;
            }

        }
        for (int i = 13; i <= 22 ; i++) {

           Label lb = (Label) scene.lookup("#lb"+ i );
            if(counters[i] > 0)
             lb.setText(String.valueOf(counters[Integer.valueOf(lb.getId().substring(2))]));
            else lb.setText("");

            if(idx != 0)
             ((Label)(scene.lookup("#POINTS2"))).setText(String.valueOf(Game.attackers.get(idx-1).points));
        }
    }
}


