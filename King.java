import java.util.ArrayList;


public class King extends Piece {

	public King(Color color, String name, int xorg, int yorg) {
		super(color, name, xorg, yorg);
	}

	boolean isFirstMove = true;

	@Override
	public boolean isPossibleCoordinate(int x, int y) {
		// cannot capture own piece
		if (this.sameColor(Board.getPiece(x, y)) == true) {
			return false;
		}
		// bishop
		else if (Math.abs(getX() - x) == 1 && Math.abs(getY() - y) == 1) {
			return true;
		}
		// rook
		else if (Math.abs(getX() - x) == 1 && Math.abs(getY() - y) == 0
				|| Math.abs(getX() - x) == 0 && Math.abs(getY() - y) == 1) {
			return true;
		}
		return false;
	}
	

	@Override
	boolean isAttackableCoOrdinate( int x, int y ) {
		return isPossibleCoordinate(x, y);
	}

	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE) {
			return "W_K";
		}
		return "B_K";
	}

	public int castle(String side) {
		Rook rook = (Rook) Board.getPiece("rook" + side, this.getColor());
		int xorg = this.getX();
		int yorg = this.getY();

		if (this.hasMoved == true || rook.hasMoved == true) {
			System.out.println("Cannot castle if king or rook has already moved");
			return -1;
		}
		if (Board.isPathClear(this.getX(), this.getY(), rook.getX(), rook.getY()) != true) {
			System.out.println("Cannot castle across a line of check");
			return -1;
		}

		if (this.getColor() == Color.WHITE) {

			if (side.equals("K")) {
				// cant castle accross a line of check
				if (this.move(5, 7, null) == 0 && this.move(6, 7, null) == 0) {
					Board.setPiece(rook.getX(), rook.getY(), null);
					Board.setPiece(5, 7, rook);
					return 0;
				} else {
					Board.setPiece(this.getX(), this.getY(), null);
					Board.setPiece(xorg, yorg, this);
					return -1;
				}
			}

			else if (side.equals("Q")) {
				if (this.move(3, 7, null) == 0 && this.move(2, 7, null) == 0) {
					Board.setPiece(rook.getX(), rook.getY(), null);
					Board.setPiece(3, 7, rook);
					return 0;
				} else {
					Board.setPiece(this.getX(), this.getY(), null);
					Board.setPiece(xorg, yorg, this);
					return -1;
				}
			}
		}

		if (this.getColor() == Color.BLACK) {
			if (side.equals("K")) {
				if (this.move(5, 0, null) == 0 && this.move(6, 0, null) == 0) {
					Board.setPiece(rook.getX(), rook.getY(), null);
					Board.setPiece(5, 0, rook);
					return 0;
				} else {
					Board.setPiece(this.getX(), this.getY(), null);
					Board.setPiece(xorg, yorg, this);
					return -1;
				}
			}

			else if (side.equals("Q")) {
				if (this.move(3, 0, null) == 0 && this.move(2, 0, null) == 0) {
					Board.setPiece(rook.getX(), rook.getY(), null);
					Board.setPiece(3, 0, rook);
					return 0;
				} else {
					Board.setPiece(this.getX(), this.getY(), null);
					Board.setPiece(xorg, yorg, this);
					return -1;
				}
			}
		}
		return -1;
	}

	@Override
	public ArrayList<String> getPossibleMoves() {
		ArrayList<String> result = new ArrayList<>();
		int x = this.getX();
		int y = this.getY();

		// bishop
		// top left
		if (this.isValidMove(x - 1, y - 1)) {
			String pos = Board.coOrdinateToPosition(x-1,y-1);
			result.add(pos);
		}
		// top right
		if (this.isValidMove(x + 1, y - 1)) {
			String pos = Board.coOrdinateToPosition(x+1,y-1);
			result.add(pos);
		}
		// bottom left
		if (this.isValidMove(x - 1, y + 1)) {
			String pos = Board.coOrdinateToPosition(x-1,y+1);
			result.add(pos);
		}
		// bottom right
		if (this.isValidMove(x + 1, y + 1)) {
			String pos = Board.coOrdinateToPosition(x+1,y+1);
			result.add(pos);
		}

		// rook
		// left
		if (this.isValidMove(x - 1, y)) {
			String pos = Board.coOrdinateToPosition(x-1,y);
			result.add(pos);
		}
		// right
		if (this.isValidMove(x + 1, y)) {
			String pos = Board.coOrdinateToPosition(x+1,y);
			result.add(pos);
		}
		// down
		if (this.isValidMove(x, y + 1)) {
			String pos = Board.coOrdinateToPosition(x,y+1);
			result.add(pos);
		}
		// up
		if (this.isValidMove(x, y - 1)) {
			String pos = Board.coOrdinateToPosition(x,y-1);
			result.add(pos);
		}


		// castle
		if ( this.hasMoved() == false ) {
			if ( color == Color.WHITE ) {

				// king side
				Piece rightRook = Board.getPiece("rookK", Color.BLACK);
				if ( this.isValidMove(x+1, y) && Board.getPiece(x+2, y)==null && rightRook.hasMoved() == false ) {
					String pos = Board.coOrdinateToPosition(x+2, y);
					result.add(pos);
				}
				// queen side
				Piece leftRook = Board.getPiece("rookL", Color.BLACK);
				if ( this.isValidMove(x-1, y) && Board.getPiece(x-2, y)==null && Board.getPiece(x-3, y) == null  && leftRook.hasMoved() == false ) {
					String pos = Board.coOrdinateToPosition(x-2, y);
					result.add(pos);
				}
			} else {

				// king side
				Piece rightRook = Board.getPiece("rookK", Color.WHITE);
				if ( this.isValidMove(x+1, y) && Board.getPiece(x+2, y)==null && rightRook.hasMoved() == false ) {
					String pos = Board.coOrdinateToPosition(x+2, y);
					result.add(pos);
				}
				// queen side
				Piece leftRook = Board.getPiece("rookL", Color.WHITE);
				if ( this.isValidMove(x-1, y) && Board.getPiece(x-2, y)==null && Board.getPiece(x-3, y) == null  && leftRook.hasMoved() == false ) {
					String pos = Board.coOrdinateToPosition(x-2, y);
					result.add(pos);
				}

			}
		}
		return result;
	}

}

