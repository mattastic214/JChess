package edu.uwrf.segroup.model;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

/**
 * The Pawn Piece which extends the ChessPiece object.
 * @author matta, charles
 *
 */
public class Pawn extends ChessPiece {

	/**
	 * The constructor of the Pawn class.
	 * @param setTeam
	 * 				Side Object to set Team of the Pawn.
	 * @param imagePath
	 * 				The image to display the Pawn
	 * @author matta, charles
	 */
	public Pawn(Side setTeam, String imagePath) {
		super(setTeam, imagePath);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The movesets of the Rook Piece
	 * @param origin
	 * 				The Square the ChessPiece is occupying.
	 * @param chessboard
	 * 				The chessboard itself containing all the squares, used to detect a 2nd active Square.
	 * @param random
	 * 				Determination of movesets based on the orientation of the board and players. Used specifically for Pawn.
	 * @author matta, charles
	 */
	@Override
	public void moveRules(Square origin, Square[][] chessboard, int random)
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
									if(chessboard[origin.getRowID() - 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to left
									if(origin.getColID() != 0 && origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to right
									if(origin.getColID() != 7 && origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
								}
								else
								{
									// Going up 1 square
									if(origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID()].getOccupier() == null)
										{
											chessboard[origin.getRowID() - 1][origin.getColID()].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to left
									if(origin.getColID() != 0 && origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to right
									if(origin.getColID() != 7 && origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
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
									if(chessboard[origin.getRowID() + 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to right
									if(origin.getColID() != 7 && origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to left
									if(origin.getColID() != 0 && origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
								}
								else
								{
									// Going up 1 square
									if(origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
										{
											chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to left
									if(origin.getColID() != 0 && origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to right
									if(origin.getColID() != 7 && origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
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
									// Going up 1 square
									if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Going up 2 squares
									if(chessboard[origin.getRowID() + 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Eating to left
									if(origin.getColID() != 0)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to right
									if(origin.getColID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
								}
								else
								{
									// Going up 1 square
									if(origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
										{
											chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to left
									if(origin.getColID() != 0 && origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to right
									if(origin.getColID() != 7 && origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
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
									if(chessboard[origin.getRowID() - 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									if(origin.getColID() != 7)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									if(origin.getColID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
								}
								else
								{
									if(origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID()].getOccupier() == null)
										{
											chessboard[origin.getRowID() - 1][origin.getColID()].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									if(origin.getColID() != 0 && origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									if(origin.getColID() != 7 && origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
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
									if(chessboard[origin.getRowID() - 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() - 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									if(origin.getColID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									if(origin.getColID() != 7)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
								}
								else
								{
									// Going up 1 square
									if(origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID()].getOccupier() == null)
										{
											chessboard[origin.getRowID() - 1][origin.getColID()].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to left
									if(origin.getColID() != 0 && origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() - 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to right
									if(origin.getColID() != 7 && origin.getRowID() != 0)
									{
										if(chessboard[origin.getRowID() - 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() - 1][origin.getColID() + 1].getOccupier().getTeam() == Side.WHITE)
										{
											chessboard[origin.getRowID() - 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
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
									if(chessboard[origin.getRowID() + 2][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 2][origin.getColID()].getOccupier() == null)
									{
										chessboard[origin.getRowID() + 2][origin.getColID()].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									if(origin.getColID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									if(origin.getColID() != 0)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
								}
								else
								{
									// Going up 1 square
									if(origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID()].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID()].getOccupier() == null)
										{
											chessboard[origin.getRowID() + 1][origin.getColID()].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to left
									if(origin.getColID() != 0 && origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() - 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() - 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() - 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
									// Eating to right
									if(origin.getColID() != 7 && origin.getRowID() != 7)
									{
										if(chessboard[origin.getRowID() + 1][origin.getColID() + 1].getFlag() == true && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier() != null && chessboard[origin.getRowID() + 1][origin.getColID() + 1].getOccupier().getTeam() == Side.BLACK)
										{
											chessboard[origin.getRowID() + 1][origin.getColID() + 1].setOccupier(origin.getOccupier());
											origin.vacate();
										}
									}
								}
							}
						}
						//chessboard[row][col].setFlag(false);
						//origin.setFlag(false);
						System.out.println("It Works!!");
						break;
					}
				}
			}
		}
	}


}
