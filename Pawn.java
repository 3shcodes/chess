import java.util.ArrayList;

public class Pawn extends Piece {

	Pawn(Color color, String name, int xorg, int yorg) {
		super(color, name, xorg, yorg);
	}


	@Override
	boolean possibleMove(int x, int y) {

		if (this.getColor() == Color.WHITE) {

			// 2 spaces forward
			if (this.getMoved() == false && this.getY() - y == 2 && this.getX() - x == 0
					&& Board.isPathClear(getX(), getY(), x, y) && Board.getPiece(x, y) == null) {
				return true;
			}
			// 1 space forward
			if (this.getY() - y == 1 && this.getX() - x == 0 && Board.getPiece(x, y) == null) {
				return true;
			}

			// diagonal
			if (this.getY() - y == 1 && Math.abs(this.getX() - x) == 1 && Board.getPiece(x, y) != null
					&& this.sameColor(Board.getPiece(x, y)) == false) {
				return true;
			}
		}

		if (this.getColor() == Color.BLACK) {
			// 2 spaces forward
			if (this.getMoved() == false && this.getY() - y == -2 && this.getX() - x == 0
					&& Board.isPathClear(getX(), getY(), x, y) && Board.getPiece(x, y) == null) {
				return true;
			}
			// 1 space forward
			if (this.getY() - y == -1 && this.getX() - x == 0 && Board.getPiece(x, y) == null) {
				return true;
			}

			// diagonal
			if (this.getY() - y == -1 && Math.abs(this.getX() - x) == 1 && Board.getPiece(x, y) != null
					&& this.sameColor(Board.getPiece(x, y)) == false) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE) {
			return "W_P";
		}
		return "B_P";
	}

	@Override
	ArrayList<String> canMove() {
		ArrayList<String> fin = new ArrayList<String>();
		int x = this.getX();
		int y = this.getY();

		if (this.getColor() == Color.WHITE) {

			if (this.testMove(x, y - 1)) {
				String pos = Board.cosString(x,y-1);
				fin.add(pos);
			}

			if (this.testMove(x, y - 2) && this.getMoved()==false) {
				String pos = Board.cosString(x,y-2);
				fin.add(pos);
			}

			if (this.testMove(x - 1, y - 1)) {
				String pos = Board.cosString(x-1,y-1);
				fin.add(pos);
			}

			if (this.testMove(x + 1, y - 1)) {
				String pos = Board.cosString(x+1,y-1);
				fin.add(pos);
			}

		}
		if (this.getColor() == Color.BLACK) {

			if (this.testMove(x, y + 1)) {
				String pos = Board.cosString(x,y+1);
				fin.add(pos);
			}

			if (this.testMove(x, y + 2) && this.getMoved()==false) {
				String pos = Board.cosString(x,y+2);
				fin.add(pos);
			}

			if (this.testMove(x - 1, y - 1)) {
				String pos = Board.cosString(x-1,y-1);
				fin.add(pos);
			}

			if (this.testMove(x + 1, y + 1)) {
				String pos = Board.cosString(x+1,y+1);
				fin.add(pos);
			}
		}

		return fin;
	}

}
