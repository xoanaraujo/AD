/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2_A1UD1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Xoan
 */
public class Teclado {
    public static double leerPos() {
        double n = 0;
        boolean isPos = false;
        BufferedReader bffReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                n = Double.parseDouble(bffReader.readLine());
                isPos = true;
                NotPositiveNumberException.checkPositive(n);
            } catch (NotPositiveNumberException e) {
                System.out.println("Se produjo una excepción: " + e.getMessage());
            } catch (Exception e){
                e.printStackTrace();
            }
        } while (!isPos || n <= 0 );
        return n;
    }
    public static int leerInt() {
        int n = 0;
        boolean isInteger = false;
        BufferedReader bffReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                n = Integer.parseInt(bffReader.readLine());
                isInteger = true;
            } catch (Exception e) {
            }
        } while (!isInteger || n == 0);
        return n;
    }
    
    public static double leerDouble() {
        double n = 0;
        boolean isDouble = false;
        BufferedReader bffReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                n = Double.parseDouble(bffReader.readLine());
                isDouble = true;
            } catch (Exception e) {
            }
        } while (!isDouble || n == 0);
        return n;
    }
    
    public static char leerChar() throws IOException {
        return (char) new BufferedReader(new InputStreamReader(System.in)).read();
    }
    
    public static String leer() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
