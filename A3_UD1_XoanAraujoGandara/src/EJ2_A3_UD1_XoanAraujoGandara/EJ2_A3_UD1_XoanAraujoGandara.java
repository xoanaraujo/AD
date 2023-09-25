 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ2_A3_UD1_XoanAraujoGandara;

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
        while(out.exists()){
            System.out.println("Archivo existente.");
            createBin();
        }
        BinaryInput in = new BinaryInput(path);
        boolean isInt = true;
        System.out.println("<===>");
        while (isInt) {            
            try {
                int b = 0;
                try{
                    b = in.getIn().readInt();
                } catch (NullPointerException e ) {
                    b = getInt();
                } catch(IOException e1){
                    System.out.println(e1.getMessage());
                }
                int a = getInt();
                if (b > a) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                out.open();
                out.write(a);
                out.write(b);
                out.close();
            } catch (InputMismatchException e) {
                System.out.println("<===>");
                isInt = false;
            }
            in.read();
        }
    }
    
    private static String createBin(){
        System.out.print("Nombre del archivo: ");
        return "src/" + sc.nextLine() + ".bin";
    }
    
    private static int getInt() throws InputMismatchException{
        return sc.nextInt();
    }
}
