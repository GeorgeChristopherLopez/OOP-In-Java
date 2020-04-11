import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private String avatar;



    public Bear(boolean polar){
       this.polar = polar;
       avatar = "/";
}
public Color getColor () {
    // getColor Color.WHITE for a polar bear (when polar is true), Color.BLACK otherwise (when polar is false)
    Color color = Color.BLACK;

    if (this.polar)
        color = Color.WHITE;

    return color;
}

public String toString(){
//toString Should alternate on each different move between a slash character (/) and a backslash character () starting with a slash.
    if(avatar.equals("/"))
        avatar = "\\";
    else
        avatar = "/";

    return avatar;
}
public Action getMove(CritterInfo info){
    //getMove always infect if an enemy is in front,
    // otherwise hop if possible, otherwise turn left.

    if (info.getFront() == Neighbor.OTHER) {

        return Action.INFECT;
    } else if(info.getFront() == Neighbor.EMPTY){
        return Action.HOP;

    } else {
        return Action.LEFT;
    }
}



}
