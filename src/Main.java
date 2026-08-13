import Modelos.Paquete;

void main() throws Exception{
    Scanner lr = new Scanner(System.in);
    boolean ciclo = true;

    do {

        System.out.println("1. Crear y guardar un paquete en la base de datos");
        System.out.println("2. Actualizar un paquete en la base de datos");
        System.out.println("3. Borrar un paquete en la base de datos");
        System.out.println("4. lista de todos los paquete");
        System.out.println("5. Buscar por id");
        System.out.println("6. SALIR");
        int menu = lr.nextInt();
        lr.nextLine();

        switch (menu){
            case 1:
                System.out.println("Nombre del destinatario");
                String nombre = lr.nextLine();

                System.out.println("peso en kg: ");
                double kg = lr.nextInt();
                lr.nextLine();

                System.out.println("Estrategia de envio");
                System.out.println("Estrategias disponibles:\n 1. Envio Estandar\n 2. Envio Express\n 3. Envio Internacional\n");
                String envio = lr.nextLine();

                try {
                    new Paquete(nombre, kg, envio).save();
                    System.out.println("Paquete registrado");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case 2:
                if (Paquete.getAll().isEmpty()){
                    System.out.println("no hay registros en la base de datos");
                    break;
                }

                System.out.println("Lista de paquetes: ");
                System.out.println(Paquete.getAll().toString());

                System.out.println("Escribe el id del paquete");
                int idact = lr.nextInt();
                lr.nextLine();

                if (Paquete.findById(idact) == null){
                    System.out.println("no existe ese paquete en la base de datos");
                    break;
                }

                System.out.println("Paquete encontrado" + Paquete.findById(idact).toString());

                System.out.println("---Actualizar Paquete---");
                System.out.println("Nombre del destinatario: ");
                String nombreact = lr.nextLine();

                System.out.println("peso en kg: ");
                double kgact = lr.nextDouble();
                lr.nextLine();

                System.out.println("Estrategia de envio");
                System.out.println("Estrategias disponibles: 1. Envio Estandar\n 2. Envio Express\n 3. Envio Internacional\n");
                String envioact = lr.nextLine();

                try {
                    new Paquete(idact, nombreact, kgact, envioact).update();
                    System.out.println("Paquete actualizado");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


                break;
            case 3:
                if (Paquete.getAll().isEmpty()){
                    System.out.println("no hay registros en la base de datos");
                    break;
                }

                System.out.println("Lista de paquetes: ");
                System.out.println(Paquete.getAll().toString());

                System.out.println("Escribe el id del paquete");
                int idel = lr.nextInt();

                if (Paquete.findById(idel) == null){
                    System.out.println("no existe ese paquete en la base de datos");
                    break;
                }

                try {
                    Paquete.findById(idel).delete();
                    System.out.println("Paquete eliminado");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case 4:

                if (Paquete.getAll().isEmpty()){
                    System.out.println("no hay registros en la base de datos");
                    break;
                }

                System.out.println("Lista de paquetes: ");
                System.out.println(Paquete.getAll().toString());

                break;
            case 5:
                if (Paquete.getAll().isEmpty()){
                    System.out.println("no hay registros en la base de datos");
                    break;
                }

                System.out.println("Escribe el id del paquete");
                int idfind = lr.nextInt();

                if (Paquete.findById(idfind) == null){
                    System.out.println("no existe ese paquete en la base de datos");
                    break;
                }

                System.out.println("El paquete: " + Paquete.findById(idfind).toString());
                break;
            case 6:
                System.out.println("saliendo...");
                ciclo = false;
                break;
        }

    }while (ciclo);
}
