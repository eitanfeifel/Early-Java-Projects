

import java.util.*;
public class Game {
	
	private Player p = new Player();
	private Deck cards = new Deck();
    private  Card c = new Card();
    private double bankroll1 = p.getBankroll();;
    public static final int HAND_SIZE = 5;
    ArrayList<Card> playerHand = p.returnHand();
    ArrayList<Integer> checkRanks = ranks(playerHand);
    ArrayList<Integer> checkSuits = suits(playerHand);
    double totalBet = 0;
    boolean isOnePair = false;
    boolean isTwoPair = false;
    boolean isThreeKind = false;
    boolean isStraight = false;
    boolean isFlush = false;
    boolean isFullHouse = false;
    boolean isFourKind = false;
    boolean isStraightFlush = false;
    boolean isRoyalFlush = false; 
    boolean isRoyalStraight = false;
    boolean gameOn = true;

    ArrayList<Card> f = cards.playerHandTest;
    

    
		
	public Game(String[] testHand)
    {
        for(String x : testHand)
        {
            p.returnHand().add(toCard(x));
        } 
        totalBet = 5;
        Collections.sort(p.returnHand());
        System.out.println("Your default bet was: 5 tokens.");
        judge(p.returnHand());
        checkHand(p.returnHand());
        getWinnings();
        System.exit(0);
	}
	
	public Game(){
        bankroll1 = p.bankroll;
          

   
	}

	public void play()
    {
		// this method should play the game
      System.out.println("Welcome to video poker.");
        while(gameOn = true){
            
         
          
           placeBet();
           System.out.println("Your Bankroll is now " +  p.getBankroll() );
           cards.shuffle();
           dealHand(); 
           playerHand = p.returnHand();
           
           System.out.println("Your Cards are: " + playerHand);
           changeHand();
           System.out.println("Your Cards are now: " + playerHand);
          // playerHand =f;
           Collections.sort(playerHand);
            
           System.out.println("Your Hand is being judged: " + playerHand);
          
           judge(playerHand);
           checkHand(playerHand);
           getWinnings();
         
 
            
           Scanner play = new Scanner(System.in);
           playerHand.clear();
           System.out.println("Would you like to play another hand? Y/N");
           String keepPlay = play.nextLine();
           if (keepPlay.equals("Y"))
           {
               gameOn = true;
           }else if(p.getBankroll() == 0){
               System.out.println("Sorry, you're out of money! Play again later.");
               gameOn = false; 
               break;
           }else{
               gameOn = false;
               System.out.println("Thanks for playing!");
               break;
           }
          
        } 
        
        
        }
	
	//Checks what your hand is and returns the result as a string.
	public void checkHand(ArrayList<Card> hand)
    {
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
        String handResult = "";
        if(isFullHouse)
        {
           System.out.println ("You have a Full House!");
        }else if(isTwoPair){
             System.out.println ("You have a two pair! ");
        }else if(isThreeKind){
             System.out.println ("You have a three of a kind! ");
        }else if(isFlush && isRoyalStraight){
            System.out.println ("You have a Royal Flush! ");
        }else if(isStraight && isFlush){
             System.out.println ("You have a Straight Flush! ");
        }else if(isFlush){
             System.out.println ("You have a Flush! ");
        }else if(isOnePair){
             System.out.println ("You have a pair! ");
        }else if(isFourKind){
             System.out.println ("You have a Four Kind! ");
        }else if(isStraight){
             System.out.println  ("You have a straight!");
        }else{
             System.out.println ("Sorry, you have nothing!");
        }

         
	}
    
