/**
 * Question Superclass
 * Question class is the superclass of subclasses Multiple, Short, and Long since they are Questions inheriting PointValue, ChapterNum, and QuestionText. What differs from each Question type are its Answers. Question superclass has 6 methods, one alternate constructor, and 5 getters. The constructor constructs the generic Question given its PointValue, ChapterNum, and QuestionText in parameters. getPointValue returns its PointValue, getChapterNum returns its ChapterNum, and getQuestionText returns its QuestionText. getQuestion is a method being overridden by Short, Long, and Multiple, and so it getAnswer. Question should not be instantiated since it is generic and there are types of Questions.
 * @authors Charles Thao and Alex Eastman
 * @emails charles.thao@my.uwrf.edu and alex.eastman@my.uwrf.edu
 * @date December 4, 2016
 */

public class Question {

	private int PointValue;
	private int ChapterNum;
	private String QuestionText;
	
	public Question(int PointValue, int ChapterNum, String QuestionText)
	{
		this.PointValue = PointValue;
		this.ChapterNum = ChapterNum;
		this.QuestionText = QuestionText;
	}
	
	public int getPointValue()
	{
		return PointValue;
	}
	
	public int getChapterNum()
	{
		return ChapterNum;
	}
	
	public String getQuestionText()
	{
		return QuestionText;
	}
	
	public String getQuestion()
	{
		return "Error!";
	}
	
	public String getAnswer()
	{
		return "Error!";
	}
	
}
