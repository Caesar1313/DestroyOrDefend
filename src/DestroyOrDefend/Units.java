package DestroyOrDefend;
import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

public class Units extends Forces {

    private Position PreviousPosition;
    private Position initLocation;
    private int initWaitTime;

    public Units(boolean armor, int x, int y, int type) {

        switch (type) {

            case 2: { //Infantry

                this.health = 250;
                this.Position = new Position(x, y);
                this.attack_value = 50;
                this.AttackSpeed = 1;
                this.moveSpeed = 2;
                this.strategy = new HighestDamage(this);
                this.cost = 3;
                if (armor)
                    this.armor = 40;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 2;
                this.initLocation = new Position(15, 15);
                this.initWaitTime = 1;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[10] = true;
                break;


            }


            case 3://sniper
            {

                this.health = 250;
                this.Position = new Position(x, y);
                this.attack_value = 75;
                this.AttackSpeed = 2.5;
                this.moveSpeed = 2;
                this.strategy = new HighestDamage(this);
                this.cost = 5;
                if (armor)
                    this.armor = 10;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 17;
                this.initLocation = this.Position;
                this.initWaitTime = 1;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[10] = true;
                break;

            }

            case 4://tesla tank
            {

                this.health = 1000;
                this.Position = new Position(x, y);
                this.attack_value = 300;
                this.AttackSpeed = 2;
                this.moveSpeed = 3;
                this.strategy = new HighestDamage(this);
                this.cost = 50;
                if (armor)
                    this.armor = 50;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 6;
                this.initLocation = new Position(1, 10);
                this.initWaitTime = 1;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[10] = true;
                this.unit_type[4] = true;
                this.unit_type[8] = true;
                this.unit_type[9] = true;
                this.unit_type[11] = true;
                this.unit_type[12] = true;
                break;

            }
            case 5://Jet
            {

                this.health = 1500;
                this.Position = new Position(x, y);
                this.attack_value = 400;
                this.AttackSpeed = 1000;
                this.moveSpeed = 10;
                this.PlayerType = 1;
                this.Target = Game.base;
                this.strategy = new HighestDamage(this);
                this.cost = 300;
                if (armor)
                    this.armor = 0;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 2;
                break;

            }

            case 7://CarBomb
            {

                this.health = 10;
                this.Position = new Position(x, y);
                this.attack_value = 1000;
                this.AttackSpeed = 1;
                this.moveSpeed = 3;
                this.strategy = new HighestDamage(this);
                this.cost = 500;
                if (armor)
                    this.armor = 0;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 3;
                this.initLocation = this.Position;
                this.initWaitTime = 1;
                for (int i = 0; i < unit_type.length; i++) {
                    if (i == 5)
                        continue;
                    unit_type[i] = true;
                }
                break;

            }
            case 8://MirageTank

            {

                this.health = 750;
                this.Position = new Position(x, y);
                this.attack_value = 1000;
                this.AttackSpeed = 1;
                this.moveSpeed = 6;
                this.strategy = new HighestDamage(this);
                this.cost = 70;
                if (armor)
                    this.armor = 10;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 1;
                this.initLocation = this.Position;
                this.initWaitTime = 1;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[10] = true;
                this.unit_type[0] = true;
                this.unit_type[1] = true;
                this.unit_type[6] = true;
                this.unit_type[13] = true;

                break;
            }

            case 9://GrizzlyTank
            {

                this.health = 1000;
                this.Position = new Position(x, y);
                this.attack_value = 250;
                this.AttackSpeed = 2;
                this.moveSpeed = 3;
                this.strategy = new HighestDamage(this);
                this.cost = 50;
                if (armor)
                    this.armor = 40;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 6;
                this.initLocation = this.Position;
                this.initWaitTime = 1;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[10] = true;
                this.unit_type[0] = true;
                this.unit_type[1] = true;
                this.unit_type[6] = true;
                this.unit_type[13] = true;

                break;

            }
            case 10://NavySeal
            {
                this.health = 400;
                this.Position = new Position(x, y);
                this.attack_value = 60;
                this.AttackSpeed = 0.5;
                this.moveSpeed = 20;
                this.strategy = new HighestDamage(this);
                this.cost = 10;
                if (armor)
                    this.armor = 20;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 1;
                this.initLocation = this.Position;
                this.initWaitTime = 1;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[10] = true;
                this.unit_type[4] = true;
                this.unit_type[9] = true;
                this.unit_type[8] = true;
                this.unit_type[11] = true;
                this.unit_type[12] = true;

                break;

            }
            case 11://TankDestroyer
            {
                this.health = 1000;
                this.Position = new Position(x, y);
                this.attack_value = 400;
                this.AttackSpeed = 2;
                this.moveSpeed = 2;
                this.strategy = new HighestDamage(this);
                this.cost = 50;
                if (armor)
                    this.armor = 50;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 4;
                this.initLocation = this.Position;
                this.initWaitTime = 1;
                this.unit_type[4] = true;
                this.unit_type[9] = true;
                this.unit_type[8] = true;
                this.unit_type[11] = true;
                this.unit_type[12] = true;

                break;

            }
            case 12://PrismTank
            {

                this.health = 1000;
                this.Position = new Position(x, y);
                this.attack_value = 300;
                this.AttackSpeed = 2;
                this.moveSpeed = 2;
                this.strategy = new HighestDamage(this);
                this.cost = 60;
                if (armor)
                    this.armor = 35;
                else
                    this.armor = 0;
                this.type = type;
                this.Range = 4;
                this.initLocation = this.Position;
                this.initWaitTime = 1;
                this.unit_type[3] = true;
                this.unit_type[2] = true;
                this.unit_type[10] = true;
                this.unit_type[4] = true;
                this.unit_type[9] = true;
                this.unit_type[8] = true;
                this.unit_type[11] = true;
                this.unit_type[12] = true;
                this.unit_type[0] = true;
                this.unit_type[1] = true;
                this.unit_type[6] = true;
                this.unit_type[13] = true;
                break;

            }
        }
    }

