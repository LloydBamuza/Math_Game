import java.util.*;



public class Addition {
	
	private int firstNum;
	private int secNum;
	private Random numGen = new Random();
	private int answer;

	
	// Generate operands based on difficulty
	Addition()
	{
		if(Math.difficulty == Math.Difficulty.EASY)
		{
		  firstNum = numGen.nextInt(10);
		  secNum = numGen.nextInt(10);
		}
		
		if(Math.difficulty == Math.Difficulty.INTERMEDIATE)
		{
		  firstNum = numGen.nextInt(20);
		  secNum = numGen.nextInt(20);
		}
		
		if(Math.difficulty == Math.Difficulty.HARD)
		{
		  firstNum = numGen.nextInt(50) + 50;
		  secNum = numGen.nextInt(50) + 50;
		}

	}
	
	public int getFirstOperand()
	{
		return firstNum;
	}
	
	public int getSecOperand()
	{
		return secNum;
	}
	
    public void calculate()
	{
		answer = firstNum + secNum; 
		System.out.println(answer);
	}
    
    public int getAnswer()
    {
    	return answer;
    }
	
	
	
}
