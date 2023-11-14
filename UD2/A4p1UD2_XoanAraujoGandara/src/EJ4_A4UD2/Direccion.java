package EJ4_A4UD2;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alberto Paz Pérez
 */
@XmlType(propOrder = {"calle", "numero", "codigoPostal"})
public class Direccion implements Serializable {
    static final long serialVersionUID = 7727413654269650764L;
    String calle;
    int numero, codigoPostal;

    public Direccion(String calle, int numero, int codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
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

    @XmlElement (name = "CodigoPostal")
    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
}