    /**
     * Above is the unit factory
     **/

    public boolean XPlus_ObstacleCondition_Check() {


        for (int i = 0; i < Game.obstaclesInArena.size(); i++) {
            if (this.Position.x + 1 == Game.obstaclesInArena.get(i).Position.x && this.Position.y == Game.obstaclesInArena.get(i).Position.y) {
                if (Game.obstaclesInArena.get(i).type == 2)
                    return true;
                if (Game.obstaclesInArena.get(i).type == 0 && (this.type == 4 || this.type == 7))
                    return true;
            }
        }
        return false;
    }

    public boolean XMinus_ObstacleCondition_Check() {


        for (int i = 0; i < Game.obstaclesInArena.size(); i++) {
            if (this.Position.x - 1 == Game.obstaclesInArena.get(i).Position.x && this.Position.y == Game.obstaclesInArena.get(i).Position.y) {
                if (Game.obstaclesInArena.get(i).type == 2)
                    return true;
                if (Game.obstaclesInArena.get(i).type == 0 && this.type == 4)
                    return true;
            }
        }
        return false;
    }

    public boolean YPlus_ObstacleCondition_Check() {


        for (int i = 0; i < Game.obstaclesInArena.size(); i++) {
            if (this.Position.x == Game.obstaclesInArena.get(i).Position.x && this.Position.y + 1 == Game.obstaclesInArena.get(i).Position.y) {
                if (Game.obstaclesInArena.get(i).type == 2)
                    return true;
                if (Game.obstaclesInArena.get(i).type == 0 && this.type == 4)
                    return true;
            }
        }
        return false;
    }

    public boolean YMinus_ObstacleCondition_Check() {


        for (int i = 0; i < Game.obstaclesInArena.size(); i++) {
            if (this.Position.x == Game.obstaclesInArena.get(i).Position.x && this.Position.y - 1 == Game.obstaclesInArena.get(i).Position.y) {
                if (Game.obstaclesInArena.get(i).type == 2)
                    return true;
                if (Game.obstaclesInArena.get(i).type == 0 && this.type == 4)
                    return true;
            }
        }
        return false;
    }

