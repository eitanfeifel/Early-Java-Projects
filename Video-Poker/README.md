# Video-Poker
Playable Game of Video Poker


The bulk of the program for PokerTest.java is run through the play() method in Game.java.
I set a boolean variable called gameOn to continue to play the game so long as gameOn is true 
(beyond the first round of play, the hand will not be judged correctly. I was unable to fix this bug, but I know it is not a requirement on the assignment to
play multiple rounds and that is why I left it alone).
 A bet is placed through my placeBet() method which takes in an integer from the user as a bet and subtracts that amount from the total bankroll and saves their bet as a 
 variable ‘totalBet’ to later calculate the winnings. 

I then shuffle all the cards with a shuffle() method from my deck class. 
This method manually shuffles the deck by choosing two random locations of the Array of cards and swapping them. I create a for loop to make this happen 1000 times
to ensure the deck is properly shuffled. 

A hand is then dealt to the player through my dealHand() method. 
This method is a for loop that runs 5 times and uses the addCard() method from my player class to add the top card of my shuffled deck to an arraylist within 
the player class that is the player’s hand of cards.

The player can then choose to swap out cards in their hand with the changeHand() method. 
This method iterates through each card in the arraylist and asks the user to input if they would like to swap the card at each index.
When the input is yes(Y), a new card is dealt with the dealt() method and replaces the original card. 

The cards in the hand are then sorted with Collections.sort() and they are judged through the juge() and checkHand() method.
The judge() method runs through a series of methods made to scan for any possible hand combinations. In the case of a pair, kind, straight, flush, etc. 
these methods will return either true or false for the corresponding boolean value (isTwoPair, isStraight, isRoyalFlush…). 
Then the checkHand() method checks which of these boolean values are true and returns the player their results. 

The player’s winnings are distributed through a similar manner as the checkHand() method but through a getWinnings() method which scans for the value of each of the
boolean values and returns the appropriate winnings based on the hand result and the total bet value. The player can then choose to either play again or exit the game.  

