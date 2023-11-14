package CLASES;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;

/**
 *
 * @author Alberto Paz Pérez
 */
public class InformacionContacto implements Serializable{
    Direccion direccion;
    ArrayList<String> telefonos;

    public InformacionContacto() {
    }

    public InformacionContacto(Direccion direccion, ArrayList<String> telefonos) {
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    @XmlElement (name = "Direccion")
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @XmlElement (name = "Telefonos")
    @XmlList
    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }
    
    
}
