package leelawatcher.goboard;

public class IllegalMoveException extends Exception {
  private final PointOfPlay proposedMove;
  private final Position position;

  IllegalMoveException(PointOfPlay proposedMove, Position position) {
    super("Illegal move:" + proposedMove + "\nPosition:\n" + position);
    this.proposedMove = proposedMove;
    this.position = position;
  }

  public PointOfPlay getProposedMove() {
    return proposedMove;
  }

  public Position getPosition() {
    return position;
  }
}
