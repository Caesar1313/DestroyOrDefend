package DOD_GUI;

import DestroyOrDefend.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;



public class Arena {

    private Scene scene;
    private static GridPane gp;

    private int top = 0  ,  down = 19;
    private int left = 0 , right = 19 ;

   private ArrayList<Forces> u;
   private  ArrayList<Obstacle> Ob;

    private static Position B = null;
    public  static Timeline tmln;

    private Button bt_Grid[][];
    private static  String nameOFunits[] = {"Tower","Canon","Solider","Sniper","Tesla Tank","Jet","Air Defence","CarBomb"
                                             ,"Mirage Tank","Grizzly Tank","Navy Seal","Tank Destroyer","Prism Tank","Pillbox"};

    public Arena() throws InterruptedException { }

    public void ArenaBuild(Stage ArenaStage) throws IOException, InterruptedException {

        Parent root = FXMLLoader.load(getClass().getResource("Arena.fxml"));
        ArenaStage.setTitle("Arena");
        ArenaStage.initStyle(StageStyle.TRANSPARENT);

        scene = new Scene(root, 1090, 528.5);
        ArenaStage.setScene(scene);

        Pane p_arena = (Pane) scene.lookup("#p_ARENA");
        p_arena.setStyle("-fx-background-color: #CAC9C9");

        TextFlow tf = (TextFlow) scene.lookup("#tf1");
        tf.setPadding(new Insets(2,0,0,5));
        tf.setStyle("-fx-border-color: #000000");

        gp = (GridPane) scene.lookup("#gp_Arena");

        ArenaStage.setX(250);
        ArenaStage.setY(250);
        ArenaStage.show();

         bt_Grid = new Button[20][20];

        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++) {
                bt_Grid[i][j] = new Button();
                bt_Grid[i][j].setId("bt" + i+"_"+j);
                bt_Grid[i][j].setPrefSize(100, 150);
                bt_Grid[i][j].setStyle("-fx-background-color: #14141414");

                bt_Grid[i][j].setOnMouseClicked(e->{
                    ZoomIN(e);
                    try {
                        setStratgyWin(e);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                });
                gp.add(bt_Grid[i][j], i, j);
            }

        setUnitsOnArena();

        ToggleButton tg = (ToggleButton) scene.lookup("#tg_PAUSE") ;
        setImageOnToggle(tg);
        Label lb = (Label) scene.lookup("#lb_Timer");
        lb.setStyle("-fx-border-color : #ffffff");


        tmln = new Timeline(new KeyFrame(Duration.seconds(0.15), e -> {

              left = Controller.left;top = Controller.top;
              down = Controller.down;right = Controller.right;

              ShowUnits();
              if(tg.isSelected()) Game.pause();
              else Game.resume();
             lb.setText(setTime());

        }));
        tmln.setCycleCount(Timeline.INDEFINITE);
        tmln.play();
    }

