/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author XoanAraujo <io.github.xoanaraujo>
 */
@XmlRootElement(name = "Empresa")
@XmlType( propOrder = {"nombre", "empleados"})
public class Empresa {
    
    String cif;
    String nombre;
    ArrayList<Empleado> empleados;

    public Empresa(String cif, String nombre, ArrayList<Empleado> empleados) {
        this.cif = cif;
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public Empresa() {
    }
    
    @XmlAttribute(name ="cif")
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElementWrapper(name ="empleados")
    @XmlElement(name = "empleado", type = Empleado.class)
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    
}
