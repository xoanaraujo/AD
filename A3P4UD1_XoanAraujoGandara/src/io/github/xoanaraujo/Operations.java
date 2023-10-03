package io.github.xoanaraujo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Operations {

    public static final String PATH = "data/corredores.dat";

    public static void init() {
        try {
            if((new File(PATH).createNewFile())){
                System.out.println("No existe el archivo. Archivo creado.");
            } else {
                for (int i = 0; i < ; i++) {
                    
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addRegis() {

    }

    public static void printRegis() {
    }

    public static void printAllRegis() {
    }

    public static void modRegis() {
    }

    public static void delete() {
    }

    private static void writeToFile(int pos, String data){
        try(RandomAccessFile raf = new RandomAccessFile(PATH, "rw")){
            raf.seek(pos);
            raf.write(data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] readFromFile(int pos, int size){
        byte[] bytes = new byte[size];

        try(RandomAccessFile raf = new RandomAccessFile(PATH, "r")){
            raf.seek(pos);
            raf.read(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bytes;
    }
}
