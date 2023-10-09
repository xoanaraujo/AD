package util.alumnos;

import model.Alumno;
import model.Nombre;
import util.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Date;
import java.util.ArrayList;

public class IOAlumno extends FileIO {

    private static final int REG_SIZE = 80;
    private RandomAccessFile raf;
    public IOAlumno(File mainFile) {
        super(mainFile);
    }

    @Override
    public void open() {
        try {
            raf = new RandomAccessFile(mainFile, "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void escribirAlumno(Alumno alumno, int pos) {
        try {
            raf.seek((long) pos * REG_SIZE);
            raf.writeInt(alumno.getNumero());
            raf.writeUTF(alumno.getNombre().getNombre());
            raf.writeUTF(alumno.getNombre().getApellido1());
            raf.writeUTF(alumno.getNombre().getApellido2());
            raf.writeLong(Long.parseLong(alumno.getFechaNac().toString()));
            raf.writeInt(alumno.getTelefono().size());
            for (int i = 0; i < alumno.getTelefono().size(); i++) {
                raf.writeUTF(alumno.getTelefono().get(i));
            }
            raf.writeBoolean(alumno.isBorrado());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Alumno leerAlumno(int pos) {
        Alumno alumno;
        try {
            raf.seek((long) pos * REG_SIZE);
            int numero = raf.readInt();
            String nombre = raf.readUTF();
            String apellido1 = raf.readUTF();
            String apellido2 = raf.readUTF();
            Long dateLong = raf.readLong();
            Date date = Date.valueOf(dateLong.toString());
            int nTelefonos = raf.readInt();
            ArrayList<String> telefonos = new ArrayList<>();
            for (int i = 0; i < nTelefonos; i++) {
                telefonos.add(raf.readUTF());
            }
            boolean borrado = raf.readBoolean();
            alumno = new Alumno(numero, new Nombre(nombre, apellido1, apellido2), date, telefonos, borrado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return alumno;
    }
}
