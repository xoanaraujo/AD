/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class BinaryInput extends FileIO{

    protected DataInputStream in;

    public BinaryInput(String path) {
        super(path);
    }
    
    
    
    @Override
    public void open() {
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(pathFile)));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            in.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void read(){
        try {
        while (true) {            
            System.out.println(in.readInt());
        }
        } catch (EOFException e) {
            System.out.println("Fin de fichero.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public DataInputStream getIn() {
        return in;
    }
    
        
}
