import java.util.Scanner;

public class Main {

    public static void main (String[] args){
    }
    public String getOperation(Scanner input){
        boolean validOp = false;
        String op = "";
        while(validOp == false){
            System.out.print("what operation would you like to perform: + - * /");
            op = input.nextLine();
            if(op.equals('/')||op.equals('*')||op.equals('+')||op.equals('-')){
            validOp = true;

            } else {
                System.out.println("Try again(/ + - *)");
            }
        }
        return op;
    }
    public boolean validFraction(String input){

    }
    public Fraction getFraction(Scanner input){
            boolean validOp = false;
            while (validOp==false){

            }
    }
}
