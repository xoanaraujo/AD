/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2_a3ud1_pt2_xoanaraujogandara;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.NotDirectoryFileException;
import util.ReadFile;
import util.WriteFile;

/**
 *
 * @author usuario
 */
public class Ej2_A3UD1_pt2_XoanAraujoGandara {
    
    private static final String PATH = "ALUMNOS/";
    private final static WriteFile ESCRIBIR = new WriteFile("log.txt");
    
    public static void main(String[] args){
        if(new File("ALUMNOS.txt").exists()){
            createFolders(new ReadFile("ALUMNOS.txt"));
        } else {
            System.out.println("No existe");
        }
    }
    
    private static void createFolders(ReadFile rdFile){
        rdFile.open();
        try {
            String line;
            while((line = rdFile.readLine()) != null){
                if ("[A-Z]+[12]/[0-9]/[A-Z]+ [A-Z]+".equals(line)) {
                    File file = new File(PATH + line);
                    System.out.println(file.getPath());
                    file.mkdirs();
                }
            }
        } catch (IOException ex) {
            System.out.println("Fin archivo");
        }
        rdFile.close();
    }
}
