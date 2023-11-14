/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author XoanAraujo <io.github.xoanaraujo>
 */
public class Estudiante extends Persona{
    private String universidad, carrera;

    public Estudiante(String universidad, String carrera, String nombre, int edad, ArrayList<String> telefonos) {
        super(nombre, edad, telefonos);
        this.universidad = universidad;
        this.carrera = carrera;
    }
    
    public Estudiante() {
    }
    
    
}
