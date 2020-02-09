package LLD.Chess;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(this.isWhite() == end.getPiece().isWhite())
        return false;
        if(((start.getX() == 1 || start.getX() ==6) && Math.abs(start.getY() -end.getY()) > 2) || Math.abs(start.getY() -end.getY()) > 1)
        return false;
                return true;

    }

}
