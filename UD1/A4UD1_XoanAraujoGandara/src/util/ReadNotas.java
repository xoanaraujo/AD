package util;

import model.NotaAlumno;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadNotas extends FileIO{
    private static ObjectInputStream ois;

    public ReadNotas(String path) {
        super(path);
    }

    @Override
    public void open() throws FileNotFoundException {
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

    public NotaAlumno leerNotaAlumno(){
        try {
            return (NotaAlumno) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
