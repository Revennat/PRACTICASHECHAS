package MODELOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private int id;
    private String nombre;
    private String tipo;
    private String region;
    private String poder;

    private Pokemon(int id, String nombre, String tipo, String region, String poder) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.region = region;
        this.poder = poder;
    }

    public Pokemon(String nombre, String tipo, String region, String poder) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.region = region;
        this.poder = poder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", region='" + region + '\'' +
                ", poder='" + poder + '\'' +
                '}';
    }

    public void save() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("insert into cenpk.Pokemon(nombre, tipo, region, poder) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ){
            ps.setString(1,this.nombre);
            ps.setString(2, this.tipo);
            ps.setString(3, this.region);
            ps.setString(4, this.poder);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                this.id = rs.getInt(1);
            }
        }
    }

    public int delete() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("DELETE FROM cenpk.Pokemon WHERE ID = ?")
                ){
            ps.setInt(1,this.id);
            return ps.executeUpdate();
        }
    }

    public static int deleteByName(String nombre) throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("DELETE FROM cenpk.Pokemon WHERE nombre = ?")
        ){
            ps.setString(1, nombre);
            return ps.executeUpdate();
        }
    }

    public int update() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("UPDATE cenpk.Pokemon SET (nombre = ?, tipo = ?, region = ?, poder = ?) WHERE id = ?")
                ){
            ps.setString(1, this.nombre);
            ps.setString(2, this.tipo);
            ps.setString(3, this.region);
            ps.setString(4, this.poder);
            ps.setInt(5, this.id);

            return ps.executeUpdate();
        }
    }

    public static List<Pokemon> getAll() throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cenpk.Pokemon");
            ){
            ResultSet rs = ps.executeQuery();
            List<Pokemon> pokemonList = new ArrayList<>();
            while (rs.next()){
                pokemonList.add(new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return pokemonList;
        }
    }

    public static Pokemon findByNombre(String nombre) throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM cenpk.Pokemon WHERE nombre = ?")
                ){
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            Pokemon p = null;

            if (rs.next()){
                p = new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            return p;
        }
    }

    public static Pokemon find(int id) throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM cenpk.Pokemon WHERE id= ?")
        ){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Pokemon p = null;
            if (rs.next()){
                p = new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            return p;
        }
    }

    public static List<Pokemon> generarReportePorRegion(String region) throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM cenpk.Pokemon WHERE region = ?;")
        ){
            ps.setString(1, region);
            ResultSet rs = ps.executeQuery();
            List<Pokemon> pokemonList = new ArrayList<>();
            while (rs.next()){
                pokemonList.add(new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return pokemonList;
        }
    }

    public static List<Pokemon> generarReportePokemonMasPoderoso(String poder) throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM cenpk.Pokemon WHERE poder = ?;")
        ){
            ps.setString(1, poder);
            ResultSet rs = ps.executeQuery();
            List<Pokemon> pokemonList = new ArrayList<>();
            while (rs.next()){
                pokemonList.add(new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return pokemonList;
        }
    }

}
