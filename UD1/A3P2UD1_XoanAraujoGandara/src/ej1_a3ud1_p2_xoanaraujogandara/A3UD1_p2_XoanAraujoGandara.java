package ej1_a3ud1_p2_xoanaraujogandara;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ReadFile;
import util.WriteFile;

/**
 *
 * @author usuario
 */
public class A3UD1_p2_XoanAraujoGandara {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WriteFile writeFile = new WriteFile("Salida.txt");
        try{
            for (String arg : args) {
                if (arg.endsWith(".txt")) {
                    try{
                        ReadFile readFile = new ReadFile(arg);
                        int nLines = 0;
                        while (readFile.readLine() != null) {
                            nLines++;
                        }
                        writeFile.writeLine(arg + " numero de lineas: " + nLines );
                    } catch (FileNotFoundException ex) {
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
                    }
                }
            }
        } catch(Exception e){
            System.out.println("Error no esperado ln 42 main");
        }
    }
}