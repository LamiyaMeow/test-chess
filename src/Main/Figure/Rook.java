package Main.Figure;

import Main.Board;
import Main.BoardUtils;
import Main.Color;
import Main.Coordinate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rook extends Piece{
    public Rook(Coordinate coordinate, Color color) {
        super(coordinate, color);
    }

    @Override
    public Set<CoordinateChange> getPieceMovesCoordinates() {
        Set<CoordinateChange> result = new HashSet<>();
            for (int a = -7; a <= 7; a++ ){
                if(a == 0) continue;
                result.add(new CoordinateChange(a,0));
                result.add(new CoordinateChange(0,a));
            }
        return result;
    }

    @Override
    public boolean isSquareAvailable(Board board, Coordinate newCoordinate) {
        boolean result = super.isSquareAvailable(board, newCoordinate);

        if(result){
            List<Coordinate> coordinateList = BoardUtils.getLinearCoordinates(this.coordinate, newCoordinate);

            for (Coordinate c: coordinateList) {

                if(board.isNotSquareEmpty(c)){
                    return false;
                }
            }
        }

        return result;
    }

    @Override
    public boolean isSquareAvailableForKing(Board board, Coordinate newCoordinate) {
        boolean result = super.isSquareAvailableForKing(board,newCoordinate);

        if(result){
            List<Coordinate> coordinateList = BoardUtils.getLinearCoordinates(this.coordinate, newCoordinate);

            for (Coordinate c: coordinateList) {

                if(board.isNotSquareEmpty(c)){
                    return false;
                }
            }
        }

        return result;
    }
}
