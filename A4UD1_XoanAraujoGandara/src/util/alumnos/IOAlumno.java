package util.alumnos;

import util.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IOAlumno extends FileIO {

    private RandomAccessFile raf;
    public IOAlumno(File mainFile) {
        super(mainFile);
    }

    @Override
    public void open() {
        try {
            raf = new RandomAccessFile(mainFile, "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
