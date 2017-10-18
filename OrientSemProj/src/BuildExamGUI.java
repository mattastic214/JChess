/**
 * BuildExamGUI Class
 * BuildExamGUI class is a JFrame that has JLabels for style, JTextFields that user can enter in NumofSelectedQuestions, MinChapter and MaxChapter, separate JButtons that checks the validity of NumofSelectedQuestions, MinChapter and MaxChapter, also additional JButtons that switches between created Exam and Key in the JScrollPane which both buttons are hidden first, and JTextAreas that are for JScrollPanes, one for throwing out errors when Processing questionpool file, one for Console which is for Exam and throwing out errors from the 3 questions, and one for Key which has the Exam's Key written, which is hidden first, and JScrollPanes, 3 of them, for the same purposes of JTextAreas in addition to scrolling vertically and horizontally. The JButtons for Check Key and Check Exam are on top of one another and act as switches that enables visibility of Console and HiddenKey, having the buttons switching visibility of itself having one being shown at a time. None of the JTextArea are editable. The enabling and disabling guides the user to input correct values, and if all are correct, disables all three JTextFields. If there are errors, it prints in Console TextArea and enables the first question JTextField and disables others, starting over and following closely to our implementation in Text UI. BuildExamGUI contains most of the coding from our Text UI, in Test class, containing all of previous methods except BuildExam because we are writing in the JTextArea and the breaking of Initiate method into smaller methods.
 * @authors Charles Thao and Alex Eastman
 * @emails charles.thao@my.uwrf.edu and alex.eastman@my.uwrf.edu
 * @date December 17, 2016
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class BuildExamGUI extends JFrame {

	private JLabel Processing, SelectedQuestionsText, MinChapterText, MaxChapterText;
	private JTextField SelectedQuestionsTextTF, MinChapterTextTF, MaxChapterTextTF;
	private JButton CheckSelectedQuestions, CheckMinChapter, CheckLastandSubmitAll, CheckKey, CheckExam;
	private JTextArea TextAreaErrors, TextAreaConsole, TextHiddenKey;
	private JScrollPane ErrorsSP, ConsoleSP, HiddenKeySP;
	
	private int NumofSelectedQuestions;
	private int MinChapter;
	private int MaxChapter;
	private Question [] AllQuestions;
	private Question [] SelectedQuestions;
	private Scanner Reader2;
	private Scanner Passer;
	private boolean readFile = false;
	
	public BuildExamGUI(String QuestionPool) throws FileNotFoundException
	{
		Processing = new JLabel("Processing...", SwingConstants.LEFT);
		SelectedQuestionsText = new JLabel("How many questions should the exam have?", SwingConstants.LEFT);
		SelectedQuestionsTextTF = new JTextField();
		MinChapterText = new JLabel("What is the minimum chapter to cover in the exam?", SwingConstants.LEFT);
		MinChapterTextTF = new JTextField();
		MaxChapterText = new JLabel("What is the maximum chapter to cover in the exam?", SwingConstants.LEFT);
		MaxChapterTextTF = new JTextField();
		CheckSelectedQuestions = new JButton("Check");
		CheckSelectedQuestions.addActionListener(new CheckSelectedQuestions());
		CheckMinChapter = new JButton("Check");
		CheckMinChapter.addActionListener(new CheckMinChapter());
		CheckLastandSubmitAll = new JButton("Check and Submit");
		CheckLastandSubmitAll.addActionListener(new CheckLastandSubmitAll());
		CheckKey = new JButton("Check Key");
		CheckKey.addActionListener(new CheckKey());
		CheckExam = new JButton("Check Exam");
		CheckExam.addActionListener(new CheckExam());
		TextAreaErrors = new JTextArea();
		TextAreaErrors.setEditable(false);
		TextAreaConsole = new JTextArea();
		TextAreaConsole.setEditable(false);
		TextHiddenKey = new JTextArea();
		TextHiddenKey.setEditable(false);
		ErrorsSP = new JScrollPane(TextAreaErrors, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		ConsoleSP = new JScrollPane(TextAreaConsole, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		HiddenKeySP = new JScrollPane(TextHiddenKey, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		SelectedQuestionsTextTF.setEnabled(false);
		MinChapterTextTF.setEnabled(false);
		MaxChapterTextTF.setEnabled(false);
		CheckSelectedQuestions.setEnabled(false);
		CheckMinChapter.setEnabled(false);
		CheckLastandSubmitAll.setEnabled(false);
		CheckKey.setVisible(false);
		CheckExam.setVisible(false);
		HiddenKeySP.setVisible(false);
		
		Processing.setLocation(650, 30);
		Processing.setSize(500,12);
		SelectedQuestionsText.setLocation(50, 30);
		SelectedQuestionsText.setSize(400, 12);
		SelectedQuestionsTextTF.setLocation(450, 30);
		SelectedQuestionsTextTF.setSize(50, 24);
		MinChapterText.setLocation(50, 60);
		MinChapterText.setSize(500, 12);
		MinChapterTextTF.setLocation(450, 60);
		MinChapterTextTF.setSize(50, 24);
		MaxChapterText.setLocation(50, 90);
		MaxChapterText.setSize(500, 12);
		MaxChapterTextTF.setLocation(450, 90);
		MaxChapterTextTF.setSize(50, 24);
		CheckSelectedQuestions.setLocation(525, 30);
		CheckSelectedQuestions.setSize(100, 24);
		CheckMinChapter.setLocation(525, 60);
		CheckMinChapter.setSize(100, 24);
		CheckLastandSubmitAll.setLocation(50, 120);
		CheckLastandSubmitAll.setSize(200, 24);
		CheckKey.setLocation(50, 525);
		CheckKey.setSize(150, 24);
		CheckExam.setLocation(50, 525);
		CheckExam.setSize(150, 24);
		ErrorsSP.setLocation(650, 60);
		ErrorsSP.setSize(500, 500);
		ConsoleSP.setLocation(50, 150);
		ConsoleSP.setSize(575, 360);
		HiddenKeySP.setLocation(50, 150);
		HiddenKeySP.setSize(575, 360);
		
		Container pane = getContentPane();
		pane.setLayout(null);
		
		pane.add(Processing);
		pane.add(ErrorsSP);
		pane.add(SelectedQuestionsText);
		pane.add(SelectedQuestionsTextTF);
		pane.add(CheckSelectedQuestions);
		pane.add(MinChapterText);
		pane.add(MinChapterTextTF);
		pane.add(CheckMinChapter);
		pane.add(MaxChapterText);
		pane.add(MaxChapterTextTF);
		pane.add(CheckLastandSubmitAll);
		pane.add(CheckKey);
		pane.add(CheckExam);
		pane.add(ConsoleSP);
		pane.add(HiddenKeySP);
		
		this.setTitle("Build Exam!");
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		Reader2 = new Scanner(new FileReader(QuestionPool));
		Passer = new Scanner(new FileReader(QuestionPool));		
		Reader2.useDelimiter("@|\n");
		Passer.useDelimiter("@|\n");
		
		AllQuestions = new Question[1];
		
		for(int i = 0; i <= AllQuestions.length; i++)
		{
			if(Reader2.hasNext())
			{
				if(AllQuestions.length > i)
				{
					if(Reader2.hasNext("multiple"))
					{
						try
						{
							Passer.next();
							AllQuestions[i] = BuildMultiple(Passer);
							readFile = true;
						}
						catch(FileNotFoundException e)
						{
							if(e.getMessage().equals("Error1"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!\n");
							else if(e.getMessage().equals("Error2"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!\n");
							else if(e.getMessage().equals("Error3"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices Out of Bounds!\n");
							else if(e.getMessage().equals("Error4"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not a char!\n");
							else if(e.getMessage().equals("Error5"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not from a to z!\n");
							else if(e.getMessage().equals("Error6"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices and its Actual Number Choices do not Match!\n");
							else if(e.getMessage().equals("Error7"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not found in the list of Choices!\n");
							Passer.nextLine();
							readFile = false;
						}
						catch(ArrayIndexOutOfBoundsException e)
						{
							TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices and its Actual Number Choices do not Match!\n");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!\n");
							Passer.nextLine();
							readFile = false;
						}
						if(readFile)
						{
							Reader2.next();
							AllQuestions[i] = BuildMultiple(Reader2);
							Passer.nextLine();
							Reader2.nextLine();
						}
						else
							AllQuestions[i] = new Question(0, 0, "Error!");
					}
					else if (Reader2.hasNext("short"))
					{
						try
						{
							Passer.next();
							AllQuestions[i] = BuildShort(Passer);
							readFile = true;
						}
						catch(FileNotFoundException e)
						{
							if(e.getMessage().equals("Error1"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!\n");
							else if(e.getMessage().equals("Error2"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!\n");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!\n");
							Passer.nextLine();
							readFile = false;
						}
						if(readFile)
						{
							Reader2.next();
							AllQuestions[i] = BuildShort(Reader2);
							Passer.nextLine();
							Reader2.nextLine();
						}
						else
							AllQuestions[i] = new Question(0, 0, "Error!");
					}
					else if (Reader2.hasNext("long"))
					{
						try
						{
							Passer.next();
							AllQuestions[i] = new Long(Passer.nextInt(), Passer.nextInt(), Passer.next(), Passer.useDelimiter("\n").next());
							Passer.useDelimiter("@|\n");
							readFile = true;
							if(AllQuestions[i].getPointValue() <= 0)
								throw new FileNotFoundException("Error1");
							if(AllQuestions[i].getChapterNum() <= 0)
								throw new FileNotFoundException("Error2");
						}
						catch(FileNotFoundException e)
						{
							if(e.getMessage().equals("Error1"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!\n");
							else if(e.getMessage().equals("Error2"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!\n");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!\n");
							Passer.nextLine();
							readFile = false;
						}
						if(readFile)
						{
							Reader2.next();
							AllQuestions[i] = new Long(Reader2.nextInt(), Reader2.nextInt(), Reader2.next(), Reader2.useDelimiter("\n").next());
							Reader2.useDelimiter("@|\n");
							Passer.nextLine();
							Reader2.nextLine();
						}
						else
							AllQuestions[i] = new Question(0, 0, "Error!");
					}
					else
					{
						TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Question Type!\n");
						Passer.nextLine();
					}
				}
				else
				{
					AllQuestions = Arrays.copyOf(AllQuestions, AllQuestions.length + 1);
					if(Reader2.hasNext("multiple"))
					{
						try
						{
							Passer.next();
							AllQuestions[i] = BuildMultiple(Passer);
							readFile = true;
						}
						catch(FileNotFoundException e)
						{
							if(e.getMessage().equals("Error1"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!\n");
							else if(e.getMessage().equals("Error2"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!\n");
							else if(e.getMessage().equals("Error3"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices Out of Bounds!\n");
							else if(e.getMessage().equals("Error4"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not a char!\n");
							else if(e.getMessage().equals("Error5"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not from a to z!\n");
							else if(e.getMessage().equals("Error6"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices and its Actual Number Choices do not Match!\n");
							else if(e.getMessage().equals("Error7"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not found in the list of Choices!\n");
							Passer.nextLine();
							readFile = false;
						}
						catch(ArrayIndexOutOfBoundsException e)
						{
							TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices and its Actual Number Choices do not Match!\n");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!\n");
							Passer.nextLine();
							readFile = false;
						}
						if(readFile)
						{
							Reader2.next();
							AllQuestions[i] = BuildMultiple(Reader2);
							Passer.nextLine();
							Reader2.nextLine();
						}
						else
							AllQuestions[i] = new Question(0, 0, "Error!");
					}
					else if (Reader2.hasNext("short"))
					{
						try
						{
							Passer.next();
							AllQuestions[i] = BuildShort(Passer);
							readFile = true;
						}
						catch(FileNotFoundException e)
						{
							if(e.getMessage().equals("Error1"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!\n");
							else if(e.getMessage().equals("Error2"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!\n");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!\n");
							Passer.nextLine();
							readFile = false;
						}
						if(readFile)
						{
							Reader2.next();
							AllQuestions[i] = BuildShort(Reader2);
							Passer.nextLine();
							Reader2.nextLine();
						}
						else
							AllQuestions[i] = new Question(0, 0, "Error!");
					}
					else if (Reader2.hasNext("long"))
					{
						try
						{
							Passer.next();
							AllQuestions[i] = new Long(Passer.nextInt(), Passer.nextInt(), Passer.next(), Passer.useDelimiter("\n").next());
							Passer.useDelimiter("@|\n");
							readFile = true;
							if(AllQuestions[i].getPointValue() <= 0)
								throw new FileNotFoundException("Error1");
							if(AllQuestions[i].getChapterNum() <= 0)
								throw new FileNotFoundException("Error2");
						}
						catch(FileNotFoundException e)
						{
							if(e.getMessage().equals("Error1"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!\n");
							else if(e.getMessage().equals("Error2"))
								TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!\n");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!\n");
							Passer.nextLine();
							readFile = false;
						}
						if(readFile)
						{
							Reader2.next();
							AllQuestions[i] = new Long(Reader2.nextInt(), Reader2.nextInt(), Reader2.next(), Reader2.useDelimiter("\n").next());
							Reader2.useDelimiter("@|\n");
							Passer.nextLine();
							Reader2.nextLine();
						}
						else
							AllQuestions[i] = new Question(0, 0, "Error!");
					}
					else
					{
						TextAreaErrors.append("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Question Type!\n");
						Passer.nextLine();
					}
				}
			}
			else
				break;
		}

		Processing.setText("Processing... Complete!");
		SelectedQuestionsTextTF.setEnabled(true);
		CheckSelectedQuestions.setEnabled(true);
		
	}
	
	/*
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		BuildExamGUI Test = new BuildExamGUI("QuestionPool.txt");
		
	}
	*/
	
	public static Question BuildMultiple(Scanner Reader) throws FileNotFoundException
	{
		Question Question;
		String [] Choices;
		int PointValue;
		int ChapterNum;
		int NumofChoices;
		String QuestionText;
		String CorrectChoice;
		String LinesofChoices;
		int Counter = 97;
		
		PointValue = Reader.nextInt();
		if(PointValue <= 0)
			throw new FileNotFoundException("Error1");
		
		ChapterNum = Reader.nextInt();
		if(ChapterNum <= 0)
			throw new FileNotFoundException("Error2");
		
		QuestionText = Reader.next();
		
		NumofChoices = Reader.nextInt();
		if(NumofChoices < 2 || NumofChoices > 26)
			throw new FileNotFoundException("Error3");
		
		CorrectChoice = Reader.next();
		if(CorrectChoice.length() != 1)
			throw new FileNotFoundException("Error4");
		if((int)CorrectChoice.charAt(0) < 97 || (int)CorrectChoice.charAt(0) > 122)
			throw new FileNotFoundException("Error5");
		
		LinesofChoices = Reader.useDelimiter("\n").next();
		LinesofChoices = LinesofChoices.substring(1);
		Reader.useDelimiter("@|\n");
		
		Choices = LinesofChoices.split("@");
		if(Choices.length != NumofChoices)
			throw new FileNotFoundException("Error6");
		
		for(int i = 0; i < Choices.length; i++)
		{
			if(Counter == (int)CorrectChoice.charAt(0))
				break;
			else
				Counter++;
			if(i == (Choices.length - 1))
				throw new FileNotFoundException("Error7");
		}
		
		Question = new Multiple(PointValue, ChapterNum, QuestionText, CorrectChoice, Choices);
		
		return Question;
	}
	
	public static Question BuildShort(Scanner Reader) throws FileNotFoundException
	{
		Question Question;
		String [] Answers;
		int PointValue;
		int ChapterNum;
		String QuestionText;
		String LineofAnswers;
		
		PointValue = Reader.nextInt();
		if(PointValue <= 0)
			throw new FileNotFoundException("Error1");
		
		ChapterNum = Reader.nextInt();
		if(ChapterNum <= 0)
			throw new FileNotFoundException("Error2");
		
		QuestionText = Reader.next();
		
		LineofAnswers = Reader.useDelimiter("\n").next();
		LineofAnswers = LineofAnswers.substring(1);
		Reader.useDelimiter("@|\n");
		
		Answers = LineofAnswers.split("@");
		
		Question = new Short(PointValue, ChapterNum, QuestionText, Answers);
		
		return Question;
	}
	
	// ---METHOD 5 Randomization---
	
	public static void Randomization(Question [] SelQ, Question [] AllQ, int MinChapter, int MaxChapter) throws FileNotFoundException
	{
		List<Question> EligibleQuestions = new ArrayList<Question>();
		List<Question> SelectedEligibleQuestions = new ArrayList<Question>();
		List<Question> SSQ = new ArrayList<Question>();
		List<Question> SMQ = new ArrayList<Question>();
		List<Question> SLQ = new ArrayList<Question>();
		List<Question> FinalQuestions = new ArrayList<Question>();
		
		for(int i = 0; i < AllQ.length; i++)
			if(AllQ[i].getChapterNum() >= MinChapter && AllQ[i].getChapterNum() <= MaxChapter && !AllQ[i].getClass().getName().equals("Question"))
				EligibleQuestions.add(AllQ[i]);
		
		Collections.shuffle(EligibleQuestions);
		
		for(int i = 0; i < SelQ.length; i++)
			SelectedEligibleQuestions.add(EligibleQuestions.get(i));
		
		for(int i = 0; i < SelQ.length; i++)
		{
			if(SelectedEligibleQuestions.get(i).getClass().getName().equals("Multiple"))
				SMQ.add(SelectedEligibleQuestions.get(i));
			else if(SelectedEligibleQuestions.get(i).getClass().getName().equals("Short"))
				SSQ.add(SelectedEligibleQuestions.get(i));
			else
				SLQ.add(SelectedEligibleQuestions.get(i));
		}
		
		for(int i = 0; i < SMQ.size(); i++)
			FinalQuestions.add(SMQ.get(i));
		for(int i = 0; i < SSQ.size(); i++)
			FinalQuestions.add(SSQ.get(i));
		for(int i = 0; i < SLQ.size(); i++)
			FinalQuestions.add(SLQ.get(i));

		FinalQuestions.toArray(SelQ); //Pseudo Return :)
	}
	
	private class CheckSelectedQuestions implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub

			try
			{
				NumofSelectedQuestions = Integer.parseInt(SelectedQuestionsTextTF.getText());
				if(NumofSelectedQuestions > AllQuestions.length || NumofSelectedQuestions <= 0)
					throw new FileNotFoundException("Error1");
				
				SelectedQuestionsTextTF.setEnabled(false);
				MinChapterTextTF.setEnabled(true);
				//MaxChapterTextTF.setEnabled(false);
				CheckSelectedQuestions.setEnabled(false);
				CheckMinChapter.setEnabled(true);
				//CheckLastandSubmitAll.setEnabled(false);
			}
			catch (FileNotFoundException e)
			{
				if(e.getMessage().equals("Error1"))
					TextAreaConsole.append("Sorry, you selected invalid number of questions.\nPlease re-enter filter!\n");
			}
			catch (Exception e)
			{
				TextAreaConsole.append("Sorry, you entered invalid input. Integers please!\nPlease re-enter filter!\n");
			}
			
		}
		
	}
	
	private class CheckMinChapter implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub
			
			try
			{
				MinChapter = Integer.parseInt(MinChapterTextTF.getText());
				if(MinChapter <= 0)
					throw new FileNotFoundException("Error2");
				
				//SelectedQuestionsTextTF.setEnabled(false);
				MinChapterTextTF.setEnabled(false);
				MaxChapterTextTF.setEnabled(true);
				//CheckSelectedQuestions.setEnabled(false);
				CheckMinChapter.setEnabled(false);
				CheckLastandSubmitAll.setEnabled(true);
			}
			catch (FileNotFoundException e)
			{
				if(e.getMessage().equals("Error2"))
					TextAreaConsole.append("Sorry, minimum chapter cannot by 0 or below.\nPlease re-enter filter!\n");
			
				SelectedQuestionsTextTF.setEnabled(true);
				MinChapterTextTF.setEnabled(false);
				//MaxChapterTextTF.setEnabled(false);
				CheckSelectedQuestions.setEnabled(true);
				CheckMinChapter.setEnabled(false);
				//CheckLastandSubmitAll.setEnabled(false);
			}
			catch (Exception e)
			{
				TextAreaConsole.append("Sorry, you entered invalid input. Integers please!\nPlease re-enter filter!\n");
			
				SelectedQuestionsTextTF.setEnabled(true);
				MinChapterTextTF.setEnabled(false);
				//MaxChapterTextTF.setEnabled(false);
				CheckSelectedQuestions.setEnabled(true);
				CheckMinChapter.setEnabled(false);
				//CheckLastandSubmitAll.setEnabled(false);
			}
			
		}
		
	}
	
	private class CheckLastandSubmitAll implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub
			
			try
			{
				int TotalPoints = 0;
				MaxChapter = Integer.parseInt(MaxChapterTextTF.getText());
				if(MaxChapter <= 0)
					throw new FileNotFoundException("Error3");
				if(MinChapter > MaxChapter)
					throw new FileNotFoundException("Error4");
				
				int Counter = 0;
				
				for(int i = 0; i < AllQuestions.length; i++)
					if(AllQuestions[i].getChapterNum() >= MinChapter && AllQuestions[i].getChapterNum() <= MaxChapter && !AllQuestions[i].getClass().getName().equals("Question"))
						Counter++;
				
				if(NumofSelectedQuestions > Counter)
					throw new FileNotFoundException("Error5");
				
				SelectedQuestions = new Question[NumofSelectedQuestions];
				
				Randomization(SelectedQuestions, AllQuestions, MinChapter, MaxChapter);
				
				for(int i = 0; i < SelectedQuestions.length; i++)
					TotalPoints += SelectedQuestions[i].getPointValue();
									
				Exam Test = new Exam(SelectedQuestions);

				TextAreaConsole.setText("Generated exam: selected " + SelectedQuestions.length + " questions with total points " + TotalPoints + "\n\n" + Test.getExam());
				TextHiddenKey.setText("Here is the key of this exam\n\n" + Test.getKey());
				
				//SelectedQuestionsTextTF.setEnabled(false);
				//MinChapterTextTF.setEnabled(false);
				MaxChapterTextTF.setEnabled(false);
				//CheckSelectedQuestions.setEnabled(false);
				//CheckMinChapter.setEnabled(false);
				CheckLastandSubmitAll.setEnabled(false);
				
				CheckKey.setVisible(true);
			}
			catch (FileNotFoundException e)
			{
				if(e.getMessage().equals("Error3"))
					TextAreaConsole.append("Sorry, maximum chapter cannot by 0 or below.\nPlease re-enter filter!\n");
				else if(e.getMessage().equals("Error4"))
					TextAreaConsole.append("Sorry, the maximum chapter cannot be smaller than the minimum chapter.\nPlease re-enter filter!\n");
				else if(e.getMessage().equals("Error5"))
					TextAreaConsole.append("Sorry, there aren't enough questions from those chapters.\nPlease re-enter filter!\n");
			
				SelectedQuestionsTextTF.setEnabled(true);
				//MinChapterTextTF.setEnabled(false);
				MaxChapterTextTF.setEnabled(false);
				CheckSelectedQuestions.setEnabled(true);
				//CheckMinChapter.setEnabled(false);
				CheckLastandSubmitAll.setEnabled(false);
			}
			catch (Exception e)
			{
				TextAreaConsole.append("Sorry, you entered invalid input. Integers please!\nPlease re-enter filter!\n");
			
				SelectedQuestionsTextTF.setEnabled(true);
				//MinChapterTextTF.setEnabled(false);
				MaxChapterTextTF.setEnabled(false);
				CheckSelectedQuestions.setEnabled(true);
				//CheckMinChapter.setEnabled(false);
				CheckLastandSubmitAll.setEnabled(false);
			}
			
		}
		
	}
	
	private class CheckKey implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			CheckExam.setVisible(true);
			ConsoleSP.setVisible(false);
			HiddenKeySP.setVisible(true);
			CheckKey.setVisible(false);
		}
		
	}
	
	private class CheckExam implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			CheckExam.setVisible(false);
			ConsoleSP.setVisible(true);
			HiddenKeySP.setVisible(false);
			CheckKey.setVisible(true);
		}
		
	}

}
