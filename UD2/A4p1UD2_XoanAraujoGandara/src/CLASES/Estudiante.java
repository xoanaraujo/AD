package CLASES;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alberto Paz Pérez
 */
//El prop order debe tener los nombres de tus atributos de clase
@XmlType(propOrder = {"universidad", "carrera"})
public class Estudiante extends Persona implements Serializable{
    String universidad;
    String carrera;

    
    public Estudiante() {
    }

    public Estudiante(String universidad, String carrera, String nombre, 
            int edad, InformacionContacto infoContacto) {
        super(nombre, edad, infoContacto);
        this.universidad = universidad;
        this.carrera = carrera;
    }

    @XmlElement (name = "Universidad")
    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    @XmlElement (name = "Carrera")
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }



   

 

    

   
   
    
}
