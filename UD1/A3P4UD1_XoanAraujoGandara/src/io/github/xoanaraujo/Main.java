package io.github.xoanaraujo;


import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        Operations.init();
        while (run){
            printMenu();
            switch (getOption()){
                case 1 : Operations.addRegis(); break;
                case 2 : Operations.printRegis(); break;
                case 3 : Operations.printAllRegis(); break;
                case 4 : Operations.modRegis(); break;
                case 5 : Operations.delete(); break;
                default : run = false;
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
                        "1.-Añadir registros\n" +
                        "2.-Consultar un registro\n" +
                        "3.-Consultar todos los registros\n" +
                        "4.-Modificar un registro\n" +
                        "5.-Borrar\n" +
                        "X.-Salir\n"
        );
    }
}