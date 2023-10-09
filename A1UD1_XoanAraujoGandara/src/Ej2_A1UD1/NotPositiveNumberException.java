/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2_A1UD1;

/**
 *
 * @author Xoan
 */
public class NotPositiveNumberException extends Exception {
    public NotPositiveNumberException() {
        super("El número no es positivo.");
    }

    public NotPositiveNumberException(String message) {
        super(message);
    }

    public static void checkPositive(double number) throws NotPositiveNumberException {
        if (number <= 0) {
            throw new NotPositiveNumberException("El número no es positivo: " + number);
        }
    }
}
