import java.util.ArrayList;

public abstract class Piece {

    Color color;
    String pName;
    int x,y;
    boolean hasMoved = false;

    Piece ( Color col, String pn, int xax, int yax ) {
        this.color = col;
        this.pName = pn;
        this.x = xax;
        this.y = yax;

        if( this.color == Color.WHITE ) {
            Board.white.add(this);
        } else {
            Board.black.add(this);
        }
		Board.setPiece(x, y, this);
    }


    String getName() {
		return this.pName;
	}

	boolean cmpPieces(String name) {
		return this.pName.equals(name);
	}

	Color getColor() {
		return this.color;
	}

	boolean sameColor(Piece otherPiece) {
		if (otherPiece == null) {
			return false;
		}
		return (this.color == otherPiece.getColor());
	}

	int getX() {
		return this.x;
	}

	void setX(int newX) {
		this.x = newX;
	}

	int getY() {
		return this.y;
	}

	void setY(int newY) {
		this.y = newY;
	}

	boolean getMoved(){
		return this.hasMoved;
	}
	void setMoved(boolean val){
		this.hasMoved = val;
	}

	abstract boolean possibleMove(int x, int y);

	int move( int x, int y, Piece other ){
		// <White/Black> <coin> at <position 1> has been moved to <position 2>
		// <White/Black> <coin> at <position 1> has captured <coin> at <position 2>

		

		if ( this.possibleMove(x, y) != true ) {
			return -1;
		}

		Color color = this.getColor();
		int xorg = this.getX();
		int yorg = this.getY();
		
		String currCol = "";
		String fCoin = this.pName;
		String fromP = Board.cosString(xorg, yorg);
		String tCoin = "";
		String toP = Board.cosString( x, y );
		if ( other!=null ) {
			tCoin = other.pName;
		}

		if ( this.getColor() == Color.WHITE ) {
			Board.black.remove(other);
			currCol = "White";
		} else {
			Board.white.remove(other);
			currCol = "Black";
		}

		Board.setPiece(xorg, yorg, null);
		Board.setPiece(x, y, this);

		boolean isFirstMove = !this.hasMoved;
		this.hasMoved = true;

		if (Board.checkForCheck(color) == true) {
			if (other != null) {
				if (this.getColor() == Color.WHITE) {
					Board.black.add(other);
				} else {
					Board.white.add(other);
				}
			}
			Board.setPiece(xorg, yorg, this);
			Board.setPiece(x, y, other);
			this.hasMoved = !isFirstMove;

			return -1;
		}

		if (this instanceof Pawn) {
			char file = this.getName().charAt(4);
			if (this.getColor() == Color.WHITE && y == 0) {
				Board.setPiece(x, y, null);
				Board.white.remove(this);
				new Queen(Color.WHITE, "queen" + file, x, y);
				System.out.println("Pawn promoted!");
			} else if (this.getColor() == Color.BLACK && y == 7) {
				Board.setPiece(x, y, null);
				Board.black.remove(this);
				new Queen(Color.BLACK, "queen" + file, x, y);
				System.out.println("Pawn promoted!");
			}
		}

		// String currCol = "";
		// String fCoin = this.pName;
		// String fromP = Board.cosString(xorg, yorg);
		// String tCoin = "";
		// String toP = Board.cosString( x, y );

		// <White/Black> <coin> at <position 1> has been moved to <position 2>
		// <White/Black> <coin> at <position 1> has captured <coin> at <position 2>
		// if ( tCoin == "" ) {
		// 	System.out.printf("The %s %s at %s has been moved to %s", currCol, fCoin, fromP, toP );
		// 	System.out.println();
		// } else {
		// 	System.out.printf("The %s %s at %s has captured %s at %s", currCol, fCoin, fromP, tCoin, toP);
		// 	System.out.println();
		// }
		return 0;
	}

	boolean testMove(int x, int y) {
		int xorg = this.getX();
		int yorg = this.getY();
		Piece other;
		boolean isFirst = !this.hasMoved;

		if (x >= 0 && y >= 0 && x <= 7 && y <= 7) {
			other = Board.getPiece(x, y);
			if (this.move(x, y, other) == 0) {
				// captured piece set to original position
				Board.setPiece(x, y, other);
				// selected piece set to original position
				Board.setPiece(xorg, yorg, this);
				hasMoved = !isFirst;
				if (other != null) {
					if (other.getColor() == Color.WHITE) {
						Board.white.add(other);
					} else
						Board.black.add(other);
				}
				return true;
			}
		}
		return false;
	}

	String nullToString() {
		return " X ";
	}

	public abstract String toString();

	abstract ArrayList<String> canMove();



    
}
