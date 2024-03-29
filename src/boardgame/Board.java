package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece [][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		//Colocando a linha e a coluna na matiz
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	//Retornar a matiz pieces na linha e coluna
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)){
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	
	public Piece piece(Position position) {
		if (!positionExists(position)){
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		//pegar a matriz na posi��io data a pe�a que eu informe
		pieces[position.getRow()][position.getColumn()] = piece;
		//nao mais na posi��o nula
		piece.position = position;
	}
	
	//retoornandoo uma piece
	public Piece removePiece(Position position) {
		if (!positionExists(position)){
			throw new BoardException("Position not on the board");
		}
		//se a pe�a do tabuleiro nessa posi��o � = a nulo
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
		
	}
	
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
		
	}
	
	public boolean thereIsAPiece (Position position) {
		if (!positionExists(position)){
		throw new BoardException("Position not on the board");
	}
		return piece(position) != null;
	}
	
}
