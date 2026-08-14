package MODELOs;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String server = "localhost"; // O la IP de tu servidor SQL
    private static String port = "1433";
    private static String database = "CentroInvestigacionPokemon";  // Base de datos por defecto para pruebas
    private static String user = "sa";
    private static String password = "1234";
    public static String  getCadenaConexion(){
        return  String.format(
                "jdbc:sqlserver://%s:%s;" +
                        "databaseName=%s;" +
                        "user=%s;" +
                        "password=%s;" +
                        "encrypt=true;" +
                        "trustServerCertificate=true;",
                server, port, database, user, password
        );
    }
    public static Connection getConexion() throws Exception{
        System.out.println("Intentando conectar a la base de datos...");

        return DriverManager.getConnection(getCadenaConexion());
    }
}
