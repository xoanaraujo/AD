package ej1_fich23_xoanag.util;

import ej1_fich23_xoanag.model.Dentista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class IODentista extends FileIO{
    public static final int REG_SIZE = 150;
    private RandomAccessFile raf;
    public IODentista(File mainFile) {
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

    public void escribirDentista(Dentista dentista, int pos){
        try {
            raf.seek((long) pos * REG_SIZE);
            raf.writeInt(dentista.getNumero());
            raf.writeUTF(dentista.getNombre());
            raf.writeUTF(dentista.getNumColegiado());
            ArrayList<Integer> pacientes = dentista.getPacientes();
            raf.writeInt(pacientes.size());
            for (Integer numPaciente : pacientes) {
                raf.writeInt(numPaciente);
            }
            raf.writeBoolean(dentista.isBaja());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Dentista leerDentista(int pos){
        Dentista dentista;
        try {
            raf.seek((long) pos * REG_SIZE);
            int numero = raf.readInt();
            String nombre = raf.readUTF();
            String numColegiado = raf.readUTF();
            ArrayList<Integer> pacientes = new ArrayList<>();
            int size = raf.readInt();
            for (int i = 0; i < size; i++) {
                pacientes.add(raf.readInt());
            }
            boolean baja = raf.readBoolean();
            dentista = new Dentista(numero, nombre, numColegiado, pacientes, baja);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dentista;
    }
}
