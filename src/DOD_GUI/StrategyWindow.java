package DOD_GUI;

import DestroyOrDefend.Forces;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Arrays;


public class StrategyWindow {


    private Scene scene;
    private GridPane gp ;
    private Pane p ;
    private boolean [] isSelect = new boolean[14];
    private String stratgy;
    private int toStrategy[] = new int[14];
    private Forces fc_Stratgy;

    StrategyWindow(){
        Arrays.fill(isSelect, false);
    }
    public void WindowBuild(Stage StratgyStage, Forces fc) throws IOException, InterruptedException {

        Parent root = FXMLLoader.load(getClass().getResource("StrategyWindow.fxml"));
        StratgyStage.setTitle("Stratgy");

        scene = new Scene(root, 130, 200);
        StratgyStage.setScene(scene);
        StratgyStage.setX(1200);
        StratgyStage.setY(10);
        StratgyStage.setResizable(false);
        StratgyStage.show();

        gp = (GridPane) scene.lookup("#gp_Stratgy");
        p = (Pane) scene.lookup("#p_Stratgy");

        fc_Stratgy = fc;

        MenuButton MB =(MenuButton) scene.lookup("#MenuButton3");

        ObservableList<MenuItem> MI = MB.getItems();

        for (int i=0;i<MI.size();i++) {
            MI.get(i).setOnAction(e->{
                custStratgy(e);
                stratgy = getStratgy(e);
            });
        }

        Button bt_SET = (Button) scene.lookup("#bt_SET");
        bt_SET.setOnMouseClicked(e->{
            setStratgy(e);
        });

        Button bt_CLOSE =(Button) scene.lookup("#bt_CLOSE");
        bt_CLOSE.setOnMouseClicked(e->{
            colseStratgy(e);
        });

        for (int i = 1; i <=13 ; i++) {

            Button bst =  (Button) scene.lookup("#bst_"+i);
            Button bst2 = (Button) gp.lookup("#cel_"+i);

            bst.setOnMouseClicked(e->{
                putOnGrid(e);
            });
            bst2.setOnMouseClicked(e->{
                putOnGrid(e);
            });

        }
    }

    private void colseStratgy(MouseEvent e) {
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    private String getStratgy(ActionEvent actionEvent) {
        MenuItem it = (MenuItem) actionEvent.getSource();
        return  it.getText();
    }
    private void setStratgy(MouseEvent e) {

        if(!stratgy.equals("Customized"))
        fc_Stratgy.SetStrategy(stratgy);
        else {
            for (int i = 1; i <= 13 ; i++) {
                Button bt_tmp = (Button) scene.lookup("#cel_"+ i);
                switch (bt_tmp.getText())
                {
                    case "Tesla Tank": { toStrategy[i-1]=4;   break; }
                    case "Sniper": { toStrategy[i-1]=3; break; }
                    case "Soldier" : { toStrategy[i-1]=2; break; }
                    case "Tower": { toStrategy[i-1]=0; break;}
                    case "Canon": { toStrategy[i-1]=1; break; }
                    case "Car BOMB":{ toStrategy[i-1]=7;break;}
                    case "Prism Tank": { toStrategy[i-1]=12;break;}
                    case "Air Defence":{ toStrategy[i-1]=6;break;}
                    case "Mirage Tank":{ toStrategy[i-1]=8;break;}
                    case "Girzzly Tank":{ toStrategy[i-1]=9;break;}
                    case "Navy Seal":{ toStrategy[i-1]=10;break;}
                    case "Tank Destroyer":{ toStrategy[i-1]=11;break;}
                    case "Pillbox": { toStrategy[i-1]=13;break;}
                }
            }

            fc_Stratgy.SetStrategyCustomized(toStrategy);
        }

    }
    private void putOnGrid(MouseEvent mouseEvent) {

        GridPane gp = (GridPane) scene.lookup("#gp_Stratgy");
        Pane p = (Pane) scene.lookup("#p_Stratgy");
        Button bt_chk;

        Button bst = (Button) mouseEvent.getSource();
        System.out.println(getIndex(bst.getText()));

        int idx = getIndex(bst.getText());
        System.out.println(idx);
        if(!isSelect[idx]) {
            for (int i = 1; i <= 13; i++) {

                bt_chk = (Button) gp.lookup("#cel_" + i);
                if (bt_chk.getText().isEmpty()) {

                    bt_chk.setVisible(true);
                    bt_chk.setDisable(false);
                    bt_chk.setText(bst.getText());

                    bst.setVisible(false);
                    bst.setDisable(true);
                    break;
                }
            }
            isSelect[idx] = true;
        }
        else {
            bst.setDisable(true);
            bst.setVisible(false);
            bst.setText("");
            Button bt = (Button) p.lookup("#bst_"+ idx);
            bt.setVisible(true);
            bt.setDisable(false);
            isSelect[idx]=false;
        }

    }
    private void custStratgy(ActionEvent actionEvent) {

        Arrays.fill(toStrategy,-1);
        MenuItem it = (MenuItem) actionEvent.getSource();
        if (it.getText().equals("Customized"))
        {
            Stage st = (Stage) scene.getWindow();
            st.setHeight(300);
            st.setWidth(810);
            st.setX(700);
            st.setY(10);
        }
        else {
            Stage st = (Stage) scene.getWindow();
            st.setHeight(227);
            st.setWidth(140);
            st.setX(1200);
            st.setY(10.4);
        }
    }
    private int getIndex(String txt) {

        switch (txt)
        {
            case "Tesla Tank": {return 1;}
            case "Sniper":     {return 2;}
            case "Soldier":    {return 3;}
            case "Tower":      {return 4;}
            case "Canon":      {return 5;}
            case "Prism Tank": {return 6;}
            case "Car BOMB":   {return 7;}
            case "Mirage Tank":{return 8;}
            case "Grizzly Tank":{return 9;}
            case "Navy Seal":   {return 10;}
            case "Tank Destroyer":{return 11;}
            case "Pillbox":      {return 12;}
            case "Air Defence":  { return 13;}
        }
        return -1;
    }
}
