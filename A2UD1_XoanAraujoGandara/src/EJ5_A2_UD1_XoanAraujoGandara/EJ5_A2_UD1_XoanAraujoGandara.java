import EJ2_A2_UD1_xoanaraujogandara.NotDirectoryFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EJ5_A2_UD1_XoanAraujoGandara {

    private static Scanner sc = new Scanner(System.in);
    private static PrintStream ps = new PrintStream(System.out);

    public static void main(String[] args) {
        System.out.println("Nombre del archivo: ");
        File dir = new File(sc.nextLine());
        System.out.println("Nombre de la extensión (Ej: txt)");
        Filtro filtro = new Filtro("." + sc.nextLine());
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
            getContent(dir, filtro);
        }
    }

    private static void getContent(File dir, Filtro filtro) {
        File[] files = dir.listFiles(filtro);

        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        NumberFormat nf = NumberFormat.getIntegerInstance();

        for (File file : files) {
            ps.print("| " + file.getName() + " <" + "FICHERO" + "> " + nf.format(file.getTotalSpace() / 1000) + " Kb " + dateFormat.format(file.lastModified()) + "\n");
        }
    }
}

class Filtro implements FilenameFilter {
    String extension;

    public Filtro(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }
}