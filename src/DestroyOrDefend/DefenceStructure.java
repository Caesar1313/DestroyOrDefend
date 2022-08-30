package DestroyOrDefend;

public class DefenceStructure extends Forces{

    public DefenceStructure(boolean armor, int x, int y, int type){

        switch (type){

            case 0://tower

                this.health = 4000;
                this.Position = new Position(x,y);
                this.attack_value = 100;
                this.AttackSpeed = 2;
                this.strategy = new HighestDamage(this);
                this.cost = 150;
                if(armor)
                    this.armor = 70;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 5;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[4] = true;
                break;


            case 1://canon

                this.health = 6500;
                this.Position = new Position(x,y);
                this.attack_value = 150;
                this.AttackSpeed = 1;
                this.strategy = new HighestDamage(this);
                this.cost = 200;
                if(armor)
                    this.armor = 30;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 10;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[4] = true;
                break;


            case 6://airdefence

                this.health = 2500;
                this.Position = new Position(x,y);
                this.attack_value = 50;
                this.AttackSpeed = 1;
                this.strategy = new HighestDamage(this);
                this.cost = 175;
                if(armor)
                    this.armor = 20;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 10;
                this.unit_type[5] = true;
                break;


            case 13://PillBox

                this.health = 4000;
                this.Position = new Position(x,y);
                this.attack_value = 100;
                this.AttackSpeed = 1.5;
                this.strategy = new HighestDamage(this);
                this.cost = 150;
                if(armor)
                    this.armor = 70;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 5;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[10] = true;
                break;



        }
    }

        @Override
    public void run() {
        while (Game.state == Game.GameState.RunningGame) {

            while (Game.isPaused == true) {
                try {
                    Thread.currentThread().sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            strategy.InRangeEnemies();
            try {
                attack(this.strategy.ReturnFirstElement());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}



