/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ1_A3_UD1_XoanAraujoGandara;

//import java.util.Random;
import java.util.Random;
import java.util.Scanner;
import util.BinaryInput;
import util.BinaryOutput;

/**
 *
 * @author usuario
 */
public class EJ1_A3_UD1_XoanAraujoGandara {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nombre del archivo: ");
        String name = sc.nextLine();
        String path = "src/" + name + ".bin";
        BinaryOutput binOutput = new BinaryOutput(path);
        int arr[] = generateRdIntArray(150, 20, 80);
        
        binOutput.open();
        for(Integer integer : arr){
            binOutput.write(integer);
        }
        binOutput.close();
        BinaryInput in = new BinaryInput(path);
        in.open();
        in.read();
        in.close();
    }
    private static int[] generateRdIntArray(int n, int min, int max){
        Random rd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(min, max + 1);
        }
        return arr;
    }
}
