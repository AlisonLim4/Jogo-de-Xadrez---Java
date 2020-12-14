package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro! O tabuleiro deve ter pelo menos uma LINHA e uma COLUNA");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	/////// Modificadores e acessores///////
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	////// Metodos de peças//////
	public Piece piece(int row, int column) {
		if(!positionExists(row,column)) {
			throw new BoardException("Posição não existe no tabuleiro");
		}
		return pieces[row][column];

	}
// ======================================================================
	// ------ Método para inserir peças no tabuleiro ------//       
	public void placePiece(Piece piece, Position position) {		 
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma peça na posição " + position);
			
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	// ------ Método para remover peça do tabuleiro ------//
	public Piece removePiece(Position position) {
		
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe no tabuleiro");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
		}
		
	

	//  -------- Método auxiliar para validar posição --------//
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	// ------ Método para validar posição ------//
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// ------ Método para validar peça ------//
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe no tabuleiro");
		}
		return piece(position) != null;
	}
	//===================================================================
	// sobrecarga//
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}

}
