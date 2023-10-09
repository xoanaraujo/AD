package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteNotas extends FileIO{

    private ObjectOutputStream oos;

    public WriteNotas(String path) {
        super(path);
    }

    @Override
    public void open() throws FileNotFoundException {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
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
