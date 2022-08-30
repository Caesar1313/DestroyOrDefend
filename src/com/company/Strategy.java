package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Strategy {


    public Forces force;
    public List<Forces> EnemiesInRange;
    public abstract  Forces ReturnFirstElement();

    Strategy(Forces f){
        EnemiesInRange = new ArrayList<>();
        force = f;
    }


    public void InRangeEnemies() {

        for(int i=0;i<Game.unitsInArena.size();i++){
        if(IsInRange(Game.unitsInArena.get(i))  && force.PlayerType != Game.unitsInArena.get(i).PlayerType && force != Game.unitsInArena.get(i))
            if(Game.unitsInArena.get(i).health > 0)
            EnemiesInRange.add(Game.unitsInArena.get(i));
        }


    }

    public boolean IsInRange(Forces obj) {

        if(obj.Position.x<=force.Position.x+force.Range&&obj.Position.x>=force.Position.x-force.Range&&obj.Position.y<=force.Position.y+force.Range&&obj.Position.y>=force.Position.y-force.Range){
            return true;
        }

        return false;
    }


}

class LowestHealthStrategy extends Strategy{

    LowestHealthStrategy(Forces f) {
        super(f);
    }

    public Forces ReturnFirstElement(){

        double[] Health = new double[EnemiesInRange.size()];
        for(int i=0;i<EnemiesInRange.size();i++){
            Health[i] = EnemiesInRange.get(i).health;
        }

        double min = Double.MAX_VALUE;

        for(int i=0;i<EnemiesInRange.size();i++)
        {
            if(min>Health[i])
                min = Health[i];
        }

        for(int i=0;i<EnemiesInRange.size();i++){
            if(min == EnemiesInRange.get(i).health)
            {
                Forces temp = EnemiesInRange.get(i);
                EnemiesInRange.remove(i);
                return temp;
            }
        }

        return null;

    }


}

class HighestDamage extends Strategy {

    HighestDamage(Forces f) {
        super(f);
    }

    public Forces ReturnFirstElement() {
        double[] Damage = new double[EnemiesInRange.size()];
        for (int i = 0; i < EnemiesInRange.size(); i++) {
            Damage[i] = EnemiesInRange.get(i).attack_value;
        }

        double max = Double.MIN_VALUE;

        for (int i = 0; i < EnemiesInRange.size(); i++) {
            if (max < Damage[i])
                max = Damage[i];
        }

        for (int i = 0; i < EnemiesInRange.size(); i++) {
            if (max == EnemiesInRange.get(i).attack_value) {
                Forces temp = EnemiesInRange.get(i);
                EnemiesInRange.remove(i);
                return temp;
            }
        }

        return null;
    }
}

class RandomStrategy extends Strategy{

    Random rand = new Random();

    RandomStrategy(Forces f) {
        super(f);
    }


    @Override
    public Forces ReturnFirstElement() {
        int r = rand.nextInt(EnemiesInRange.size());
        return EnemiesInRange.get(r);
    }

}

class Customized extends Strategy{


    List<List<Forces>> ListOfLists = new ArrayList<>(5);
    int[] Priorities = new int[5];

    Customized(Forces f) {
        super(f);
    }

    @Override
    public Forces ReturnFirstElement() {

        for(int i=0;i<5;i++){

            ListOfLists.get(EnemiesInRange.get(i).type).add(EnemiesInRange.get(i));

        }

        /*

        fill priorities

        */

        for(int i=0;i<5;i++)
        {
            if(!ListOfLists.get(Priorities[i]).isEmpty())
            {
                Forces temp = ListOfLists.get(Priorities[i]).get(0);
                ListOfLists.get(Priorities[i]).remove(0);
                EnemiesInRange.remove(temp);
                return temp;
            }
        }

        return null;
    }
}