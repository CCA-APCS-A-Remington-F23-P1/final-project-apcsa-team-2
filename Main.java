import java.util.Scanner;

public class Main{
  
    public static void main(String[] args){
      Scanner scanner =  new Scanner(System.in);
      System.out.println("choose your character!!");
      System.out.println("1) sumana");
      System.out.println("2) leher");
      System.out.println("3) jen");

      int charChoice = scanner.nextInt();

      System.out.println("loading the game..");

      String charChoiceString = charChoice + "";
      Game run = new Game(charChoiceString);
    }

}
