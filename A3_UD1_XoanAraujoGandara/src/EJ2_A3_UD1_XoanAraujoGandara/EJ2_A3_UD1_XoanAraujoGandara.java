 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ2_A3_UD1_XoanAraujoGandara;

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
        BinaryOutput out = createBinOut();
        System.out.println("<===>");
        createConsecIntBinaryFile(out);
        System.out.println("<===>");
        
        BinaryInput binaryInput = new BinaryInput("src/" + out.getName());
        binaryInput.open();
        binaryInput.read();
        binaryInput.close();
    }
    
    private static BinaryOutput createBinOut(){
        System.out.print("Nombre del archivo: ");
        BinaryOutput out = new BinaryOutput("src/" + sc.nextLine() + ".bin");
        if (out.exists()){
            System.out.println("Archivo existente, sobreescribir? [Y/N]");
            if(sc.next().toUpperCase().charAt(0) ==  'N')
                createBinOut();
        }
        
        return out;
    }
    
    public static void createConsecIntBinaryFile(BinaryOutput out){
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
            System.out.println(e.getMessage());
        }
        out.close();
    }
    
    private static int getInt() throws InputMismatchException{
        System.out.print("=> ");
        int n = sc.nextInt();
        return n;
    }
}
