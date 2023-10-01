package EJ1_A3_P3_UD1_XoanAraujoGandara;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EJ1_A3_P3_UD1_XoanAraujoGandara {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;


        while (run){
        printMenu();
            switch (getOption()) {
                case 0 -> Operations.createFile();
                case 1 -> Operations.addRegis();
                case 2 -> Operations.printRegis();
                case 3 -> Operations.printAllRegis();
                case 4 -> Operations.modRegis();
                case 5 -> Operations.delete();
                default -> run = false;
            }
        }
    }

    private static int getOption(){
        System.out.println("Selecciona: ");
       return sc.nextInt();
    }

    private static void printMenu(){
        System.out.println(
        "Menú de opciones\n" +
        "----------------\n" +
        "0.-Crear archivo\n" +
        "1.-Añadir registros\n" +
        "2.-Consultar un registro\n" +
        "3.-Consultar todos los registros\n" +
        "4.-Modificar un registro\n" +
        "5.-Borrar\n" +
        "X.-Salir\n"
        );
    }

}
