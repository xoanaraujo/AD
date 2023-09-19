/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ1_A1UD1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Xoan
 */
public class EJ1_A1UD1 {
    
    public static void main(String[] args) {
        int a = leerNumero();
        int b = leerNumero();
        resultado(a, b);
    }
    
    private static int leerNumero() {
        int n = 0;
        boolean isInteger = false;
        BufferedReader bffReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                System.out.print("n = ");
                n = Integer.parseInt(bffReader.readLine());
                isInteger = true;
            } catch (Exception e) {
            }
        } while (!isInteger || n == 0);
        return n;
    }
    
    private static void resultado(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " * " + b + " = " + (a * b));
        System.out.println("(Entera)" + a + " / " + b + " = " + (a / b));
        System.out.println("(Real)" + a + " / " + b + " = " + ((double)a / b));
    }
}
