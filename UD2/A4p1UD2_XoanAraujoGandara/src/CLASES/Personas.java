package CLASES;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alberto Paz Pérez
 */
@XmlRootElement(name = "Personas")
public class Personas implements Serializable{   
    
    ArrayList<Estudiante> estudiantes;   
    
    ArrayList<Trabajador> trabajadores;

    public Personas() {
    }

    public Personas(ArrayList<Estudiante> estudiantes, ArrayList<Trabajador> trabajadores) {
        this.estudiantes = estudiantes;
        this.trabajadores = trabajadores;
    }

    @XmlElement (name = "Estudiante")
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
//    @XmlElementWrapper(name = "Trabajador")
//    @XmlElement(name = "Trabajador", type = Trabajador.class)
     @XmlElement (name = "Trabajador")
    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    
    
}
