/**
 * Test Driver Class
 * Test class is the driver class with main with ultimate goal to create an Exam with Selected Questions. Test class has 5 methods besides its main, Initiate, BuildMultiple, BuildShort, BuildExam, and Randomization. In main, it Calls the Initiate method in driver class, which prints the intro and text, creates many instance variables and asks user to input question pool file name to get all questions into allQuestion array, if short, calls the BuildShort method in Driver Class within Initiate method to create the Short Question, if multiple, calls the BuildMultiple method in Driver Class within Initiate method to create the Multiple Question, then asks how many questions, minimum chapter, and maximum chapter, calls the Randomization method in Driver Class within Initiate method to get eligible questions, selecting a given number of questions randomly and arranging them randomly, then after Randomization, it creates Exam object using selected Questions in parameters, calls BuildExam method in driver class within Initiate method to write the Exam's Questions in String in output file to Exam.txt and Exam's Answers in String in output file to Key.txt. Also, adds input boundaries with error responses and exceptions and resets if errors are found.
 * @authors Charles Thao and Alex Eastman
 * @emails charles.thao@my.uwrf.edu and alex.eastman@my.uwrf.edu
 * @date December 4, 2016
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Initiate();
		
	}
	
	// ---METHOD 1 Initiate---

	public static void Initiate() throws FileNotFoundException
	{
// ---INSTANCIATE VARIABLES START---
		
		String QuestionPool;
		int NumofSelectedQuestions;
		int MinChapter;
		int MaxChapter;
		Question [] AllQuestions;
		Question [] SelectedQuestions;
		Scanner Reader1 = new Scanner(System.in);
		Scanner Reader2;
		Scanner Passer;
		boolean readFile = false;
		
			// ---INSTANCIATE VARIABLES END---
		
// ---INTRODUCTION START---
		
		System.out.println("Welcome to Examinator 2016 Created by Charles Thao and Alex Eastman\n");
		System.out.print("Please enter the name of the question pool file: ");

			// ---INTRODUCTION END---
		
// ---GET QUESTIONPOOL START---
		
		do
		{
			QuestionPool = Reader1.nextLine();
			if(QuestionPool.length() < 4)
			{
				System.out.print("\n***Pool file loading error!***\nPlease check the question-pool file and re-enter the file name: ");
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
							System.out.print("\n***Pool file loading error!***\nPlease check the question-pool file and re-enter the file name: ");
							readFile = false;
						}
					}
					catch(Exception e)
					{
						System.out.print("\n***Pool file loading error!***\nPlease check the question-pool file and re-enter the file name: ");
						readFile = false;
					}
					if(readFile)
						System.out.println("\nChecking file: correct!\n");
				}
				else
					System.out.print("\n***Pool file loading error!***\nPlease check the question-pool file and re-enter the file name: ");
			}
		} while(!readFile);
		
		Reader2 = new Scanner(new FileReader(QuestionPool));
		Passer = new Scanner(new FileReader(QuestionPool));		
		Reader2.useDelimiter("@|\n");
		Passer.useDelimiter("@|\n");
		
			// ---GET QUESTIONPOOL END---
		
// ---GET ALL QUESTIONS FROM FILE START---
		
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
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!");
							else if(e.getMessage().equals("Error2"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!");
							else if(e.getMessage().equals("Error3"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices Out of Bounds!");
							else if(e.getMessage().equals("Error4"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not a char!");
							else if(e.getMessage().equals("Error5"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not from a to z!");
							else if(e.getMessage().equals("Error6"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices and its Actual Number Choices do not Match!");
							else if(e.getMessage().equals("Error7"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not found in the list of Choices!");
							Passer.nextLine();
							readFile = false;
						}
						catch(ArrayIndexOutOfBoundsException e)
						{
							System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices and its Actual Number Choices do not Match!");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!");
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
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!");
							else if(e.getMessage().equals("Error2"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!");
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
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!");
							else if(e.getMessage().equals("Error2"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!");
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
						System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Question Type!");
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
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!");
							else if(e.getMessage().equals("Error2"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!");
							else if(e.getMessage().equals("Error3"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices Out of Bounds!");
							else if(e.getMessage().equals("Error4"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not a char!");
							else if(e.getMessage().equals("Error5"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not from a to z!");
							else if(e.getMessage().equals("Error6"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices and its Actual Number Choices do not Match!");
							else if(e.getMessage().equals("Error7"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Correct Choice is not found in the list of Choices!");
							Passer.nextLine();
							readFile = false;
						}
						catch(ArrayIndexOutOfBoundsException e)
						{
							System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Number of Choices and its Actual Number Choices do not Match!");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!");
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
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!");
							else if(e.getMessage().equals("Error2"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!");
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
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Point Value!");
							else if(e.getMessage().equals("Error2"))
								System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Chapter Number!");
							Passer.nextLine();
							readFile = false;
						}
						catch(Exception e)
						{
							System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Input Mismatch!");
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
						System.out.println("Error at Line " + (i + 1) + "!\n" + Reader2.nextLine() + "\nProblem: Invalid Question Type!");
						Passer.nextLine();
					}
				}
			}
			else
				break;
		}
		
			// ---GET ALL QUESTIONS FROM FILE END---
		
// ---GET SELECTED QUESTIONS AND BUILD EXAM START---
		
		do
		{	
			try
			{
				int TotalPoints = 0;
				System.out.println("How many questions should the exam have?");
				NumofSelectedQuestions = Reader1.nextInt();
				if(NumofSelectedQuestions > AllQuestions.length || NumofSelectedQuestions <= 0)
					throw new FileNotFoundException("Error1");
				
				System.out.println("What is the minimum chapter to cover in the exam?");
				MinChapter = Reader1.nextInt();
				if(MinChapter <= 0)
					throw new FileNotFoundException("Error2");
				
				System.out.println("What is the maximum chapter to cover in the exam?");
				MaxChapter = Reader1.nextInt();
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
					
				System.out.println("Generated exam: selected " + SelectedQuestions.length + " questions with total points " + TotalPoints);
				
				Exam Test = new Exam(SelectedQuestions);
				
				BuildExam(Test);
				
				readFile = true;
			}
			catch (FileNotFoundException e)
			{
				if(e.getMessage().equals("Error1"))
					System.out.println("Sorry, you selected invalid number of questions.\nPlease re-enter filter!");
				else if(e.getMessage().equals("Error2"))
					System.out.println("Sorry, minimum chapter cannot by 0 or below.\nPlease re-enter filter!");
				else if(e.getMessage().equals("Error3"))
					System.out.println("Sorry, maximum chapter cannot by 0 or below.\nPlease re-enter filter!");
				else if(e.getMessage().equals("Error4"))
					System.out.println("Sorry, the maximum chapter cannot be smaller than the minimum chapter.\nPlease re-enter filter!");
				else if(e.getMessage().equals("Error5"))
					System.out.println("Sorry, there aren't enough questions from those chapters.\nPlease re-enter filter!");
				readFile = false;
			}
			catch (Exception e)
			{
				Reader1.next();
				System.out.println("Sorry, you entered invalid input. Integers please!\nPlease re-enter filter!");
				readFile = false;
			}
		}
		while (!readFile);

		Reader1.close();
		Reader2.close();
		
			// ---GET SELECTED QUESTIONS AND BUILD EXAM END---
	}
	
	// ---METHOD 2 BuildMultiple---
	
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
	
	// ---METHOD 3 BuildShort---
	
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
	
	// ---METHOD 4 BuildExam---
	
	public static void BuildExam(Exam Test) throws FileNotFoundException
	{
		PrintWriter ExamFile = new PrintWriter("Exam.txt");
		PrintWriter KeyFile = new PrintWriter("Key.txt");
		
		ExamFile.print(Test.getExam());
		KeyFile.print(Test.getKey());
		
		ExamFile.close();
		KeyFile.close();
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
	
}
