import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;

public class Math {
	
	static enum Difficulty{
		EASY, INTERMEDIATE, HARD;
	}
	private JFrame frame;
	private JTextField txtQuestion;
	private JTextField txtInput;
	private JTextField txtResult;
	public Addition additionObj;
	public Division divisionObj;
	public Multiplication multiplicationObj;
	public Subtraction subtractionObj;
	private JTextField txtMathGame;
	private JTextField txtEnterAnswerHere;
	private JTextField txtResult_1;
	private JTextField txtMathGame_1;
	private JTextField textField_4;
	private JTextField txtResult_2;
	private JTextField txtMathGame_2;
	private JTextField textField_7;
	private JTextField txtResult_3;
	private JMenuBar menuBar;
	JLabel lblReady;
	private JMenu mnOptions;
	private JMenuItem mntmTimedChallenge;
	static public int  numberCorrect = 0;
	boolean timedChallengeOn = false;
	static public int totalQuestionsAnswered;
	private int timePassed = 0;
	public static Difficulty difficulty = Difficulty.EASY;
	private JMenu mnNewMenu;
	private JMenuItem mntmEasy;
	private JMenuItem mntmIntermidiate;
	private JMenuItem mntmHard;
	private JLabel lblReady_1;
	private JLabel lblReady_2;
	private JLabel lblReady_3;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Math window = new Math();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Math() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				frame.setLocationRelativeTo(null);
			}
		});
		frame.setBounds(100, 100, 450, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Addition", null, panel, null);
		
		txtQuestion = new JTextField();
		txtQuestion.setFont(new Font("Footlight MT Light", Font.PLAIN, 25));
		txtQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuestion.setText("MATH GAME");
		txtQuestion.setForeground(Color.YELLOW);
		txtQuestion.setBackground(Color.BLUE);
		txtQuestion.setColumns(10);
		
		txtInput = new JTextField();
		txtInput.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtInput.setForeground(Color.GREEN);
		txtInput.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(additionObj != null) // make sure button generate has been clicked first
				{
				  int userInput = Integer.parseInt(txtInput.getText());
				
				  if(additionObj.getAnswer() == userInput)
				  {
					txtResult.setText(" CORRECT!");
					if(timedChallengeOn == true) numberCorrect++;
		          }
				  else
				  {
					  txtResult.setText("Incorrect. Answer is: "+ additionObj.getAnswer());
				  }
				
				  txtQuestion.setText("");// clear textfield
				  txtInput.setText(""); //clear textfield
				  txtQuestion.setText("MATH GAME");
				  
				  additionObj = null; 
				  
				  if(timedChallengeOn) totalQuestionsAnswered++;
				}       
				else
				{
					JOptionPane.showMessageDialog(null, " Please click on: ' GENERATE ' " , "Error" ,JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.RED);
		
		JButton btnNewButton_1 = new JButton("GENERATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				additionObj = new Addition();
				additionObj.calculate();
				txtQuestion.setText(""); //clear textfield 
				txtResult.setText(""); // clear textfield
				txtInput.setText(""); //clear textfield
				
				// display problem on textfield
				txtQuestion.setText(Integer.toString(additionObj.getFirstOperand()) + " + " + Integer.toString(additionObj.getSecOperand())+ "?");
				
				
	
				txtInput.setText(""); //clear textfield
				if(!timedChallengeOn) lblReady.setText(" Difficulty: "+ difficulty);
				//System.out.println(additionObj.getAnswer());
				
				
				
				
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.RED);
		
		txtResult = new JTextField();
		txtResult.setForeground(Color.GREEN);
		txtResult.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtResult.setHorizontalAlignment(SwingConstants.CENTER);
		txtResult.setText("RESULT");
		txtResult.setBackground(Color.BLUE);
		txtResult.setColumns(10);
		
		lblReady = new JLabel("Ready...");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(txtQuestion, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(txtInput, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(txtResult, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(lblReady, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(txtQuestion, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtInput, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtResult, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblReady, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Subtraction", null, panel_1, null);
		
		txtMathGame = new JTextField();
		txtMathGame.setForeground(Color.YELLOW);
		txtMathGame.setBackground(Color.BLUE);
		txtMathGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtMathGame.setFont(new Font("Footlight MT Light", Font.PLAIN, 25));
		txtMathGame.setText("MATH GAME");
		txtMathGame.setColumns(10);
		
		txtEnterAnswerHere = new JTextField();
		txtEnterAnswerHere.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("ENTER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(subtractionObj != null) // make sure button generate has been clicked first
				{
				  int userInput = Integer.parseInt(txtEnterAnswerHere.getText());
				
				  if(subtractionObj.getAnswer() == userInput)
				  {
					txtResult_1.setText(" CORRECT!");
					  if(timedChallengeOn) numberCorrect++;
		          }
				  else
				  {
					  txtResult_1.setText("Incorrect. Answer is: "+ subtractionObj.getAnswer());
				  }
				
				  txtMathGame.setText("");// clear textfield
				  txtEnterAnswerHere.setText(""); //clear textfield
				  txtMathGame.setText("MATH GAME");
				  
				  subtractionObj = null;
				  if(timedChallengeOn) totalQuestionsAnswered++;
				}       
				else
				{
					JOptionPane.showMessageDialog(null, " Please click on: ' GENERATE ' " , "Error" ,JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		
		JButton btnNewButton_3 = new JButton("GENERATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				subtractionObj = new Subtraction();
				subtractionObj.calculate();
				txtMathGame.setText(""); //clear textfield 
				txtResult_1.setText(""); // clear textfield
				txtEnterAnswerHere.setText(""); //clear textfield
				
				// display problem on textfield
				txtMathGame.setText(Integer.toString(subtractionObj.getFirstOperand()) + " - " + Integer.toString(subtractionObj.getSecOperand())+ "?");
				
				
	
				txtEnterAnswerHere.setText(""); //clear textfield
				if(!timedChallengeOn)
					{
					lblReady.setText(" Difficulty: "+ difficulty);
					lblReady_1.setText(" Difficulty: "+ difficulty);
					lblReady_2.setText(" Difficulty: "+ difficulty);
					lblReady_3.setText(" Difficulty: "+ difficulty);
					}
				System.out.println(subtractionObj.getAnswer());
								
			}
		});
		btnNewButton_3.setForeground(Color.RED);
		
		txtResult_1 = new JTextField();
		txtResult_1.setForeground(Color.CYAN);
		txtResult_1.setBackground(Color.BLUE);
		txtResult_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtResult_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtResult_1.setText("RESULT");
		txtResult_1.setColumns(10);
		
		lblReady_1 = new JLabel("Ready...");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(txtMathGame, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(txtEnterAnswerHere, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(txtResult_1, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblReady_1, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(txtMathGame, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEnterAnswerHere, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtResult_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(lblReady_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Multiplication", null, panel_2, null);
		
		txtMathGame_1 = new JTextField();
		txtMathGame_1.setForeground(Color.YELLOW);
		txtMathGame_1.setBackground(Color.BLUE);
		txtMathGame_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMathGame_1.setFont(new Font("Footlight MT Light", Font.PLAIN, 25));
		txtMathGame_1.setText("MATH GAME");
		txtMathGame_1.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("ENTER");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(multiplicationObj != null) // make sure button generate has been clicked first
				{
				  int userInput = Integer.parseInt(textField_4.getText());
				
				  if(multiplicationObj.getAnswer() == userInput)
				  {
					txtResult_2.setText(" CORRECT!");
				    if(timedChallengeOn) numberCorrect++;
		          }
				  else
				  {
					  txtResult_2.setText("Incorrect. Answer is: "+ multiplicationObj.getAnswer());
				  }
				
				  txtMathGame_1.setText("");// clear textfield
				  textField_4.setText(""); //clear textfield
				  txtMathGame_1.setText("MATH GAME");
				  
				  multiplicationObj = null;
				  if(timedChallengeOn) totalQuestionsAnswered++;
				}  

				else
				{
					JOptionPane.showMessageDialog(null, " Please click on: ' GENERATE ' " , "Error" ,JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_4.setForeground(Color.RED);
		
		JButton btnNewButton_5 = new JButton("GENERATE");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				multiplicationObj = new Multiplication();
				multiplicationObj .calculate();
				txtMathGame_1.setText(""); //clear textfield 
				txtResult_2.setText(""); // clear textfield
				textField_4.setText(""); //clear textfield
				
				// display problem on textfield
				txtMathGame_1.setText(Integer.toString(multiplicationObj.getFirstOperand()) + " * " + Integer.toString(multiplicationObj.getSecOperand())+ "?");
				
				
	
				textField_4.setText(""); //clear textfield
				if(!timedChallengeOn) lblReady.setText(" Difficulty: "+ difficulty);

				
				System.out.println(multiplicationObj.getAnswer());
			}
		});
		btnNewButton_5.setForeground(Color.RED);
		
		txtResult_2 = new JTextField();
		txtResult_2.setBackground(Color.BLUE);
		txtResult_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtResult_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtResult_2.setForeground(Color.CYAN);
		txtResult_2.setText("RESULT");
		txtResult_2.setColumns(10);
		
		lblReady_2 = new JLabel("Ready...");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(txtMathGame_1, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtResult_2, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
						.addComponent(lblReady_2, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(txtMathGame_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtResult_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblReady_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Division", null, panel_3, null);
		
		txtMathGame_2 = new JTextField();
		txtMathGame_2.setBackground(Color.BLUE);
		txtMathGame_2.setForeground(Color.YELLOW);
		txtMathGame_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtMathGame_2.setFont(new Font("Footlight MT Light", Font.PLAIN, 25));
		txtMathGame_2.setText("MATH GAME");
		txtMathGame_2.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("ENTER");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(divisionObj != null) // make sure button generate has been clicked first
				{
				  int userInput = Integer.parseInt(textField_7.getText());
				
				 // check if answer is correct
				  if(divisionObj.getAnswer() == userInput)
				  {
					  System.out.println(divisionObj.getAnswer() + " "+  userInput);
					txtResult_3.setText(" CORRECT!");
					  if(timedChallengeOn) numberCorrect++;
		          }
				  else
				  {
					  txtResult_3.setText("Incorrect. Answer is: "+ divisionObj.getAnswer());
				  }
				
				  txtMathGame_2.setText("");// clear textfield
				  textField_7.setText(""); //clear textfield
				  txtMathGame_2.setText("MATH GAME");
				  
				  divisionObj = null; 
				  if(timedChallengeOn) totalQuestionsAnswered++;
				}       
				else
				{
					JOptionPane.showMessageDialog(null, " Please click on: ' GENERATE ' " , "Error" ,JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_6.setForeground(Color.RED);
		
		JButton btnNewButton_7 = new JButton("GENERATE");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				divisionObj = new Division();
				divisionObj.calculate();
				txtMathGame_2.setText(""); //clear textfield 
				txtResult_3.setText(""); // clear textfield
				textField_7.setText(""); //clear textfield
				
				// display problem on textfield
				txtMathGame_2.setText(Integer.toString(divisionObj .getFirstOperand()) + " /" + Integer.toString(divisionObj .getSecOperand())+ "?");
				
				
	
				textField_7.setText(""); //clear textfield
				if(!timedChallengeOn) lblReady.setText(" Difficulty: "+ difficulty);

				System.out.println(divisionObj.getAnswer()); //debugging
			}
		});
		btnNewButton_7.setForeground(Color.RED);
		
		txtResult_3 = new JTextField();
		txtResult_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtResult_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtResult_3.setBackground(Color.BLUE);
		txtResult_3.setForeground(Color.CYAN);
		txtResult_3.setText("RESULT");
		txtResult_3.setColumns(10);
		
		lblReady_3 = new JLabel("Ready...");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(btnNewButton_7, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(btnNewButton_6, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(textField_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(txtMathGame_2, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addComponent(txtResult_3, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(lblReady_3, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(txtMathGame_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnNewButton_7, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(txtResult_3, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblReady_3, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		mntmTimedChallenge = new JMenuItem("Timed challenge");
		mntmTimedChallenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				timedChallengeOn = true;
				
				Timerx t;
				
				JOptionPane.showMessageDialog(null,  " You have 60 seconds to complete as many questions"," Timed Challenge", JOptionPane.INFORMATION_MESSAGE);
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Button is working");
				t = new Timerx(60, lblReady,lblReady_1, lblReady_2,lblReady_3, timedChallengeOn, numberCorrect);
				Results resultsWindow = new Results();
				
			 
			}
		});
		mntmTimedChallenge.addMenuKeyListener(new MenuKeyListener() {
			public void menuKeyPressed(MenuKeyEvent arg0) {
			}
			public void menuKeyReleased(MenuKeyEvent arg0) {
			
			}
			public void menuKeyTyped(MenuKeyEvent arg0) {
			}
		});
		mntmTimedChallenge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				
					}
		});
		
		mnNewMenu = new JMenu("Difficulty");
		mnOptions.add(mnNewMenu);
		
		mntmEasy = new JMenuItem("Easy");
		mntmEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				difficulty = Difficulty.EASY;
				if(!timedChallengeOn)
					{
					lblReady.setText(" Difficulty: EASY");
					lblReady_1.setText(" Difficulty: EASY");
					lblReady_2.setText(" Difficulty: EASY");
					lblReady_3.setText(" Difficulty: EASY");
					}

				JOptionPane.showMessageDialog(null, " Difficulty set to: EASY", "Difficulty", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmEasy);
		
		mntmIntermidiate = new JMenuItem("Intermidiate");
		mntmIntermidiate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				difficulty = Difficulty.INTERMEDIATE;
				if(!timedChallengeOn)
					{
					lblReady.setText(" Difficulty: INTERMEDIATE");
					lblReady_1.setText(" Difficulty: EASY");
					lblReady_2.setText(" Difficulty: EASY");
					lblReady_3.setText(" Difficulty: EASY");
					}
				JOptionPane.showMessageDialog(null, " Difficulty set to: INTERMEDIATE", "Difficulty", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmIntermidiate);
		
		mntmHard = new JMenuItem("Hard");
		mntmHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				difficulty = Difficulty.HARD;
				if(!timedChallengeOn)
					{
					lblReady.setText(" Difficulty: HARD");
					lblReady_1.setText(" Difficulty: EASY");
					lblReady_2.setText(" Difficulty: EASY");
					lblReady_3.setText(" Difficulty: EASY");
					}
				JOptionPane.showMessageDialog(null, " Difficulty set to: HARD", "Difficulty", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmHard);
		mnOptions.add(mntmTimedChallenge);
	}
}
