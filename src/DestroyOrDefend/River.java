package DestroyOrDefend;

public class River extends Obstacle {

    River(){
        type = 0;
    }

    River(int x,int y){

        Position P = new Position(x,y);
        this.Position = P;
        this.type = 0;

    }
}
