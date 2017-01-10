import java.util.Random;

public class Multiplication {
	private int firstNum;
	private int secNum;
	private Random numGen = new Random();
	private int answer;

	// Generate operands based on difficulty	
	Multiplication()
	{
		if(Math.difficulty == Math.Difficulty.EASY)
		{
		  firstNum = numGen.nextInt(5);
		  secNum = numGen.nextInt(5);
		}
		
		if(Math.difficulty == Math.Difficulty.INTERMEDIATE)
		{
		  firstNum = numGen.nextInt(20);
		  secNum = numGen.nextInt(8);
		}
		
		if(Math.difficulty == Math.Difficulty.HARD)
		{
		  firstNum = numGen.nextInt(40);
		  secNum = numGen.nextInt(13);
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
		answer = firstNum * secNum; 
	}
    
    public int getAnswer()
    {
    	return answer;
    }

}
