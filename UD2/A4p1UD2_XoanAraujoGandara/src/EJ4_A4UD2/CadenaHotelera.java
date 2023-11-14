package EJ4_A4UD2;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alberto Paz Pérez
 */
@XmlRootElement (name = "CadenaHotelera")
@XmlType(propOrder = {"nombre", "CIF", "hoteles"})
public class CadenaHotelera implements Serializable {  
    String nombre;  
    String CIF;
    ArrayList<Hotel> hoteles;
    
    public CadenaHotelera() {
    }

    public CadenaHotelera(String nombre, String CIF, ArrayList<Hotel> hoteles) {
        this.nombre = nombre;
        this.CIF = CIF;
        this.hoteles = hoteles;
    }

    @XmlAttribute(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlAttribute(name = "CIF")
    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }
    
     public void nuevoHotel(Hotel hotel) {
        hoteles.add(hotel);
    }
    
    
    
}
