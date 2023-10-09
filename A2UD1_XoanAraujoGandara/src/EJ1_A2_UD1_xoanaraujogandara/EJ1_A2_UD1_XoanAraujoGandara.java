/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EJ1_A2_UD1_xoanaraujogandara;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class EJ1_A2_UD1_XoanAraujoGandara {

    private static PrintStream ps;
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        showMenu();
        try {
            chooseOption();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private static void showMenu() {
        System.out.println("Menu de opciones");
        System.out.println("----------------");
        System.out.println("[P] listado por pantalla");
        System.out.println("[D] listado a un fichero");
        System.out.println("----------------");
    }

    private static void chooseOption() throws FileNotFoundException {
        switch (option()) {
            case 'P': {
                ps = System.out;
            }break;
            case 'D': {
                ps = new PrintStream("src/listadoUnidades.txt");
            }break;
        }
        list();
    }

    private static char option() {
        char op;
        do {
            System.out.print("->");
            op = sc.next().toUpperCase().charAt(0);
        } while (op != 'D' && op != 'P');
        return op;
    }

    private static void list() {
        File[] roots = File.listRoots();
        ps.println("");
        NumberFormat nf = NumberFormat.getInstance();
        for (File file : roots) {
            long libre, total;
            libre = file.getFreeSpace();
            total = file.getTotalSpace();
            ps.println(file.getAbsolutePath().charAt(0) + ":\\");
            ps.println("Espacio total: " + nf.format(total) +"( "+ ( total / Math.pow(2, 30)) + " )");
            ps.println("Espacio ocupado" + nf.format(total - libre) +"( "+ ( total - libre / Math.pow(2, 30)) + " )");
            ps.println("Espacio libre: " + nf.format(libre) +"( "+ ( libre / Math.pow(2, 30)) + " )");
        }
    }
}
