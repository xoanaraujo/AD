package a4ud1_alumno;

import model.Alumno;
import model.Nombre;
import model.NotaAlumno;
import model.NotaModulo;
import util.alumnos.IOAlumno;
import util.notas.InputNotas;
import util.notas.OutputNotas;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Operaciones {
    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private static final String PATH_ALUMNOS = "alumnos.dat";
    private static final String PATH_NOTAS = "notasAlumnos.dat";
    private static int nAlumnos;
    private static final int REG_SIZE = 80;
    private static Scanner sc = new Scanner(System.in);
    private static final IOAlumno ioAlumno = new IOAlumno(new File(PATH_ALUMNOS));
    private static final InputNotas inputNotas = new InputNotas(new File(PATH_NOTAS));
    private static final OutputNotas outputNotas = new OutputNotas(new File(PATH_NOTAS));

    public static void iniciar() {
        File file = new File(PATH_ALUMNOS);
        try {
            if (file.createNewFile()) {
                nAlumnos = 0;
            } else {
                nAlumnos = (int) Math.ceil((double) file.length() / REG_SIZE);
            }
            System.out.println("Numero de alumnos registrados: " + nAlumnos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void nuevoAlumno() {
        boolean addAlumnoOk = true;
        while (addAlumnoOk) {
            System.out.println("Introduce * para cancelar");
            System.out.println("Nombre?");
            String nombre = sc.nextLine();
            if (nombre.equals("*")) {
                addAlumnoOk = false;
            } else {
                System.out.println("1er apellido?");
                String apellido1 = sc.nextLine();

                System.out.println("2ndo apellido?");
                String apellido2 = sc.nextLine();

                boolean dateOk = false;
                Date fechaNac = null;
                while (!dateOk) {
                    System.out.println("Fecha de nacimiento? Formato: dd/MM/yyyy");
                    String dateStr = sc.nextLine();
                    try {

                        fechaNac = format.parse(dateStr);
                        dateOk = true;
                    } catch (ParseException e) {
                        System.out.println("Formato incorrecto.");
                    }
                }
                boolean addTel = true;
                ArrayList<String> telefonos = new ArrayList<>();
                while (addTel){
                    System.out.println("Telefono? * para cancelar (minimo 1 telefono)");
                    String telefono = sc.nextLine();
                    if (telefono.equals("*") && !telefonos.isEmpty()){
                        addTel = false;
                    } else{
                        telefonos.add(telefono);
                    }
                }

                ArrayList<NotaModulo> notas = new ArrayList<>();
                boolean addNota = true;
                while (addNota){
                    System.out.println("Nombre modulo? Minimo 1 asignatura");
                    String asignatura = sc.nextLine();
                    if (asignatura.equals("*") && !notas.isEmpty()){
                        addNota = false;
                    } else {
                        System.out.println("Nota?");
                        Double nota = sc.nextDouble();
                        sc.nextLine();
                        notas.add(new NotaModulo(asignatura, nota));
                    }
                }
                try{
                    Alumno alumno = new Alumno(nAlumnos + 1, new Nombre(nombre, apellido1, apellido2), fechaNac, telefonos, false);
                    NotaAlumno notasAlumno = new NotaAlumno(nAlumnos + 1, notas);
                    ioAlumno.open();
                    ioAlumno.escribirAlumno(alumno, nAlumnos);
                    ioAlumno.close();
                    if (nAlumnos == 0){
                        outputNotas.openWithHeader();
                    } else {
                        outputNotas.open();
                    }
                    outputNotas.escribirNota(notasAlumno);
                    outputNotas.close();
                } catch (Exception e){
                    System.out.println("No se ha podido añadir el alumno.");
                }

            }
        }
    }
    public static void nuevoAlumnoConInfo() {
        nuevoAlumno();
        leerAlumno(nAlumnos);
    }

    public static void datosAlumnos() {
        for (int i = 0; i < nAlumnos; i++) {
            leerAlumno(i);
        }
    }

    private static void leerAlumno(int pos){
        ioAlumno.open();
        Alumno alumno = ioAlumno.leerAlumno(pos);
        System.out.println("----------------------DATOS ALUMNOS----------------------\n");
        System.out.println("ALUMNO NUMERO: " + alumno.getNombre().getNombre() + " " + alumno.getNombre().getApellido1() + " " + alumno.getNombre().getApellido2());
        System.out.print("FECHA NACIMIENTO: " + alumno.getFechaNac());
        System.out.println(" EDAD: " + (LocalDate.now().getYear() - alumno.getFechaNac().getYear()));
        inputNotas.open();
        ArrayList<NotaModulo> notas = inputNotas.leerNotas(pos).getNotas();
        inputNotas.close();
        int sumNotas = 0;
        for (int i = 0; i < notas.size(); i++) {
            NotaModulo nota = notas.get(i);
            System.out.println("MODULO / NOTA");
            System.out.println(nota.getAsignatura() + " - " + nota.getNota());
            sumNotas += nota.getNota();
        }
        System.out.println("MEDIA");
        System.out.println(sumNotas / notas.size());
    }

    public static void datosNotas() {
        for (int i = 0; i < nAlumnos; i++) {
            ioAlumno.open();
            Alumno alumno = ioAlumno.leerAlumno(i);
            ioAlumno.close();
            inputNotas.open();
            ArrayList<NotaModulo> notas = inputNotas.leerNotas(i).getNotas();
            inputNotas.close();
            System.out.println("----------------------------");
            System.out.println(alumno.getNumero() + ". " + alumno.getNombre() + " ");
            for (int j = 0; j < notas.size(); j++) {
                System.out.println(notas.get(i).getAsignatura() + " - " + notas.get(i).getNota());
            }
            System.out.println("----------------------------");
        }
    }

    public static void consultarTelefono() {
        int numeroAlumno;
        do {
        System.out.println("Numero del alumno");
        numeroAlumno = sc.nextInt();
        } while (numeroAlumno > nAlumnos);
        sc.nextLine();
        System.out.println("Numero de telefono?");
        if (existTelefonoOfAlumno(numeroAlumno, sc.nextLine())){
            System.out.println("Numero existente, sobreescribirlo? [1] Si [2] No");
        } else {
            System.out.println("Numero no encontrado, guardar? [1] Si [2] No");
        }
        if(sc.nextInt() == 1){
            ioAlumno.open();
            ioAlumno.escribirAlumno(ioAlumno.leerAlumno(numeroAlumno), numeroAlumno);
            ioAlumno.close();
        }
    }

    private static boolean existTelefonoOfAlumno(int nAlumno, String tel){
        ioAlumno.open();
        Alumno alumno = ioAlumno.leerAlumno(nAlumno);
        for (int j = 0; j < alumno.getTelefonos().size(); j++) {
            if (alumno.getTelefonos().get(j).equals(tel)){
                return true;
            }
        }
        ioAlumno.close();
        return false;
    }
}
