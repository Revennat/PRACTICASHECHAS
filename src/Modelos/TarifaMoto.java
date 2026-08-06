package Modelos;

public class TarifaMoto implements Tarifa{

    @Override
    public double calcular(int horas){
        return horas;
    }

}
