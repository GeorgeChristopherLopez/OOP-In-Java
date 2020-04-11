import javax.print.DocFlavor;
import java.awt.*;
import java.util.Random;

public class WhiteTiger extends Critter {
    private int moves;
    private Color color;
    //Constructor public Tiger()
    public  WhiteTiger(){
        color = Color.white;

    }

    //getColor Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE) and uses that color for three moves, then randomly picks one of
    //those colors again for the next three moves, then randomly picks another one of those colors for the next three moves, and so on.
    public Color getColor(){


        return this.color;
    }
    //toString "TGR"
    public String toString(){
        return "WhtTGR";
    }
    //getMove always infect if an enemy is in front, otherwise if a wall is in front or to the right, then turn left, otherwise if a fellow Tiger is in front, then turn
    //right, otherwise hop.
    public Action getMove(CritterInfo info){
        moves++;
        if (info.getFront() == Neighbor.OTHER) {

            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;

        } else if(info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }
}
