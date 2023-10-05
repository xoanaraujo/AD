/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.xoanaraujo.util;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author usuario
 */
public abstract class FileIO {
    
    protected File filePath;
    public FileIO(String path){
        filePath = new File(path);
    }
    
    public boolean exists(){
        return filePath.exists();
    }
    
    public String getName(){
        return filePath.getName();
    }
    
    public abstract void open() throws FileNotFoundException;
    public abstract void close();
    
}
