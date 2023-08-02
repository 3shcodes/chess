# 2 Player Chess Game

## (Demo Video)[https://youtube.com]

## Quick Installation
Step by step procedure on how to get the development environment running.

```bash
git clone http://github.com/3shcodes/chess.git
cd chess/
javac Chess.java && java Chess
```


## Description
This project is a command-line based 2 Player Chess game. The players take turns alternately, with Player 1 controlling the white pieces and Player 2 controlling the black pieces. The game follows the standard rules of chess, with each piece having its own unique moves and capabilities.

## Assumptions
- The players take turns alternately.
- The chess board is denoted as <Num><Alphabet> (e.g., "d8" denotes the position of the Black Queen).
- Player 1 controls the white pieces and Player 2 controls the black pieces.

## Gameplay
### Choose Coin:
- The player chooses a piece by entering its position on the board (e.g., "b1" denotes the white Knight on the left).
- The system will then print the type of piece and the possible moves for that piece, considering obstructing pieces and potential captures.

### Move Coin:
- The player enters the new position to which the piece should be moved. If it's a valid move, the piece is moved to the new position.
- The game then moves to the next player.

### Special Commands:
- "exit" - Exits the game.
- "Print" - Shows the current state of the board.
- "<Position> --help" - Checks if the piece can be captured if moved to that position. If so, it prints "The <Coin> in <position> can capture your <coin>", otherwise it prints "Safe place".

## Board Representation
The board is represented with the following notation:

- For White Pieces:
  - W_K: King
  - W_Q: Queen
  - W_R: Rook
  - W_B: Bishop
  - W_N: Knight
  - W_P: Pawn

- For Black Pieces:
  - B_K: King
  - B_Q: Queen
  - B_R: Rook
  - B_B: Bishop
  - B_N: Knight
  - B_P: Pawn

## Recording
Every move in the game is recorded in a separate file. The record includes the color of the piece, the initial and final positions, and any captures that occurred.

