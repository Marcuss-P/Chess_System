package boardgame;

public class Position {

	private int row;
	private int column;
	
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	//atualizar os valores de uma posição
	public void setValue (int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	@Override 
	//Usa-se o Override no toString pois esta se sobreescrevendo
	//um metodo toString que é da classe object 	
	//Imprimir a posição na tela
	public String toString() {
		return row + ", " + column;
	}
	
}
