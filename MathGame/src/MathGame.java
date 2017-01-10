import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MathGame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private Random rand = new Random();
	int firstButtonClick = 0;
	int number1;
	int number2;
	int answer = 20;
	int userAnswer;
	JButton btnEnter;
	private JButton Start;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MathGame window = new MathGame();
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
	public MathGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
              
			}
			@Override
			public void windowActivated(WindowEvent arg0) {
				
			}
		});
		frame.setBounds(100, 100, 447, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		tabbedPane.addTab("Addition", null, panel, null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBackground(Color.CYAN);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
		
	
				userAnswer = Integer.parseInt(textField_1.getText());
				

				if(userAnswer == answer)
				{
					textArea.append("Correct! ");
					textField.setText("");
					textField_1.setText("");
				}
				else
				{
					textArea.setText(" ");
					textArea.append("Incorrect \n");
					textArea.append("Correct answer is: "+ answer);
					textField.setText("");
					textField_1.setText("");
					
				}
			
		

	
			
			}
				
		
				

	
				
				
				
			
		});
		
		Start = new JButton("GENERATE");
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  number1 = rand.nextInt(50);
				   number2 = rand.nextInt(20);
				   answer = number1 - number2;
				   textField.setText(Integer.toString(number1) + " - " + Integer.toString(number2) + " =");
				   System.out.println(answer);
			}
		});
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 21));
		textArea.setForeground(Color.RED);
		textArea.setBackground(Color.GREEN);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(105)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnEnter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Start, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_1, Alignment.LEADING)
						.addComponent(textArea, Alignment.LEADING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEnter)
					.addGap(8)
					.addComponent(Start)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
	}
}
