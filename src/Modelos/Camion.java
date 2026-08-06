package Modelos;

public class Camion extends Vehiculo{
    public Camion(String placa, int horasEstacionado, Tarifa tarifaporcobrar) {
        Tarifa TC = new TarifaCamion();
        super(placa, horasEstacionado, TC);
    }
}
