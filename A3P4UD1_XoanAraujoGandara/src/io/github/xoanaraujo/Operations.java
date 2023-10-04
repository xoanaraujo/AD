package io.github.xoanaraujo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Operations {

    private static Integer Nreg;

    private static final int REG_SIZE = 80;

    public static final String PATH = "data/corredores.dat";

    private static final Scanner sc = new Scanner(System.in);

    public static void init() {
        try {
            File file = new File(PATH);
            if ((file.createNewFile())) {
                System.out.println("No existe el archivo. Archivo creado.");
                Nreg = 0;
            } else {
                Nreg = (int) Math.ceil((double) file.length() / REG_SIZE);
                System.out.println("Numero de registros: " + Nreg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addRegis() {
        String name;

        boolean addOk = true;
        System.out.println("Introduce [*] para cancelar la operacion");
        while (addOk) {
            System.out.println("Nombre?");
            name = sc.nextLine();
            if (!name.equals("*")) {
                System.out.println("Tiempo?");
                int time = sc.nextInt();
                sc.nextLine();
                writeRunner(new Runner(name, Nreg + 1, time), Nreg);
                Nreg ++;
            } else {
                addOk = false;
                System.out.println("OPERACION CANCELADA");
            }
        }
    }

    public static void printRegis() {
        System.out.println("Dorsal del corredor?");
        int dorsal = sc.nextInt();
        if (runnerExists(dorsal - 1)){
            printRunner(readRunner(dorsal - 1));;
        }
    }

    public static void printAllRegis() {
        for (int i = 0; i < Nreg; i++) {
            printRunner(readRunner(i));
        }
    }

    private static void printRunner(Runner runner){
        if(!runner.isDeleted())
            System.out.println(runner.getDorsal() + ". " + runner.getName() + ", tiempo: " + runner.getTime());
    }

    public static void modRegis() {
        System.out.println("Dorsal?");
        int dorsal = sc.nextInt();
        if (runnerExists(dorsal - 1)){
            Runner runner = readRunner(dorsal);
            if (!runner.isDeleted()){
                printRunner(runner);
                sc.nextLine();
                System.out.println("Quieres modificar este corredor? [1] Si [2] No");
                int op = sc.nextInt();
                sc.nextLine();
                if(op == 1){
                    System.out.println("Nuevo nombre?");
                    String name = sc.nextLine();
                    System.out.println("Nuevo tiempo?");
                    int time = sc.nextInt();
                    writeRunner(new Runner(name, runner.getDorsal(), time), dorsal - 1);
                }
            }
        }
    }

    public static void delete() {
        System.out.println("Dorsal?");
        int dorsal = sc.nextInt();
        if (runnerExists(dorsal - 1)){
            Runner runner = readRunner(dorsal - 1);
            if (!runner.isDeleted()) {
                printRunner(runner);
                sc.nextLine();
                System.out.println("Quieres borrar este corredor? [1] Si [2] No");
                int op = sc.nextInt();
                sc.nextLine();
                if (op == 1){
                    writeRunner(new Runner(runner.getName(), runner.getDorsal(), runner.getTime(), true), runner.getDorsal() - 1);
                }
            } else {
                System.out.println("Corredor ya  eliminado");
            }
        }
    }

    private static void writeRunner(Runner runner, int pos) {
        try (RandomAccessFile raf = new RandomAccessFile(PATH, "rw")) {
            raf.seek((long) pos * REG_SIZE);
            raf.writeInt(runner.getDorsal());
            raf.writeUTF(runner.getName());
            raf.writeInt(runner.getTime());
            raf.writeBoolean(runner.isDeleted());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Runner readRunner(int pos) {
        Runner runner;
        try (RandomAccessFile raf = new RandomAccessFile(PATH, "r")) {
            raf.seek((long) (pos) * REG_SIZE);
            int dorsal = raf.readInt();
            String name = raf.readUTF();
            int time = raf.readInt();
            boolean deleted = raf.readBoolean();
            runner = new Runner(name, dorsal, time, deleted);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return runner;
    }

    private static boolean runnerExists(int pos){
        return 0 <= pos && pos <= Nreg;
    }
}
