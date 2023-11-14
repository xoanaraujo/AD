package EJ4_A4UD2;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alberto Paz Pérez
 */
@XmlType(propOrder = {"nombre", "telefonos", "direccion"})
public class Hotel implements Serializable {
    int codigoHotel;
    
    String nombre;
    ArrayList<String> telefonos;
    Direccion direccion;
    static final long serialVersionUID = 7727413654269650764L;

    public Hotel(int codigoHotel, String nombre, ArrayList<String> telefonos, Direccion direccion) {
        this.codigoHotel = codigoHotel;
        this.nombre = nombre;
        this.telefonos = telefonos;
        this.direccion = direccion;
    }

    @XmlAttribute(name = "id")
    public int getCodigoHotel() {
        return codigoHotel;
    }

    public void setCodigoHotel(int codigoHotel) {
        this.codigoHotel = codigoHotel;
    }

    @XmlElement (name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement (name = "Telefonos")
    @XmlList
    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    @XmlElement (name = "Direccion")
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
