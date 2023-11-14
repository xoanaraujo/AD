package CLASES;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Alberto Paz Pérez
 */
//El root debe ser el mismo nombre exacto que en el XML
@XmlRootElement(name = "Modulo")
//El prop order debe tener los nombres de tus atributos de clase
@XmlType(propOrder = {"nome", "contenido"})
public class Modulo {
    
    String nome;
    
    @XmlElementWrapper(name = "Contidos")
    @XmlElement(name = "Bloque", type = Bloque.class)
    ArrayList <Bloque> contenido;

    public Modulo() {
    }

    public Modulo(String nome, ArrayList<Bloque> contenido) {
        this.nome = nome;
        this.contenido = contenido;
    }

    //Esto tiene que ser igual al del XML
    @XmlElement (name = "Nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Bloque> getContenido() {
        return contenido;
    }

    public void setContenido(ArrayList contenido) {
        this.contenido = contenido;
    }  
    
    
    
}