    private String setTime() {

        int min,sec,hor,time;

        min = sec = hor = 0;
        time = BattleTime.i;
        while (time >= 60)
        {
           time-=60;
           min++;
            if (min >= 60)
            {
                min-=60;
                hor++;
            }
        }
        sec = time;
        return hor+":"+min+":"+sec;
    }
    private void setImageOnToggle(ToggleButton tg) {
        Image im = new Image(getClass().getResourceAsStream("/Resources/pauseIcon.png"));
        ImageView imv = new ImageView(im);
        imv.setFitHeight(40);
        imv.setFitWidth(38);
        imv.setPreserveRatio(false);
        tg.setGraphic(imv);
        tg.setOnMouseClicked(e->{
            pauseButton(e);
        });
    }
    private void ShowUnits() {

        Button bt_change;
        u = (ArrayList<Forces>) Game.unitsInArena;
        int x , y , z ,xp,yp;

        Reset_Arena();

        for (int i = 0; i < u.size(); i++) {

          x = u.get(i).Position.x;
          y = u.get(i).Position.y;
          z = u.get(i).type;

         if (x >= left && x <= right && y >= top && y <= down) {

                xp=x;  yp=y;

                if(x >= 19) x-=left;
                if(y >= 19) y-=top;
                bt_change = (Button) gp.lookup("#bt" +x+"_"+y);
                bt_change.setText(String.valueOf(z));
                Forces fc = getUnit(xp, yp);

                if (fc != null) {
                    if (fc.PlayerType == 1)
                    {
                        switch (z)
                        {
                            case 2:{
                                bt_change.setStyle("-fx-border-color: #0000ff;" +
                                        "-fx-border-width:3px 3px 3px 3px;");
                                break;
                            }
                            case 3:{
                                bt_change.setStyle("-fx-border-color: #0000ff;" +
                                        "-fx-border-width:3px 3px 3px 3px;");
                                break;
                            }
                            case 4:{
                                bt_change.setStyle("-fx-border-color: #0000ff;-fx-border-width:8px 8px 8px 8px;");
                                break;
                            }
                            case 5:{
                                bt_change.setStyle("-fx-border-color: #0000ff;" +
                                        "-fx-border-width:12px 12px 12px 12px;");
                                break;
                            }
                            case 7:{ bt_change.setStyle("-fx-border-color: #0000ff;" +
                                    "-fx-border-width:5px 5px 5px 5px;");
                                break;
                            }
                            case 8:{
                                bt_change.setStyle("-fx-border-color: #0000ff;" +
                                        "-fx-border-width:8px 8px 8px 8px;");
                            }
                            case 9:{
                                bt_change.setStyle("-fx-border-color: #0000ff;" +
                                        "-fx-border-width:8px 8px 8px 8px;");
                                break;
                            }
                            case 10:{
                                bt_change.setStyle("-fx-border-color: #0000ff;" +
                                        "-fx-border-width:3px 3px 3px 3px;");
                                break;
                            }
                            case 11:{
                                bt_change.setStyle("-fx-border-color: #0000ff;" +
                                        "-fx-border-width:8px 8px 8px 8px;");
                                break;
                            }
                            case 12:{
                                bt_change.setStyle("-fx-border-color: #0000ff;" +
                                        "-fx-border-width:8px 8px 8px 8px;");
                                break;
                            }
                        }
                    }
                    else {

                        switch (z)
                        {

                            case 0:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:15px 10px 15px 10px;");
                                break;
                            }
                            case 1:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:7px 7px 7px 7px;");
                                break;
                            }
                            case 2:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:3px 3px 3px 3px;");
                                break;
                            }
                            case 3:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:3px 3px 3px 3px;");
                                break;
                            }
                            case 4:{
                                bt_change.setStyle("-fx-border-color: #ff0000;-fx-border-width:8px 8px 8px 8px;");
                                break;
                            }
                            case 6:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:6px 6px 6px 6px;");
                                break;
                            }
                            case 8:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:8px 8px 8px 8px;");
                            }
                            case 9:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:8px 8px 8px 8px;");
                                break;
                            }
                            case 10:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:3px 3px 3px 3px;");
                                break;
                            }
                            case 11:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:8px 8px 8px 8px;");
                                break;
                            }
                            case 12:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:8px 8px 8px 8px;");
                                break;
                            }
                            case 13:{
                                bt_change.setStyle("-fx-border-color: #ff0000;" +
                                        "-fx-border-width:2px 5px 2px 5px;");
                            }
                        }
                    }
                }
            }
        }
        if(B.x >= Controller.left && B.x <=Controller. right && B.y >= Controller.top && B.y <= Controller.down) {
            bt_change = (Button) gp.lookup("#bt" + B.x+"_"+B.y);
            bt_change.setText("X");
            bt_change.setStyle("-fx-border-color: #ffff00;-fx-border-width:15px 15px 15px 15px;-fx-border-insets:5px 5px 5px 5px;");
        }
        ShowObstacles();
        if (Game.state != Game.GameState.RunningGame && Game.state != Game.GameState.Initialization) {
            tmln.stop();
        }

    }
    private void Reset_Arena (){

        Button bt_empty;
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++) {
                bt_empty = (Button) gp.lookup("#bt" +i+"_"+ j);
                bt_empty.setText("");
                 bt_empty.setStyle("-fx-background-color: #14141414");

            }
    }
    private void ZoomIN(MouseEvent mouseEvent) {

        if(Game.state != Game.GameState.RunningGame && Game.state != Game.GameState.Initialization) return;

        Button b_tmp = (Button) mouseEvent.getSource();
        Scene sc = b_tmp.getScene();
        TextFlow tf = (TextFlow) sc.lookup("#tf1");
        tf.getChildren().clear();
        int x,y;

        String id[] = (b_tmp.getId().substring(2)).split("_");
        x = Integer.parseInt(id[0]);
        y = Integer.parseInt(id[1]);

        if (left != 0) x+=left;
        if (top != 0)  y+=top;

        String ToText=null;

        if(x == B.x && y == B.y) { ToText ="Base \n"+"Health : "+Game.base.health;}
        else {
            Forces fc = getUnit(x, y);
            if (fc != null) {
                ToText = nameOFunits[fc.type] + "\n" + "Health : " + fc.health + "\n" + "Attack Damage : " + fc.attack_value + "\n";
                ToText += "Player :"+ ((fc.PlayerType == 1) ? "Attacker\n" : "Defender\n");
                ToText += "Position : "+x+" , "+y+"\n";
            }
        }

        if(ToText != null) { tf.getChildren().add(new Text(ToText)); }
        else  tf.getChildren().add(new Text("No Units"));
    }
    private  Forces  getUnit(int x,int y) {

        u = (ArrayList<Forces>) Game.unitsInArena;
        for (int i = 0; i < u.size() ; i++) {
            if((u.get(i).Position.x == x ) && (u.get(i).Position.y == y))
                return u.get(i);
        }
        return null;
    }
    private void ShowObstacles() {
        Button bt_change;
        Ob = (ArrayList<Obstacle>) Game.obstaclesInArena;
        int x , y , z;

        for (int i = 0; i < Ob.size(); i++) {

            x = Ob.get(i).Position.x;
            y = Ob.get(i).Position.y;
            z = Ob.get(i).type;

            if (x >= left && x <= right && y >= top && y <= down) {

                if(x >= 19) x-=left;
                if(y >= 19) y-=top;

                bt_change = (Button) gp.lookup("#bt" +x+ "_" +y);
                bt_change.setText(String.valueOf(z));
                switch (z)
                {
                    case 0 :{
                        bt_change.setStyle("-fx-background-color:#87ceeb");
                        break;
                    }
                    case 1:{
                        bt_change.setStyle("-fx-background-color:#A52A2A");
                        break;
                    }
                    case 2:{
                        bt_change.setStyle("-fx-background-color: #228B22");
                        break;
                    }
                }
            }
        }
    }
    private void setStratgyWin(MouseEvent mouseEvent) throws IOException, InterruptedException {

        if(Game.state == Game.GameState.RunningGame) return;
        Button bt_tmp = (Button) mouseEvent.getSource();
        String id[] = bt_tmp.getId().substring(2).split("_");
        int x = Integer.parseInt(id[0]);
        int y = Integer.parseInt(id[1]);
        (new StrategyWindow()).WindowBuild(new Stage(),getUnit(x,y));


    }
    private void setUnitsOnArena() throws InterruptedException {
        if(Controller.G == null) Controller.G = new Game();
        Arena.B = Game.base.BasePosition;
        ShowUnits();
    }
    private void  pauseButton(MouseEvent mouseEvent) {
        ToggleButton tg = (ToggleButton) mouseEvent.getSource();
        if (tg.isSelected())
        {
            Image im = new Image(getClass().getResourceAsStream("/Resources/stopIcon.png"));
            ImageView imv = new ImageView(im);
            imv.setFitHeight(40);
            imv.setFitWidth(38);
            imv.setPreserveRatio(true);
            tg.setGraphic(imv);
        }
        else {
            Image im = new Image(getClass().getResourceAsStream("/Resources/pauseIcon.png"));
            ImageView imv = new ImageView(im);
            imv.setFitHeight(40);
            imv.setFitWidth(38);
            imv.setPreserveRatio(true);
            tg.setGraphic(imv);
        }

    }

}
