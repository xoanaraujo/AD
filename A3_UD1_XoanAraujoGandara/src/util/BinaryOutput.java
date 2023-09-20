/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ldap.Rdn;

/**
 *
 * @author usuario
 */
public class BinaryOutput extends FileIO{
    
    DataOutputStream out;
    
    public BinaryOutput(String path) {
        super(path);
    }
    
    @Override
    public void open() {
        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathFile)));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()); 
        }
    }

    @Override
    public void close() {
        try {
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void write(int n) {
        try {
            out.writeInt(n);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
