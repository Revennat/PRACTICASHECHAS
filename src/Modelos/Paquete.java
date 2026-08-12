package Modelos;

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

    }

}
