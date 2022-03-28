package boardgame;

public class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		//Posi��o de uma pe�a recem criada � nulo
		position = null;
	}

	//somente classes do mesmo pacote e subclasses podem usalo
	protected Board getBoard() {
		return board;
	}
	
	//nao ha o set pois nn pode deixar q o tabuleiro seja alterado
	
	
	
	
}
