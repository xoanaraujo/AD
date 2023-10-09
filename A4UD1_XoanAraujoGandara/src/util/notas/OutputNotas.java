package util.notas;

import util.FileIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputNotas extends FileIO {

    private ObjectOutputStream oos;

    public OutputNotas(File mainFile) {
        super(mainFile);
    }

    @Override
    public void open() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(mainFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
