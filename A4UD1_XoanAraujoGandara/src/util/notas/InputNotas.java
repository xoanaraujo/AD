package util.notas;

import util.FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputNotas extends FileIO {
    private ObjectInputStream ois;

    public InputNotas(File mainFile) {
        super(mainFile);
    }

    @Override
    public void open() {
        try {
            ois = new ObjectInputStream(new FileInputStream(mainFile));
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
}
