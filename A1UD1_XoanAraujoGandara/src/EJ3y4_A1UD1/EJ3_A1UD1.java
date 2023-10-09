/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ3y4_A1UD1;

import Ej2_A1UD1.NotPositiveNumberException;
import Ej2_A1UD1.Teclado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author Xoan
 */
public class EJ3_A1UD1 {
    private static final String PATH_NAME = "src/NumerosPositivos.txt";
    private static PrintStream printStream;
    private static double num;

    public static void main(String[] args) throws IOException, NotPositiveNumberException {
        abrirFichero();
        System.out.println("Introduce el numero de positivos para grabar en fichero:");
        num = Teclado.leerPos();

        for (int i = 1; i <= num; i++) {
            System.out.print("numero " + i + ": ");
            grabarFichero(Teclado.leerPos());
        }
        cerrarFichero();
        //ordenarFichero();
        leerFichero();
    }   

    private static void abrirFichero() throws FileNotFoundException {
        printStream = new PrintStream(new FileOutputStream(PATH_NAME, true));
    }

    private static void grabarFichero(double numero) {
        printStream.print(numero + " ");
    }

    private static void cerrarFichero() {
        printStream.close();
    }

    private static void leerFichero() throws IOException {
        System.out.println("\nContenido del fichero NumerosPositivos.txt:");
        try {
            Scanner fileScanner = new Scanner(new File(PATH_NAME));
            while (fileScanner.hasNext()) {
                System.out.print(fileScanner.next() + " ");
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo NumerosPositivos.txt no se encontro.");
        }
    }
    
    private static void ordenarFichero(){
        ArrayList<Double> numArray = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File(PATH_NAME));
            while (fileScanner.hasNext()) {
                numArray.add(Double.valueOf(fileScanner.next()));
            }
            fileScanner.close();
            
            Collections.sort(numArray, new Comparator<Double>(){
                @Override
                public int compare(Double o1, Double o2) {
                    return Double.compare(o2, o1);
                }
            });
                    
            try (PrintStream overwriteStream = new PrintStream(new FileOutputStream(PATH_NAME))) {
            for(Double num : numArray){
                overwriteStream.print(num + " ");
            }
        }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo NumerosPositivos.txt no se encontro.");
        }
    }
}
