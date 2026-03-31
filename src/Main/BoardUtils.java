package Main;

import Main.Figure.Piece;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;
import java.util.HashSet;

public class BoardUtils {

    public static List<Coordinate> getDiagonalCoordinates(Coordinate source, Coordinate target){
        List<Coordinate> result = new ArrayList<>();

        int fileChange = source.file.ordinal() < target.file.ordinal() ? 1 : -1;
        int rowChange = source.row < target.row ? 1 : -1;

        for (int file = source.file.ordinal() + fileChange,
             row = source.row + rowChange;
             file != target.file.ordinal() || row != target.row;
             file += fileChange, row += rowChange
        ){
            result.add(new Coordinate(row,File.values()[file]));
        }

        return result;
    }

    public static List<Coordinate> getLinearCoordinates(Coordinate source, Coordinate target){
        List<Coordinate> result = new ArrayList<>();

        int fileChange = source.file.ordinal() < target.file.ordinal() ? 1 : -1;
        int rowChange = source.row < target.row ? 1 : -1;

        if(source.row == target.row){
            for (int file = source.file.ordinal() + fileChange;
                 file != target.file.ordinal();
                 file += fileChange
            ){
                result.add(new Coordinate(source.row, File.values()[file]));
            }
        } else {
            for (int row = source.row + rowChange;
                 row != target.row;
                 row += rowChange
            ){
                result.add(new Coordinate(row,source.file));
            }
        }
        return  result;
    }

    public static Set<Coordinate> givesAllMovesPieces(Board board, Color color){

        HashSet<Coordinate> result = new HashSet<>();

        for (Piece piece:
             board.hashMap.values()) {
            if(color.ordinal() != piece.color.ordinal()){
                result.addAll (piece.availableSquareForKing(board));
            }
        }

        return result;
    }
}
