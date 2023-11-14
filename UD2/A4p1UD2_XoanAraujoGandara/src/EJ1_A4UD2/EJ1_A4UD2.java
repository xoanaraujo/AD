package EJ1_A4UD2;

import CLASES.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Alberto Paz Pérez
 */

public class EJ1_A4UD2 {

    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList();
        empleados.add(new Empleado("12345678C", "Carlos Perez Ruiz", 29));
        empleados.add(new Empleado("87654321C", "Claudia Ortiz Zaldo", 31));
        empleados.add(new Empleado("87654325T", "Carlos Perez Perez", 30));

        Empresa empresa = new Empresa("A58818501", "TECNOMUR S.L.", empleados);

        JAXBContext contexto = null;
        Marshaller m = null;
        try {
            contexto = JAXBContext.newInstance(Empresa.class);
            m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(empresa, System.out);
            
        } catch (JAXBException ex) {
            ex.printStackTrace();
            System.out.println("error al crear el objeto Marshaller");
        }

    }

}
