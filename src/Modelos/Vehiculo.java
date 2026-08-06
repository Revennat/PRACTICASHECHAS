package Modelos;

public abstract class Vehiculo {
    private String placa;
    private int horasEstacionado;
    private Tarifa tipotarifa;

    public Vehiculo(String placa, int horasEstacionado, Tarifa tarifaporcobrar) {
        this.placa = placa;
        this.horasEstacionado = horasEstacionado;
        this.tipotarifa = tarifaporcobrar;
    }

    public double calcularCostoEstacionamiento(){
        return this.tipotarifa.calcular(horasEstacionado);
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

    public Tarifa getTipotarifa() {
        return tipotarifa;
    }

    public void setTipotarifa(Tarifa tipotarifa) {
        this.tipotarifa = tipotarifa;
    }
}
