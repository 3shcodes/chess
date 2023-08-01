import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rook extends Piece {

	Rook(Color color, String name, int xorg, int yorg) {
		super(color, name, xorg, yorg);
	}

	boolean hasMoved = false;


	@Override
	boolean isPossibleCoordinate(int x, int y) {
		// cannot capture own piece
		if (this.sameColor(Board.getPiece(x, y)) == true) {
			return false;
		}
		// invalid move for rook
		if (Math.abs(getX() - x) != 0 && Math.abs(getY() - y) != 0) {
			return false;
		}

		if (Board.isPathClear(getX(), getY(), x, y)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE) {
			return "W_R";
		}
		return "B_R";
	}

	@Override
	ArrayList<String> getPossibleMoves() {
		ArrayList<String> result = new ArrayList<String>();

		int x = this.getX();
		int y = this.getY();

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

