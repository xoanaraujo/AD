package EJ4_A4UD2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Alberto Paz Pérez
 */
public class EscribirObjeto extends Archivo {

    ObjectOutputStream salida;

    public EscribirObjeto(String ruta) {
        super(ruta);
    }

    @Override
    public void abrirArchivo() {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(ruta));
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida.");
        }
    }

    public void abrirArchivoAdd() {
        try {
            salida = new MiObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ruta, true)));

        } catch (IOException ex) {
            System.out.println("Error de entrada/salida.");
        }
    }

    @Override
    public void cerrarArchivo() {
        try {
            salida.close();
        } catch (IOException e) {
            System.out.println("Error, no se ha cerrado el archivo");
        }
    }

    public void escribirArchivo(Object obj) {
        try {
            salida.writeObject(obj);

        } catch (IOException ex) {
            System.out.println("Error de escritura");
        }
    }
}
