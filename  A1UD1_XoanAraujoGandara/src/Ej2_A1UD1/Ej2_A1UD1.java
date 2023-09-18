/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2_A1UD1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Xoan
 */
public class Ej2_A1UD1 {
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream(System.out);
        //System.out.print("Leer cadena: ");
        ps.print("Leer cadena: ");
        String s = Teclado.leer();
        //System.out.print("Leer caracter: ");
        ps.print("Leer caracter: ");
        char car = Teclado.leerChar();
        //System.out.print("Leer numero entero: ");
        ps.print("Leer numero entero: ");
        int num1 = Teclado.leerInt();
        //System.out.print("Leer numero double: ");
        ps.print("Leer numero double: ");
        double num2 = Teclado.leerDouble();
        
        //System.out.println(" cadena: " + s);
        //System.out.println(" caracter: " + car);
        //System.out.println(" entero: " + num1);
        //System.out.println(" numero real double: " + num2);
        ps.print(" cadena: " + s + "\n");
        ps.print(" caracter: " + car + "\n");
        ps.print(" entero: " + num1 + "\n");
        ps.print(" numero real double: " + num2 + "\n");
        
        try {
            FileWriter fw = new FileWriter("src/EJ2_A1UD1/Datos.txt", true);
            fw.write(" cadena: " + s + "\n");
            fw.write(" caracter: " + car + "\n");
            fw.write(" entero: " + num1 + "\n");
            fw.write(" numero real double: " + num2 + "\n");
            fw.close();
        } catch (Exception e) {
        }
    }
    
}
