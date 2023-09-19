/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ3_A2_UD1_xoanaraujogandara;

import EJ2_A2_UD1_xoanaraujogandara.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class EJ3_A2_UD1_XoanAraujoGandara {

    private static Scanner sc = new Scanner(System.in);
    private static PrintStream ps = new PrintStream(System.out);
    private static String dirPath;

    public static void main(String[] args) {
        dirPath = sc.nextLine();
        File dir = new File(dirPath);
        if (!dir.exists()) {
            try {
                throw new FileNotFoundException("No existe el fichero");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (!dir.isDirectory()) {
            try {
                throw new NotDirectoryFileException("El fichero no es un directorio");
            } catch (NotDirectoryFileException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            ps.println("--LISTANDO EL DIRECTORIO " + dir + " --");
            getContent(dir, 0);
        }

    }

    private static void getContent(File dir, int nParents) {
        for (File file : dir.listFiles()) {
            StringBuilder strB = new StringBuilder("");
            for (int i = 0; i < nParents + 1; i++) {
                strB.append("---");
            }
            ps.print(strB);
            if (file.isDirectory()) {
                ps.print("| " + file.getName() + "<DIR>\n");
                if(file.listFiles() != null){
                    getContent(file, nParents + 1);
                }
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                NumberFormat nf = NumberFormat.getIntegerInstance();
                ps.print("-| " + file.getName() + " <" + "FICHERO" + ">" + nf.format(file.getTotalSpace() / 1000) + " Kb " + dateFormat.format(file.lastModified()) + "\n");
            }
        }
    }
}
