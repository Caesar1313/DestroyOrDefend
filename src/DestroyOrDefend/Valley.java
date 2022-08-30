package DestroyOrDefend;

public class Valley extends Obstacle {

    Valley(){
        type = 2;
    }

    Valley(int x,int y){

        Position P = new Position(x,y);
        this.Position = P;
        this.type = 2;

    }
}
