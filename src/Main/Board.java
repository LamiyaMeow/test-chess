package Main;

import Main.Figure.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {

    final String COLOR_RESET = "\u001b[0m";
    final String COLOR_BLACK_BACKGROUND = "\u001b[48;5;71m";
    final String COLOR_WHITE_BACKGROUND = "\u001b[48;5;240m";
    final String COLOR_BLACK = "\u001b[38;5;16m";
    final String COLOR_WHITE = "\u001b[38;5;15m";
    final String COLOR_BLACK_FRONT =  "\u001b[38;5;71m";
    final String COLOR_WHITE_FRONT =  "\u001b[38;5;240m";
    final String COLOR_AVAILABLE_FRONT = "\u001b[38;5;196m";
    final String COLOR_AVAILABLE_BACKGROUND = "\u001b[48;5;196m";


    HashMap<Coordinate, Piece> hashMap = new HashMap<>();


    public void setPiece(Coordinate coordinate, Piece piece){
        piece.coordinate = coordinate;
        hashMap.put(coordinate,piece);
    }

    public void removePiece(Coordinate coordinate){
        hashMap.remove(coordinate);
    }

    public void movePiece(Coordinate from, Coordinate to){
        Piece piece = getPiece(from);
        removePiece(from);
        setPiece(to, piece);
    }


    public boolean isNotSquareEmpty(Coordinate coordinate){
        return hashMap.containsKey(coordinate);
    }

    public Piece getPiece(Coordinate coordinate){
        return hashMap.get(coordinate);
    }

    public String isSquareBlack(int a, File file){
        if ((a + file.ordinal() + 1) % 2 == 0){
            return COLOR_WHITE_BACKGROUND;
        } else return  COLOR_BLACK_BACKGROUND;
    }

    public String availableSquare(){
        return COLOR_AVAILABLE_BACKGROUND;
    }

    public String availableEmptySpriteColor(){
        return COLOR_AVAILABLE_FRONT + " ♟ ";
    }
    public String emptySpriteColor(int a, File file){
        if ((a + file.ordinal() + 1) % 2 == 0){
            return COLOR_WHITE_FRONT + " ♟ ";
        } else return  COLOR_BLACK_FRONT + " ♟ ";
    }

    public String colorizedSprite(Piece piece){
        if (piece.color == Color.WHITE){
            return COLOR_WHITE;
        } else return COLOR_BLACK;
    }



    public String getSprite(Piece piece){
        switch (piece) {
            case Pawn pawn -> {
                return " ♟ ";
            }
            case Rook rook -> {
                return " ♖ ";
            }
            case King king -> {
                return " ♔ ";
            }
            case Bishop bishop -> {
                return " ♗ ";
            }
            case Queen queen -> {
                return " ♕ ";
            }
            case Knight knight -> {
                return " ♘ ";
            }
            case null, default -> {
            }
        }
        return " ";

    }
    public void setStartPositions(){
       for (File file : File.values()){
            setPiece(new Coordinate(2,file), new Pawn(new Coordinate(2,file),Color.WHITE));
            setPiece(new Coordinate(7,file), new Pawn(new Coordinate(7,file),Color.BLACK));
        }

        setPiece(new Coordinate(1, File.A), new Rook(new Coordinate(1, File.A), Color.WHITE));
        setPiece(new Coordinate(1, File.H), new Rook(new Coordinate(1, File.H), Color.WHITE));
        setPiece(new Coordinate(8, File.A), new Rook(new Coordinate(8, File.A), Color.BLACK));
        setPiece(new Coordinate(8, File.H), new Rook(new Coordinate(8, File.H), Color.BLACK));

        setPiece(new Coordinate(1, File.B), new Knight(new Coordinate(1, File.B), Color.WHITE));
        setPiece(new Coordinate(1, File.G), new Knight(new Coordinate(1, File.G), Color.WHITE));
        setPiece(new Coordinate(8, File.B), new Knight(new Coordinate(8, File.B), Color.BLACK));
        setPiece(new Coordinate(8, File.G), new Knight(new Coordinate(8, File.G), Color.BLACK));

        setPiece(new Coordinate(1, File.C), new Bishop(new Coordinate(1, File.C), Color.WHITE));
        setPiece(new Coordinate(1, File.F), new Bishop(new Coordinate(1, File.F), Color.WHITE));
        setPiece(new Coordinate(8, File.C), new Bishop(new Coordinate(8, File.C), Color.BLACK));
        setPiece(new Coordinate(8, File.F), new Bishop(new Coordinate(8, File.F), Color.BLACK));

        setPiece(new Coordinate(1, File.E), new King(new Coordinate(1, File.E), Color.WHITE));
        setPiece(new Coordinate(8, File.E), new King(new Coordinate(8, File.E), Color.BLACK));

        setPiece(new Coordinate(1, File.D), new Queen(new Coordinate(1, File.D), Color.WHITE));
        setPiece(new Coordinate(8, File.D), new Queen(new Coordinate(8, File.D), Color.BLACK));


    }

    public void showBoard(){

        for (int r = 8; r >= 1; r--){
            String string = "";
            for (File file : File.values()){
                Coordinate coordinate;
                coordinate = new Coordinate(r,file);

                if(isNotSquareEmpty(coordinate)){
                    string = string + isSquareBlack(r, file) + colorizedSprite(getPiece(coordinate)) +  getSprite(getPiece(coordinate)) ;
                } else {  string = string + isSquareBlack(r, file) + emptySpriteColor(r,file);}
            }
            System.out.println(string + COLOR_RESET);
        }
    }

    public void showAvalaibleMoves(Set<Coordinate> availableMoves) {

        for (int r = 8; r >= 1; r--){
            String string = "";
            for (File file : File.values()){
                Coordinate coordinate;
                coordinate = new Coordinate(r,file);

                if(isNotSquareEmpty(coordinate)){
                    if(availableMoves.contains(coordinate)){
                        string = string + availableSquare() + colorizedSprite(getPiece(coordinate)) +  getSprite(getPiece(coordinate)) ;
                        continue;
                    }
                    string = string + isSquareBlack(r, file) + colorizedSprite(getPiece(coordinate)) +  getSprite(getPiece(coordinate)) ;

                } else {
                    if(availableMoves.contains(coordinate)){
                        string = string + availableSquare() + availableEmptySpriteColor();
                        continue;
                    }
                    string = string + isSquareBlack(r, file) + emptySpriteColor(r,file);
                }
            }
            System.out.println(string + COLOR_RESET);
        }
    }
}
