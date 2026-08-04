package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private int id;
    private int matricula;
    private String nombre;
    private int edad;
    private String sexo;
    private String correo;

    private Alumno(int id, int matricula, String nombre, int edad, String sexo, String correo) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
    }

    private Alumno(int matricula, String nombre, int edad, String sexo, String correo){
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
    }

    private Alumno(int matricula) {
        this.matricula = matricula;
    }

    public static Alumno crearAlumno(int matricula, String nombre, int edad, String sexo, String correo){
        return new Alumno(matricula, nombre, edad, sexo, correo);
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

    public int deleteByMatricula() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("DELETE ALUMNOS WHERE matricula = ?")
                ){
            ps.setInt(1, this.matricula);
            return ps.executeUpdate();
        }
    }

    public int updateByMatricula() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("UPDATE ALUMNOS SET nombre = ?, edad = ?, sexo = ?, correo = ? WHERE matricula = ?")
                ){
            ps.setString(1, this.nombre);
            ps.setInt(2, this.edad);
            ps.setString(3, this.sexo);
            ps.setString(4, this.correo);
            ps.setInt(5, this.matricula);
            return ps.executeUpdate();
        }
    }

    public static List<Alumno> getAll() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM ALUMNOS")
        ){
            ResultSet rs = ps.executeQuery();
            List<Alumno> listAlum = new ArrayList<>();
            while (rs.next()){
                Alumno al = new Alumno(rs.getInt("id"), rs.getInt("matricula"), rs.getString("nombre"), rs.getInt("edad"), rs.getString("sexo"), rs.getString("correo"));
                listAlum.add(al);
            }
            return listAlum;
        }
    }

    public static Alumno getAlumnobyMatricula(int Matricula) throws Exception{
        Alumno a = new Alumno(Matricula);
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM ALUMNOS WHERE matricula = ?")
                ){
            ps.setInt(1, Matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                a = new Alumno(rs.getInt("id"), rs.getInt("matricula"), rs.getString("nombre"), rs.getInt("edad"), rs.getString("sexo"), rs.getString("correo"));
            }
            return a;
        }
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", matricula=" + matricula +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
