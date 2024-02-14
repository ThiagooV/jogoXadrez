package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition(){
        // subtraindo 'a' da column, trás o inteiro referente a subtração dos unicodes
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' - position.getColumn()), (8 - position.getRow()));
    }

    @Override
    public String toString(){
        //a string vazia serve para forçar o complador a entender que é uma concatenação de Strings
        return "" + column + row;
    }
}
