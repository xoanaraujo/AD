package ej1_fich23_xoanag.util;

import java.io.*;

public class LeerFichero extends FileIO{
    private BufferedReader bffReader;
    public LeerFichero(File mainFile) {
        super(mainFile);
    }

    @Override
    public void open() {
        try {
            bffReader = new BufferedReader(new FileReader(mainFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            bffReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String leerLinea(){
        try {
            return bffReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
