package digital.motivo;

public class SquareUtil {
    public static void printBlueSquare(Square square) {
        System.out.print("\u001B[34m[\u001B[0m");
        if(square.isFixed()) {
            System.out.print("\u001B[36m" + (square.getValue() != 0 ? square.getValue() : " ") + "\u001B[0m");
        } else {
            System.out.print(square.getValue() != 0 ? square.getValue() : " ");
        }       
        System.out.print("\u001B[34m]\u001B[0m");
    }

    public static void printRedSquare(Square square) {
        System.out.print("\u001B[31m[\u001B[0m");
        if(square.isFixed()) {
            System.out.print("\u001B[36m" + (square.getValue() != 0 ? square.getValue() : " ") + "\u001B[0m");
        } else {
            System.out.print(square.getValue() != 0 ? square.getValue() : " ");
        }       
        System.out.print("\u001B[31m]\u001B[0m");
    }

    public static void printGreenSquare(Square square) {
        System.out.print("\u001B[32m[\u001B[0m");
        if(square.isFixed()) {
            System.out.print("\u001B[36m" + (square.getValue() != 0 ? square.getValue() : " ") + "\u001B[0m");
        } else {
            System.out.print(square.getValue() != 0 ? square.getValue() : " ");
        }       
        System.out.print("\u001B[32m]\u001B[0m");
    }
}
