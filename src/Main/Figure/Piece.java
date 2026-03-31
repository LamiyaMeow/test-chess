package Main.Figure;

import Main.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Piece {
    public boolean isCheck = false;
    public Coordinate coordinate;
    public final Color color;

    public Piece(Coordinate coordinate, Color color) {
        this.coordinate = coordinate;
        this.color = color;
    }
    
    public Set<Coordinate> availableSquare(Board board){
        Set<Coordinate> result = new HashSet<>();
        for(CoordinateChange coordinateChange : getPieceMovesCoordinates()){
            if(coordinate.isOutOfBounds(coordinateChange)){
                Coordinate newCoordinate = coordinate.changesCoordinate(coordinateChange);
                if (isSquareAvailable(board, newCoordinate)){
                    result.add(newCoordinate);
                }
            }
        }
        return result;
    }



    public Set<Coordinate> availableSquareForKing(Board board){
        Set<Coordinate> result = new HashSet<>();
        for(CoordinateChange coordinateChange : getPieceMovesCoordinates()){
            if(coordinate.isOutOfBounds(coordinateChange)){
                Coordinate newCoordinate = coordinate.changesCoordinate(coordinateChange);
                if (isSquareAvailableForKing(board, newCoordinate)){
                    result.add(newCoordinate);
                }
            }
        }
        return result;
    }

    public boolean isSquareAvailable(Board board, Coordinate newCoordinate){
        return !board.isNotSquareEmpty(newCoordinate) || board.getPiece(newCoordinate).color != color;
    }

    public boolean isSquareAvailableForKing(Board board, Coordinate newCoordinate){
        return !board.isNotSquareEmpty(newCoordinate) || board.getPiece(newCoordinate).color == color ;
    }
    
    public abstract Set<CoordinateChange> getPieceMovesCoordinates();
}
