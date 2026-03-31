package Main.Figure;

import Main.Board;
import Main.BoardUtils;
import Main.Color;
import Main.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece{
    public King(Coordinate coordinate, Color color) {
        super(coordinate, color);
    }

    @Override
    public Set<CoordinateChange> getPieceMovesCoordinates() {
        Set<CoordinateChange> result = new HashSet<>();

        result.add(new CoordinateChange(1, 0));
        result.add(new CoordinateChange(1,1));
        result.add(new CoordinateChange(1,-1));
        result.add(new CoordinateChange(0,1));
        result.add(new CoordinateChange(0,-1));
        result.add(new CoordinateChange(-1, 0));
        result.add(new CoordinateChange(-1,1));
        result.add(new CoordinateChange(-1,-1));

        return  result;
    }

    @Override
    public boolean isSquareAvailable(Board board, Coordinate newCoordinate) {
        boolean result = super.isSquareAvailable(board,newCoordinate);

        if(result){
            Set<Coordinate> coordinateHashSet = BoardUtils.givesAllMovesPieces(board, this.color);

            for (Coordinate c:
                 coordinateHashSet) {
                if (newCoordinate.equals(c)){
                    return false;
                }
            }
        }

        return result;
    }
}
