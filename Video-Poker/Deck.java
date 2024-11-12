
import java.util.*;
public class Deck 
{	
	private Card[] cardArray  = new Card[52];
   	private int top; // the index of the top of the deck
    private Random random; 
    private static final int SHUFFLES = 1000;
    public ArrayList<Card> playerHandTest = new ArrayList<Card>(5);
            
    
    public Deck()
    {
		// make a 52 card deck here
            playerHandTest.add(new Card(1, 1));
            playerHandTest.add(new Card(1, 10));
            playerHandTest.add(new Card(1,11));
            playerHandTest.add(new Card(1, 12));
            playerHandTest.add(new Card(1, 9));
        
        
        random = new Random();
        int k = 0;
        
        for (int i = 1; i<=13; i++)
        {
            for (int j = 1; j<=4; j++)
            {
                cardArray[k] = new Card(j,i);
                k++;
               
            }         
           
        }     
       
    }
    
    public void getDeck()
    {
         System.out.println(cardArray);
    }

    public void shuffle()
    {
		// shuffle the deck here
       top = 0;
        for (int i =0; i< SHUFFLES;i++)
        {
           int rand1 = random.nextInt(51);
           int rand2 = random.nextInt(51);
           
            Card temp = cardArray[rand1];
            cardArray[rand1] = cardArray[rand2];
            cardArray[rand2] = temp;
        }
      
        
	}
	public Card deal()
    {
		// deal the top card in the deck
        Card topCard = cardArray[top];
        top++;
        return topCard;
	}

	
}
