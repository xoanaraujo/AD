/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author usuario
 */
public abstract class FileIO {
    
    protected File pathFile;
    public FileIO(String path){
        pathFile = new File(path);
    }
    
    public boolean exists(){
        return pathFile.exists();
    }
    
    public String getName(){
        return pathFile.getName();
    }
    
    public abstract void open();
    public abstract void close();
    
}
