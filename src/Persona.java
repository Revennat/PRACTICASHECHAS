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

    public void agregarAnimal(Animal a) throws Exception{
        if (this.id == 0){
            throw new Exception("Debe guardar la persona antes de que agrege un animal");
        }

        String sql = "INSERT INTO Animal (nombre, tipo, persona_id) VALUES (?, ?, ?)";

        try(Connection conexion = Conexion.getConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql);)
        {
            pstmt.setString(1, a.getNombre());
            pstmt.setString(2, a.getTipo());
            pstmt.setInt(3, this.id);

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){

            }
        }
    }

    //Buscar los animales que su dueno es la persona

    public  List<Animal> getAnimales() throws Exception{
        String sql = "SELECT * FROM Animal WHERE persona_id = ?";

        try(Connection conexion = Conexion.getConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql);)
        {
            pstmt.setInt(1, this.id);
            ResultSet rs = pstmt.executeQuery();
            this.animals = new ArrayList<>();
            while(rs.next()){
                this.animals.add(new Animal (rs.getInt("id"), rs.getString("nombre"), rs.getString("tipo")));
            }
            return this.animals;
        }
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
