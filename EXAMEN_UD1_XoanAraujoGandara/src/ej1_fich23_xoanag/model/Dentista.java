package ej1_fich23_xoanag.model;

import java.util.ArrayList;

public class Dentista {
    private int numero;
    private String nombre;
    private String numColegiado;
    private ArrayList<Integer> pacientes;
    private boolean baja;

    public Dentista(int numero, String nombre, String numColegiado, ArrayList<Integer> pacientes) {
        this(numero, nombre, numColegiado, pacientes, false);
    }
    public Dentista(int numero, String nombre, String numColegiado, ArrayList<Integer> pacientes, boolean baja) {
        this.numero = numero;
        this.nombre = nombre;
        this.numColegiado = numColegiado;
        this.pacientes = pacientes;
        this.baja = baja;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public ArrayList<Integer> getPacientes() {
        return pacientes;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }
}
