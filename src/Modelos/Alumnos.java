package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Alumnos {
    private int id;
    private int matricula;
    private String nombre;
    private int edad;
    private String sexo;
    private String correo;

    public Alumnos(int matricula, String nombre, int edad, String sexo, String correo) throws Exception {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
    }

    public void save() throws Exception {
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("INSERT INTO ALUMNOS(MATRICULA, NOMBRE, EDAD, SEXO, CORREO) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, this.matricula);
            ps.setString(2, this.nombre);
            ps.setInt(3, this.edad);
            ps.setString(4, this.sexo);
            ps.setString(5, this.correo);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        }
    }
}
