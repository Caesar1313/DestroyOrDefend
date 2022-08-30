package DestroyOrDefend;



import java.util.ArrayList;
import java.util.List;


public class Game implements Runnable {

    public static Base base = new Base();
    public static List<Forces> unitsInArena = new ArrayList();
    /**
     * all units in arena
     **/
    public static List<attacker> attackers = new ArrayList();
    /**
     * attackers list
     **/
    public static List<defender> defenders = new ArrayList();
    /**
     * defenders list
     **/
    public static List<Obstacle> obstaclesInArena = new ArrayList();
    public static GameState state;

    private static Thread t[],BT,GR ;
    private   BattleTime bt;

    public static boolean isPaused = false;
    public enum GameState /** the states of the game **/
    {

        Attackers, Defenders, RunningGame,Initialization,Paused;

    }

    public Game() throws InterruptedException /** Game **/
    {

       state = GameState.Initialization;


        Position p = new Position(1, 1);

        base.BasePosition = p;


        Valley ob1 = new Valley(3,3);
        Valley ob2= new Valley(3,4);
        Valley ob3 = new Valley(5,4);
        Valley ob4 = new Valley(6,7);

        obstaclesInArena.add(ob1);
        obstaclesInArena.add(ob2);
        obstaclesInArena.add(ob3);
        obstaclesInArena.add(ob4);


        River ob5 = new River(2,5);
        River ob7 = new River(0,7);
        River ob8 = new River(1,6);

        obstaclesInArena.add(ob5);
        obstaclesInArena.add(ob7);
        obstaclesInArena.add(ob8);






        for (int i = 0; i < defenders.size() ; i++) {
            for (int j = 0; j < defenders.get(i).units.size() ; j++) {
                unitsInArena.add(defenders.get(i).units.get(j));

            }

            defenders.get(i).setUnitsType();
        }

        for (int i = 0; i < attackers.size() ; i++) {
            for (int j = 0; j < attackers.get(i).units.size() ; j++) {
                unitsInArena.add(attackers.get(i).units.get(j));

            }

            attackers.get(i).setUnitsType();
        }
         t = new Thread[unitsInArena.size()];


    }

    public void start_threads(){

        state = GameState.RunningGame;

        for(int i=0;i<t.length;i++){
            t[i] = new Thread(unitsInArena.get(i));
            t[i].start();
        }

        bt = new BattleTime();

        BT = new Thread(bt);
        GR = new Thread(this);

        BT.start();
        GR.start();


    }



public static void pause(){

        isPaused = true;
}


public static void resume(){


        isPaused = false;


}
    @Override
    public void run() /** Game state checker thread **/
    {


        while (state == GameState.RunningGame) {

            for (int i = 0; i < unitsInArena.size(); i++) {
                if (unitsInArena.get(i).isDead()) {
                    unitsInArena.remove(unitsInArena.get(i));
                    i--;
                }
            }
            GameRules.Consult();

            if (state != GameState.RunningGame)
                System.out.println("End !");
        }
    }

    static class GameRules {



        public static void Consult() {/** updates the state of the game **/

            if (attackers_check()||BattleTime.i==1000)
                state = GameState.Defenders;

            else if (base.isDead())
                state = GameState.Attackers;

            else state = GameState.RunningGame;

        }


    }


    static boolean attackers_check() /** removes the dead attacker **/
    {

        PlayersUnitCheck();

        for (int i = 0; i < attackers.size(); i++) {
            if (attackers.get(i).units.size() == 0){
                attackers.remove(i);i--;}

        }

        if (attackers.size() == 0)
            return true;
        else
            return false;


    }


    public static void PlayersUnitCheck() {  /** removes the dead units **/


        for (int i = 0; i < attackers.size(); i++) {
            attackers.get(i).units_check();
        }

        for (int i = 0; i < defenders.size(); i++) {
            defenders.get(i).units_check();
        }


    } /** removes dead units **/
}