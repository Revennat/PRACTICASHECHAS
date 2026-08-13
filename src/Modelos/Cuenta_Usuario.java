package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cuenta_Usuario {
    private int id;
    private String correoElectronico;
    private int MesesActivo;
    private String PlanSuscripcion;

    public Cuenta_Usuario(int id, String correoElectronico, int mesesActivo, String planSuscripcion) {
        this.id = id;
        this.correoElectronico = correoElectronico;
        MesesActivo = mesesActivo;
        PlanSuscripcion = planSuscripcion;
    }

    public Cuenta_Usuario(String correoElectronico, int mesesActivo, String planSuscripcion) {
        this.correoElectronico = correoElectronico;
        MesesActivo = mesesActivo;
        PlanSuscripcion = planSuscripcion;
    }

    public Cuenta_Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getMesesActivo() {
        return MesesActivo;
    }

    public void setMesesActivo(int mesesActivo) {
        MesesActivo = mesesActivo;
    }

    public String getPlanSuscripcion() {
        return PlanSuscripcion;
    }

    public void setPlanSuscripcion(String planSuscripcion) {
        PlanSuscripcion = planSuscripcion;
    }


    //METODOS

    public void save() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("INSERT INTO CUENTAUSUARIOS  (CorreoElectronico, MesesActivos, PlanSuscripcion) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ){
            ps.setString(1, this.correoElectronico);
            ps.setInt(2, this.MesesActivo);
            ps.setString(3, this.PlanSuscripcion);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                this.id = rs.getInt(1);
            }
        }
    }

    public int update() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("UPDATE CUENTAUSUARIOS SET CorreoElectronico = ?, MesesActivos = ?, PlanSuscripcion = ? WHERE id = ?")
                ){
            ps.setString(1, this.correoElectronico);
            ps.setInt(2, this.MesesActivo);
            ps.setString(3, this.PlanSuscripcion);
            ps.setInt(4, this.id);
            return ps.executeUpdate();
        }
    }

    public int delate() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("DELETE CUENTAUSUARIOS WHERE id = ?")
                ){
            ps.setInt(1, this.id);
            return ps.executeUpdate();
        }
    }

    public static ArrayList<Cuenta_Usuario> GetAll() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM CUENTAUSUARIOS");
        ){
            ArrayList<Cuenta_Usuario> listaCuenta = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listaCuenta.add(new Cuenta_Usuario(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            return listaCuenta;
        }
    }

    public static Cuenta_Usuario findById(int id) throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM CUENTAUSUARIOS WHERE id = ?")
                ){
            ps.setInt(1, id);
            Cuenta_Usuario cuentaUsuario = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                cuentaUsuario = new Cuenta_Usuario(id, rs.getString(2), rs.getInt(3), rs.getString(4));
            }
            return cuentaUsuario;
        }
    }



    @Override
    public String toString() {
        return "Cuenta_Usuario{" +
                "id=" + id +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", MesesActivo=" + MesesActivo +
                ", PlanSuscripcion='" + PlanSuscripcion + '\'' +
                '}';
    }

}
