package Modelos;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String server = "localhost";
    private static String port = "1433";
    private static String database = "Paqueteria";
    private static String user = "sa";
    private static String pass = "1234";

    public static String getCadenaConexion(){
        return String.format(
                "jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s;encrypt=true;encrypt=true;trustServerCertificate=true;",
                server,port,database,user,pass
        );
    }

    public static Connection getConexion() throws Exception{
        return DriverManager.getConnection(getCadenaConexion());
    }
}
