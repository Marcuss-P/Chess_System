package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}	
	
	//Esta aqui pois sera reaproveitada em todas a peças
	//protected pois sera acessada somente peloo mesmo pacote e pelas subclasses	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
//retorna se p for diferente de nulo E a cor da peça for diferente da cor da peça atual
		return p != null && p.getColor() != color;
		
	}
}
