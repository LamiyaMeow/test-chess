# Console Chess Game (Java)

## Description

This project is a **console chess game written in Java**.
The program implements chess rules, piece movement logic, check detection, and available move highlighting directly in the terminal using colored output.

The game is played by entering coordinates (for example: `e2`, `e4`).

---

##  Features

* Full chess board
* All chess pieces implemented:

    * Pawn
    * Rook
    * Knight
    * Bishop
    * Queen
    * King
* Legal move validation
* Check detection
* Highlight available moves
* Colored board in console
* Turn-based game (White / Black)
* Coordinate input system

---

##  How to Play

When the game starts, the board will be displayed in the console.

You need to:

1. Enter the coordinate of the piece (example: `e2`)
2. The game will show available moves
3. Enter the coordinate where you want to move the piece (example: `e4`)

Example input:

```
Enter cords: (ex.f2)
e2
Enter move for piece
e4
```

---

## 📂 Project Structure

```
Main/
│
├── Main.java
├── Game.java
├── Board.java
├── BoardUtils.java
├── Checkmate.java
├── InputCoordinates.java
├── Coordinate.java
├── File.java
├── Color.java
│
└── Figure/
    ├── Piece.java
    ├── Pawn.java
    ├── Rook.java
    ├── Knight.java
    ├── Bishop.java
    ├── Queen.java
    ├── King.java
    └── CoordinateChange.java
```

---

## How the Program Works

### Board

The board is stored in a `HashMap<Coordinate, Piece>`, where:

* Key = board coordinate
* Value = chess piece

### Pieces

Each chess piece extends the abstract class `Piece` and implements:

* Available moves
* Movement rules
* Capture rules

### Move System

Each piece has a set of possible coordinate changes (`CoordinateChange`), and the program checks:

* Board boundaries
* Collisions with other pieces
* Capture rules
* Special rules for each piece

### Check Detection

The program checks if the king is under attack by calculating all possible enemy moves.

---

## Technologies Used

* Java
* OOP (Inheritance, Polymorphism, Abstraction)
* HashMap
* Set / List Collections
* Console ANSI Colors

---

## How to Run

1. Install Java (JDK 8 or higher)
2. Open the project in IntelliJ IDEA / Eclipse
3. Run:

```
Main.java
```

---

##  Controls

| Action       | Example |
| ------------ | ------- |
| Select piece | e2      |
| Move piece   | e4      |

---

##  Limitations

* No castling
* No en passant
* No pawn promotion
* No checkmate detection yet
* Console only (no GUI)

---

## Possible Improvements

* Add castling
* Add pawn promotion
* Add checkmate detection
* Add stalemate
* Add GUI (Swing / JavaFX)
* Add AI opponent
* Save/load game
* Move history

---

## 👨‍💻 Author

LamiyaMeow

---

## 📄 License

This project is created for educational purposes.
