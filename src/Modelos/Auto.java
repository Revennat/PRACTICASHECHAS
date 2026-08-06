package Modelos;

public class Auto extends Vehiculo{

    public Auto(String placa, int horasEstacionado, Tarifa tarifaporcobrar) {
        Tarifa TA = new TarifaAuto();
        super(placa, horasEstacionado, TA);
    }
}
