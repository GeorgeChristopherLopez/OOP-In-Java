import java.awt.*;

public class Giant extends Critter {
    private int moves;
    private String avatar;

    // Constructor public Giant()
    public Giant(){
        moves = 1;
        avatar = "fee";
    }
    //getColor Color.GRAY
    public Color getColor(){
       return Color.gray;
    }
    //toString "fee" for 6 moves, then "􀃕e" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
    public String toString(){
        if(moves%6==0){
            if(this.avatar == "fee")
            avatar = "fi";
            else if(this.avatar == "fi")
            this.avatar = "foe";
            else if(this.avatar == "foe")
            this.avatar = "fum";
        }
            return avatar;
    }

    //getMove always infect if an enemy is in front, otherwise hop if possible, otherwise turn right.
    public Action getMove(CritterInfo info){
        moves++;
        if (info.getFront() == Neighbor.OTHER) {

            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;

        } else {
            return Action.RIGHT;
        }
    }

}
