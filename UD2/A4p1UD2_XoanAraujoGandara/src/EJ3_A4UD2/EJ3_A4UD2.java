package EJ3_A4UD2;

import CLASES.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Alberto Paz Pérez
 */
public class EJ3_A4UD2 {

    public static void main(String[] args) throws JAXBException, IOException {
        ArrayList<String> telefonos1 = new ArrayList();
        telefonos1.add("123456789");
        telefonos1.add("000000000");
        Estudiante estu1 =  new Estudiante("FIC", "Ing. informatica", "Enrique", 
        20, new InformacionContacto(new Direccion("Luna", 6, "Pontevedra", "Pontevedra"), telefonos1));
    
        ArrayList<String> telefonos2 = new ArrayList();
        telefonos2.add("987654321");
        telefonos2.add("111111111");
        Estudiante estu2 =  new Estudiante("FIC", "Ing. informatica", "Carlos", 
        25, new InformacionContacto(new Direccion("Sol", 7, "Pontevedra", "Pontevedra"), telefonos2));
    
        
        ArrayList<String> telefonos3 = new ArrayList();
        telefonos3.add("123459876");
        telefonos3.add("222222222");
        Trabajador trabajador =  new Trabajador("PcComponentes", "Director", 2000, "Lucio", 
        31, new InformacionContacto(new Direccion("Noche", 8, "Barcelona", "Barcelona"), telefonos3));
        
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estu1);
        estudiantes.add(estu2);
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        trabajadores.add(trabajador);
        
        Personas personas = new Personas(estudiantes,trabajadores);
        JAXBContext contexto = null;
        Marshaller m = null;
        
        try {
            contexto = JAXBContext.newInstance(Personas.class);
            m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Writer w = new FileWriter("Personas.xml");
            m.marshal(personas, w);
        } catch (JAXBException ex) {
            ex.printStackTrace();
            System.out.println("error al crear el objeto Marshaller");
        }
    }

}
