package ej1_fich23_xoanag.util;


import ej1_fich23_xoanag.model.Paciente;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputPaciente extends FileIO {

    private ObjectOutputStream oos;

    public OutputPaciente(File mainFile) {
        super(mainFile);
    }

    @Override
    public void open() {
        try {
            oos = new MyObjectOutputStream(new FileOutputStream(mainFile, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void openWithHeader() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(mainFile, true));
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

    public void escribirPaciente(Paciente paciente){
        try {
            oos.writeObject(paciente);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
