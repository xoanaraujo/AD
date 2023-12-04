package a1_ud3_xoanaraujogandara;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MSSMSConection {

    private Connection con;

    public MSSMSConection(String dbName, String user, String psswd) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=" + dbName + ";TrustServerCertificate = true", user, psswd);
            System.out.println("Conexion correcta");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(A1_UD3_XoanAraujoGandara.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean cerrarConexion(){
        boolean cierreOk = true;
        try {
            con.close();
            System.out.println("Conexion cerrada.");
        } catch (SQLException e) {
            System.err.println(e);
            cierreOk = false;
        }
        return cierreOk;
    }
    
    public boolean update(String sql){
        boolean consultaOk = true;
        try{
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("Update completado");
        }catch(SQLException e){
            System.err.println(e);
            consultaOk = false;
        }
        return consultaOk;
    }
    
    
}
