package com.company;

public class Tower extends DefenceStructure {

    public Tower(){
        this.cost = 800.0;
        this.attack_value = 5.0; // was 100
        this.AttackSpeed = 3;
        this.health = 2500.0;
        this.armor = 0.0;
        this.type = 2;
        this.Range = 25;
    }

    @Override
    public void run() {
            try {
                attack(this.strategy.ReturnFirstElement());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

