package EJ4_A4UD2;

import java.io.*;

/**
 *
 * @author Alberto Paz Pérez
 */
public class LeerObjeto extends Archivo {

    ObjectInputStream entrada;

    public LeerObjeto(String ruta) {
        super(ruta);
    }

    @Override
    public void abrirArchivo() {
        try {
            entrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ruta)));
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida.");
        }
    }

    @Override
    public void cerrarArchivo() {
        try {
            entrada.close();
        } catch (IOException e) {
            System.out.println("Error, no se ha cerrado el fichero");
        }
    }

    public Object leerObjeto() throws FileNotFoundException, IOException {
        Object o = null;
        try {
            o = entrada.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println("Objeto no encontrado");
            ex.printStackTrace();
        }

        return o;
    }

}