package com.company;

public abstract class DefenceStructure extends Forces implements Behave{


    @Override
    public void attack(Forces obj) throws InterruptedException {


        while(!obj.isDead()&&!this.isDead()){
            Thread.currentThread().sleep(1000/AttackSpeed);
            obj.receiveAttack(this.attack_value);
        }
    }

    @Override
    public void upgrade() {
        double increaseHealth = this.health * (25/100);
        this.health += increaseHealth;
        double increaseAttack = this.attack_value * (10/100);
        this.attack_value += increaseAttack;
    }

}
