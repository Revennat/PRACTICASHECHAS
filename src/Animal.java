public class Animal {
    private int id;
    private String nombre;
    private String tipo;
    private int persona_id;

    public Animal(int id, String nombre, String tipo, int persona_id) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.persona_id = persona_id;
    }

    public Animal(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }
}
