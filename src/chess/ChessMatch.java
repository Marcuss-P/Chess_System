package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	// retornar uma matriz de peças de xadrez
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				// utilizando o downcasting
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		// retorna matriz de peças da ChessMatch
		return mat;
	}
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		//converter a posição de xadrez para uma posição de matriz normal
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	// sourcePosition é a posição de origem e a target é a posição de destino
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		//convertenda para posição da matriz
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		//downcasting para chesspiece, pois a peça capturada era do tipo piece
		return (ChessPiece)capturedPiece;
			
	}
	
	private Piece makeMove(Position source, Position target) {
		//removendo a possivel peça q esteja na posição de destino e por padrao sera a peça capturada
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		//se nao existir um peça nessa posição vai acontecer uma exceção
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
		
	}
	
	private void validateTargetPosition(Position source, Position target) {
		//se a peça de origem a posição de destino n for possivel, significa q nn posso mover para la
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}

	private void placeNewPiece(char clomun, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(clomun, row).toPosition());

	}

	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
	
	

}
