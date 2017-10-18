/**
 * Multiple Subclass
 * Multiple class is a subclass of Question class, inheriting its PointValue, ChapterNum, and QuestionText. Multiple also has a CorrectChoice along with its Array of Choices. Multiple subclass has 3 methods, one alternate constructor and 2 getters. The alternate constructor constructs the Multiple obtaining all of its given parameters. getQuestion constructs and returns the whole Question in String, formated in style of QuestionText and PointValue, overriding Question class's getQuestion. getAnswer constructs and returns the Answer of the Question, which is just solely the CorrectChoice, overriding Question class getAnswer.
 * @authors Charles Thao and Alex Eastman
 * @emails charles.thao@my.uwrf.edu and alex.eastman@my.uwrf.edu
 * @date December 4, 2016
 */

public class Multiple extends Question {
	
	private String CorrectChoice;
	private String [] Choices;
	
	public Multiple(int PointValue, int ChapterNum, String QuestionText, String CorrectChoice, String [] Choices)
	{
		super(PointValue, ChapterNum, QuestionText);
		this.CorrectChoice = CorrectChoice;
		this.Choices = new String [Choices.length];
		for(int i = 0; i < Choices.length; i++)
			this.Choices[i] = Choices[i];
	}
	
	public String getQuestion()
	{
		String message = "(" + super.getPointValue() + " points) " + super.getQuestionText() + "\n";
		for(int i = 0; i < Choices.length; i++)
			message += ((char)(i + 97)) + ". " + Choices[i] + "\n";
		message += "________";
		return message;
	}
	
	public String getAnswer()
	{
		return "The correct answer is: " + CorrectChoice;
	}
	
}
