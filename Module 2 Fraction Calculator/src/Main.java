import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        greeting();
        FractionCalculator();
    }

    public static void greeting (){
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q");
        System.out.println("Please enter you fractions in the form a/b, where a and b are integers");
        System.out.println("---------------------------------------------------------------------");
    }
    public static String getOperation(Scanner input) {
        boolean Exit = false;
        boolean validOp = false;
        String op = "";

            while (validOp == false) {
                System.out.print("Please enter an operation (+, -, *, /, or Q to quit) ");
                op = input.nextLine();

                if (op.equals("Q") || op.equals("q")) {
                    System.exit(0);
                }
                if (op.equals("/") || op.equals("*") || op.equals("+") || op.equals("-")) {
                    validOp = true;
                } else {
                    System.out.println("Try again(/ + - *)");
                }
            }
        return op;
    }
    public static boolean validFraction(String input){

        if (input == null || input.length() == 0) {
            return false;
        }
        try {
            String [] arr = input.split("/");
            if(arr.length == 1){
                Integer.parseInt(arr[0]);
            } else if(arr.length == 2){

                int num = Integer.parseInt(arr[0]);
                int den = Integer.parseInt(arr[1]);
                if(den == 0){
                    return false;
                }
            }

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Fraction getFraction(Scanner input) {
        boolean validFrac = false;
        Fraction fraction = new Fraction();
        while (validFrac == false) {
            System.out.print("Please enter a fraction (a/b) or integer (a) ");
            String res = input.nextLine();
            if (validFraction(res)) {
                String[] arr = res.split("/");
                if (arr.length == 1) {
                     fraction = new Fraction(Integer.parseInt(arr[0]));
                } else if (arr.length == 2) {
                     fraction = new Fraction((Integer.parseInt(arr[0])), Integer.parseInt(arr[1]));

                } else {
                     fraction = new Fraction((Integer.parseInt(arr[0])));
                }
                validFrac = true;
            } else {
                System.out.print("Invalid Fractions, ");
            }
        }
        return fraction;
    }

    public static void FractionCalculator(){
        Scanner input = new Scanner(System.in);
        boolean on = true;
        while (on = true){
            String op = getOperation(input);
            if (op.equals("Q") || op.equals("q")) {

                System.exit(1);
            }
            Fraction test = getFraction(input);
            Fraction test2 = getFraction(input);
            switch (op) {
                case "+":
                    test.add(test2);
                    break;
                case "-":
                    test.subtract(test2);
                    break;
                case "/":
                    test.divide(test2);
                    break;
                case "*":
                    test.multipy(test2);
                    break;

                default:
                    System.out.println("invalid entry");
                    break;
            }
            System.out.println("---------------------------------------------------------------------");
        }


    }


}
