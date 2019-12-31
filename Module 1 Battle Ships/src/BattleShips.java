import java.util.Arrays;
import java.util.Scanner;

public class BattleShips {
    public static void main(String[] args) {
        greeting();
        String[][] map = createOceanMap();
        String[][] displayMap = deployPlayerShips(map);
        String[][] mainMap = deployCpuShips(displayMap);
        battle(displayMap, mainMap);
    }

    static void greeting() {
        System.out.println("**** Welcome to Battle Ships game *****");
        System.out.println();
        System.out.println("Right now, the sea is empty");
        System.out.println();
    }

    static String[][] createOceanMap() {
        // declaring and initializing 2D array
        String map[][] = new String[10][10];
        //populate map with sea (empty space)
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                map[r][c] = " ";
            }
        }


        // print map
        printMap(map);
        return map;
    }

    static void printMap(String[][] map) {
        // print map
        System.out.println("   0123456789   ");


        for (int r = 0; r < map.length; r++) {
            String joinedString = (String.join("", map[r]));
            System.out.println(r + " |" + joinedString + "| " + r);
        }
        System.out.println("   0123456789   ");

    }

    static String[][] deployPlayerShips(String[][] map) {
        Scanner input = new Scanner(System.in); //This line creates a Scanner for you to use
        String[][] displayMap = new String[10][10];
        for (int i = 0; i < 10; i++) {
            displayMap[i] = Arrays.copyOf(map[i], map[i].length);
        }
        int choice = 0;

        while (choice < 5) {
            choice++;
            boolean check = false;

            while (!check) {
                System.out.print("Enter X coordinate for your ship " + choice + ": ");
                int x = input.nextInt();
                System.out.print("Enter Y coordinate for your ship " + choice + ": ");
                int y = input.nextInt();
                // test
                if (x >= 0 && x < 10 && y < 10 && y >= 0) {
                    if (displayMap[x][y] == " ") {
                        displayMap[x][y] = "@";
                        check = true;
                    } else {
                        System.out.println("Seat taken. try again");
                    }
                } else {
                    System.out.println("Out of bounds. try again");
                }
            }
        }
        printMap(displayMap);
        return displayMap;
    }

    static String[][] deployCpuShips(String[][] map) {

        System.out.println("\nComputer is deploying ships");
        int choice = 0;
        String[][] mainMap = new String[10][10];
        for (int i = 0; i < 10; i++) {
            mainMap[i] = Arrays.copyOf(map[i], map[i].length);
        }
        while (choice < 5) {
            choice++;
            boolean check = false;

            while (!check) {
                int x = (int) Math.floor(Math.random() * 10);
                int y = (int) Math.floor(Math.random() * 10);
                // test
                if (x >= 0 && x < 10 && y < 10 && y >= 0) {
                    if (mainMap[x][y] == " ") {
                        mainMap[x][y] = "2";
                        System.out.println(choice + ". ship DEPLOYED");
                        check = true;
                    }
                }
            }
        }
        System.out.println("-----------------\n");

        return mainMap;
    }

    static void battle(String[][] displayMap, String[][] mainMap) {
        int pShips = 5;
        int cShips = 5;
        boolean game = false;
        String winner = "";
        Scanner input = new Scanner(System.in);


        while (!game) {

            boolean check = false;

            while (!check) {
                System.out.println("\nYOUR TURN");

                System.out.print("Enter X coordinate: ");
                int x = input.nextInt();
                System.out.print("Enter Y coordinate: ");
                int y = input.nextInt();
                // test
                if (x >= 0 && x < 10 && y < 10 && y >= 0) {
                    if (mainMap[x][y] == " ") {
                        System.out.println("You missed");
                        displayMap[x][y] = "-";
                        mainMap[x][y] = "-";
                        check = true;
                    } else if (mainMap[x][y] == "@") {
                        System.out.println("that's your ship silly. try again");
                    } else if (mainMap[x][y] == "2") {
                        System.out.println("hit!");
                        displayMap[x][y] = "!";
                        mainMap[x][y] = "!";
                        cShips--;
                        check = true;
                    } else if (mainMap[x][y] == "-" || mainMap[x][y] == "!") {
                        System.out.println("called that one already silly. try again");
                    }
                } else {
                    System.out.println("Out of bounds. try again");
                }
            }

            //check win state
            if (pShips == 0) {
                game = true;
                winner = "computer";
            } else if (cShips == 0) {
                game = true;
                winner = "player";
            }
            printMap(displayMap);
            System.out.println(("Your ships: "+pShips+" | Computer ships: "+cShips));

            // computer choice
            System.out.println("\nCOMPUTER'S TURN");
            check = false;
            while (!check) {
                int x = (int) Math.floor(Math.random() * 10);
                int y = (int) Math.floor(Math.random() * 10);
                // test
                if (x >= 0 && x < 10 && y < 10 && y >= 0) {
                    if (mainMap[x][y] == " ") {
                        System.out.println("computer missed");
                        displayMap[x][y] = "-";
                        mainMap[x][y] = "-";
                        check = true;
                    } else if (mainMap[x][y] == "@") {
                        System.out.println("Computer hit!");
                        displayMap[x][y] = "X";
                        mainMap[x][y] = "X";
                        pShips--;
                        check = true;
                    }
                }
            }
            //check win state
            if (pShips == 0) {
                game = true;
                winner = "computer";
            } else if (cShips == 0) {
                game = true;
                winner = "player";
            }
            printMap(displayMap);
            System.out.println(("Your ships: "+pShips+" | Computer ships: "+cShips));

        }

        System.out.println(("Your ships: "+pShips+" | Computer ships: "+cShips));

        if(winner=="player"){
            System.out.println(("Hooray! you win"));

        } else {
            System.out.println(("ah shucks. you lost! computer wins. hail skynet or tesla"));

        }
        printMap(mainMap);

    }
}
