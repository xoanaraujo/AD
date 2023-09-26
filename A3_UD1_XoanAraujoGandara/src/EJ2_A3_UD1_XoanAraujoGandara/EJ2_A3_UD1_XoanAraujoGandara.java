 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ2_A3_UD1_XoanAraujoGandara;

import EJ1_A3_UD1_XoanAraujoGandara.NotConsecutiveIntegersException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import util.BinaryInput;
import util.BinaryOutput;

/**
 *
 * @author usuario
 */
public class EJ2_A3_UD1_XoanAraujoGandara {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) { 
        String path = createBin();
        BinaryOutput out = new BinaryOutput(path);
        if (out.exists()){
            System.out.println("Archivo existente, sobreescribir? [Y/N]");
            if(sc.next().toUpperCase().charAt(0) ==  'Y')
                while (out.exists())
                    createBin();
        }
        
        System.out.println("<===>");
        out.open();
        int a;
        int b;
        try {
            a = getInt();
            while (true) {
                out.write(a);
                b = getInt();
                if (b < a){
                    throw new NotConsecutiveIntegersException();
                }
                else
                    a = b;
            }
        } catch (InputMismatchException e) {
            System.out.println("Fin de introduccion de enteros.");
        } catch (NotConsecutiveIntegersException e){
            e.getMessage();
        }
        out.close();
        System.out.println("<===>");
        
        BinaryInput binaryInput = new BinaryInput(path);
        binaryInput.open();
        binaryInput.read();
        binaryInput.close();
    }
    
    private static String createBin(){
        System.out.print("Nombre del archivo: ");
        return "src/" + sc.nextLine() + ".bin";
    }
    
    private static int getInt() throws InputMismatchException{
        System.out.print("=> ");
        int n = sc.nextInt();
        return n;
    }
}
