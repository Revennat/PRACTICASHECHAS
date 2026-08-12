package Modelos;

import javax.swing.plaf.PanelUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Paquete {
    private int id;
    private String nombreDestinario;
    private double kg;
    private String EstrategiaEnvio;

    public Paquete(int id, String nombreDestinario, double kg, String estrategiaEnvio) {
        this.id = id;
        this.nombreDestinario = nombreDestinario;
        this.kg = kg;
        EstrategiaEnvio = estrategiaEnvio;
    }

    public Paquete(String nombreDestinario, double kg, String estrategiaEnvio) {
        this.nombreDestinario = nombreDestinario;
        this.kg = kg;
        EstrategiaEnvio = estrategiaEnvio;
    }


    public Paquete() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDestinario() {
        return nombreDestinario;
    }

    public void setNombreDestinario(String nombreDestinario) {
        this.nombreDestinario = nombreDestinario;
    }

    public String getEstrategiaEnvio() {
        return EstrategiaEnvio;
    }

    public void setEstrategiaEnvio(String estrategiaEnvio) {
        EstrategiaEnvio = estrategiaEnvio;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    // METODOS

    public void save() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("INSERT INTO PAQUETES (nombreDestinatario, kg, EstrategiaEnvio) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ){
            ps.setString(1, this.nombreDestinario);
            ps.setDouble(2, this.kg);
            ps.setString(3, this.EstrategiaEnvio);
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
                PreparedStatement ps = con.prepareStatement("UPDATE PAQUETES SET (nombreDestinatario = ?, kg = ?, EstrategiaEnvio = ?) WHERE id = ?")
        ){
            ps.setString(1, this.nombreDestinario);
            ps.setDouble(2, this.kg);
            ps.setString(3, this.EstrategiaEnvio);
            ps.setInt(4, this.id);
            return ps.executeUpdate();
        }
    }

    public int delete() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("DELETE PAQUETES WHERE id = ?")
        ){
            ps.setInt(1, this.id);
            return ps.executeUpdate();
        }
    }

    public static ArrayList<Paquete> getAll() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM PAQUETES");
        ){
            ArrayList<Paquete> listaPaquetes = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listaPaquetes.add(new Paquete(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            return listaPaquetes;
        }
    }

    public static Paquete findById(int id) throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM PAQUETES WHERE = ?");
        ){
            ps.setInt(1, id);
            Paquete p = new Paquete();
            ResultSet rs = ps.executeQuery();
             if(rs.next()){
               p = new Paquete(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            }
             return p;
        }
    }


    @Override
    public String toString() {
        return "Paquete{" +
                "id=" + id +
                ", nombreDestinario='" + nombreDestinario + '\'' +
                ", kg=" + kg +
                ", EstrategiaEnvio='" + EstrategiaEnvio + '\'' +
                '}';
    }
}
