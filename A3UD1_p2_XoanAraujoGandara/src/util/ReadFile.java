/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ReadFile extends FileIO{
    BufferedReader bffReader;

    public ReadFile(String path) {
        super(path);
    }
    
    @Override
    public void open() {
        try {
            bffReader = new BufferedReader(new FileReader(pathFile));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            bffReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public String readLine() throws IOException{
        return bffReader.readLine();
    }
    
}
