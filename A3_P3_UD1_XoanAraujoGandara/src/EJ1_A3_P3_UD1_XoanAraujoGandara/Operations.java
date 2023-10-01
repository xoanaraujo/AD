package EJ1_A3_P3_UD1_XoanAraujoGandara;

import util.ReadObj;
import util.WriteObj;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Operations {
    private static final String PATH = "res/data/corredores.dat";
    private static final Scanner sc = new Scanner(System.in);
    private static ReadObj readObj = new ReadObj(PATH);
    private static WriteObj writeObj = new WriteObj(PATH);

    public static boolean createFile(){
        try {
            return new File(PATH).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        System.out.println("Dorsal del corredor?");
        int dorsal = sc.nextInt();
        sc.nextLine();

        Runner runner;

        do{
        readObj.open();
        runner = (Runner) readObj.readObj();
        readObj.close();
        } while (dorsal != runner.getDorsal());

        printRunner(runner);
    }
    public static void printAllRegis() {
        readObj.open();
        Runner runner;
        do{
            runner = (Runner) readObj.readObj();
            printRunner(runner);
        } while (runner != null);
        readObj.close();
    }

    private static void printRunner(Runner runner){
        if(runner != null)
            System.out.println(runner.getName() + " " + runner.getDorsal() + " " + runner.getTime() + ".");
    }

    public static void modRegis() {
        System.out.println("Dorsal del corredor a modificar?");
        int dorsal = sc.nextInt();
        sc.nextLine();

        ObjectOutputStream tmpOos = new ObjectOutputStream(new BufferedOutputStream());

        Runner runner;

        tmpWriteObj.open();
        do{
            runner = (Runner) readObj.readObj();
            if(runner.getDorsal() == dorsal){

            }

        } while (runner.getDorsal() != dorsal);

    }

    public static void delete() {
    }

}
