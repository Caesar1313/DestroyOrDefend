package DOD_GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.net.URL;


public class StartWindow extends Application{

    private   Scene scene;
    public StartWindow() throws InterruptedException {
    }

    @Override
    public void start(Stage StartStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("StartWindow.fxml"));
        StartStage.setTitle("DestroyOrDefend");
        scene = new Scene(root, 800, 650);
        Pane p_start = (Pane) scene.lookup("#p_START");
        Label lb_start = (Label) scene.lookup("#lb_START");

        URL im = getClass().getResource("/Resources/M4.jpg");
        p_start.setStyle("-fx-background-image: url('" + im + "');-fx-background-position: center center;-fx-background-repeat: stretch;-fx-background-size:cover");
        lb_start.setStyle("-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 )");

        StartStage.setScene(scene);
        StartStage.setResizable(false);

        StartStage.show();

    }
}
