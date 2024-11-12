# Game-of-Nim
Game of Nim
Nim.java:

The Nim game runs mostly out of the Play() method in Game.java.

I created a while loop, which causes the game to continue running while the marbles are greater than 1.

Within the while loop I switch turns using an if statement. A random integer is generated (whoFirst) between 1 and 2, deciding which player goes first. If whoFirst is 0 the human goes, and whoFirst is switched to 1. When whoFirst is 1, the computer goes and then whoFirst is switched to 0. 

The human player turn is caused by the move() method within the human class.  
This asks the player for input of how many marbles they will take. It then reduces the size of the marble pile by the amount chosen and outputs the result. 

The Computer player turn is caused by the move() method within the computer class. 
This has a conditional of two modes 1, easy mode, and two, hard mode.

 If the user chooses easy mode, I run a while loop as long as the marbles are greater than 3 (in order to avoid the computer's choice issues when the pile reaches 3). I generate a random integer that is less than half the pile and reduce the pile by that number. 
While the marbles are equal to 3 I generate a random number between 1 and two and then reduce the pile by that number. Finally, while the pile is equal to two the computer takes  a single marble. 

If the user chooses hard mode, I create a conditional of if the pile is equal to a power of two minus one, or two. If this condition is met I do the same while loop I did in easy mode ( generating a random number and subtracting that number from the pile. At >3, 3 and 2).
If it is not met, I reduce the pile by a number generated through a method findArrayNum(). This method takes in an integer parameter (in this case the pile of marbles) and compares it to an array of powers of two minus one.If the numbers of marbles are greater than the number at the array at i, then the pile is set equal to i. If the number of marbles is less than i, i iterates. 

Back in Game.java, the turns go back and forth off this conditional statement until it breaks out of the while loop(marbles being greater than 1).
Once marbles are equal to 1, a conditional statement is run. If it is the human’s turn (whoFirst == 1) then the human loses, and if it is the computer's turn (whoFirst == 2) the computer loses. 

 



