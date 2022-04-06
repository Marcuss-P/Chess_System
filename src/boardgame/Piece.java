package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		//Posição de uma peça recem criada é nulo
		position = null;
	}

	//somente classes do mesmo pacote e subclasses podem usalo
	protected Board getBoard() {
		return board;
	}
	
	//nao ha o set pois nn pode deixar q o tabuleiro seja alterado
	
	public abstract boolean [][] possibleMoves();

	public boolean possibleMove(Position position) {
		//metodo retornando uma matriz
		//metodo concreto utilizando um metodo abstrato 
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
