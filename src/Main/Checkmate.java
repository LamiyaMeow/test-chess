package Main;

import Main.Figure.King;
import Main.Figure.Piece;

import java.util.HashSet;
import java.util.Set;

public class Checkmate {
    static Board board;

    public Checkmate(Board board) {
        Checkmate.board = board;
    }

    public static boolean isOnCheckForKing(Board board, Color color){
        HashSet<Coordinate> coordinates = new HashSet<>();

        for (Piece piece:
             board.hashMap.values()) {
            coordinates.addAll(piece.availableSquare(board));
        }

        for (Coordinate c:
                coordinates) {
            if(board.getPiece(c) instanceof King && board.getPiece(c).color.ordinal() == color.ordinal()){
                board.getPiece(c).isCheck = true;
                return true;
            }
        }
        return false;
    }

    public static boolean isOnCheckForPieces(Board board, Color color){
        for (Piece piece:
                board.hashMap.values()) {
            if(piece.color.ordinal() != color.ordinal()){
                Set<Coordinate> availableSSquares = piece.availableSquare(board);

                for (Coordinate c:
                     availableSSquares) {
                    if(board.getPiece(c) instanceof King){
                        board.getPiece(c).isCheck = true;
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static void resetCheck(Board board){
        for (Piece piece:
                board.hashMap.values()) {
            piece.isCheck = false;
        }
    }
}
