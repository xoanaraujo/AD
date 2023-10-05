/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class WriteFile extends FileIO{
    private BufferedWriter bffWriter;

    public WriteFile(String path) {
        super(path);
    }

    @Override
    public void open() {
        try {
            this.bffWriter = new BufferedWriter(new FileWriter(pathFile));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            this.bffWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void writeLine(String str){
        try {
            bffWriter.write(str);
            bffWriter.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }       
    }
    
    
}
