package Main;

import Main.Figure.Piece;

import java.util.Set;

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop(){
        boolean isWhiteToMove = true;
        System.out.println("Enter cords to choose piece and then enter cords to move");

        while (true){

            board.showBoard();

            if(Checkmate.isOnCheckForKing(board,isWhiteToMove ? Color.WHITE : Color.BLACK)){
                System.out.println("Check to " + (isWhiteToMove ? Color.WHITE : Color.BLACK));
            }

            Coordinate sourceCoordinate = InputCoordinates.inputPieceColor(
                    isWhiteToMove ? Color.WHITE : Color.BLACK , board
            );

            Piece piece = board.getPiece(sourceCoordinate);
            Set<Coordinate> avalaibleMoves = piece.availableSquare(board);

            board.showAvalaibleMoves(avalaibleMoves);

            Coordinate targetCoordinate = InputCoordinates.inputAvaibleSquare(avalaibleMoves);

            board.movePiece(sourceCoordinate, targetCoordinate);

            Checkmate.resetCheck(board);

            isWhiteToMove =! isWhiteToMove;

        }



    }
}
