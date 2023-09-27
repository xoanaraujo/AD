package util;

import java.io.*;

public class WriteObj extends FileIO{

    ObjectOutputStream oos;

    public WriteObj(String path) {
        super(path);
    }

    @Override
    public void open(){
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void openBuff(){
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));
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

    public void writeObj(Object obj){
        try {
            oos.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