    public boolean YMinus_XMinus_ObstacleCondition_Check() {


        for (int i = 0; i < Game.obstaclesInArena.size(); i++) {
            if (this.Position.x - 1 == Game.obstaclesInArena.get(i).Position.x && this.Position.y - 1 == Game.obstaclesInArena.get(i).Position.y) {
                if (Game.obstaclesInArena.get(i).type == 2)
                    return true;
                if (Game.obstaclesInArena.get(i).type == 0 && this.type == 4)
                    return true;
            }
        }
        return false;
    }

    public boolean YMinus_XPlus_ObstacleCondition_Check() {


        for (int i = 0; i < Game.obstaclesInArena.size(); i++) {
            if (this.Position.x + 1 == Game.obstaclesInArena.get(i).Position.x && this.Position.y - 1 == Game.obstaclesInArena.get(i).Position.y) {
                if (Game.obstaclesInArena.get(i).type == 2)
                    return true;
                if (Game.obstaclesInArena.get(i).type == 0 && this.type == 4)
                    return true;
            }
        }
        return false;
    }

    public boolean YPlus_XPlus_ObstacleCondition_Check() {


        for (int i = 0; i < Game.obstaclesInArena.size(); i++) {
            if (this.Position.x + 1 == Game.obstaclesInArena.get(i).Position.x && this.Position.y + 1 == Game.obstaclesInArena.get(i).Position.y) {
                if (Game.obstaclesInArena.get(i).type == 2)
                    return true;
                if (Game.obstaclesInArena.get(i).type == 0 && this.type == 4)
                    return true;
            }
        }
        return false;
    }

    public boolean YPlus_XMinus_ObstacleCondition_Check() {


        for (int i = 0; i < Game.obstaclesInArena.size(); i++) {
            if (this.Position.x - 1 == Game.obstaclesInArena.get(i).Position.x && this.Position.y + 1 == Game.obstaclesInArena.get(i).Position.y) {
                if (Game.obstaclesInArena.get(i).type == 2)
                    return true;
                if (Game.obstaclesInArena.get(i).type == 0 && this.type == 4)
                    return true;
            }
        }
        return false;
    }

    /**
     * Above is the Obstacles Checker
     **/

    public boolean XPlus_CollisionCondition_Check() {


        for (int i = 0; i < Game.unitsInArena.size(); i++) {
            if (this.Position.x + 1 == Game.unitsInArena.get(i).Position.x && this.Position.y == Game.unitsInArena.get(i).Position.y)
                return true;
        }
        return false;
    }

    public boolean XMinus_CollisionCondition_Check() {

        for (int i = 0; i < Game.unitsInArena.size(); i++) {
            if (this.Position.x - 1 == Game.unitsInArena.get(i).Position.x && this.Position.y == Game.unitsInArena.get(i).Position.y)
                return true;
        }

        return false;
    }

    public boolean YPlus_CollisionCondition_Check() {

        for (int i = 0; i < Game.unitsInArena.size(); i++) {
            if (this.Position.x == Game.unitsInArena.get(i).Position.x && this.Position.y + 1 == Game.unitsInArena.get(i).Position.y)
                return true;
        }
        return false;
    }

    public boolean YMinus_CollisionCondition_Check() {

        for (int i = 0; i < Game.unitsInArena.size(); i++) {
            if (this.Position.x == Game.unitsInArena.get(i).Position.x && this.Position.y - 1 == Game.unitsInArena.get(i).Position.y)
                return true;
        }
        return false;
    }

    public boolean YMinus_XMinus_CollisionCondition_Check() {

        for (int i = 0; i < Game.unitsInArena.size(); i++) {
            if (this.Position.x - 1 == Game.unitsInArena.get(i).Position.x && this.Position.y - 1 == Game.unitsInArena.get(i).Position.y)
                return true;
        }
        return false;
    }

    public boolean YMinus_XPlus_CollisionCondition_Check() {

        for (int i = 0; i < Game.unitsInArena.size(); i++) {
            if (this.Position.x + 1 == Game.unitsInArena.get(i).Position.x && this.Position.y - 1 == Game.unitsInArena.get(i).Position.y)
                return true;
        }
        return false;
    }

