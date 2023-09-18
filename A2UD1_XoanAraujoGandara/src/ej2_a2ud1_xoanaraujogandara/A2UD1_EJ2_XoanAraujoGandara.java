/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2_a2ud1_xoanaraujogandara;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class A2UD1_EJ2_XoanAraujoGandara {

    private static Scanner sc = new Scanner(System.in);
    private static PrintStream ps = new PrintStream(System.out);
    private static String dirPath;

    public static void main(String[] args) {
        dirPath = sc.nextLine();
        getContent(dirPath);
    }

    private static void getContent(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            System.out.print("No existe, introduce el directorio:");
            getContent(sc.nextLine());
        } else if (!dir.isDirectory()) {
            System.out.print("No es un directorio, introduce el directorio:");
            getContent(sc.nextLine());
        } else {
            System.out.println("--LISTANDO EL DIRECTORIO " + path + " --");

            for (File file : dir.listFiles()) {
                if(file.isDirectory())
                    ps.print("-| " + file.getName() + " <" + "DIR" + "> \n");
                else {
                    //DateFormat dateFormat = new DateFormat
                    ps.print("-| " + file.getName() + " <" + "FICHERO" + ">" + file.getTotalSpace() + " " + file.lastModified() + "\n");
                }
            }
        }

    }
}
