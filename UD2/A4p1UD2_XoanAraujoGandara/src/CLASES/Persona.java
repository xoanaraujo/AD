package CLASES;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Alberto Paz Pérez
 */
//El prop order debe tener los nombres de tus atributos de clase
@XmlType(propOrder = {"nombre", "edad", "infoContacto"})
public class Persona implements Serializable{
    String nombre;
    int edad;

    InformacionContacto infoContacto;
    
    public Persona() {
    }

    public Persona(String nombre, int edad, InformacionContacto infoContacto) {
        this.nombre = nombre;
        this.edad = edad;
        this.infoContacto = infoContacto;
    }

 
    @XmlElement (name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement (name = "Edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @XmlElement (name = "Informacion Contacto")
    public InformacionContacto getInfoContacto() {
        return infoContacto;
    }

    public void setInfoContacto(InformacionContacto infoContacto) {
        this.infoContacto = infoContacto;
    }


    
    
    
}
