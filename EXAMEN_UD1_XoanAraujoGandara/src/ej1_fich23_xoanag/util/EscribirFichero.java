package ej1_fich23_xoanag.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero extends FileIO{
    private BufferedWriter bffWriter;

    public EscribirFichero(File mainFile) {
        super(mainFile);
    }

    @Override
    public void open() {
        try {
            bffWriter = new BufferedWriter(new FileWriter(mainFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            bffWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escribirLinea(String linea){
        try {
            bffWriter.write(linea);
            bffWriter.newLine();;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
