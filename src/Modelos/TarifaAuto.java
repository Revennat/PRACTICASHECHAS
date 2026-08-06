package Modelos;

public class TarifaAuto implements Tarifa{

    @Override
   public double calcular(int horas){
        return (double) horas * 2;
    }
}