    //Allows player to place a bet
    public void placeBet()
    {
           Scanner playerBetString = new Scanner(System.in);
           System.out.println("Your bankroll is: " + p.getBankroll() + " tokens. How many tokens would you like to bet? (Please enter a value 1-5)");
           int bet = playerBetString.nextInt();
           double bankroll2 = p.bets(bet);
           double playerBet = bankroll1 - bankroll2; 
           bankroll1 = bankroll2;
           totalBet = p.getBankroll() - bankroll1;

    }
    //Deals initial hand
    public void dealHand()
    {
        for(int i = 0; i<5; i++)
           {
              p.addCard(cards.deal());
              
           }
    }
    //Allows player to change card
    public void changeHand()
    {
        Scanner remover = new Scanner(System.in);
        System.out.println("Would you like to change any of your cards? Y/N?");
        String removeCard = remover.nextLine();  
        if (removeCard.equals("Y"))
        {
                      Scanner removed = new Scanner(System.in); 
                      System.out.println("Will you change Card 1?Y/N");
                       String cardRemoved = removed.nextLine(); 
                           if (cardRemoved.equals("Y"))
                           {
                               
                               p.addCard(0 , dealt() );
                               
                           }else{
                              playerHand = playerHand;  
                           }
                           System.out.println("Will you change Card 2?Y/N");
                           cardRemoved = removed.nextLine(); 
                           if ( cardRemoved.equals("Y"))
                           {
                               
                               p.addCard(1,dealt());
                               
                           }else{
                                playerHand = playerHand; 
                           }
                           System.out.println("Will you change Card 3?Y/N");
                           cardRemoved = removed.nextLine(); 
                           if ( cardRemoved.equals("Y"))
                           {
                              
                               p.addCard(2, dealt());
                               
                           }else{
                                    playerHand = playerHand; 
                           }
                           System.out.println("Will you change Card 4?Y/N");
                           cardRemoved = removed.nextLine(); 
                           if ( cardRemoved.equals("Y"))
                           {
                               
                               p.addCard(3, dealt());
                               
                           }else{
                                    playerHand = playerHand; 
                           }
                           System.out.println("Will you change Card 5?Y/N");
                           cardRemoved = removed.nextLine(); 
                           if ( cardRemoved.equals("Y"))
                           {
                               
                               p.addCard(4, dealt());
                               
                           }else{
                                playerHand = playerHand; 
                           }
                       cardRemoved.equals('N');
                   
                    }else{
                  playerHand = playerHand;
        }
               }
    //Deals a single card
    public Card dealt()
    {
        return cards.deal();
    }
    
    //Checks if any boolean of the hand results is T/F based on the below check...() methods
    private void judge(ArrayList<Card> playerHand)
    {
        Collections.sort(playerHand);
        checkRoyalStraight(playerHand);
        checkPairKind(playerHand);
        checkStraight(playerHand);
        checkFlush(playerHand); 
    } 
    //checks for pairs and kinds in final hand
    private void checkPairKind(ArrayList<Card> playerHand)
    {
        int counter1 = 0;
        int counter2 = 0;
        boolean isPair = false;
        
         for (int i =0; i < playerHand.size() - 1 ;i++)
         {
          
                 int compare = playerHand.get(i).compareTo(playerHand.get(i+1));
                 if (compare == 0)
                 {
                     if(isPair)
                     {
                         counter2++;
                     }else{
                         counter1++;
                     }
                 }else{
                     isPair = true;
                 }
             

         }
        
        if((counter1 == 1 && counter2 == 2) || (counter2 == 1 && counter1 == 2) ){
            isFullHouse = true;
        }else if(counter1 == 2 || counter2 == 2){
            isThreeKind = true;
        }else if(counter1 == 1 && counter2 == 1){
            isTwoPair = true;
        }else if(counter1 ==1 || counter2 ==1)
        {
            isOnePair = true;
        }else if(counter1 == 3 ||counter2 == 3){
            isFourKind = true;
        }
        
        
    }  
    //checks for a staight in final hand
    private void checkStraight(ArrayList<Card> playerHand)
    {
        int k = 0;
         for (int i = 0; i < playerHand.size()-1; i++)
         {
            
                if ((playerHand.get(i).returnRank() == (playerHand.get(i+1).returnRank()-1)))
                    k++;     
             
         }
        
        
        
             if (k==4 && playerHand.get(0).returnRank() == 1)
             {
                 isStraight= false;
             }else if(k==4 || isRoyalStraight){
                 isStraight = true;
             }else{
                 isStraight = false;
             }
    }
   
