package CLASES;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Alberto Paz Pérez
 */
public class Direccion implements Serializable {
    String calle;
    int numero;
    String localidad;
    String provincia;

    public Direccion() {
    }

    public Direccion(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    @XmlElement (name = "Calle")
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @XmlElement (name = "Numero")
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @XmlElement (name = "Localidad")
    public String getLocalidad() {
        return localidad;
    }

    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @XmlElement (name = "Provincia")
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", numero=" + numero + ", localidad=" + localidad + ", provincia=" + provincia + '}';
    }
    
    
}
