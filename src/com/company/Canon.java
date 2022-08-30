package com.company;

public class Canon extends DefenceStructure {

    public Canon(){
        this.cost = 600.0;
        this.attack_value = 100.0;
        this.health = 2000.0;
        this.armor = 0.0;
        this.type = 3;
        this.Range = 20;
    }

    @Override
    public void run() {


        Forces a;
        a = (Forces) Target;
        try {
            attack((Forces) Target);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

