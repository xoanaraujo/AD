package CLASES;

import java.util.ArrayList;
import javax.swing.text.html.parser.AttributeList;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Alberto Paz Pérez
 */
@XmlRootElement()
@XmlType(propOrder = {"nombre", "empleados"})
public class Empresa {
   

    @XmlAttribute(name = "cif")
    private String cif;
    private String nombre;
    
    @XmlElementWrapper(name = "empleados")
    @XmlElement(name = "empleado", type = Empleado.class)
    private ArrayList<Empleado> empleados;

    public Empresa() {
    }

    public Empresa(String cif, String nombre, ArrayList<Empleado> empleados) {
        this.cif = cif;
        this.nombre = nombre;
        this.empleados = empleados;
    }

//    public String getCif() {
//        return cif;
//    }
//
//    public void setCif(String cif) {
//        this.cif = cif;
//    }

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}
