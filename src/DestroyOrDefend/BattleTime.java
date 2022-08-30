package DestroyOrDefend;

import java.util.Date;

public class BattleTime implements Runnable{

    public static int i =0;

    BattleTime(){}

    @Override
    public void run() {


        while(i<1000){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
    }

    }
}
