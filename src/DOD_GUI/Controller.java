package DOD_GUI;

import  DestroyOrDefend.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    public static int top = 0, down = 19;
    public static int left = 0, right = 19;
    private int xdp = 5,ydp = 5,xap = 17,yap = 17;

    public static Game G = null;

    public TextField Atxt, Dtxt;

    public Controller() throws InterruptedException { }

    public void Down(MouseEvent mouseEvent) throws IOException, InterruptedException {

        if (down + 19 > 10000) return;

        Button b_tmp = (Button) mouseEvent.getSource();
        Scene sc = b_tmp.getScene();
        TextFlow tf = (TextFlow) sc.lookup("#tf1");
        tf.getChildren().clear();
        tf.getChildren().add(new Text("Down Button is pressed"));


        if (b_tmp.getId().equals("bt_DOWN")) {
            top += 19;
            down += 19;
        }

    }
    public void Up(MouseEvent mouseEvent) throws IOException, InterruptedException {

        if ((top - 19) < 0) return;


        Button b_tmp = (Button) mouseEvent.getSource();
        Scene sc = b_tmp.getScene();
        TextFlow tf = (TextFlow) sc.lookup("#tf1");
        tf.getChildren().clear();
        tf.getChildren().add(new Text("Up Button is pressed"));


        if (b_tmp.getId().equals("bt_UP")) {
            top -= 19;
            down -= 19;
        }

    }
    public void Right(MouseEvent mouseEvent) throws IOException, InterruptedException {

        if ((right + 19) > 10000) return;

        Button b_tmp = (Button) mouseEvent.getSource();
        Scene sc = b_tmp.getScene();
        TextFlow tf = (TextFlow) sc.lookup("#tf1");
        tf.getChildren().clear();
        tf.getChildren().add(new Text("Right Button is pressed"));


        if (b_tmp.getId().equals("bt_RIGHT")) {
            left += 19;
            right += 19;
        }

    }
    public void Left(MouseEvent mouseEvent) throws IOException, InterruptedException {

        if ((left - 19) < 0) return;

        Button b_tmp = (Button) mouseEvent.getSource();
        Scene sc = b_tmp.getScene();
        TextFlow tf = (TextFlow) sc.lookup("#tf1");
        tf.getChildren().clear();
        tf.getChildren().add(new Text("Left Button is pressed\n"));

        if (b_tmp.getId().equals("bt_LEFT")) {
            left -= 19;
            right -= 19;
        }
    }


    public void Go(MouseEvent mouseEvent) throws IOException, InterruptedException {
        goto1(mouseEvent);
        ((Stage) ((Button) mouseEvent.getSource()).getScene().getWindow()).close();
    }
    public void goto1(MouseEvent mouseEvent) throws IOException, InterruptedException {

        Button bt_tmp = (Button) mouseEvent.getSource();
        Scene sc = bt_tmp.getScene();

        if (bt_tmp.getId().equals("bt_START")) {
            (new PlayersNumberWindow()).WindowBuild(new Stage());
        }
        if (bt_tmp.getId().equals("bt_NEXT")) {

            Atxt = (TextField) sc.lookup("#Atxt");
            Dtxt = (TextField) sc.lookup("#Dtxt");
            try {
                if (Atxt.getText().isEmpty() || Dtxt.getText().isEmpty() || Atxt.getText().equals("0") || Dtxt.getText().equals("0")) throw new Exception();
            } catch (Exception e) {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("Incomplete answer !!");
                al.setContentText("There is an Error occurred , please check the numbers of players");
                al.show();
                return;
            }


            PlayersNumberWindow.AttackersNum = (Atxt.getText().isEmpty()) ? 0 : Integer.parseInt(Atxt.getText());
            PlayersNumberWindow.DefendersNum = (Dtxt.getText().isEmpty()) ? 0 : Integer.parseInt(Dtxt.getText());

            for (int i = 0; i < PlayersNumberWindow.DefendersNum; i++) {
                Game.defenders.add(new defender());
            }
            for (int i = 0; i < PlayersNumberWindow.AttackersNum; i++) {
                Game.attackers.add(new attacker());

            }
            goto2(mouseEvent);
            ((Stage) ((Button) mouseEvent.getSource()).getScene().getWindow()).close();
        }
    }
    public void goto2(MouseEvent mouseEvent) throws IOException, InterruptedException {

        Button bt_tmp = (Button) mouseEvent.getSource();

        if (bt_tmp.getId().equals("bt_NEXT")) {
            (new DefendersWindow()).WindowBuild(new Stage());
        }
        if (bt_tmp.getId().equals("bt_READY1")) {
            goto3(mouseEvent);
            ((Stage) ((Button) mouseEvent.getSource()).getScene().getWindow()).close();

        }
    }
    public void goto3(MouseEvent mouseEvent) throws IOException, InterruptedException {

        Button bt_tmp = (Button) mouseEvent.getSource();
        if (bt_tmp.getId().equals("bt_READY1")) {
            (new AttackersWindow()).WindowBuild(new Stage());
        }
        if (bt_tmp.getId().equals("bt_READY2")) {
            goto4(mouseEvent);
            ((Stage) ((Button) mouseEvent.getSource()).getScene().getWindow()).close();
        }
    }
    public void goto4(MouseEvent mouseEvent) throws IOException, InterruptedException {

        (new Arena()).ArenaBuild(new Stage());
        ((Stage) ((Button) mouseEvent.getSource()).getScene().getWindow()).close();
    }


    public void ctr_sniper1(MouseEvent mouseEvent) {

        try {
            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 5 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new Units(true,xdp,ydp,3));
            ydp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV1")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb1");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 5;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }
    }
    public void ctr_soldier1(MouseEvent mouseEvent) {

        try {

            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 3 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new Units(true,xdp,ydp,2));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV2")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb2");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);

            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 3;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }
    }
    public void ctr_TeslaTank1(MouseEvent mouseEvent) {

        try {
            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 50 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new Units(true,xdp,ydp,4));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV3")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb3");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);

            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 50;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }
    }
    public void ctr_tower1(MouseEvent mouseEvent) {

        try {

            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 150 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new DefenceStructure(true,xdp,ydp,0));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV4")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb4");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 150;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));

        }

    }
    public void ctr_Cannon1(MouseEvent mouseEvent) {

        try {

            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 200 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new DefenceStructure(true,xdp,ydp,1));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV5")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb5");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 200;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));

        }


    }
    public void ctr_AirDefence(MouseEvent mouseEvent) {

        try {

            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 175 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new DefenceStructure(true,xdp,ydp,6));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV6")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb6");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 175;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }

    }
    public void ctr_PrismTank1(MouseEvent mouseEvent) {

        try {
            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 5 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new Units(true,xdp,ydp,12));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV11")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb11");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 5;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }
    }
    public void ctr_MirageTank1(MouseEvent mouseEvent) {

        try {
            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 5 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new Units(true,xdp,ydp,8));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV7")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb7");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 5;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }
    }
    public void ctr_GrizzlyTank1(MouseEvent mouseEvent) {

        try {
            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 5 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new Units(true,xdp,ydp,9));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV8")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb8");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 5;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }
    }
    public void ctr_NavySeal1(MouseEvent mouseEvent) {

        try {
            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 5 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new Units(true,xdp,ydp,10));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV9")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb9");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 5;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }
    }
    public void ctr_TankDestroyer1(MouseEvent mouseEvent) {

        try {
            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 5 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new Units(true,xdp,ydp,11));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV10")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb10");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 5;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }
    }
    public void ctr_PillBox1(MouseEvent mouseEvent) {

        try {
            if(DefendersWindow.idx == 0) throw new Exception();
            if (Game.defenders.get(DefendersWindow.idx - 1).points - 5 < 0) return;
            Game.defenders.get(DefendersWindow.idx-1).units.add(new DefenceStructure(true,xdp,ydp,13));
            xdp+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV12")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb12");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY1");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET1");
            bt_tmp.setDisable(false);
            Game.defenders.get(DefendersWindow.idx - 1).points -= 5;
            ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(Game.defenders.get(DefendersWindow.idx - 1).points));
        }
    }


    public void ctr_sniper2(MouseEvent mouseEvent) {

        try {
            if(AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 5 < 0) return;
            Game.attackers.get(AttackersWindow.idx-1).units.add(new Units(true,xap,yap,3));
            xap+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV13")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb13");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);
            Game.attackers.get(AttackersWindow.idx - 1).points -= 5;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));

        }
    }
    public void ctr_soilder2(MouseEvent mouseEvent) {

        try {


            if(AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 3 < 0) return;
            Game.attackers.get(AttackersWindow.idx-1).units.add(new Units(true,xap,yap,2));
            xap+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }

        ImageView im_tmp = (ImageView) mouseEvent.getSource();

        if (im_tmp.getId().equals("IMV14")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb14");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);

            Game.attackers.get(AttackersWindow.idx - 1).points -= 3;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));


        }
    }
    public void ctr_TeslaTank2(MouseEvent mouseEvent) {

        try {
            if(AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 50 < 0) return;
            Game.attackers.get(AttackersWindow.idx-1).units.add(new Units(true,xap,yap,4));
            xap+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV15")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb15");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);
            Game.attackers.get(AttackersWindow.idx - 1).points -= 50;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));


        }
    }
    public void ctr_JET(MouseEvent mouseEvent) {

        try {


            if(AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 75 < 0) return;
            Game.attackers.get(AttackersWindow.idx-1).units.add(new Units(true,xap,yap,5));
            xap+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV16")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb16");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);
            Game.attackers.get(AttackersWindow.idx - 1).points -= 75;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));


        }

    }
    public void ctr_CARBOMB(MouseEvent mouseEvent) {
        try {
            if (AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 150 < 0) return;
            Game.attackers.get(AttackersWindow.idx - 1).units.add(new Units(true, 9, 11, 7));
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV17")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb17");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);
            Game.attackers.get(AttackersWindow.idx - 1).points -= 150;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));


        }
    }
    public void ctr_MirageTank2(MouseEvent mouseEvent) {
        try {

            if(AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 150 < 0) return;
            Game.attackers.get(AttackersWindow.idx-1).units.add(new Units(true,xap,yap,8));
            xap+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV18")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb18");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);
            Game.attackers.get(AttackersWindow.idx - 1).points -= 150;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));
        }
    }
    public void ctr_GrizzlyTank2(MouseEvent mouseEvent) {
        try {
            if(AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 150 < 0) return;
            Game.attackers.get(AttackersWindow.idx-1).units.add(new Units(true,xap,yap,9));
            xap+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV19")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb19");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);
            Game.attackers.get(AttackersWindow.idx - 1).points -= 150;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));
        }
    }
    public void ctr_NavySeal2(MouseEvent mouseEvent) {
        try {

            if(AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 150 < 0) return;
            Game.attackers.get(AttackersWindow.idx-1).units.add(new Units(true,xap,yap,10));
            xap+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV20")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb20");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);
            Game.attackers.get(AttackersWindow.idx - 1).points -= 150;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));
        }
    }
    public void ctr_TankDestroyer2(MouseEvent mouseEvent) {
        try {

            if(AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 150 < 0) return;
            Game.attackers.get(AttackersWindow.idx-1).units.add(new Units(true,xap,yap,11));
            xap+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV21")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb21");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);
            Game.attackers.get(AttackersWindow.idx - 1).points -= 150;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));
        }
    }
    public void ctr_PrismTank2 (MouseEvent mouseEvent){
        try {
            if(AttackersWindow.idx == 0) throw new Exception();
            if (Game.attackers.get(AttackersWindow.idx - 1).points - 150 < 0) return;
            Game.attackers.get(AttackersWindow.idx-1).units.add(new Units(true,xap,yap,12));
            xap+=2;
        } catch (Exception e) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Incomplete answer !!");
            al.setContentText("There is an Error occurred , please check your team or your answer");
            al.show();
            return;
        }
        ImageView im_tmp = (ImageView) mouseEvent.getSource();
        if (im_tmp.getId().equals("IMV22")) {

            Scene sc = im_tmp.getScene();
            Label lb = (Label) sc.lookup("#lb22");
            int count = 0;
            if (lb.getText().isEmpty()) {
                lb.setText("1");
            } else {
                count = Integer.parseInt(lb.getText());
                count++;
                lb.setText(String.valueOf(count));
            }
            Button bt_tmp = (Button) sc.lookup("#bt_READY2");
            bt_tmp.setDisable(false);
            bt_tmp = (Button) sc.lookup("#bt_RESET2");
            bt_tmp.setDisable(false);
            Game.attackers.get(AttackersWindow.idx - 1).points -= 150;
            ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(Game.attackers.get(AttackersWindow.idx - 1).points));
        }
    }

    public void Start_Game(MouseEvent mouseEvent) throws InterruptedException {
        G.start_threads();
        ((Button) mouseEvent.getSource()).setDisable(true);
        ((((Button) mouseEvent.getSource()).getScene().lookup("#tg_PAUSE"))).setDisable(false);
    }
    public void Exit(MouseEvent mouseEvent) {
        Button bt_exit = (Button) mouseEvent.getSource();
        if (bt_exit.getId().equals("bt_EXIT")) {
            ((Stage) ((Button) mouseEvent.getSource()).getScene().getWindow()).close();
            System.exit(1);
        }
    }

    public void Close(MouseEvent mouseEvent) {
        ((Stage) ((Button) mouseEvent.getSource()).getScene().getWindow()).close();
    }

    public void Dreset(MouseEvent mouseEvent) {

        Button bt_tmp = (Button) mouseEvent.getSource();
        Scene sc = bt_tmp.getScene();
        for (int i = 1; i <= 12; i++) {
            Label lb = (Label) sc.lookup("#lb" + i);
            lb.setText("");
        }

        Game.defenders.get(DefendersWindow.idx - 1).units.clear();
        ((Button) mouseEvent.getSource()).setDisable(true);
        Game.defenders.get(DefendersWindow.idx - 1).points = 3000;
        ((Label) sc.lookup("#POINTS1")).setText(String.valueOf(3000));
        if(Game.defenders.size() == 0) {
        bt_tmp = (Button) sc.lookup("#bt_READY1");
        bt_tmp.setDisable(false);
        }
    }
    public void Areset(MouseEvent mouseEvent) {

        Button bt_tmp = (Button) mouseEvent.getSource();
        Scene sc = bt_tmp.getScene();
        for (int i = 13; i <= 22; i++) {
            Label lb = (Label) sc.lookup("#lb" + i);
            lb.setText("");
        }
        Game.attackers.get(AttackersWindow.idx - 1).units.clear();
        ((Button) mouseEvent.getSource()).setDisable(true);
        Game.attackers.get(AttackersWindow.idx - 1).points = 3000;
        ((Label) sc.lookup("#POINTS2")).setText(String.valueOf(3000));
        if(Game.attackers.size() == 0) { bt_tmp = (Button) sc.lookup("#bt_READY2");
        bt_tmp.setDisable(false); }
    }
}


