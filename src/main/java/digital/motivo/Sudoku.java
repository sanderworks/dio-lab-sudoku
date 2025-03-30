package digital.motivo;

import java.util.List;

public class Sudoku {
    private Square board[][];
    private List<String> coordinateLetters;
    
    public Sudoku() {
        coordinateLetters = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I");

        //Monta o tabuleiro
        board = new Square[9][9]; 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square();
            }
        }

        //Valores fixos pré-definidos
        board[0][1].setFixedValue(2);  
        board[0][4].setFixedValue(3);
        board[0][7].setFixedValue(4);
        board[1][0].setFixedValue(6);
        board[1][8].setFixedValue(3);
        board[2][2].setFixedValue(4);
        board[2][6].setFixedValue(5); 
        board[3][3].setFixedValue(8);
        board[3][5].setFixedValue(6);
        board[4][0].setFixedValue(8);
        board[4][4].setFixedValue(1);
        board[4][8].setFixedValue(6);
        board[5][3].setFixedValue(7);
        board[5][5].setFixedValue(5);
        board[6][2].setFixedValue(7);
        board[6][6].setFixedValue(6);
        board[7][0].setFixedValue(4); 
        board[7][8].setFixedValue(8);
        board[8][1].setFixedValue(3);
        board[8][4].setFixedValue(4);
        board[8][7].setFixedValue(2);
    }

    public Square[][] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println("\u001B[33m" + "    A  B  C   D  E  F   G  H  I " + "\u001B[0m");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    System.out.print("\u001B[33m " + coordinateLetters.get(i) + " \u001B[0m");
                }

                if(j == 3 || j == 6) {
                    System.out.print("\u001B[33m" + "|" + "\u001B[0m");
                }                
                if(i < 3) {
                    SquareUtil.printBlueSquare(board[i][j]);                 
                }
                else if(i < 6) {
                    SquareUtil.printRedSquare(board[i][j]);
                }
                else {
                    SquareUtil.printGreenSquare(board[i][j]);
                }
                
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<String> getCoordinateLetters() {
        return coordinateLetters;
    }

    public boolean isSudokuSolved() {
        // Validar linhas
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                int value = board[i][j].getValue();
                if (value == 0 || seen[value - 1]) {
                    return false;
                }
                seen[value - 1] = true;
            }
        }

        // Validar colunas
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[9];
            for (int i = 0; i < 9; i++) {
                int value = board[i][j].getValue();
                if (value == 0 || seen[value - 1]) {
                    return false;
                }
                seen[value - 1] = true;
            }
        }

        // Validar blocos 3x3
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                boolean[] seen = new boolean[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int value = board[row + i][col + j].getValue();
                        if (value == 0 || seen[value - 1]) {
                            return false;
                        }
                        seen[value - 1] = true;
                    }
                }
            }
        }

        return true;
    }

    public void solveSudoku() {
        board[0][0].setValue(9);
        board[0][2].setValue(5);
        board[0][3].setValue(6);
        board[0][5].setValue(1);
        board[0][6].setValue(8);
        board[0][8].setValue(7);

        board[1][1].setValue(1);
        board[1][2].setValue(8);
        board[1][3].setValue(5);
        board[1][4].setValue(7);
        board[1][5].setValue(4);
        board[1][6].setValue(2);
        board[1][7].setValue(9);

        board[2][0].setValue(3);
        board[2][1].setValue(7);
        board[2][3].setValue(9);
        board[2][4].setValue(8);
        board[2][5].setValue(2);
        board[2][7].setValue(6);
        board[2][8].setValue(1);

        board[3][0].setValue(7);
        board[3][1].setValue(4);
        board[3][2].setValue(9);
        board[3][4].setValue(2);
        board[3][6].setValue(1);
        board[3][7].setValue(3);
        board[3][8].setValue(5);

        board[4][1].setValue(5);
        board[4][2].setValue(2);
        board[4][3].setValue(4);
        board[4][5].setValue(3);
        board[4][6].setValue(9);
        board[4][7].setValue(7);

        board[5][0].setValue(1);
        board[5][1].setValue(6);
        board[5][2].setValue(3);
        board[5][4].setValue(9);
        board[5][6].setValue(4);
        board[5][7].setValue(8);
        board[5][8].setValue(2);

        board[6][0].setValue(2);
        board[6][1].setValue(8);
        board[6][3].setValue(3);
        board[6][4].setValue(5);
        board[6][5].setValue(9);
        board[6][7].setValue(1);
        board[6][8].setValue(4);

        board[7][1].setValue(9);
        board[7][2].setValue(1);
        board[7][3].setValue(2);
        board[7][4].setValue(6);
        board[7][5].setValue(7);
        board[7][6].setValue(3);
        board[7][7].setValue(5);

        board[8][0].setValue(5);
        board[8][2].setValue(6);
        board[8][3].setValue(1);
        board[8][5].setValue(8);
        board[8][6].setValue(7);
        board[8][8].setValue(9);
    }

}
