import javax.swing.*;

public class Timerx implements Runnable {
	int length = 0;
	JLabel j,k,l,m;
	boolean timerOn;
	int numCorrectAnswers = 0;
	
    Timerx(int length, JLabel jl, JLabel j2,JLabel j3,JLabel j4, boolean timerOn, int num)
    {
    	Thread t = new Thread(this);
    	this.length = length;
    	j = jl;
    	k = j2;
    	l = j3;
    	m = j4;
    	this.timerOn = timerOn;
    	numCorrectAnswers = num;
    	t.start();
    	
    	
    }
 
    public void start( ){
    	//System.out.println("Started");
    	
    	
    // countdown loop	
	while( length > 0)
	{
		//initialize all status bars
		j.setText("");
		k.setText("");
		l.setText("");
		m.setText("");
		
		// display amount of time remaining on all status bars
		j.setText(" Time remaining: " + Integer.toString(length) );
		k.setText(" Time remaining: " + Integer.toString(length) );
		l.setText(" Time remaining: " + Integer.toString(length) );
		m.setText(" Time remaining: " + Integer.toString(length) );
		
		length--;
		//System.out.println(length);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	timerOn = false;
	
	j.setText(" Time up.");
	k.setText(" Time up.");
	l.setText(" Time up.");
	m.setText(" Time up.");
	
	//display results window
    Results showResults = new Results();
    showResults.setVisible(true);
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//finalize
	j.setText("Ready...");
	k.setText("Ready...");
	l.setText("Ready...");
	m.setText("Ready...");
	Math.numberCorrect = 0;
	Math.totalQuestionsAnswered = 0;
	
    }
    
    
    public void run()
    {
    	this.start();
    	
    }
    
}
