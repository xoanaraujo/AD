/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ3_A3_UD1_XoanAraujoGandara;

import EJ2_A3_UD1_XoanAraujoGandara.EJ2_A3_UD1_XoanAraujoGandara;
import java.util.Scanner;
import util.BinaryInput;
import util.BinaryOutput;

/**
 *
 * @author Xoan
 */
public class EJ3_A3_UD1_XoanAraujoGandara {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String path = sc.nextLine();
        for (int i = 0; i < 2; i++) {
            EJ2_A3_UD1_XoanAraujoGandara.createConsecIntBinaryFile();
        }
    }
}
