
/*
    Xoan Araujo Gandara
    77550086C
 */

package ej1_fich23_xoanag.main;

import ej1_fich23_xoanag.model.Datos;
import ej1_fich23_xoanag.model.Dentista;
import ej1_fich23_xoanag.model.Paciente;
import ej1_fich23_xoanag.util.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Operaciones {
    private static Integer nPacientes;
    private static Integer nDentistas;
    private static final Integer REG_SIZE = IODentista.REG_SIZE;
    private static final String PATH_PACIENTES = "Pacientes.dat";
    private static final String PATH_DENTISTAS = "Dentistas.dat";
    private static final IODentista ioDentista = new IODentista(new File(PATH_DENTISTAS));
    private static final InputPaciente inPaciente = new InputPaciente(new File(PATH_PACIENTES));
    private static final OutputPaciente outPaciente = new OutputPaciente(new File(PATH_PACIENTES));
    private static final Scanner sc = new Scanner(System.in);

    public static void iniciarPacientes() {
        File file = new File(PATH_PACIENTES);
        try {
            if (file.createNewFile()) {
                nPacientes = 0;
            } else {
                inPaciente.open();
                nPacientes = inPaciente.getNumPacientes();
                inPaciente.close();
            }
            System.out.println("Numero de pacientes: " + nPacientes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void iniciarDentistas() {
        File file = new File(PATH_DENTISTAS);
        try {
            if (file.createNewFile()) {
                nDentistas = 0;
            } else {
                nDentistas = (int) Math.ceil((double) file.length() / REG_SIZE);
            }
            System.out.println("Numero de alumnos registrados: " + nDentistas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void altaPaciente(String dni, String nombre, String apellido1, String apellido2, LocalDate fecha, ArrayList<String> telefonos) {
        iniciarPacientes();
        if (dniExiste(dni)) {
            System.out.println("Paciente ya registrado");
        } else {
            try {
                int numPaciente = nPacientes + 1;
                StringBuilder historia = new StringBuilder();
                historia.append(numPaciente).append(nombre.charAt(0)).append(apellido1, 0, 4).append(apellido2, 0, 4);

                Datos datosPaciente = new Datos(dni, nombre, apellido1, apellido2, fecha, historia.toString().toUpperCase(), LocalDate.now());
                Paciente paciente = new Paciente(numPaciente, datosPaciente, telefonos);
                if (nPacientes == 0) {
                    outPaciente.openWithHeader();
                } else {
                    outPaciente.open();
                }
                outPaciente.escribirPaciente(paciente);
                outPaciente.close();
                nPacientes++;
                leerPacientes();
            } catch (Exception e) {
                e.printStackTrace();
                //System.out.println("Error inesperado. Paciente no registrado");
            }
        }
    }

    public static void altaPaciente() {
        LeerFichero leerFichero = new LeerFichero(new File("datosPacientes.txt"));
        String linea;
        leerFichero.open();
        while ((linea = leerFichero.leerLinea()) != null){
            System.out.println(linea);
            String[] datos = linea.split(";");
            String dni = datos[0];
            String nombre = datos[1];
            String apellido1 = datos[2];
            String apellido2 = datos[3];
            LocalDate fechaNac = LocalDate.parse(datos[4]);
            ArrayList<String> telefonos = new ArrayList<>();
            for (int i = 5; i < datos.length; i++) {
                telefonos.add(datos[i]);
            }
            altaPaciente(dni, nombre, apellido1, apellido2, fechaNac, telefonos);
        }
        leerFichero.close();
    }

    private static void guardarRegistro(Paciente[] pacientes){
        EscribirFichero escribirFichero = new EscribirFichero(new File("datosRegistro.txt"));
        escribirFichero.open();
        for (int i = 0; i < pacientes.length; i++) {
            escribirFichero.escribirLinea(pacientes[i].getNumPaciente() + "   " +
                    pacientes[i].getDatosPaciente().getNombre() + "   " +
                    pacientes[i].getDatosPaciente().getApellido1() + "   " +
                    pacientes[i].getDatosPaciente().getApellido2() + "   " +
                    pacientes[i].getDatosPaciente().getNumHistoria() + "   " +
                    pacientes[i].getDatosPaciente().getFechaAlta()
            );
        }
        escribirFichero.close();
    }

    private static void leerPacientes() {
        iniciarPacientes();
        inPaciente.open();
        Paciente[] pacientes = new Paciente[nPacientes];
        for (int i = 0; i < nPacientes; i++) {
            Paciente paciente = inPaciente.leerPaciente();
            pacientes[i] = paciente;
            Datos datPac = paciente.getDatosPaciente();
            System.out.println("------------------------------------------------");
            System.out.println("Paciente numero" + paciente.getNumPaciente());
            System.out.println("------------------------------------------------");
            System.out.println("Nombre: " + datPac.getNombre() + " " + datPac.getApellido1() + " " + datPac.getApellido2() + " DNI: " + datPac.getDni());
            System.out.println("Fecha nacimiento " + datPac.getFechaNacimiento().toString() + " EDAD: " + (LocalDate.now().getYear() - datPac.getFechaNacimiento().getYear()) + " anhos");
            StringBuilder telefonosBuilder = new StringBuilder();
            ArrayList<String> telefonos = paciente.getTelefonos();
            for (String telefono : telefonos) {
                telefonosBuilder.append(telefono).append(" ");
            }
            System.out.println("Telefonos: " + telefonosBuilder);
            System.out.println("Numero de Historia: " + datPac.getNumHistoria());
            System.out.println("Registro creado el " + datPac.getFechaAlta().toString());
            System.out.println("------------------------------------------------");
        }
        guardarRegistro(pacientes);
        inPaciente.close();
    }

    public static void altaDentista(String nombre, String numColegiado, ArrayList<Integer> pacientes) {
        iniciarDentistas();
        iniciarPacientes();
        if(numColegiadoExiste(numColegiado)){
            System.out.println("Dentista ya registrado.");
        } else if(pacientesDuplicados(pacientes) ){
            System.out.println("Pacientes duplicados. NO se ha dado de alta al dentista.");
        } else if(!existenPacientes(pacientes)){
            System.out.println("Se detecto paciente inexistente. NO se ha dado de alta al dentista");
        }else {
            ioDentista.open();
            Dentista dentista = new Dentista(nDentistas + 1, nombre, numColegiado, pacientes);
            ioDentista.escribirDentista(dentista, nDentistas);
            ioDentista.close();
            nDentistas++;
            leerDentistas();
        }
    }

    public static void leerDatosDentista(int pos){
        iniciarDentistas();
        iniciarPacientes();
        ioDentista.open();
        Dentista dentista = ioDentista.leerDentista(pos - 1);
        System.out.println("------------------------------------------------");
        System.out.println("Dentista numero " + dentista.getNumero());
        System.out.println("------------------------------------------------");
        System.out.println("Nombre: " + dentista.getNombre() + "Numero de colegiado: " + dentista.getNumColegiado());
        System.out.println("Estado: " + (dentista.isBaja() ? "BAJA" : "ALTA"));
        System.out.println("------------------------------------------------");
        System.out.println("PACIENTES");
        ArrayList<Integer> pacientes = dentista.getPacientes();
        for (int i = 0; i < pacientes.size(); i++) {
            inPaciente.open();
            System.out.println("");
            Paciente paciente = inPaciente.leerPaciente(i);
            System.out.println(paciente.getNumPaciente() + "- " + paciente.getDatosPaciente().getNombre());
            inPaciente.close();
        }
        ioDentista.close();

        System.out.println("Dar de baja al dentista o paciente? [1] Si [2] No");
        int op = sc.nextInt();
        sc.nextLine();
        if(op == 1){
            System.out.println("[1] Dentista");
            System.out.println("[2] Paciente");
            op = sc.nextInt();
            sc.nextLine();
            if (op == 1){
                dentista.setBaja(true);
            } else {
                System.out.println("Que paciente?");
                op = sc.nextInt();
                sc.nextLine();
                try {
                    pacientes.remove(op);
                } catch (IndexOutOfBoundsException e){
                    System.out.println("El paciente no se encuentra en la lista");
                }
            }
        ioDentista.open();
        ioDentista.escribirDentista(dentista, pos - 1);
        ioDentista.close();
        leerDatosDentista(pos);
        }
    }

    private static void leerDentistas(){
        iniciarDentistas();
        ioDentista.open();
        for (int i = 0; i < nDentistas; i++) {
            Dentista dentista = ioDentista.leerDentista(i);
            if(!dentista.isBaja()){
                System.out.println("------------------------------------------------");
                System.out.println("Dentista numero " + dentista.getNumero());
                System.out.println("------------------------------------------------");
                System.out.println("Numero de colegiado: " + dentista.getNumColegiado());
                System.out.println("Nombre: " + dentista.getNombre());
                ArrayList<Integer> pacientes = dentista.getPacientes();
                StringBuilder pacientesBuilder = new StringBuilder("Pacientes: ");
                for (Integer numPaciente : pacientes) {
                    pacientesBuilder.append(numPaciente).append(" ");
                }
                System.out.println(pacientesBuilder);
                System.out.println("------------------------------------------------");
            }
        }
    }

    private static boolean dniExiste(String dniPaciente) {
        if (nPacientes > 0) {
            inPaciente.open();
            for (int i = 0; i < nPacientes; i++) {
                Paciente paciente = inPaciente.leerPaciente();
                if (paciente.getDatosPaciente().getDni().equals(dniPaciente)) {
                    return true;
                }
            }
            inPaciente.close();
        }
        return false;
    }

    private static boolean numColegiadoExiste(String numColegiado) {
        if (nDentistas > 0) {
            ioDentista.open();
            for (int i = 0; i < nDentistas; i++) {
                Dentista dentista = ioDentista.leerDentista(i);
                if (dentista.getNumColegiado().equals(numColegiado)){
                    return true;
                }
            }
            ioDentista.close();
        }
        return false;
    }

    private static boolean pacientesDuplicados(ArrayList<Integer> pacientes){
        for (int i = 0; i < pacientes.size(); i++) {
            for (int j = 0; j < pacientes.size(); j++) {
                if(j != i)
                    if(pacientes.get(i).equals(pacientes.get(j)))
                        return true;
            }
        }

        return false;
    }

    private static boolean existenPacientes(ArrayList<Integer> pacientes){

        for (int i = 0; i < pacientes.size(); i++) {
            if (!existePaciente(pacientes.get(i)))
                return false;
        }

        return true;
    }
    private static boolean existePaciente(int n){
        if (nPacientes > 0){
            inPaciente.open();
            for (int i = 0; i < nPacientes; i++) {
                if(inPaciente.leerPaciente().getNumPaciente() == n){
                    return true;
                }
            }
            inPaciente.close();
        }
        return false;
    }
}
