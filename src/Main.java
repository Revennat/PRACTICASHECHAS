import Modelos.Vehiculo;

void main() throws Exception{
    Scanner lr = new Scanner(System.in);
    boolean ciclo = true;

    do {

        System.out.println("1. Crear y guardar un vehiculo en la base de datos");
        System.out.println("2. Actualizar un vehiculo en la base de datos");
        System.out.println("3. Borrar un vehiculo en la base de datos");
        System.out.println("4. lista de todos los vehiculo");
        System.out.println("5. Buscar por id");
        System.out.println("6. SALIR");
        int menu = lr.nextInt();

        switch (menu){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("saliendo...");
                ciclo = false;
                break;
        }

    }while (ciclo);



}
