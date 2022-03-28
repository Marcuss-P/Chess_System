package chess;

import boardgame.Board;

public class ChessMatch {

	private Board board;	
	
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	//retornar uma matriz de peças de xadrez
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				//utilizando o downcasting
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		//retorna matriz de peças da ChessMatch
		return mat;
	}
	
}
