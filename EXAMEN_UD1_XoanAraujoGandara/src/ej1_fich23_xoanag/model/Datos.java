package ej1_fich23_xoanag.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Datos implements Serializable {
    private static final long serialVersionUID = 120L;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
    private String numHistoria;
    private LocalDate fechaAlta;

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNumHistoria() {
        return numHistoria;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public Datos(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String numHistoria, LocalDate fechaAlta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.numHistoria = numHistoria;
        this.fechaAlta = fechaAlta;
    }
}
