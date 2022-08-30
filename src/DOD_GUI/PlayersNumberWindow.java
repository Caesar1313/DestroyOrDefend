package DOD_GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;


public class PlayersNumberWindow {

    public static int AttackersNum;
    public static int DefendersNum;

    private Scene scene;

    public void WindowBuild(Stage PlayersStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("PlayersNumberWindow.fxml"));
        PlayersStage.setTitle("Players Number");
        scene = new Scene(root, 500, 400);
        PlayersStage.setScene(scene);
        PlayersStage.setResizable(false);

        Pane p_players = (Pane) scene.lookup("#p_PLAYERS");
        URL im = getClass().getResource("/Resources/M4.jpg");
        p_players.setStyle("-fx-background-image: url('" + im + "');-fx-background-position: center center;-fx-background-repeat: stretch;" +
                "-fx-background-size:cover");

        PlayersStage.show();

    }


}
