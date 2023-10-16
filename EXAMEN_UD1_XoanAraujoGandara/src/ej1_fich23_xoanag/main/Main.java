package ej1_fich23_xoanag.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("666554433");
        //for (int i = 0; i < 3; i++) {
        //    Operaciones.altaPaciente(String.valueOf(i).repeat(5), "Xoan", "Araujo", "Gandara", LocalDate.of(2005, 9, 3), telefonos);
        //}
        //ArrayList<Integer> pacientes = new ArrayList<>();
        //pacientes.add(1);
        //pacientes.add(2);
        //pacientes.add(3);
        //for (int i = 0; i < 6; i++) {
        //    Operaciones.altaDentista("Pedro", "21848E" + i, pacientes);
        //}
        //Operaciones.leerDatosDentista(1);
        //Operaciones.altaPaciente("111111", "Xoan", "Araujo", "Gandara", LocalDate.of(2005, 9, 3), telefonos);
        Operaciones.altaPaciente();
    }
}