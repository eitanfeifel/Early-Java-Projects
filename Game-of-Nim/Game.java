/*****************************************
 * A template for a Nim game
 ****************************************/ 
import java.util.Random;
import java.util.Scanner;
public class Game{  
    private Human humanPlayer;
    private Computer computerPlayer;
    Random random;
    public static int marbles;
    public static int marblesRemain = Computer.marblesLeft;
    public boolean easy; 
    Random num1 = new Random();
    int whoFirst = num1.nextInt(2);
    
 public Game(int level)
 {
        humanPlayer = new Human();
        computerPlayer = new Computer(level); 
    }    
 public void play()
 {  
    Random num = new Random();
    int marbles = num.nextInt(90) + 10;
    System.out.println("The size of the pile is: " + marbles + " marbles.");   
         while(marbles > 1)
         {
           
             if(whoFirst ==0){
                 System.out.println("Player: Human will now go.");
                 humanPlayer.move(marbles);
                 marbles = marbles - humanPlayer.getChoice();
                 checkTurn();
            }else{
                 System.out.println("Player: Computer will now go.");
                 computerPlayer.move(marbles);
                 marbles = marbles - computerPlayer.getChoice();
                 checkTurn();
                   }  
         }
         
        while (marbles == 1)
        {
            if (whoFirst == 0){
                System.out.println("There is 1 marble left. Sorry, you lose!");
            }else{
                System.out.println("There is 1 marble left. Congratulations, you win!");
            }
            break;
        }
}
 private void checkTurn()
 {
     if (whoFirst == 0){
         whoFirst = 1; 
     }else{
         whoFirst = 0;
           }     
        }
 
}
    
    
         
       
      
      
        
        
    

    


