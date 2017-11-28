package edu.uwrf.segroup.model;


/**
 * An extension of ChessPiece
 * @author matta
 *
 */
public class Rook extends ChessPiece {

	public Rook(Side setTeam, String imagePath) {
		super(setTeam, imagePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveRules(Square origin, Square[][] chessboard, int random) {

		if(origin.getFlag() == true) {
			
			for(int row = 0; row < Settings.NUM_ROWS; row++){
				
				for(int col = 0; col <Settings.NUM_COLS; col++) {
					// Check which Square was clicked and set it's flag to true
					if(chessboard[row][col].getFlag() == true && chessboard[row][col] != origin) {
						
						if (random == 0) {
							
							if(team == Side.BLACK) {
								
								// Moving up or down
								if(chessboard[row][col].getColID() == origin.getColID()) {
									// Moving up
									if (row > origin.getRowID()) {
										for(int i = origin.getRowID() + 1; i < row; i++) {
											if(chessboard[i][col].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
										
									}
									// Moving down
									if(row < origin.getRowID()) {
										for(int i = origin.getRowID() - 1; i > row; i--) {
											if(chessboard[i][col].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
										
									}
								
								}
								
								// Moving side to side
								else if(chessboard[row][col].getRowID() == origin.getRowID()) {
									// Moving Left
									if (col < origin.getColID()) {
										for (int i = origin.getColID() - 1; i > col; i--) {
											if(chessboard[row][i].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Moving Right
									if (col > origin.getColID()) {
										for(int i = origin.getColID() + 1; i < col; i++) {
											if(chessboard[row][i].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
							}
							else if(team == Side.WHITE) {
								// Moving up or down
								if(chessboard[row][col].getColID() == origin.getColID()) {
									// Moving up
									if (row > origin.getRowID()) {
										for(int i = origin.getRowID() + 1; i < row; i++) {
											if(chessboard[i][col].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Moving down
									if(row < origin.getRowID()) {
										for(int i = origin.getRowID() - 1; i > row; i--) {
											if(chessboard[i][col].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
								// Moving side to side
								else if(chessboard[row][col].getRowID() == origin.getRowID()) {
									// Moving Left
									if (col < origin.getColID()) {
										for (int i = origin.getColID() - 1; i > col; i--) {
											if(chessboard[row][i].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Moving Right
									if (col > origin.getColID()) {
										for(int i = origin.getColID() + 1; i < col; i++) {
											if(chessboard[row][i].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
							}
						}
						else if (random == 1) {
							
							if(team == Side.BLACK) {
								
								// Moving up or down
								if(chessboard[row][col].getColID() == origin.getColID()) {
									// Moving up
									if (row > origin.getRowID()) {
										for(int i = origin.getRowID() + 1; i < row; i++) {
											if(chessboard[i][col].getOccupier() != null) ; 
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Moving down
									if(row < origin.getRowID()) {
										for(int i = origin.getRowID() - 1; i > row; i--) {
											if(chessboard[i][col].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
								// Moving side to side
								else if(chessboard[row][col].getRowID() == origin.getRowID()) {
									// Moving Left
									if (col < origin.getColID()) {
										for (int i = origin.getColID() - 1; i > col; i--) {
											if(chessboard[row][i].getOccupier() != null) ; 
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Moving Right
									if (col > origin.getColID()) {
										for(int i = origin.getColID() + 1; i < col; i++) {
											if(chessboard[row][i].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
							}
							else if(team == Side.WHITE) {
								// Moving up or down
								if(chessboard[row][col].getColID() == origin.getColID()) {
									// Moving up
									if (row > origin.getRowID()) {
										for(int i = origin.getRowID() + 1; i < row; i++) {
											if(chessboard[i][col].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Moving down
									if(row < origin.getRowID()) {
										for(int i = origin.getRowID() - 1; i > row; i--) {
											if(chessboard[i][col].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
								}
								// Moving side to side
								else if(chessboard[row][col].getRowID() == origin.getRowID()) {
									// Moving Left
									if (col < origin.getColID()) {
										for (int i = origin.getColID() - 1; i > col; i--) {
											if(chessboard[row][i].getOccupier() != null) ;
												//return;
										}
										chessboard[row][col].setOccupier(origin.getOccupier());
										origin.vacate();
									}
									// Moving Right
									if (col > origin.getColID()) {
										for(int i = origin.getColID() + 1; i < col; i++) {
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
				}
				System.out.println("It Works!!");
				break;
			}
		}
		
	}

}
