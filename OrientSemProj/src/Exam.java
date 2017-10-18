/**
 * Exam Class
 * Exam class has an Array of Questions, since an Exam has multiple Questions of different types, like Long, Short, and Multiple. Exam has 3 methods, 1 constructor and 2 getters. The alternate constructor creates the Exam with given values of a Selected List of Questions, constructed in Test driver class. getExam constructs the exam, calling all of its Question's getQuestion and returning it into one huge String for Exam.txt. getKey is also the same, except it calls all of its Question's getAnswer method and returns in one huge String for Key.txt.
 * @authors Charles Thao and Alex Eastman
 * @emails charles.thao@my.uwrf.edu and alex.eastman@my.uwrf.edu
 * @date December 4, 2016
 */

public class Exam {

	private Question [] Questions;
	
	public Exam(Question [] Questions)
	{
		this.Questions = new Question[Questions.length];
		for(int i = 0; i < Questions.length; i++)
		{
			this.Questions[i] = Questions[i];
		}
	}
	
	public String getExam()
	{
		String message = "";
		int i = 1;
		for(Question A : Questions)
		{
			message += i + ". " + A.getQuestion() + "\n";
			i++;
		}
		return message;
	}
	
	public String getKey()
	{
		String message = "";
		int i = 1;
		for(Question A : Questions)
		{
			message += i + ". " + A.getAnswer() + "\n";
			i++;
		}
		return message;
	}

}
