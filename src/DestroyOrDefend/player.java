package DestroyOrDefend;
import java.util.*;

public abstract class player{

    public int points;
    public  List<Forces> units = new ArrayList();

    player(){

        points = 3000;

    }

    public void units_check(){

        for(int i=0;i<units.size();i++)
        {
            if(units.get(i).isDead()){
                units.remove(units.get(i));
                i--;
            }



        }


    }

    public abstract void setUnitsType();
}






