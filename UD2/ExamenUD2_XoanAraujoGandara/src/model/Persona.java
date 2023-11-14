/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;

/**
 *
 * @author XoanAraujo <io.github.xoanaraujo>
 */
@XmlType(propOrder = {"nombre", "edad", "nombre"})
public abstract class Persona {
    private String nombre;
    private int edad;
    private ArrayList<String> telefonos;

    public Persona(String nombre, int edad, ArrayList<String> telefonos) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefonos = telefonos;
    }

    public Persona() {
    }

    
    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement(name = "edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @XmlList()
    @XmlElement(name = "informacion")
    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }
    
    
    
}
