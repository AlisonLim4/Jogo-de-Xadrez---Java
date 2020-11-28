package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	/////// Modificadores e acessores///////
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	////// Metodos de pe�as//////
	public Piece piece(int row, int column) {
		return pieces[row][column];

	}
// ======================================================================
	// ------ M�todo para inserir pe�as no tabuleiro ------//       
	public void placePiece(Piece piece, Position position) {		 
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	// ------ M�todo para remover pe�a do tabuleiro ------//
	public Piece removePiece(Position position) {
		return null;
	}

	// ------ M�todo para validar posi��o ------//
	public boolean positionExists(Position position) {
		return false;
	}
	
	// ------ M�todo para validar pe�a ------//
	public boolean thereIsAPiece(Position position) {
		return false;
	}
	//===================================================================
	// sobrecarga//
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}

}
