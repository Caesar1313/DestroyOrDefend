package com.company;

public class Base implements Runnable{


    public Position BasePosition;
    public int type;
    public double armor;
    public double  health;





    public Base(){
        this.type = 1;
        this.armor = 0.0;
        this.health = 500.0;
    }

    public void receiveAttack(double damageValue){
        damageValue = damageValue - (damageValue * armor);
        health = health - damageValue;
        //System.out.print(type + " ");
        //System.out.println(health);
    }

    public boolean isDead(){return health <= 0;}

    @Override
    public void run() {

    }
}
