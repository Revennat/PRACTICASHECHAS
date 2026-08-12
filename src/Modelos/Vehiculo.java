package Modelos;

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
}
