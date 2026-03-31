package Main;


import Main.Figure.CoordinateChange;
import Main.Figure.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // A,B,C,D,E,F,G,H;


        Board board = new Board();

        board.setStartPositions();


        Game game = new Game(board);
        game.gameLoop();

    }
}