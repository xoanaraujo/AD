package a4ud1_alumno;


import a4ud1_alumno.Operaciones;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        Operaciones.iniciar();
        while (run){
            printMenu();
            switch (getOption()){
                case 1 : Operaciones.nuevoAlumno(); break;
                case 2 : Operaciones.nuevoAlumnoConInfo(); break;
                case 3 : Operaciones.datosAlumnos(); break;
                case 4 : Operaciones.datosNotas(); break;
                case 5 : Operaciones.consultarTelefono(); break;
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
                        "1.-Nuevo Alumno\n" +
                        "2.-Nuevo Alumno con info\n" +
                        "3.-Datos alumno\n" +
                        "4.-Datos notas\n" +
                        "5.-Consultar telefono\n" +
                        "X.-Salir\n"
        );
    }
}