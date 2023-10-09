package io.github.xoanaraujo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObj extends FileIO{

    private ObjectInputStream ois;
    public ReadObj(String path) {
        super(path);
    }

    @Override
    public void open() {
        try {
            ois = new ObjectInputStream(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

@Override
    public void close() {
        try {
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object readObj(){
        try {
            return ois.readObject();
        } catch (IOException e) {
            System.out.println("Fin de fichero.");
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