    //checks for a Flush in final hand
    private void checkFlush(ArrayList<Card> playerHand)
    {
        int flush = 0;
        for (int i = 0; i<playerHand.size()-1; i++)
        {
            
               int compare2 = playerHand.get(i).compareToSuit(playerHand.get(i+1));
             if (compare2 == 0){
                 flush++;
                 
             }else{
                 flush = flush;
             }
       }
         
        if(flush == 4)
        {
            isFlush = true;
        }else{
            isFlush = false;
        }
    }    
    //checks for a Royal straight to allow the Flush method to include a royal flush.
    private void checkRoyalStraight(ArrayList<Card> playerHand)
    {
        ArrayList<Integer> royalFlushRank = new ArrayList<Integer>(5);
        royalFlushRank.add(1);
        royalFlushRank.add(10);
        royalFlushRank.add(11);
        royalFlushRank.add(12);
        royalFlushRank.add(13);
        for (int i = 0; i < playerHand.size(); i ++)
        {
            
            if(playerHand.get(i).returnRank() == royalFlushRank.get(i)){
                isRoyalStraight = true;
            }else{
                 isRoyalStraight  = false;
             }
        }
         
    }
   
    //Computes the winning return odds of the player's hand result
    public double odds(ArrayList<Card> playerHand)
    {
        double winnings = 0;
        
        if(isFullHouse)
        {
           winnings = 6;
        }else if(isTwoPair){
             winnings =2 ;
        }else if(isThreeKind){
              winnings = 3;
        }else if(isFlush && isRoyalStraight){
             winnings = 250;
        }else if(isStraight && isFlush){
              winnings = 50;
        }else if(isFlush){
              winnings = 5;
        }else if(isOnePair){
              winnings = 1;
        }else if(isFourKind){
              winnings = 25;
        }else if(isStraight){
              winnings = 4;
        }else{
              winnings = 0;
        } 
        
        return winnings;
    }
    
    //adds the players winnings to their hand
    public void getWinnings()
    {
          double betReturn = odds(playerHand);
          p.winnings(totalBet, betReturn);
          System.out.println("Your bankroll is now " + p.getBankroll());
    }
    
 
   
    //returns the ranks of the hand
    public ArrayList<Integer> ranks (ArrayList<Card> hand)
    {
        ArrayList<Integer> rankList = new ArrayList<Integer>();
        for (Card c : hand )
        {
            rankList.add(c.returnRank());
        }
        return rankList;
    }
    //returns the suits of the hand
    public ArrayList<Integer> suits (ArrayList<Card> hand)
    {
        ArrayList<Integer> suitList = new ArrayList<Integer>();
        for (Card c : hand )
        {
            suitList.add(c.returnSuit());
        }
        return suitList;
    }
    
   //converts the command line cards to Card objects
   public Card toCard(String cardString)
   {
        char[] charCard = cardString.toCharArray();
        Card convertString;
        int cRank = 0;
        if (charCard.length == 3)
        {
            String sRank = charCard[1] + "" + charCard[2];
            cRank = Integer.parseInt(sRank);
        }
        else if(charCard.length ==2)
        {
            cRank = Integer.parseInt(String.valueOf(charCard[1]));
        }
        switch(charCard[0])
        {
           case 's': convertString = new Card(1, cRank);
                   break;
           case 'c': convertString = new Card(2, cRank);
                   break;
           case 'd': convertString = new Card(3, cRank);
                   break;
           case 'h': convertString = new Card(4, cRank);
                   break;
            default: convertString = new Card();
                
        }
        return convertString;
    }
        
   
   

   
    
    
}

