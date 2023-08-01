import java.util.ArrayList;

class Bishop extends Piece {

	Bishop(Color color, String name, int xorg, int yorg) {
		super(color, name, xorg, yorg);
	}

	@Override
	boolean possibleMove(int x, int y) {
		// cannot capture own piece
		if (this.sameColor(Board.getPiece(x, y)) == true) {
			return false;
		}
		// invalid move for bishop
		if (Math.abs(getX() - x) != Math.abs(getY() - y)) {
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
			return "W_B";
		}
		return "B_B";
	}

	@Override
	ArrayList<String> canMove() {

		ArrayList<String> fin = new ArrayList<>();

		int xorg = this.getX();
		int yorg = this.getY();

		// reset x and y to original position after each while loop
		int x = xorg;
		int y = yorg;

		// top left
		while ((--x) >= 0 && (--y) >= 0) {
			if (this.testMove(x, y)) {
				String pos = Board.cosString(x,y);
				fin.add(pos);
			}
		}
		x = xorg;
		y = yorg;
		// top right
		while ((++x) <= 7 && (--y) >= 0) {
			if (this.testMove(x, y)) {
				String pos = Board.cosString(x,y);
				fin.add(pos);
			}
		}
		x = xorg;
		y = yorg;
		// bottom left
		while ((--x) >= 0 && (++y) <= 7) {
			if (this.testMove(x, y)) {
				String pos = Board.cosString(x,y);
				fin.add(pos);
			}
		}
		x = xorg;
		y = yorg;
		// bottom right
		while ((++x) <= 7 && (++y) <= 7) {
			if (this.testMove(x, y)) {
				String pos = Board.cosString(x,y);
				fin.add(pos);
			}
		}
		return fin;
	}

}

