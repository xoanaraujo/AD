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
@XmlType(propOrder = {"empresa", "puesto", "salario"})
public class Trabajador extends Persona implements Serializable{
    String empresa;
    String puesto;
    int salario;
    
    public Trabajador() {
    }

    public Trabajador(String empresa, String puesto, int salario, String nombre, 
            int edad,InformacionContacto infoContacto) {
        
        super(nombre, edad, infoContacto);
        this.empresa = empresa;
        this.puesto = puesto;
        this.salario = salario;
    }    

    @XmlElement (name = "Empresa")
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @XmlElement (name = "Puesto")
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @XmlElement (name = "Salario")
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "empresa=" + empresa + ", puesto=" + puesto + ", salario=" + salario + '}';
    }
    
    
}
