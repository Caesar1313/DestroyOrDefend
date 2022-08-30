package DestroyOrDefend;

public class Bridge extends Obstacle {
    public double Health;


    Bridge(int x,int y){

        Position P = new Position(x,y);
        this.Position = P;
        type = 1;
        Health = 300.0;

    }
}
