package EJ1_A3_P3_UD1_XoanAraujoGandara;

import util.ReadObj;
import util.WriteObj;

import java.io.File;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Operations {
    private static final Scanner sc = new Scanner(System.in);
    private static ReadObj readObj = new ReadObj("res/data/corredores.dat");
    private static WriteObj writeObj = new WriteObj("res/data/corredores.dat");

    private static ObjectOutputStream oos;

    public static void createFile(){
        System.out.println("Nombre del archivo:");
        File file = new File(sc.nextLine());
        if(file.exists()){
            System.out.println("Archivo existente. Sobreescribir? [Y]/[N]");
            char op;
            do{
                op = (char) sc.nextInt();
            } while(op != 'Y' && op != 'y' && op != 'N' && op != 'n');

            if(op == 'N' || op == 'n'){
                createFile();
            }
        }
        writeObj.openBuff();
        writeObj.close();
    }
    public static void addRegis() {
        writeObj.open();
        boolean addRunerOk = true;
        while (addRunerOk){
            Runner runner = addRunner();
            if(runner != null)
                writeObj.writeObj(runner);
            else
                addRunerOk = false;
        }
        writeObj.close();
    }

    private static Runner addRunner(){
        Runner runner;
        System.out.println("Nombre? ( * para cancelar operacion)");
        String name = sc.nextLine();
        if (name.equals("*")){
            runner = null;
        } else{
            System.out.println("Dorsal?");
            Integer dorsal = sc.nextInt();
            sc.nextLine();
            System.out.println("Tiempo? (En segundos)");
            Integer time = sc.nextInt();
            sc.nextLine();
            runner = new Runner(name, dorsal, time);
        }
        return runner;
    }

    public static void printRegis() {

    }
    public static void printAllRegis() {
        readObj.open();
        Runner runner;
        do{
            runner = (Runner) readObj.readObj();
            if(runner != null)
                System.out.println(runner.getName() + " " + runner.getDorsal() + " " + runner.getTime() + ".");
        } while (runner != null);
        readObj.close();
    }

    public static void modRegis() {

    }

    public static void delete() {
    }

}
