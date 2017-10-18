/**
 * Short Subclass
 * Short class is a subclass of Question class, inheriting its PointValue, ChapterNum, and QuestionText. Short also has an Array of Answers. Short subclass has 3 methods, one alternate constructor and 2 getters. The Alternate constructor constructs the Short with all given parameters. getQuestion constructs and returns the whole Question in String, formated in style of QuestionText and PointValue, overriding Question class's getQuestion. getAnswer constructs and returns the Array of Answers of the Question into one String, overriding Question class's getAnswer.
 * @author Charles Thao and Alex Eastman
 * @email charles.thao@my.uwrf.edu and alex.eastman@my.uwrf.edu
 * @date December 4, 2016
 */

public class Short extends Question {

	private String [] Answer;
	
	public Short(int PointValue, int ChapterNum, String QuestionText, String [] Answer)
	{
		super(PointValue, ChapterNum, QuestionText);
		this.Answer = new String[Answer.length];
		for(int i = 0; i < Answer.length; i++)
			this.Answer[i] = Answer[i];
	}
	
	public String getQuestion()
	{
		String message = "(" + super.getPointValue() + " points) " + super.getQuestionText() + "\n_____________________________________________________________________________";
		return message;
	}
	
	public String getAnswer()
	{
		String message = "The correct answer is: ";
		for(int i = 0; i < Answer.length; i++)
		{
			message += Answer[i];
			if(i != (Answer.length - 1))
				message += ", or ";
		}
		return message;
	}
	
}
