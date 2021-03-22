import java.util.*;

public class SimpleTest 
{
	public static void main (String[] args)
	{
		String stringGuess;
		SimpleDotCom dot = new SimpleDotCom();
		dot.checkYourself();
	}
}



class SimpleDotCom
{

	int unknown = (int) (Math.random()*5);
	int i;
	int numOfHits = 0;
	
	
	int[] locationCells = new int[]{ unknown, unknown+1, unknown+2 };
	System.out.println(unknown);
		
	Scanner sc =new Scanner(System.in);
	
	public void checkYourself()
		{
			
			while(result == "kill")
			{
				numOfHits++;
				System.out.println("Enter your Input");
				
				String stringGuess= sc.nextLine();
				
				int guess =Integer.parseInt(stringGuess); 
				
				for(int cell : locationCells)
				{
					if (guess == cell)
						{
							result = "hit" ; 
							//numOfHits++;
							//break;
							System.out.println("hit");
						}	
					else
					{
						System.out.println("miss");
					}
				}
				
				if (numOfHits == locationCells.length)
					{
						result ="kill"; 
						System.out.println(result);
						
					}
					
					
					
				
			}
			System.out.println("No of Hits :"+numOfHits);
			
	}
}	
		