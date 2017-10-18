/**
 * GetQuestionPoolGUI Class
 * GetQuestionPoolGUI class is a JFrame that has JLabels for style, a JTextField that user can enter in question pool file name, a JButton that checks the file with event handler, and if errors throws out the error text in a JTextArea which users cannot edit. If the question pool file name is valid, the event handler creates a new BuildExamGUI class which is also a JFrame, creating its window and implementing QuestionPool String into BuildExamGUI parameters. Has a constructor that creates the window by instantiating variables, a main method which creates this object and runs the program, and Event handler class which is for JButton.
 * @authors Charles Thao and Alex Eastman
 * @emails charles.thao@my.uwrf.edu and alex.eastman@my.uwrf.edu
 * @date December 17, 2016
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class GetQuestionPoolGUI extends JFrame {

	private JLabel Intro, QuestionPoolText;
	private JTextField QuestionPoolTextTF;
	private JButton Check;
	private JTextArea TextArea;
	
	private String QuestionPool;
	private Scanner Reader2;
	private boolean readFile = false;
	
	public GetQuestionPoolGUI()
	{
		Intro = new JLabel("Welcome to Examinator 2016 Created by Charles Thao and Alex Eastman", SwingConstants.CENTER);
		QuestionPoolText = new JLabel("Please enter the name of the question pool file: ", SwingConstants.CENTER);
		QuestionPoolTextTF = new JTextField();
		Check = new JButton("Check");
		Check.addActionListener(new GetQuestionPool());
		TextArea = new JTextArea(5, 1);
		TextArea.setEditable(false);
		
		Intro.setLocation(0, 30);
		Intro.setSize(500,12);
		QuestionPoolText.setLocation(0, 60);
		QuestionPoolText.setSize(500, 12);
		QuestionPoolTextTF.setLocation(50, 90);
		QuestionPoolTextTF.setSize(400, 24);
		Check.setLocation(200, 120);
		Check.setSize(100, 24);
		TextArea.setLocation(50, 150);
		TextArea.setSize(400, 60);
		
		Container pane = getContentPane();
		pane.setLayout(null);
		
		pane.add(Intro);
		pane.add(QuestionPoolText);
		pane.add(QuestionPoolTextTF);
		pane.add(Check);
		pane.add(TextArea);
		
		this.setTitle("Get Question Pool!");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		QuestionPool = "";
	}
	
	public static void main(String[] args)
	{
		GetQuestionPoolGUI GetQuestionPool = new GetQuestionPoolGUI();
	}
	
	private class GetQuestionPool implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub
			
			QuestionPool = QuestionPoolTextTF.getText();
			if(QuestionPool.length() < 4)
			{
				TextArea.setText("\n***Pool file loading error!***\nPlease check the question-pool file and re-enter the file name: ");
			}
			else
			{
				if(QuestionPool.substring(QuestionPool.length() - 4).equals(".txt"))
				{
					try
					{
						String Checker;
						String [] Splitter;
						Reader2 = new Scanner(new FileReader(QuestionPool));
						Reader2.useDelimiter("@|\n");
						if(Reader2.hasNext("multiple") || Reader2.hasNext("short") || Reader2.hasNext("long"))
						{
							while(Reader2.hasNextLine())
							{
								Checker = Reader2.nextLine();
								Splitter = Checker.split("@");
								if(Splitter[0].equals("multiple"))
								{
									if(Splitter.length <= 7)
										throw new FileNotFoundException();
								}
								else if(Splitter.length <= 4)
									throw new FileNotFoundException();
							}
							readFile = true;
						}
						else
						{
							TextArea.setText("\n***Pool file loading error!***\nPlease check the question-pool file and re-enter the file name: ");
							readFile = false;
						}
						if(readFile)
						{
							TextArea.setText("\nChecking file: correct!\n");
							BuildExamGUI Test = new BuildExamGUI(QuestionPool);
						}
					}
					catch(Exception e)
					{
						TextArea.setText("\n***Pool file loading error!***\nPlease check the question-pool file and re-enter the file name: ");
						readFile = false;
					}
				}
				else
					TextArea.setText("\n***Pool file loading error!***\nPlease check the question-pool file and re-enter the file name: ");
			}
			
		}
		
	}
	
}
