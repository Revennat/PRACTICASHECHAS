package Modelos;

public class Moto extends Vehiculo{
    public Moto(String placa, int horasEstacionado, Tarifa tarifaporcobrar) {
        Tarifa TM = new TarifaMoto();
        super(placa, horasEstacionado, TM);
    }
}
