package Modelos;

public class TarifaCamion implements Tarifa{

    @Override
    public double calcular(int horas){
      return (double) (horas * 4) + 5;
    }
}
