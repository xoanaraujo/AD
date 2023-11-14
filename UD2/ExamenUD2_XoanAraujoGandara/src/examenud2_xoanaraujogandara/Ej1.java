/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenud2_xoanaraujogandara;

import model.Empresa;
import model.Empleado;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author usuario
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList();
        empleados.add(new Empleado("12345678C", "Carlos Perez Ruiz", 29));
        empleados.add(new Empleado("87654321C", "Claudia Ortiz Zaldo", 31));
        empleados.add(new Empleado("87654325T", "Carlos Perez Perez", 30));

        Empresa empresa = new Empresa("A58818501", "TECNOMUR S.L.", empleados);
        
        JAXBContext contexto;
        Marshaller marshaller;
        try {
            contexto = JAXBContext.newInstance(Empresa.class);
            marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(empresa, System.out);
        } catch (JAXBException ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
    }
    
}
