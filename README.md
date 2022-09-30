# bomberman.oasis.nh11
bomberman.aosis/nh11

import java.util.ArrayList;

public class Game {
  private Board board;
  private ArrayList<Move> moveHistory;

  public Game(Board board) {
    this.board = board;
    this.moveHistory = new ArrayList<Move>();
  }

  /** movePiece. */
  public void movePiece(Piece piece, int x, int y) {
    if (piece.canMove(board, x, y)) {
      Piece killedPiece = board.getAt(x, y);
      if (killedPiece != null) {
        board.removeAt(x, y);
      }
      piece.setCoordinatesX(x);
      piece.setCoordinatesY(y);
      board.addPiece(piece);
      moveHistory.add(new Move(piece, x, y, killedPiece));
    }
    if (piece != null && piece.canMove(this.board, x, y)) {
      this.board.removeAt(piece.getCoordinatesX(), piece.getCoordinatesY());
      piece.setCoordinatesX(x);
      piece.setCoordinatesY(y);
      this.board.addPiece(piece);
      this.moveHistory.add(new Move(piece, x, y));
    }
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public ArrayList<Move> getMoveHistory() {
    return moveHistory;
  }
}
