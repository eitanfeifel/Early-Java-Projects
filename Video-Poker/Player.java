import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	public double bankroll;
    private double bet;
    private Deck d1;
	double totalBet;

	// you may choose to use more instance variables
		
	public Player()
    {		
	    // create a player here
        hand = new ArrayList<Card>(5);
        Deck d1 = new Deck();
        bankroll = 50; 
	}

	public void addCard(int index, Card c)
    {
	    // add the card c to the player's hand
        hand.set(index, c);   
	}
    public void addCard(Card c)
    {
	    // add the card c to the player's hand
        hand.add(c);   
	}

	public void removeCard(Card c)
    {
	    // remove the card c from the player's hand
        hand.remove(c); 
    }
		
    public double bets(double amt)
    {
            // player makes a bet
        bankroll = bankroll - amt;
        totalBet = amt; 
        return bankroll;
        
    }
   
    public void winnings(double odds, double bet)
    {
        
         bankroll = bankroll + (bet*odds);
    }

    public double getBankroll()
    {
           return bankroll;
    }
    
    public ArrayList<Card> returnHand()
    {
        return hand;    
    }
    public void sortHand()
    {
        Collections.sort(hand);
    }

   
    
        // you may wish to use more methods here
}


