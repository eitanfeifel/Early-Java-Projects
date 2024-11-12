/*****************************************
 * A template for a Human Nim player
 ****************************************/ 
import java.util.Scanner;

public class Human{
   
    private int choice;
    private int halfMarbles;
    private Scanner input;
    private boolean valid = false;
    public static int marblesLeft1 = Game.marbles;
    
    public Human()
    {
        halfMarbles = (marblesLeft1/2);
        input= new Scanner(System.in);
        choice = -1;
        
    }
    public void move(int marblesLeft1)
    {

        System.out.println("How many marbles will you take?");
        choice = input.nextInt();    
//             if (choice > halfMarbles)
//             {
//                  while(choice > halfMarbles)
//                  {
//                         System.out.println("Invalid action: Please take only less than half the pile.");
//                         System.out.println("How many marbles will you take?");
//                         choice = input.nextInt();
//                  }   
//             }else{
         marblesLeft1 = marblesLeft1 - choice;
         System.out.println("You took " + choice + " marble(s). There are now " + marblesLeft1 + " marble(s) left");     
            //}
    }
    public int getChoice()
    {
        return choice;
    }
   
}

