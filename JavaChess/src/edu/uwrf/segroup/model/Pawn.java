package edu.uwrf.segroup.model;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

public class Pawn extends ChessPiece {

	public Pawn(Side setTeam, String imagePath) {
		super(setTeam, imagePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveRules(Square origin, Square[][] chessboard)
	{
		if(origin.getFlag() == true)
		{
			//System.out.println("asdf!");
			for(int row = 0; row < Settings.NUM_ROWS; row++)
			{
				for(int col = 0; col < Settings.NUM_COLS; col++)
				{
					//System.out.println("ghjk!");
					if(chessboard[row][col].getFlag() == true && chessboard[row][col] != origin)
					{
						// Pawn rules here!
<<<<<<< HEAD
						if(random == 0)
						{
							if(team == Side.BLACK)
							{
								if(origin.getRowID() == 6)
								{
									// Going up 1 Square
									if(chessboard[origin.getRowID() - 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Going up 2 squares
									else if(chessboard[origin.getRowID() - 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to left
									else if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to right
									else if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
								else
								{
									// Going up 1 square
									if(chessboard[origin.getRowID() - 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to left
									else if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to right
									else if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
							}
							else
							{
								if(origin.getRowID() == 1)
								{
									// Going up 1 square
									if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Going up 2 squares
									else if(chessboard[origin.getRowID() + 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to right
									else if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to left
									else if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
								else
								{
									// Going up 1 square
									if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to left
									else if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to right
									else if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
							}
						}
						else if(random == 1)
						{
							if(team == Side.BLACK)
							{
								if(origin.getRowID() == 1)
								{
									if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
								else
								{
									if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
							}
							else
							{
								if(origin.getRowID() == 6)
								{
									if(chessboard[origin.getRowID() - 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
								else
								{
									if(chessboard[origin.getRowID() - 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
							}
						}
						else
						{
							if(team == Side.BLACK)
							{
								if(origin.getRowID() == 6)
								{
									if(chessboard[origin.getRowID() - 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
								else
								{
									if(chessboard[origin.getRowID() - 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
									{
										chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
							}
							else
							{
								if(origin.getRowID() == 1)
								{
									if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
								else
								{
									if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									else if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
									{
										chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
							}
						}
						//chessboard[row][col].setFlag(false);
						//origin.setFlag(false);
						System.out.println("It Works!!");
=======
						
>>>>>>> 1bb52bba2801cfa6a3cf543b9f0fed6f547209c6
						break;
					}
				}
			}
		}
		
	}


}
