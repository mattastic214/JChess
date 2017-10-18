/**
 * Long Subclass
 * Long class is a subclass of Question class, inheriting its PointValue, ChapterNum, and QuestionText. Long also has a String Answer, which is different than Short and Multiple. Long subclass has 3 methods, one alternate constructor and 2 getters. The alternate constructor constructs the Long getting all of its parameters into the variables. getQuestion which constructs and returns the whole Question in String, formated in style of QuestionText and PointValue, overriding Question class's getQuestion. getAnswer constructs and returns the Answer of the Question, which is the String Answer formatted to look pretty, overriding Question class's getAnswer.
 * @authors Charles Thao and Alex Eastman
 * @emails charles.thao@my.uwrf.edu and alex.eastman@my.uwrf.edu
 * @date December 4, 2016
 */

public class Long extends Question {
	
	private String Answer;
	
	public Long(int PointValue, int ChapterNum, String QuestionText, String Answer)
	{
		super(PointValue, ChapterNum, QuestionText);
		this.Answer = Answer.substring(1);
	}
	
	public String getQuestion()
	{
		String message = "(" + super.getPointValue() + " points) " + super.getQuestionText() + "\n______________________________________________________________________________\n______________________________________________________________________________\n______________________________________________________________________________\n______________________________________________________________________________\n______________________________________________________________________________\n______________________________________________________________________________\n______________________________________________________________________________\n______________________________________________________________________________\n______________________________________________________________________________\n______________________________________________________________________________";
		return message;
	}
	
	public String getAnswer()
	{
		String message = "The correct answer is: ";
		String [] BreakAnswer = Answer.split("@");
		for(int i = 0; i < BreakAnswer.length; i++)
		{
			if(i == BreakAnswer.length - 1)
				message += BreakAnswer[i];
			else
				message += BreakAnswer[i] + "\n";
		}
		return message;
	}

}
