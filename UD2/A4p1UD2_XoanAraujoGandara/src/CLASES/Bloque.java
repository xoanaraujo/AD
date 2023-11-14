package CLASES;


/**
 *
 * @author Alberto Paz Pérez
 */
@XmlType(propOrder = {"titulo", "descripcion"})
public class Bloque { 
    int sesions; 
    int numero;       
    String titulo;   
    String descripcion;

    public Bloque() {
    }

    public Bloque(int sesions, int numero, String titulo, String descripcion) {
        this.sesions = sesions;
        this.numero = numero;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    @XmlAttribute(name = "sesions")
    public int getSesions() {
        return sesions;
    }

    public void setSesions(int sesions) {
        this.sesions = sesions;
    }

    @XmlAttribute(name = "num")
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @XmlElement (name = "Titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlElement (name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
