package DestroyOrDefend;

import java.util.ArrayList;
import java.util.List;

public class defender extends player {

    /**
     * each defender has a list of units and structures
     **/

    public defender() {
        super();
    }

    @Override
    public void setUnitsType() {
        for (int i = 0; i < units.size(); i++) {
            units.get(i).PlayerType = 2;
        }
    }
}
