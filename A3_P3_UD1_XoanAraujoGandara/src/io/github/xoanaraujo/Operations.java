package io.github.xoanaraujo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Operations {

    private static Scanner sc = new Scanner(System.in);

    private static final String PATH = "data/corredores.dat";
    private static ArrayList<Runner> runners;


    public static void init(){
        try {
            if (!new File(PATH).createNewFile()){
                loadFile();
            } else {
                runners = new ArrayList<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveFile(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))){
            oos.writeObject(runners);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadFile() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))){
            runners = (ArrayList<Runner>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e){
            runners = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Runner findRunnerByDorsal(int dorsal){

        Runner runner = null;

        for (int i = 0; i < runners.size(); i++) {
            if(dorsal ==runners.get(i).getDorsal()){
                runner =runners.get(i);
            }
        }
        return runner;
    }

    private static int findRunnerPositionByDorsal(int dorsal){

        int pos = -1;

        for (int i = 0; i < runners.size(); i++) {
            if(dorsal ==runners.get(i).getDorsal()){
                pos = i;
            }
        }
        return pos;
    }

    public static void addRegis() {
        boolean addRunerOk = true;
        while (addRunerOk){
            System.out.print("[*] para CANCELAR) ");
            Runner runner = createRunner();
            if(runner != null)
                runners.add(runner);
            else
                addRunerOk = false;
        }
        saveFile();
    }

    private static Runner createRunner(){
        Runner runner;
        System.out.println("Nombre?");
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



    public static void printAllRegis() {
        for (Runner runner : runners) {
            printRunner(runner);
            System.out.println("================================");
        }
    }

    public static void printRegis() {
        System.out.println("Dorsal del jugador?");
        Runner runner = findRunnerByDorsal(sc.nextInt());
        if (runner != null){
            printRunner(runner);
        } else {
            System.out.println("No existe el jugador");
        }
    }

    private static void printRunner(Runner runner){
        System.out.println("Dorsal: " + runner.getDorsal() + " | Nombre: " + runner.getName() + " | Tiempo: " + runner.getTime());
    }

    public static void modRegis() {
        System.out.println("Dorsal del jugador?");
        int  pos = findRunnerPositionByDorsal(sc.nextInt());
        if (pos != -1){
            runners.set(pos, createRunner());
            saveFile();
        } else{
            System.out.println("No existe el jugador");
        }
    }

    public static void delete() {
        System.out.println("Dorsal del jugador?");
        Runner runner = findRunnerByDorsal(sc.nextInt());
        if (runner != null){
            runners.remove(runner);
            saveFile();
        } else {
            System.out.println("No existe el jugador");
        }

    }
}
