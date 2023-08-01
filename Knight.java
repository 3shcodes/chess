import java.util.ArrayList;

public class Knight extends Piece {

	Knight(Color color, String name, int xorg, int yorg) {
		super(color, name, xorg, yorg);
	}

	@Override
	boolean possibleMove(int x, int y) {
		// cannot capture own piece
		if (this.sameColor(Board.getPiece(x, y)) == true) {
			return false;
		}

		if (Math.abs(this.getY() - y) == 2 && Math.abs(this.getX() - x) == 1
				|| Math.abs(this.getY() - y) == 1 && Math.abs(this.getX() - x) == 2) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE) {
			return "W_N";
		}
		return "B_N";
	}

	@Override
	ArrayList<String> canMove() {

		ArrayList<String> fin = new ArrayList<String>();

		int x = this.getX();
		int y = this.getY();

		// left & up
		if (this.testMove(x - 2, y - 1)) {
			String pos = Board.cosString(x-2,y-1);
			fin.add(pos);
		}
		if (this.testMove(x - 1, y - 2)) {
			String pos = Board.cosString(x-1,y-2);
			fin.add(pos);
		}

		// right & up
		if (this.testMove(x + 2, y - 1)) {
			String pos = Board.cosString(x+2,y-1);
			fin.add(pos);
		}
		if (this.testMove(x + 1, y - 2)) {
			String pos = Board.cosString(x+1,y-2);
			fin.add(pos);
		}

		// left & down
		if (this.testMove(x - 2, y + 1)) {
			String pos = Board.cosString(x-2,y+1);
			fin.add(pos);
		}
		if (this.testMove(x - 1, y + 2)) {
			String pos = Board.cosString(x-1,y+2);
			fin.add(pos);
		}

		// right & down
		if (this.testMove(x + 2, y + 1)) {
			String pos = Board.cosString(x+2,y+1);
			fin.add(pos);
		}
		if (this.testMove(x + 1, y + 2)) {
			String pos = Board.cosString(x+1,y+2);
			fin.add(pos);
		}

		return fin;
	}

}
