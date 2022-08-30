package com.company;

class Position{

    int x,y;
    Position(int x,int y){
        this.x = x;
        this.y = y;
    }

}



public abstract class Forces implements Runnable {

    public double health;
    public double armor;
    public int type;
    public int PlayerType;
    public Position Position;
    public int Size;
    public int Range;
    public Strategy strategy;
    protected double cost;
    protected double attack_value;
    public int AttackSpeed;
    public Object Target;

    public void receiveAttack(double damageValue){
        damageValue = damageValue - (damageValue * armor);
        health = health - damageValue;

    }


    public void attack(Forces obj) throws InterruptedException {


        try{
        while(!obj.isDead()&&!this.isDead()){
            Thread.currentThread().sleep(1000/AttackSpeed);
            obj.receiveAttack(this.attack_value);
            System.out.println(" Player " + this.PlayerType + " force type " + this.type +" attacked player " + obj.PlayerType + " unit type " + obj.type );
        }}catch (NullPointerException e){}
    }

    public void attack(Base obj) throws InterruptedException {

        try{
        while(!obj.isDead()&&!this.isDead()){
            System.out.println(" Player " + this.PlayerType + " force type " + this.type +" attacked player 2"  + " unit type " + obj.type );
            Thread.currentThread().sleep(1000/AttackSpeed);
            obj.receiveAttack(this.attack_value);
        }}catch (NullPointerException e){}
    }

    public boolean isDead(){
        return health <= 0;
    }
    public boolean isBaseInRange(){

        if(Game.base.BasePosition.x<=this.Position.x+this.Range&&Game.base.BasePosition.x>=this.Position.x-this.Range&&Game.base.BasePosition.y<=this.Position.y+this.Range&&Game.base.BasePosition.y>=this.Position.y-this.Range){
            return true;
        }

        return false;
    }

}