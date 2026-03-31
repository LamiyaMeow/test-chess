package Main.Figure;

import Main.*;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {

    Coordinate oldCoordinate;


    public Pawn(Coordinate coordinate, Color color) {
        super(coordinate, color);
        this.oldCoordinate = new Coordinate(coordinate);
    }

    @Override
    public Set<CoordinateChange> getPieceMovesCoordinates() {
        Set<CoordinateChange> result = new HashSet<>();

        if(this.color == Color.WHITE) {
            result.add(new CoordinateChange(1,1));
            result.add(new CoordinateChange(1,-1));
            if (oldCoordinate.equals(this.coordinate)) {
                result.add(new CoordinateChange(2, 0));
                result.add(new CoordinateChange(1, 0));
            } else {
                result.add(new CoordinateChange(1, 0));
            }
        } else {
            result.add(new CoordinateChange(-1,1));
            result.add(new CoordinateChange(-1,-1));
            if (oldCoordinate.equals(this.coordinate)) {
                result.add(new CoordinateChange(-2, 0));
                result.add(new CoordinateChange(-1, 0));
            } else {
                result.add(new CoordinateChange(-1, 0));
            }
        }
        return result;
    }

    @Override
    public boolean isSquareAvailable(Board board,Coordinate newCoordinate) {

        if(newCoordinate.file.ordinal() == this.coordinate.file.ordinal() ){
            return !board.isNotSquareEmpty(newCoordinate);
        } else {
            if(board.isNotSquareEmpty(newCoordinate)){
                return board.getPiece(newCoordinate).color != color;
            }
        }

        return false;
    }

    @Override
    public boolean isSquareAvailableForKing(Board board,Coordinate newCoordinate) {
        return newCoordinate.file.ordinal() != this.coordinate.file.ordinal();
    }
}
