//Ayaz Araf
//Hw3 CS 212
import java.util.Random;
import java.util.Scanner;

class Die// die class. Here is where the die is created
{
   private int dieside;
   private int random;

   public Die(int numSides)
   {
      dieside = numSides;
      roll();
   }

   public void roll()// random used for dice roll.
   {
      // Create a Random object.
      Random rand = new Random();

      // Get a random value for the die.
      random = rand.nextInt(dieside) + 1;
   }

   public int getSides()
   {
       return dieside;
   }

   public int getValue()
   {
       return random;
   }
}

class Player{//sets up player's attributes and sets up the score system.
	
	 private String name;
     private int score;
     private Die die;
     public Player(String a){
           name = a;
           score = 50;
           die = new Die(6);
     }
     public int roll(){
            die.roll();
            return (die.getValue());          
     }
     public void setScore(int a){
             if ((score - a) < 1)
                 score = score + a;
             else
                 score = score -a;
     }
     public int getScore(){
            return score;
     }
     public String getName(){
            return name;
     }

}

public class FirstToOneGame23197568 {//driver ask user for player 1 and two's name and calls in 
	//take method and gameInPlay

	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

         String name1 , name2;
         Scanner name = new Scanner(System.in);
         System.out.println("Enter Player 1's name:");
         name1 = name.next();
         System.out.println("Enter Player 2's name:");
         name2 = name.next();

         Player p1 = new Player(name1);
         Player p2 = new Player(name2);
         int count = 1;
      take(p1, p2, count);
       
     }
	
public static void take(Player p1, Player p2, int count){
//method where outputs the round and outputs the random number 
//and keeps track of the points 
	 while (p1.getScore() != 1 && p2.getScore() != 1){
    	 System.out.println("--------------------------");
         System.out.println("Round " + count + ":");
     int    d1 = p1.roll();
         p1.setScore(d1);
         System.out.println(p1.getName() + " rolled the die and gets a " + d1);        
      int   d2 = p2.roll();
         p2.setScore(d2);
         System.out.println(p2.getName() + " rolled the die and gets a " + d2);
         System.out.println(p1.getName() + " : " + p1.getScore() + " points");
         System.out.println(p2.getName() + " : " + p2.getScore() + " points");
         
         count++;    
       
    }  gameInPlay(p1, p2);
 
   
    
 }
//method that produces the results if either player earns a 1.	

	public static void gameInPlay(Player p1, Player p2){
		
		if(p1.getScore()==1 && p2.getScore()!=1)
        {
			System.out.println("-------------Result!-----------");
       	 System.out.println(p1.getName()+ " wins the game. " + p2.getName()
       	 + " has been defeated.");
        }
        else if(p2.getScore()==1 && p1.getScore()!=1){
        	System.out.println("-------------Result!-----------");
       	 System.out.println(p2.getName()+" wins the game. "+ p1.getName()+
       			 " has been defeated.");
        }
        else if(p1.getScore()==1&&p2.getScore()==1){
        	System.out.println("-------------Result!-----------");
        	System.out.println("Its a tie!!!!");
        }
       
	}
}