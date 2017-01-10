
public class Timer implements Runnable {
	int length = 0;
	int update = 0; 
	
	
    Timer(int update,int length)
    {
    	this.length = length;
    	this.update = update;
    }
    
    
    public void run()
    {
   
    	while( length > 0)
    	{
    		length--;
    		
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
}
