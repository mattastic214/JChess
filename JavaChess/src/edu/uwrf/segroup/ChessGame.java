package edu.uwrf.segroup;

import javax.swing.*;

public class ChessGame {
	
	private static final int CHESSPIECESIZE = 76;
	private static final int CHESSPIECEHALFSIZE = CHESSPIECESIZE / 2;
	
	private ChessBoard ChessBoard;
	private ChessPiece [] WhiteChessPieces;
	private ChessPiece [] WhiteExtraChessPieces;
	private ChessPiece [] BlackChessPieces;
	private ChessPiece [] BlackExtraChessPieces;
	private Player Player1;
	private Player Player2;
	private JPanel ChessGameContainer;
	
	public ChessGame()
	{
		ChessBoard = new ChessBoard();
		WhiteChessPieces = new ChessPiece[16];
		WhiteExtraChessPieces = new ChessPiece[32];
		BlackChessPieces = new ChessPiece[16];
		BlackExtraChessPieces = new ChessPiece[32];
		Player1 = new Player();
		Player2 = new Player();
		ChessGameContainer = new JPanel(null);
		
		for(int i = 0; i < WhiteChessPieces.length; i++)
		{
			if(i >= 0 && i <= 7)
			{
				WhiteChessPieces[i] = new Pawn();
				if(i == 0)
				{
					WhiteChessPieces[i].getContainer().setSize(CHESSPIECESIZE, CHESSPIECESIZE);
					WhiteChessPieces[i].getContainer().setLocation((65 - CHESSPIECEHALFSIZE), (572 - CHESSPIECEHALFSIZE));
					ChessGameContainer.add(WhiteChessPieces[i].getContainer());
				}
			}
			else if(i == 8 || i == 9)
			{
				WhiteChessPieces[i] = new Rook();
			}
			else if(i == 10 || i == 11)
			{
				WhiteChessPieces[i] = new Knight();
			}
			else if(i == 12 || i == 13)
			{
				WhiteChessPieces[i] = new Bishop();
			}
			else if(i == 14)
			{
				WhiteChessPieces[i] = new Queen();
			}
			else
			{
				WhiteChessPieces[i] = new King();
			}
		}
		
		for(int i = 0; i < WhiteExtraChessPieces.length; i++)
		{
			if(i >= 0 && i <= 7)
				WhiteExtraChessPieces[i] = new Rook();
			if(i >= 8 && i <= 15)
				WhiteExtraChessPieces[i] = new Knight();
			if(i >= 16 && i <= 23)
				WhiteExtraChessPieces[i] = new Bishop();
			if(i >= 24 && i <= 31)
				WhiteExtraChessPieces[i] = new Queen();
		}
		
		for(int i = 0; i < BlackChessPieces.length; i++)
		{
			if(i >= 0 && i <= 7)
				BlackChessPieces[i] = new Pawn();
			else if(i == 8 || i == 9)
				BlackChessPieces[i] = new Rook();
			else if(i == 10 || i == 11)
				BlackChessPieces[i] = new Knight();
			else if(i == 12 || i == 13)
				WhiteChessPieces[i] = new Bishop();
			else if(i == 14)
				BlackChessPieces[i] = new Queen();
			else
				BlackChessPieces[i] = new King();
		}
		
		for(int i = 0; i < BlackExtraChessPieces.length; i++)
		{
			if(i >= 0 && i <= 7)
				BlackExtraChessPieces[i] = new Rook();
			if(i >= 8 && i <= 15)
				BlackExtraChessPieces[i] = new Knight();
			if(i >= 16 && i <= 23)
				BlackExtraChessPieces[i] = new Bishop();
			if(i >= 24 && i <= 31)
				BlackExtraChessPieces[i] = new Queen();
		}
		
		ChessBoard.getContainer().setSize(720, 720);
		ChessBoard.getContainer().setLocation(0, 0);
		ChessGameContainer.add(ChessBoard.getContainer());
		
	}
	
	public JPanel getChessGameContainer()
	{
		return ChessGameContainer;
	}

}
