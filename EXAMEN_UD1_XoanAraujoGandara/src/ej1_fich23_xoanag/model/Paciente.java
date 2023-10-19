package ej1_fich23_xoanag.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Paciente implements Serializable {
    private static final long serialVersionUID = 120L;
    private int numPaciente;
    private Datos datosPaciente;
    private ArrayList<String> telefonos;

    public int getNumPaciente() {
        return numPaciente;
    }

    public Datos getDatosPaciente() {
        return datosPaciente;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public Paciente(int numPaciente, Datos datosPaciente, ArrayList<String> telefonos) {
        this.numPaciente = numPaciente;
        this.datosPaciente = datosPaciente;
        this.telefonos = telefonos;
    }
}
