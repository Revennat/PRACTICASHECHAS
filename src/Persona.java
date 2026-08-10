import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private int edad;
    private String sexo;
    private List<Animal> animals;

    public void save() throws Exception{
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("INSERT INTO PERSONA(nombre, edad, sexo) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)
                ){
            ps.setString(1, this.nombre);
            ps.setInt(2, this.edad);
            ps.setString(3, this.sexo);
            ps.executeQuery();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                this.id = rs.getInt(1);
            }
        }
    }

    public int update() throws Exception {
        try (
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("UPDATE PERSONA ")
                ) {

        }
        return 0;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
