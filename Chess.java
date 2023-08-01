import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) throws IOException {

		Scanner moveChoice = new Scanner(System.in);
        // Path fileName = Path.of("./logs.txt");
        File file = new File("log.txt");

		while (true) {
			Board.startGame();
            FileWriter gfWriter = new FileWriter(file,true);
            PrintWriter gpWriter = new PrintWriter(gfWriter);
            gpWriter.println();
            gpWriter.println();
            gpWriter.println("Game at "+new Date());
            gpWriter.println("------------------------------------------------------------");
            gpWriter.println();
            gpWriter.close();

			int turns = 0;
			Color color;

			while (true) {
				Board.printBoard();
				// check for check
				if (turns % 2 == 0) {
					color = Color.WHITE;
				} else
					color = Color.BLACK;

				if (Board.isStaleMate(color) == true) {
					System.out.println("game over, stalemate");
					break;
				}
				if (Board.isCheck(color) == true) {
					if (Board.isCheckMate(color) == true) {

						System.out.printf("Checkmate, %s wins \n", color == Color.WHITE ? "Black" : "White");
						break;
					}
					System.out.printf("%s is in Check! \n", color == Color.WHITE ? "White" : "Black");
				}

				// move choice
                // System.out.print(String.format("\033[%dA",200));
				System.out.printf("%s's turn \n", color == Color.WHITE ? "White" : "Black");

				String choosePosition = moveChoice.nextLine();
                String piece = Board.chooseCoin(choosePosition, color);
                String pos = "";
                if ( piece.equals("") == false ) {
                    System.out.println("Enter position to be moved to: ");
				    pos = moveChoice.nextLine();
                }else{
                    continue;
                }

                String col = turns%2 ==0 ? "White":"Black";
                Piece fromPiece = Board.getPiece(piece, color);
                String fromPosition = Board.coOrdinateToPosition( fromPiece.getX(), fromPiece.getY());
                Piece toPiece = Board.getPiece(pos);
                String toPosition = pos;
                




            //     <White/Black> <coin> at <position 1> has been moved to <position 2>
		    //   <White/Black> <coin> at <position 1> has been captured <coin> at <position 2>

				// process move
                String move = piece+" "+pos;
                
				if ( pos.equals("") == false && piece.equals("")==false && Board.processMove(move, color) == 0) {
                    FileWriter fWriter = new FileWriter(file,true);
                    PrintWriter pWriter = new PrintWriter(fWriter);
                    if ( toPiece == null ) {
                        String content = String.format("The %s %s at %s has been moved to %s", col, fromPiece.getName(), fromPosition, toPosition  );
                        pWriter.println(content);
                        System.out.println();
                    } else {
                        String content = String.format("The %s %s at %s has captured %s at %s", col, fromPiece.getName(), fromPosition, toPiece.getName(), toPosition);
                        pWriter.println(content);
                        System.out.println();
                    }
                    pWriter.close();
					turns++;
				} else {
					System.out.println("illegal move");
				}

			}
			System.out.println("would you like to play again? y/n");
			if (moveChoice.next().equals("y")) {
				continue;
			} else {
				System.exit(0);
            }
		}

    }
}