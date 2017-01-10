import java.util.Random;

public class Subtraction {

	private int firstNum;
	private int secNum;
	private Random numGen = new Random();
	private int answer;

	// Generate operands based on difficulty	
	Subtraction()
	{
		if(Math.difficulty == Math.Difficulty.EASY)
		{
		  firstNum = numGen.nextInt(10);
		  secNum = numGen.nextInt(10);
		}
		
		if(Math.difficulty == Math.Difficulty.INTERMEDIATE)
		{
		  firstNum = numGen.nextInt(50);
		  secNum = numGen.nextInt(50);
		}
		
		if(Math.difficulty == Math.Difficulty.HARD)
		{
		  firstNum = numGen.nextInt(100);
		  secNum = numGen.nextInt(100);
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
		answer = firstNum - secNum; 
	}
    
    public int getAnswer()
    {
    	return answer;
    }
}
