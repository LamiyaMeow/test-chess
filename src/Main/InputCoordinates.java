package Main;

import Main.Figure.CoordinateChange;
import Main.Figure.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {

    static Scanner scanner = new Scanner(System.in);

    public static Coordinate input(){
        while (true){
            System.out.println("Enter cords: (ex.f2) ");

            String line = scanner.nextLine();

            if(line.length() != 2){
                System.out.println("Incorrect");
                continue;
            }

            char fileChar = line.charAt(0);
            char rowChar = line.charAt(1);

            if(!Character.isLetter(fileChar)){
                System.out.println("Incorrect");
                continue;
            }

            if(!Character.isDigit(rowChar)){
                System.out.println("Incorrect");
                continue;
            }

            int row = Character.getNumericValue(rowChar);
            if (row < 1 || row > 8){
                System.out.println("Incorrect");
                continue;
            }

            File file =File.fromChar(fileChar);
            if(file == null){
                System.out.println("Incorrect");
                continue;
            }
            return new Coordinate(row,file);
        }
    }

    public static Coordinate inputPieceColor(Color color, Board board){
        while (true) {
            Coordinate coordinate = input();

            if(!board.isNotSquareEmpty(coordinate)){
                System.out.println("Incorrect");
                continue;
            }

            Piece piece = board.getPiece(coordinate);
            if(piece.color != color){
                System.out.println("Incorrect");
                continue;
            }

            if(piece.availableSquare(board).size() == 0){
                System.out.println("No available square to move");
                continue;
            }

            Set<CoordinateChange> pieceMovesCoordinates = piece.getPieceMovesCoordinates();
            if(pieceMovesCoordinates.size() == 0){
                System.out.println("Incorrect");
                continue;
            }

            return coordinate;
        }
    }

    public static Coordinate inputAvaibleSquare (Set<Coordinate> coordinates){
        while (true){
            System.out.println("Enter move for piece");

            Coordinate input = input();
            if(!coordinates.contains(input)){
                System.out.println("Not available move");
                continue;
            }

            return input;
        }
    }
}
