package digital.motivo;

import java.util.List;
import java.util.Scanner;

public class App {

    private static Square sudoku[][] = new Square[9][9]; 
    private static List<String> letters = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I");
    private static String command;
    public static void main(String[] args) {
        System.out.println("Lab DIO Sudoku\n");
        
        //Monta o tabuleiro
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                sudoku[i][j] = new Square();
            }
        }

        //Valores fixos pré-definidos
        sudoku[0][1].setFixedValue(2);  
        sudoku[0][4].setFixedValue(3);
        sudoku[0][7].setFixedValue(4);
        sudoku[1][0].setFixedValue(6);
        sudoku[1][8].setFixedValue(3);
        sudoku[2][2].setFixedValue(4);
        sudoku[2][6].setFixedValue(5); 
        sudoku[3][3].setFixedValue(8);
        sudoku[3][5].setFixedValue(6);
        sudoku[4][0].setFixedValue(8);
        sudoku[4][4].setFixedValue(1);
        sudoku[4][8].setFixedValue(6);
        sudoku[5][3].setFixedValue(7);
        sudoku[5][5].setFixedValue(5);
        sudoku[6][2].setFixedValue(7);
        sudoku[6][6].setFixedValue(6);
        sudoku[7][0].setFixedValue(4); 
        sudoku[7][8].setFixedValue(8);
        sudoku[8][1].setFixedValue(3);
        sudoku[8][4].setFixedValue(4);
        sudoku[8][7].setFixedValue(2);
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printSudoku();
            System.out.print("Insira o commando. Exemplos: AA=9 (inserir valor 9 na linha A e coluna A) ou 'SAIR' (sair do sistema):");
           
            command = scanner.nextLine().trim().toUpperCase();

            if (command.equalsIgnoreCase("sair")) {
                System.out.println("The end.");
                break;
            }

            if (command.matches("[A-I][A-I]=[1-9]")) {                
                int row = letters.indexOf(command.substring(0, 1));
                int col = letters.indexOf(command.substring(1, 2));
                int value = Character.getNumericValue(command.charAt(3));

                if (!sudoku[row][col].isFixed()) {
                    sudoku[row][col].setValue(value);                    
                } else {
                    System.out.println("\nAviso! Valores iniciais não podem ser alterados.");
                }
            } else {
                System.out.println("Comando inválido. Favor usar o formato 'AA=9' ou 'SAIR'.");
            }

            System.out.print("\n\n");
        }

        scanner.close();
        
    }

    private static void printSudoku() {
        System.out.println("\u001B[33m" + "    A  B  C   D  E  F   G  H  I " + "\u001B[0m");
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                if (j == 0) {
                    System.out.print("\u001B[33m " + letters.get(i) + " \u001B[0m");
                }

                if(j == 3 || j == 6) {
                    System.out.print("\u001B[33m" + "|" + "\u001B[0m");
                }                
                if(i < 3) {
                    printBlueSquare(sudoku[i][j]);                 
                }
                else if(i < 6) {
                    printRedSquare(sudoku[i][j]);
                }
                else {
                    printGreenSquare(sudoku[i][j]);
                }
                
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private static void printBlueSquare(Square square) {
        System.out.print("\u001B[34m[\u001B[0m");
        if(square.isFixed()) {
            System.out.print("\u001B[36m" + (square.getValue() != 0 ? square.getValue() : " ") + "\u001B[0m");
        } else {
            System.out.print(square.getValue() != 0 ? square.getValue() : " ");
        }       
        System.out.print("\u001B[34m]\u001B[0m");
    }

    private static void printRedSquare(Square square) {
        System.out.print("\u001B[31m[\u001B[0m");
        if(square.isFixed()) {
            System.out.print("\u001B[36m" + (square.getValue() != 0 ? square.getValue() : " ") + "\u001B[0m");
        } else {
            System.out.print(square.getValue() != 0 ? square.getValue() : " ");
        }       
        System.out.print("\u001B[31m]\u001B[0m");
    }

    private static void printGreenSquare(Square square) {
        System.out.print("\u001B[32m[\u001B[0m");
        if(square.isFixed()) {
            System.out.print("\u001B[36m" + (square.getValue() != 0 ? square.getValue() : " ") + "\u001B[0m");
        } else {
            System.out.print(square.getValue() != 0 ? square.getValue() : " ");
        }       
        System.out.print("\u001B[32m]\u001B[0m");
    }

}