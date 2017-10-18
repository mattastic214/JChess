package edu.uwrf.segroup;

public class Player {

	private String PlayerName;
	private int PlayerNumber;
	
	public Player()
	{
		PlayerName = "";
		PlayerNumber = 0;
	}
	
	public Player(String Name, int Num)
	{
		PlayerName = Name;
		PlayerNumber = Num;
	}
	
	public String getPlayerName()
	{
		return PlayerName;
	}
	
	public int getPlayerNumber()
	{
		return PlayerNumber;
	}
	
	public void setPlayerName(String Name)
	{
		PlayerName = Name;
	}
	
	public void setPlayerNumber(int Num)
	{
		PlayerNumber = Num;
	}
	
}
