/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EJ4_A4UD2;

import java.io.File;
/**
 *
 * @author Alberto Paz Pérez
 */
public abstract class Archivo {

    File ruta;

    public Archivo(String ruta) {
        this.ruta = new File(ruta);
    }

    public abstract void abrirArchivo();

    public abstract void cerrarArchivo();

    public boolean exists() {
        return (ruta.exists());
    }
    
    public boolean borrarFichero() {
        return(ruta.delete());
    }
    
    public boolean renombrar(String newName) {
        return(ruta.renameTo(new File(newName)));
    }

    public String getNombre() {
        return ruta.getName();
    }
}
