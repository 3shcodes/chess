import java.util.ArrayList;



public class Queen extends Piece {

	Queen(Color color, String name, int xorg, int yorg) {
		super(color, name, xorg, yorg);
	}

	@Override
	boolean isPossibleCoordinate(int x, int y) {
		// cannot capture own piece
		if (this.sameColor(Board.getPiece(x, y)) == true) {
			return false;
		}
		// obstruction
		if (Board.isPathClear(getX(), getY(), x, y) != true) {
			return false;
		}
		// bishop
		if (Math.abs(getX() - x) == Math.abs(getY() - y)) { // bishop
			return true;
		}
		// rook
		if (Math.abs(getX() - x) != 0 && Math.abs(getY() - y) == 0
				|| Math.abs(getX() - x) == 0 && Math.abs(getY() - y) != 0) {
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
			return "W_Q";
		}
		return "B_Q";
	}

	@Override
	ArrayList<String> getPossibleMoves() {
		
		ArrayList<String> result = new ArrayList<String>();
		int x = this.getX();
		int y = this.getY();

		// bishop
		// top left
		while ((--x) >= 0 && (--y) >= 0) {
			if (this.isValidMove(x, y)) {
				String pos = Board.coOrdinateToPosition(x,y);
				result.add(pos);
			}
		}

		x = this.getX();
		y = this.getY();
		// top right
		while ((++x) <= 7 && (--y) >= 0) {
			if (this.isValidMove(x, y)) {
				String pos = Board.coOrdinateToPosition(x,y);
				result.add(pos);
			}
		}

		x = this.getX();
		y = this.getY();
		// bottom left
		while ((--x) >= 0 && (++y) <= 7) {
			if (this.isValidMove(x, y)) {
				String pos = Board.coOrdinateToPosition(x,y);
				result.add(pos);
			}
		}

		x = this.getX();
		y = this.getY();
		// bottom right
		while ((++x) <= 7 && (++y) <= 7) {
			if (this.isValidMove(x, y)) {
				String pos = Board.coOrdinateToPosition(x,y);
				result.add(pos);
			}
		}

		x = this.getX();
		y = this.getY();
		// rook
		// left
		while ((--x) >= 0 && y >= 0) {
			if (this.isValidMove(x, y)) {
				String pos = Board.coOrdinateToPosition(x,y);
				result.add(pos);
			}
		}

		x = this.getX();
		y = this.getY();
		// right
		while ((++x) <= 7 && y >= 0) {
			if (this.isValidMove(x, y)) {
				String pos = Board.coOrdinateToPosition(x,y);
				result.add(pos);
			}
		}

		x = this.getX();
		y = this.getY();
		// down
		while (x >= 0 && (++y) <= 7) {
			if (this.isValidMove(x, y)) {
				String pos = Board.coOrdinateToPosition(x,y);
				result.add(pos);
			}
		}

		x = this.getX();
		y = this.getY();
		// up
		while (x <= 7 && (--y) >= 0) {
			if (this.isValidMove(x, y)) {
				String pos = Board.coOrdinateToPosition(x,y);
				result.add(pos);
			}
		}
		return result;
	}

}
