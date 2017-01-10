import java.util.Random;

public class Division {
	private int firstNum;
	private int secNum = 1;
	private Random numGen = new Random();
	private int answer;

	
	Division(){}
	
	public int getFirstOperand()
	{
		return firstNum;
	}
	
	public int getSecOperand()
	{
		return secNum;
	}

	// repeatedly generate operands until both operands have no remainder
    public void calculate()
	{
    	try
    	{
    	  do
    	  {
    			if(Math.difficulty == Math.Difficulty.EASY)
    			{
    			  firstNum = numGen.nextInt(50);
    			  secNum = numGen.nextInt(50);
    			}
    			
    			if(Math.difficulty == Math.Difficulty.INTERMEDIATE)
    			{
    			  firstNum = numGen.nextInt(150);
    			  secNum = numGen.nextInt(150);
    			}
    			
    			if(Math.difficulty == Math.Difficulty.HARD)
    			{
    			  firstNum = numGen.nextInt(250);
    			  secNum = numGen.nextInt(250);
    			}
    			
    			// avoid division by zero
    		  if(secNum == 0){
    			  while(secNum == 0)
    			  {
    				  secNum = numGen.nextInt();
    			  }
    		  }
    	  }
    	  
    	  while((firstNum % secNum)!=0 );
    	}
    	catch(ArithmeticException e)
    	{
    		System.out.println("Division by zero");
    	}
    	
    	answer = firstNum / secNum;
	}
    
    public int getAnswer()
    {
    	return answer;
    }
}
