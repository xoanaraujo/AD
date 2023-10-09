package util;

import CLASESDATOS.Alumno;
import CLASESDATOS.Nombre;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Date;
import java.util.ArrayList;

public class ReadWriteAlumno extends FileIO{

    private static final Integer REG_SIZE = 80;
    private RandomAccessFile raf;

    public ReadWriteAlumno(String path) {
        super(path);
    }


    @Override
    public void open() throws FileNotFoundException {
        raf = new RandomAccessFile(filePath, "rw");
    }

    @Override
    public void close() {
        try {
            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private  void writeRunner(Alumno alumno, int pos) {
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

    private Alumno readRunner(int pos) {
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
            alumno = new Alumno(new Nombre(nombre, apellido1, apellido2), date, telefonos, borrado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return alumno;
    }
}
