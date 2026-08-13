package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Vehiculo {
   private int id;
   private String placa;
   private int horasEstacionado;
   private String Tarifa;

    public Vehiculo(int id, String placa, int horasEstacionado, String tarifa) {
        this.id = id;
        this.placa = placa;
        this.horasEstacionado = horasEstacionado;
        Tarifa = tarifa;
    }

    public Vehiculo(String placa, int horasEstacionado, String tarifa) {
        this.placa = placa;
        this.horasEstacionado = horasEstacionado;
        Tarifa = tarifa;
    }

    public Vehiculo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getHorasEstacionado() {
        return horasEstacionado;
    }

    public void setHorasEstacionado(int horasEstacionado) {
        this.horasEstacionado = horasEstacionado;
    }

    public String getTarifa() {
        return Tarifa;
    }

    public void setTarifa(String tarifa) {
        Tarifa = tarifa;
    }

    // METODOS

    public void save() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("INSERT INTO VEHICULOS (placa, horasEstacionadas, Tarifa) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ){
            ps.setString(1, this.placa);
            ps.setInt(2, this.horasEstacionado);
            ps.setString(3, this.Tarifa);
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
                PreparedStatement ps = con.prepareStatement("UPDATE VEHICULOS SET placa = ?, horasEstacionadas = ?, Tarifa = ? WHERE id = ?")
        ){
            ps.setString(1, this.placa);
            ps.setInt(2, this.horasEstacionado);
            ps.setString(3, this.Tarifa);
            ps.setInt(4, this.id);

            return ps.executeUpdate();
        }
    }

    public int delate() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("DELETE VEHICULOS WHERE id = ?")
        ){
            ps.setInt(1, this.id);
            return ps.executeUpdate();
        }
    }

    public static ArrayList<Vehiculo> GetAll() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM VEHICULOS");
        ){
            ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listaVehiculo.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            return listaVehiculo;
        }
    }

    public static Vehiculo findById(int id) throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM VEHICULOS WHERE id = ?")
        ){
            ps.setInt(1, id);
            Vehiculo cuentaUsuario = new Vehiculo();
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                cuentaUsuario = new Vehiculo(id, rs.getString(2), rs.getInt(3), rs.getString(4));
            }
            return cuentaUsuario;
        }
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", horasEstacionado=" + horasEstacionado +
                ", Tarifa='" + Tarifa + '\'' +
                '}';
    }
}
