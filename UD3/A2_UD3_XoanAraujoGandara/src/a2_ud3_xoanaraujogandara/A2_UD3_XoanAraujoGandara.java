package a2_ud3_xoanaraujogandara;

/**
 *6
 * @author Adrián Rodríguez Blanco
 */
public class A2_UD3_XoanAraujoGandara {

    private static MSSMSConection con;

    public static void main(String[] args) {
        con = new MSSMSConection("DBEmpresa", "sa", "abc123.");
        subirSalario(100, "PERSOAL");
    }

    private static void subirSalario(float cantidad, String departamento) {
        String subirSalario = """
                              USE BDEmpresa;
                              UPDATE EMPREGADO
                              SET Salario = ?
                              WHERE Num_Departamento LIKE ?""";
        String[] values = {String.valueOf(cantidad), departamento};
        System.out.println(con.preparedStatement(subirSalario, values) ? "Correcto" : "Incorrecto");
    }
}
