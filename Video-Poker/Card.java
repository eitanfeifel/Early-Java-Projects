public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
    
	public Card(int s, int r)
    {
        //make a card with suit s and value v
        suit = s;
        rank = r;  
       
	}
    public Card()
    {

    }
	
	public int compareTo(Card c)
    { 
        // use this method to compare cards so they // may be easily sorted
        int compare = 0;
        if(c.rank ==rank)
        {
            compare = 0;
        }else if(c.rank>rank){
            compare = -1;
        }else if(c.rank< rank){
            compare = 1;
        }
       
        
       
    
        
        return compare;
    }
    public int compareToSuit(Card c)
    {
        int compare1 = 0;
        if (c.suit == suit)
        {
            compare1 = 0;
        }else{
            compare1 = 1;
        }
        return compare1;
        }
    
    
    
    
    
    
    public int returnRank()
    {
        return rank;
    }
    
    public int returnSuit()
    {
        return suit;
    }
	
	public String toString()
    {
        String playerCard= "";
        
        if (suit == 1)
        {
            playerCard = "s";
        }else if(suit ==2)
        {
            playerCard = "c";
        }else if(suit ==3)
        {
            playerCard = "d";
        }else if(suit ==4)
        {
            playerCard = "h";
        }
        
        return playerCard + rank;
    }
	
            
}
