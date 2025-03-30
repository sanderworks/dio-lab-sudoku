package digital.motivo;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Sudoku game = new Sudoku();                
        String command;
        
        try(Scanner scanner = new Scanner(System.in)) {
            List<String> coordinateLetters = game.getCoordinateLetters();
            while (true) {
                System.out.print("\n");
                System.out.println("Lab DIO Sudoku (by SanderWorks)\n");
                game.printBoard();

                if (game.isSudokuSolved()) {
                    System.out.println("Parabéns! Você resolveu o Sudoku!");
                    break;
                }

                System.out.print("Insira o commando. Exemplos: AA=9 (insere valor 9 na linha A e coluna A) ou 'SAIR' (sair do sistema): ");
                command = scanner.nextLine().trim().toUpperCase();

                if (command.equalsIgnoreCase("sair")) {
                    System.out.println("\nResolução do Sudoku:\n");
                    game.solveSudoku();
                    game.printBoard();
                    break;
                }

                if (command.matches("[A-I][A-I]=[1-9]")) {                
                    int row = coordinateLetters.indexOf(command.substring(0, 1));
                    int col = coordinateLetters.indexOf(command.substring(1, 2));
                    int value = Character.getNumericValue(command.charAt(3));
                    if (!game.getBoard()[row][col].isFixed()) {
                        game.getBoard()[row][col].setValue(value);                    
                    } else {
                        System.out.println("\nAviso! Valores iniciais não podem ser alterados.");
                    }
                } else {
                    System.out.println("Comando inválido. Favor usar o formato 'AA=9' ou 'SAIR'.");
                }
            }
        } finally {
            System.out.println("The end.");
        }
    }
}
