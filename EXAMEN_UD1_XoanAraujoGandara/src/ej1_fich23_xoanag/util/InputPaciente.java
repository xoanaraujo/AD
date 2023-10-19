package ej1_fich23_xoanag.util;


import ej1_fich23_xoanag.model.Paciente;

import java.io.*;

public class InputPaciente extends FileIO {
    private ObjectInputStream ois;

    public InputPaciente(File mainFile) {
        super(mainFile);
    }

    @Override
    public void open() {
        try {
            ois = new ObjectInputStream(new FileInputStream(mainFile));
        } catch (IOException e) {
            e.printStackTrace();
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

    public Paciente leerPaciente(int pos){
        boolean esPacienteBuscado = false;
        int i = 0;
        Paciente paciente;
        try {
            do{
                paciente = (Paciente) ois.readObject();
                if (pos == i)
                    esPacienteBuscado = true;
                i++;
            } while (!esPacienteBuscado);
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }

    public Paciente leerPaciente(){
        try {
            return (Paciente) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getNumPacientes(){
        int nPacientes = 0;
        boolean hayPaciente = true;
        while (hayPaciente){
            try {
                ois.readObject();
                nPacientes++;
            } catch (EOFException e){
                hayPaciente = false;
                System.out.println("Fin de fichero");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        return nPacientes;
    }
}
