public class BattleShips {
    public static void main (String [] args){
     greeting();
     String[][] map = createOceanMap();

    }
    static void greeting(){
        System.out.println("**** Welcome to Battle Ships game *****");
        System.out.println();
        System.out.println("Right now, the sea is empty");
        System.out.println();
    }

    static String[][] createOceanMap(){
        // declaring and initializing 2D array
        String map[][] = new String[10][10];
        //populate map with sea (empty space)
        for(int r = 0; r < map.length; r++){
            for (int c = 0; c < map[0].length; c++){
                map[r][c] = " ";
            }
        }

        String playerShip = "@";
        String computerShip = "2";

        map[2][2]= playerShip;
        map[2][4]= playerShip;
        map[4][2]= playerShip;
        map[5][2]= computerShip;
        map[7][5]= computerShip;
        map[9][7]= computerShip;


        System.out.println("   0123456789   ");


        for(int r = 0; r < map.length; r++){
            String joinedString = (String.join("", map[r]));
            System.out.println(r+" |"+joinedString+"| "+r);
        }
        System.out.println("   0123456789   ");
        return map;
    }
}

