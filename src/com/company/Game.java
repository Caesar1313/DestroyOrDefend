package com.company;
import java.util.*;

abstract class player{

    public int points;
    public  List<Forces> units = new ArrayList();

    player(){

        points = 10000;

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

}



public class Game implements Runnable {

    public static Base base = new Base();
    public static List<Forces> unitsInArena = new ArrayList();
    public static List<attacker> attackers = new ArrayList();
    public static List<defender> defenders= new ArrayList();
    public static GameState state;

    Game() throws InterruptedException {

        state = GameState.RunningGame;

        Position p = new Position(1,1);
        Position p1 = new Position(6,6);
        Position p2 = new Position(5,5);
        Position p3 = new Position(20,20);
        Position p4 = new Position(20,21);

        base.BasePosition = p;

        Forces t1 = new Sniper();
        Forces t2 = new Sniper();
        t1.Position = p1;
        t2.Position = p2;

        Forces t3 = new Soldier();
        Forces t4 = new Soldier();
        t3.Position = p3;
        t4.Position = p4;

        attacker a = new attacker();
        a.units.add(t3);
        a.units.add(t4);

        defender b = new defender();
        b.units.add(t1);
        b.units.add(t2);

        attackers.add(a);
        defenders.add(b);


        unitsInArena.add(t1);
        unitsInArena.add(t2);
        unitsInArena.add(t3);
        unitsInArena.add(t4);

        Thread t00 = new Thread(this);
        Thread t11 = new Thread(t1);
        Thread t22 = new Thread(t2);
        Thread t33 = new Thread(t3);
        Thread t44 = new Thread(t4);

        t00.start();
        t11.start();
        t22.start();
        t33.start();
        t44.start();


        t11.join();
        t22.join();
        t33.join();
        t44.join();
        t00.join();



    }

    @Override
    public void run() {

        while(state == GameState.RunningGame){

            GameRules.Consult();

         if(state != GameState.RunningGame)
           System.exit(1);

        }

    }

    class attacker extends player{



        attacker(){

            super();
            for(int i=0;i<units.size();i++){
                units.get(i).PlayerType = 1;
            }

        }










    }

    class defender extends player{

        public  List<DefenceStructure> structs = new ArrayList();
        GameState state;

        defender(){
            super();
            for(int i=0;i<units.size();i++){
                units.get(i).PlayerType = 2;
            }
        }



    }

    enum GameState {


        Attackers,Defenders,RunningGame;

    }


    static class GameRules{

        public static void Consult(){

            if(attackers_check())
                state =  GameState.Defenders;

            else if(base.isDead())
                state =  GameState.Attackers;

            else state = GameState.RunningGame;


        }




    }


    static boolean attackers_check(){

        PlayersUnitCheck();

        for(int i=0;i<attackers.size();i++)
        {
            if(attackers.get(i).units.size()==0)
                attackers.remove(i);
        }

        if(attackers.size()==0)
            return true;
        else
            return false;


    }


    public static void PlayersUnitCheck(){


            for (int i = 0; i < attackers.size(); i++) {
                attackers.get(i).units_check();
            }

            for (int i = 0; i < defenders.size(); i++) {
                defenders.get(i).units_check();
            }



    }


}


