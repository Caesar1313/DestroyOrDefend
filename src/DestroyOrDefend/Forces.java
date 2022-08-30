package DestroyOrDefend;


public abstract class Forces implements Runnable, Behave {

    public double health;
    protected double moveSpeed;
    protected static double armor;
    public int type;
    public int PlayerType;
    public Position Position;
    protected int Range;
    protected Strategy strategy = new HighestDamage(this);
    protected double cost;
    public double attack_value;
    protected double AttackSpeed;
    protected Object Target;
    protected boolean[] unit_type = new boolean[14];

    public void receiveAttack(double damageValue) {
        damageValue = damageValue - (damageValue * armor/100);
        health = health - damageValue;

    }


    public void attack(Forces obj) throws InterruptedException {


        try {
            if (!obj.isDead() && !this.isDead()) {
                Thread.currentThread().sleep((long) (1000 / AttackSpeed));
                obj.receiveAttack(this.attack_value);
                System.out.println(" Player " + this.PlayerType + " force type " + this.type + " attacked player " + obj.PlayerType + " unit type " + obj.type);
            }
        } catch (NullPointerException e) {
        }
    }

    public void attack(Base obj) throws InterruptedException {

        try {
            if (!obj.isDead() && !this.isDead()) {
                System.out.println(" Player " + this.PlayerType + " force type " + this.type + " attacked player 2" + " unit type " + obj.type);
                Thread.currentThread().sleep((long) (1000 / AttackSpeed));
                obj.receiveAttack(this.attack_value);
            }
        } catch (NullPointerException e) {
        }
    }


    public void attack() throws InterruptedException {

        if (!this.isDead()) {
            if (!strategy.EnemiesInRange.isEmpty()) {

                for (int i = 0; i < strategy.EnemiesInRange.size(); i++) {
                    System.out.println(" Player " + this.PlayerType + " force type " + this.type + " attacked player " + strategy.EnemiesInRange.get(i).PlayerType + " unit type " + strategy.EnemiesInRange.get(i).type);
                    strategy.EnemiesInRange.get(i).receiveAttack(attack_value);
                }


                if (isBaseInRange())

                    Game.base.receiveAttack(attack_value);

                health = 0;
                return;
            }

            if (isBaseInRange()){
                System.out.println(" Player " + this.PlayerType + " force type " + this.type + " attacked player 2" + " unit type " + Game.base.type);
                Game.base.receiveAttack(attack_value);
                health = 0;
            }



        }
    }


    @Override
    public void upgrade() {
        double increaseHealth = this.health * (25 / 100);
        this.health += increaseHealth;
        double increaseAttack = this.attack_value * (10 / 100);
        this.attack_value += increaseAttack;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public boolean isBaseInRange() {

        if (Game.base.BasePosition.x <= this.Position.x + this.Range && Game.base.BasePosition.x >= this.Position.x - this.Range && Game.base.BasePosition.y <= this.Position.y + this.Range && Game.base.BasePosition.y >= this.Position.y - this.Range) {
            return true;
        }

        return false;
    }

    public void SetStrategy(String s_strategy) {

        if (s_strategy.equals("HighestDamage"))
            strategy = new HighestDamage(this);
        if (s_strategy.equals("LowestHealth"))
            strategy = new LowestHealthStrategy(this);
        if (s_strategy.equals("Random"))
            strategy = new RandomStrategy(this);

    }

    public void SetStrategyCustomized(int[] pr){

        strategy = new Customized(this,pr);

    }

}