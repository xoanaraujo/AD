package ej1_a4p1ud2_xoanaraujogandara;

import CLASES.Empleado;
import CLASES.Empresa;

import java.util.ArrayList;

public class EJ1 {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList();
        empleados.add(new Empleado("12345678C", "Carlos Perez Ruiz", 29));
        empleados.add(new Empleado("87654321C", "Claudia Ortiz Zaldo", 31));
        empleados.add(new Empleado("87654325T", "Carlos Perez Perez", 30));

        Empresa empresa = new Empresa("A58818501", "TECNOMUR S.L.", empleados);
    }
}
