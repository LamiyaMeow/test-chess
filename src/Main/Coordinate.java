package Main;

import Main.Figure.CoordinateChange;

import java.util.Objects;

public class Coordinate {
     public int row;
     public File file;

     public Coordinate(int row, File file) {
          this.row = row;
          this.file = file;
     }

     public Coordinate(Coordinate coordinate){
          this.row = coordinate.row;
          this.file = coordinate.file;
     }

     public Coordinate changesCoordinate(CoordinateChange coordinateChange){
          return new Coordinate(this.row + coordinateChange.rowChange, File.values()[this.file.ordinal() + coordinateChange.fileChange] );
     }

     public boolean isOutOfBounds(CoordinateChange coordinateChange){
          int r = row + coordinateChange.rowChange;
          int f = file.ordinal() + coordinateChange.fileChange;

          if (r < 1 || r > 8) return false;
         return f >= 0 && f < 8;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Coordinate that = (Coordinate) o;
          return row == that.row && file == that.file;
     }

     @Override
     public int hashCode() {
          return Objects.hash(row, file);
     }
}
