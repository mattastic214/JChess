package edu.uwrf.segroup.model;


/**
 * The Rook Piece which extends the ChessPiece object.
 * @author matta
 *
 */
public class Rook extends ChessPiece {

	/**
	 * The constructor of the Rook class.
	 * @param setTeam
	 * 				Side Object to set Team of the Rook.
	 * @param imagePath
	 * 				The image to display the Rook
	 * @author matta, charles
	 */
	public Rook(Side setTeam, String imagePath) {
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
		/*
		if(origin.getFlag() == true)
		{
			for(int row = 0; row < Settings.NUM_ROWS; row++)
			{
				for(int col = 0; col <Settings.NUM_COLS; col++)
				{
					// Check which Square was clicked and set it's flag to true
					if(chessboard[row][col].getFlag() == true && chessboard[row][col] != origin)
					{
						// Rook rules here!
						if(team == Side.BLACK)
						{
							// Moving up or down
							if(chessboard[row][col].getColID() == origin.getColID())
							{
								// Moving up
								if (row > origin.getRowID())
								{
									for(int i = origin.getRowID() + 1; i < row; i++)
									{
										if(chessboard[i][col].getOccupier() != null) ;
											//return;
									}
									chessboard[row][col].setOccupier(origin.getOccupier());
									origin.vacate();
									
								}
								// Moving down
								if(row < origin.getRowID())
								{
									for(int i = origin.getRowID() - 1; i > row; i--)
									{
										if(chessboard[i][col].getOccupier() != null) ;
											//return;
									}
									chessboard[row][col].setOccupier(origin.getOccupier());
									origin.vacate();
									
								}
							
							}
							
							// Moving side to side
							else if(chessboard[row][col].getRowID() == origin.getRowID())
							{
								// Moving Left
								if (col < origin.getColID()) {
									for (int i = origin.getColID() - 1; i > col; i--)
									{
										if(chessboard[row][i].getOccupier() != null) ;
											//return;
									}
									chessboard[row][col].setOccupier(origin.getOccupier());
									origin.vacate();
								}
								// Moving Right
								if (col > origin.getColID()) {
									for(int i = origin.getColID() + 1; i < col; i++)
									{
										if(chessboard[row][i].getOccupier() != null) ;
											//return;
									}
									chessboard[row][col].setOccupier(origin.getOccupier());
									origin.vacate();
								}
							}
						}
						else if(team == Side.WHITE)
						{
							// Moving up or down
							if(chessboard[row][col].getColID() == origin.getColID())
							{
								// Moving up
								if (row > origin.getRowID()) {
									for(int i = origin.getRowID() + 1; i < row; i++)
									{
										if(chessboard[i][col].getOccupier() != null) ;
											//return;
									}
									chessboard[row][col].setOccupier(origin.getOccupier());
									origin.vacate();
								}
								// Moving down
								if(row < origin.getRowID()) {
									for(int i = origin.getRowID() - 1; i > row; i--)
									{
										if(chessboard[i][col].getOccupier() != null) ;
											//return;
									}
									chessboard[row][col].setOccupier(origin.getOccupier());
									origin.vacate();
								}
							}
							// Moving side to side
							else if(chessboard[row][col].getRowID() == origin.getRowID())
							{
								// Moving Left
								if (col < origin.getColID())
								{
									for (int i = origin.getColID() - 1; i > col; i--)
									{
										if(chessboard[row][i].getOccupier() != null) ;
											//return;
									}
									chessboard[row][col].setOccupier(origin.getOccupier());
									origin.vacate();
								}
								// Moving Right
								if (col > origin.getColID())
								{
									for(int i = origin.getColID() + 1; i < col; i++)
									{
										if(chessboard[row][i].getOccupier() != null) ;
											//return;
									}
									chessboard[row][col].setOccupier(origin.getOccupier());
									origin.vacate();
								}
							}
						}
					}
				}
				System.out.println("It Works!!");
				break;
			}
		}
		*/
	}

}
