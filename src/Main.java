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
        lr.nextLine();

        switch (menu){
            case 1:
                System.out.println("Placa del vehiculo");
                String placa = lr.nextLine();
                System.out.println("Horas estacionadas del vehiculo");
                int horas = lr.nextInt();
                lr.nextLine();
                System.out.println("Tarifa del vehiculo");
                System.out.println("Tarifas disponibles:\n 1. Tarifa\n 2. Tarifa\n 3. Tarifa\n");
                String tarifa = lr.nextLine();

                try {
                    new Vehiculo(placa,horas,tarifa).save();
                    System.out.println("Vehiculo registrado");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case 2:
                if (Vehiculo.GetAll().isEmpty()){
                    System.out.println("no hay registros en la base de datos");
                    break;
                }

                System.out.println("Lista de Vehiculos");
                System.out.println(Vehiculo.GetAll().toString());

                System.out.println("escribe el id del vehiculo");
                int id2 = lr.nextInt();
                lr.nextLine();

                if (Vehiculo.findById(id2) == null){
                    System.out.println("no existe ese vehiculo en la base de datos");
                    break;
                }

                System.out.println("Placa del vehiculo");
                String placaact = lr.nextLine();

                System.out.println("Horas registradas");
                int horasact = lr.nextInt();
                lr.nextLine();

                System.out.println("Tarifa del vehiculo");
                System.out.println("Tarifas disponibles:\n 1. Tarifa\n 2. Tarifa\n 3. Tarifa\n");
                String tarifact = lr.nextLine();

                try {
                    new Vehiculo(id2, placaact, horasact, tarifact).update();
                    System.out.println("Vehiculo actualizado");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case 3:
                if (Vehiculo.GetAll().isEmpty()){
                    System.out.println("no hay registros en la base de datos");
                    break;
                }
                break;
            case 4:
                if (Vehiculo.GetAll().isEmpty()){
                    System.out.println("no hay registros en la base de datos");
                    break;
                }

                System.out.println("Lista de Vehiculos");
                System.out.println(Vehiculo.GetAll().toString());

                break;
            case 5:
                if (Vehiculo.GetAll().isEmpty()){
                    System.out.println("no hay registros en la base de datos");
                    break;
                }
                System.out.println("ingresa el id del vehiculo");
                int id = lr.nextInt();

                if (Vehiculo.findById(id) == null){
                    System.out.println("no existe ese vehiculo en la base de datos");
                    break;
                }

                System.out.println(Vehiculo.findById(id).toString());

                break;
            case 6:
                System.out.println("saliendo...");
                ciclo = false;
                break;
        }

    }while (ciclo);



}
