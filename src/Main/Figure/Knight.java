package Main.Figure;

import Main.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece{
    public Knight(Coordinate coordinate, Color color) {
        super(coordinate, color);
    }

    @Override
    public Set<CoordinateChange> getPieceMovesCoordinates() {

        Set<CoordinateChange> result = new HashSet<>();

        result.add(new CoordinateChange(2,1));
        result.add(new CoordinateChange(2,-1));

        result.add(new CoordinateChange(-2,1));
        result.add(new CoordinateChange(-2,-1));

        result.add(new CoordinateChange(1,-2));
        result.add(new CoordinateChange(-1,-2));

        result.add(new CoordinateChange(1,2));
        result.add(new CoordinateChange(-1,2));

        return result;
    }
}
