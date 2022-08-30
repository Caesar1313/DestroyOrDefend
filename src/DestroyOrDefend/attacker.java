package DestroyOrDefend;

public class attacker extends player {

    /**
     * each attacker has list of units
     **/

    public attacker() {

        super();


    }

    @Override
    public void setUnitsType() {

        for (int i = 0; i < units.size(); i++) {
            units.get(i).PlayerType = 1;
        }
    }


}
