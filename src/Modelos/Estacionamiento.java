package Modelos;

import java.util.ArrayList;

public class Estacionamiento {

    public Estacionamiento(String nombre, int no) {
        this.nombre = nombre;
        this.no = no;
    }

    private String nombre;
    private int no;
    ArrayList<Vehiculo> vehiculosestacionados = new ArrayList<>();

   public void addVehiculo(Vehiculo vehiculo){
       this.vehiculosestacionados.add(vehiculo);
    }

    public double calcularDinerorecaudadoeneldia(){
        double totalrecaudado = 0;
        for (Vehiculo v : this.vehiculosestacionados){
            totalrecaudado += v.calcularCostoEstacionamiento();
        }
        return totalrecaudado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
