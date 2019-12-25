import java.util.Scanner;

public class BattleShips {
    public static void main (String [] args){
     greeting();
     String[][] map = createOceanMap();
     map = deployPlayerShips(map);
map = deployCpuShips(map);
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


        // print map
        printMap(map);
        return map;
    }

     static void printMap(String[][] map){
        // print map
        System.out.println("   0123456789   ");


        for(int r = 0; r < map.length; r++){
            String joinedString = (String.join("", map[r]));
            System.out.println(r+" |"+joinedString+"| "+r);
        }
        System.out.println("   0123456789   ");

    }

    static String[][] deployPlayerShips(String[][] map){
        Scanner input = new Scanner(System.in); //This line creates a Scanner for you to use
        int choice = 0;

        while(choice < 5) {
            choice++;
            boolean check = false;

            while (!check){
                System.out.print("Enter X coordinate for your ship " + choice + ": ");
                 int x = input.nextInt();
                System.out.print("Enter Y coordinate for your ship " + choice + ": ");
                 int y = input.nextInt();
                 // test
                if(x >= 0 && x < 10 && y < 10 && y >= 0){
                    if (map[x][y]==" "){
                        map[x][y] = "@";
                        check = true;
                    } else {
                        System.out.println("Seat taken. try again");
                    }
                } else {
                    System.out.println("Out of bounds. try again");
                }
            }
        }
           printMap(map);
            return map;
    }

    static String [][] deployCpuShips(String[][] map){

        int choice = 0;

        while(choice < 5) {
            choice++;
            boolean check = false;

            while (!check){
                int x = (int) Math.floor(Math.random()*10);
                int y = (int) Math.floor(Math.random()*10);
                // test
                if(x >= 0 && x < 10 && y < 10 && y >= 0){
                    if (map[x][y]==" "){
                        map[x][y] = "2";
                        System.out.println(choice+". ship DEPLOYED");
                       check = true;
                    }
                }
            }
        }
        // for testing
        printMap(map);
        return map;
    }
}