    public boolean YPlus_XPlus_CollisionCondition_Check() {

        for (int i = 0; i < Game.unitsInArena.size(); i++) {
            if (this.Position.x + 1 == Game.unitsInArena.get(i).Position.x && this.Position.y + 1 == Game.unitsInArena.get(i).Position.y)
                return true;
        }
        return false;
    }

    public boolean YPlus_XMinus_CollisionCondition_Check() {

        for (int i = 0; i < Game.unitsInArena.size(); i++) {
            if (this.Position.x - 1 == Game.unitsInArena.get(i).Position.x && this.Position.y + 1 == Game.unitsInArena.get(i).Position.y)
                return true;
        }
        return false;
    }

    /**
     * above is the collision check
     */

    public boolean PreviousPositionCheck(int x, int y) {


        if (x == this.PreviousPosition.x && y == this.PreviousPosition.y)
            return true;

        return false;


    }

    /**
     * Above is a condition for the unit not to go to the previous position
     **/

    public void MakeStep(double MS) {

        try {
            Thread.currentThread().sleep((long) (1000 / MS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (PreviousPosition == null)
            PreviousPosition = this.Position;
        int[] h;
        h = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        if (!(YPlus_CollisionCondition_Check() || YPlus_ObstacleCondition_Check() || this.Position.y + 1 >= 10000 || PreviousPositionCheck(this.Position.x, this.Position.y + 1)))
            h[0] = (int) Math.sqrt(Math.pow((this.Position.x - Game.base.BasePosition.x), 2) +
                    Math.pow(((this.Position.y + 1) - Game.base.BasePosition.y), 2)); /** down**/
        if (!(XPlus_CollisionCondition_Check() || XPlus_ObstacleCondition_Check() || this.Position.x + 1 >= 10000 || PreviousPositionCheck(this.Position.x + 1, this.Position.y)))
            h[1] = (int) Math.sqrt(Math.pow(((this.Position.x + 1) - Game.base.BasePosition.x), 2) +
                    Math.pow((this.Position.y - Game.base.BasePosition.y), 2));  /** right **/
        if (!(YMinus_CollisionCondition_Check() || YMinus_ObstacleCondition_Check() || this.Position.y - 1 < 0 || PreviousPositionCheck(this.Position.x, this.Position.y - 1)))
            h[2] = (int) Math.sqrt(Math.pow((this.Position.x - Game.base.BasePosition.x), 2) +
                    Math.pow(((this.Position.y - 1) - Game.base.BasePosition.y), 2)); /** up**/
        if (!(XMinus_CollisionCondition_Check() || XMinus_ObstacleCondition_Check() || this.Position.x - 1 < 0 || PreviousPositionCheck(this.Position.x - 1, this.Position.y)))
            h[3] = (int) Math.sqrt(Math.pow(((this.Position.x - 1) - Game.base.BasePosition.x), 2) +
                    Math.pow((this.Position.y - Game.base.BasePosition.y), 2));  /** left**/
        if (!(YMinus_XMinus_CollisionCondition_Check() || YMinus_XMinus_ObstacleCondition_Check() || this.Position.x - 1 < 0 || this.Position.y - 1 < 0 || PreviousPositionCheck(this.Position.x - 1, this.Position.y - 1)))
            h[4] = (int) Math.sqrt(Math.pow(((this.Position.x - 1) - Game.base.BasePosition.x), 2) +
                    Math.pow(((this.Position.y - 1) - Game.base.BasePosition.y), 2));  /** up & left **/
        if (!(YPlus_XMinus_CollisionCondition_Check() || YPlus_XMinus_ObstacleCondition_Check() || this.Position.x - 1 < 0 || this.Position.y + 1 >= 10000 || PreviousPositionCheck(this.Position.x - 1, this.Position.y + 1)))
            h[5] = (int) Math.sqrt(Math.pow(((this.Position.x - 1) - Game.base.BasePosition.x), 2) +
                    Math.pow(((this.Position.y + 1) - Game.base.BasePosition.y), 2)); /** down & left **/
        if (!(YPlus_XPlus_CollisionCondition_Check() || YPlus_XPlus_ObstacleCondition_Check() || this.Position.x + 1 >= 10000 || this.Position.y + 1 >= 10000 || PreviousPositionCheck(this.Position.x + 1, this.Position.y + 1)))
            h[6] = (int) Math.sqrt(Math.pow(((this.Position.x + 1) - Game.base.BasePosition.x), 2) +
                    Math.pow(((this.Position.y + 1) - Game.base.BasePosition.y), 2)); /** down & right **/
        if (!(YMinus_XPlus_CollisionCondition_Check() || YMinus_XPlus_ObstacleCondition_Check() || this.Position.x + 1 >= 10000 || this.Position.y - 1 < 0 || PreviousPositionCheck(this.Position.x + 1, this.Position.y - 1)))
            h[7] = (int) Math.sqrt(Math.pow(((this.Position.x + 1) - Game.base.BasePosition.x), 2) +
                    Math.pow(((this.Position.y - 1) - Game.base.BasePosition.y), 2)); /** Up & right**/


        int minv = Integer.MAX_VALUE, mini = -1;

        for (int i = 0; i < 8; i++) {
            if (minv == h[i]) {
                mini = i;
            }

            if (minv > h[i] && h[i] != -1) {
                minv = h[i];
                mini = i;
            }
        }

        if (mini == 0) {
            int x, y;
            x = this.Position.x;
            y = this.Position.y;
            Position temp = new Position(x, y);
            PreviousPosition = temp;
            this.Position.y++;
        } else if (mini == 1) {
            int x, y;
            x = this.Position.x;
            y = this.Position.y;
            Position temp = new Position(x, y);
            PreviousPosition = temp;
            this.Position.x++;
        } else if (mini == 2) {
            int x, y;
            x = this.Position.x;
            y = this.Position.y;
            Position temp = new Position(x, y);
            PreviousPosition = temp;
            this.Position.y--;
        } else if (mini == 3) {
            int x, y;
            x = this.Position.x;
            y = this.Position.y;
            Position temp = new Position(x, y);
            PreviousPosition = temp;
            this.Position.x--;
        } else if (mini == 4) {
            int x, y;
            x = this.Position.x;
            y = this.Position.y;
            Position temp = new Position(x, y);
            PreviousPosition = temp;
            this.Position.x--;
            this.Position.y--;
        } else if (mini == 5) {
            int x, y;
            x = this.Position.x;
            y = this.Position.y;
            Position temp = new Position(x, y);
            PreviousPosition = temp;
            this.Position.x--;
            this.Position.y++;
        } else if (mini == 6) {
            int x, y;
            x = this.Position.x;
            y = this.Position.y;
            Position temp = new Position(x, y);
            PreviousPosition = temp;
            this.Position.x++;
            this.Position.y++;
        } else if (mini == 7) {
            int x, y;
            x = this.Position.x;
            y = this.Position.y;
            Position temp = new Position(x, y);
            PreviousPosition = temp;
            this.Position.x++;
            this.Position.y--;
        }
    }

    /**
     * Above is Moving to base algortihm
     **/

    public int move() {

        double ms = this.moveSpeed;

        for (int i = 0; i < Game.obstaclesInArena.size(); i++) {

            if (this.Position.x == Game.obstaclesInArena.get(i).Position.x && this.Position.y == Game.obstaclesInArena.get(i).Position.y) {
                if (Game.obstaclesInArena.get(i).type == 0)
                    ms = (int) (this.moveSpeed - (this.moveSpeed * 0.3));
            }


        }


        if (this.PlayerType == 1) /** if the unit was an attacker **/ {

            if (this.strategy.EnemiesInRange.isEmpty()) {

                if (this.isBaseInRange()) { /** Moving to Base algorithm **/
                    return 1;
                } else {

                    MakeStep(ms);

                    return 0;

                }


            } /**Moving to Base Process**/


            return 2;


        } else if (this.PlayerType == 2) /** if the unit was a defender **/ {


            if (this.strategy.EnemiesInRange.isEmpty()) {

                if (this.isBaseInRange()) { /** Patrolling algorithm **/

                    try {
                        Thread.currentThread().sleep((long) (1000 / ms));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Random rand = new Random();
                    int r = rand.nextInt(4);
                    if (r == 0) {

                        if (XPlus_CollisionCondition_Check() || XPlus_ObstacleCondition_Check())
                            r = 1;
                    }

                    if (r == 0 && this.Position.x + 1 < 10000)
                        this.Position.x++;


                    if (r == 1) {

                        if (XMinus_CollisionCondition_Check() || XMinus_ObstacleCondition_Check())
                            r = 2;

                    }

                    if (r == 1 && this.Position.x - 1 > 0)
                        this.Position.x--;


                    if (r == 2) {

                        if (YPlus_CollisionCondition_Check() || YPlus_ObstacleCondition_Check())
                            r = 3;

                    }

                    if (r == 2 && this.Position.y + 1 < 10000)
                        this.Position.y++;


                    if (r == 3) {

                        if (YMinus_CollisionCondition_Check() || YMinus_ObstacleCondition_Check())
                            return -1;

                    }

                    if (this.Position.y - 1 > 0)
                        this.Position.y--;

                    return -1;


                } /** Patrolling end **/
                else { /** Moving to Base algorithm **/


                    MakeStep(ms);

                    return 0;


                } /**Moving to Base algorithm end **/


            }

            return 2;

        }

        return Integer.parseInt(null);
    }

    /** in case of returning 0 then there's nothing in range **/
    /** in case of returning 1 then there's the enemy's base in range **/
    /**
     * in case of returning 2 then there're enemies in range
     **/


    public void MoveToLocation(int x, int y) {

        double ms = this.moveSpeed;

        try {
            Thread.currentThread().sleep((long) (1000 / ms));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (PreviousPosition == null)
            PreviousPosition = this.Position;
        int[] h;
        h = new int[]{-1, -1, -1, -1};

        if (!(YPlus_CollisionCondition_Check() || YPlus_ObstacleCondition_Check() || this.Position.y + 1 >= 10000 || PreviousPositionCheck(this.Position.x, this.Position.y + 1)))
            h[0] = Math.abs(this.Position.x - x) +
                    Math.abs(this.Position.y + 1 - y);
        if (!(XPlus_CollisionCondition_Check() || XPlus_ObstacleCondition_Check() || this.Position.x + 1 >= 10000 || PreviousPositionCheck(this.Position.x + 1, this.Position.y)))
            h[1] = Math.abs(this.Position.x + 1 - x) +
                    Math.abs(this.Position.y - y);
        if (!(YMinus_CollisionCondition_Check() || YMinus_ObstacleCondition_Check() || this.Position.y - 1 < 0 || PreviousPositionCheck(this.Position.x, this.Position.y - 1)))
            h[2] = Math.abs(this.Position.x - x) +
                    Math.abs(this.Position.y - 1 - y);
        if (!(XMinus_CollisionCondition_Check() || XMinus_ObstacleCondition_Check() || this.Position.x - 1 < 0 || PreviousPositionCheck(this.Position.x - 1, this.Position.y)))
            h[3] = Math.abs(this.Position.x - 1 - x) +
                    Math.abs(this.Position.y - y);


        int maxv = Integer.MAX_VALUE, maxi = -1;

        for (int i = 0; i < 4; i++) {
            if (maxv == h[i]) {
                maxi = i;
            }

            if (maxv > h[i] && h[i] != -1) {
                maxv = h[i];
                maxi = i;
            }
        }

        if (maxi == 0) {
            int x1, y1;
            x1 = this.Position.x;
            y1 = this.Position.y;
            Position temp = new Position(x1, y1);
            PreviousPosition = temp;
            this.Position.y++;
        } else if (maxi == 1) {
            int x1, y1;
            x1 = this.Position.x;
            y1 = this.Position.y;
            Position temp = new Position(x1, y1);
            PreviousPosition = temp;
            this.Position.x++;
        } else if (maxi == 2) {
            int x1, y1;
            x1 = this.Position.x;
            y1 = this.Position.y;
            Position temp = new Position(x1, y1);
            PreviousPosition = temp;
            this.Position.y--;
        } else if (maxi == 3) {
            int x1, y1;
            x1 = this.Position.x;
            y1 = this.Position.y;
            Position temp = new Position(x1, y1);
            PreviousPosition = temp;
            this.Position.x--;
        }


    }


    public int PlaneMoveToTarget() throws InterruptedException {

        Thread.currentThread().sleep((long) (1000 / moveSpeed));


        if (Target instanceof Base) {

            if (!(((Base) Target).BasePosition.x <= this.Position.x + this.Range && ((Base) Target).BasePosition.x >= this.Position.x - this.Range && ((Base) Target).BasePosition.y <= this.Position.y + this.Range && ((Base) Target).BasePosition.y >= this.Position.y - this.Range)) {

                if (((Base) Target).BasePosition.x > this.Position.x && ((Base) Target).BasePosition.y > this.Position.y) {
                    Position.x++;
                    Position.y++;
                    return 0;
                }

                if (((Base) Target).BasePosition.x < this.Position.x && ((Base) Target).BasePosition.y < this.Position.y) {
                    Position.x--;
                    Position.y--;
                    return 0;
                }

                if (((Base) Target).BasePosition.x > this.Position.x) {
                    this.Position.x++;
                    return 0;
                }


                if (((Base) Target).BasePosition.x < this.Position.x) {
                    this.Position.x--;
                    return 0;
                }

                if (((Base) Target).BasePosition.y > this.Position.x) {
                    this.Position.y++;
                    return 0;
                }

                if (((Base) Target).BasePosition.y < this.Position.x) {
                    this.Position.y--;
                    return 0;
                }


            }

            return 1;


        }

        return Integer.parseInt(null);
    }


    public boolean PlaneBackToBase() throws InterruptedException {

        Thread.currentThread().sleep(200);

        //airbase.Position = AirBasePosition;
        Position ABP = new Position(25, 25);


        if (ABP != this.Position) {

            if (ABP.x > this.Position.x && ABP.y > this.Position.y) {
                Position.x++;
                Position.y++;
                return true;
            }

            if (ABP.x < this.Position.x && ABP.y < this.Position.y) {
                Position.x--;
                Position.y--;
                return true;
            }

            if (ABP.x > this.Position.x) {
                this.Position.x++;
                return true;
            }


            if (ABP.x < this.Position.x) {
                this.Position.x--;
                return true;
            }

            if (ABP.y > this.Position.y) {
                this.Position.y++;
                return true;
            }

            if (ABP.y < this.Position.y) {
                this.Position.y--;
                return true;
            }


        }

        Thread.currentThread().sleep(10000);
        return false;
    }

    @Override
    public void run()  /**Unit activity thread**/
    {

        if (this.type == 7) {

            while (Game.state == Game.GameState.RunningGame) {


                while (Game.isPaused) {
                    try {
                        Thread.currentThread().sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                int mode = -1;
                strategy.InRangeEnemies();
                mode = move();

                if (mode == 1) {
                    try {
                        attack();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (mode == 2) {

                    try {
                        attack();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            return;
        }


        if (this.type == 5) {


            boolean Attacked = false;
            int mode = -1;
            while (Game.state == Game.GameState.RunningGame) {

                while (Game.isPaused) {
                    try {
                        Thread.currentThread().sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    mode = PlaneMoveToTarget();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if (mode == 1) {
                    try {
                        attack(Game.base);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Attacked = true;
                }

                while (Attacked) {
                    try {
                        Attacked = PlaneBackToBase();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }

            return;
        }


        boolean initplan = true;
        if (initLocation == this.Position)
            initplan = false;
        int mode = -1;
        while (Game.state == Game.GameState.RunningGame && initplan) {


            while (initplan) {
                MoveToLocation(initLocation.x, initLocation.y);
                if (initLocation.x == this.Position.x && initLocation.y == this.Position.y) {
                    initplan = false;
                    try {
                        Thread.currentThread().sleep(initWaitTime * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }


        while (Game.state == Game.GameState.RunningGame) {

            while (Game.isPaused) {
                try {
                    Thread.currentThread().sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //int mode = -1;
            strategy.InRangeEnemies();
            mode = move();

            if (mode == 1) {
                try {
                    attack(Game.base);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (mode == 2) {

                try {
                    attack(strategy.ReturnFirstElement());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}