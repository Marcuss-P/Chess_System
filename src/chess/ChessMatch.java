package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;	
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	//retornar uma matriz de pe�as de xadrez
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				//utilizando o downcasting
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		//retorna matriz de pe�as da ChessMatch
		return mat;
	}

	private void placeNewPiece(char clomun, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(clomun, row). toPosition());
		
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.BLACK));
	}
	
}
