import Modelos.*;

void main() throws Exception {
    Scanner lr = new Scanner(System.in);
    boolean ciclo = true;
    do {

        System.out.println("1. Crear y guardar un Usuario en la base de datos");
        System.out.println("2. Actualizar un Usuario en la base de datos");
        System.out.println("3. Borrar un Usuario en la base de datos");
        System.out.println("4. lista de todos los Usuarios");
        System.out.println("5. Buscar por id");
        System.out.println("6. SALIR");
        int menu = lr.nextInt();
        lr.nextLine();

        switch (menu){
            case 1:
                System.out.println("Escribe el correo del usuario");
                String correo = lr.nextLine();

                System.out.println("Escribe los meses registrados de usuario");
                int meses = lr.nextInt();
                lr.nextLine();

                System.out.println("Escribe el tipo de Plan del usuario");
                System.out.printf("lista de planes actual:\n 1. Plan Basico\n 2. Plan Estandar\n 3. Plan Premium %n");
                String plan = lr.nextLine();
                try {
                    new Cuenta_Usuario(correo, meses, plan).save();
                    System.out.println("Usuario Registrado");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                if (Cuenta_Usuario.GetAll().isEmpty()){
                    System.out.println("No hay nada registrado en la base de datos");
                    break;
                }

                System.out.println(Cuenta_Usuario.GetAll().toString());

                System.out.println("Escribe el id del usuario");
                int idact = lr.nextInt();
                lr.nextLine();

                if (Cuenta_Usuario.findById(idact) == null) {
                    System.out.println("Usuario no encotrado");
                    break;
                }

                System.out.println("Usuario Encontrado" + Cuenta_Usuario.findById(idact).getCorreoElectronico());

                System.out.println("---Actualizar datos del ususario---");

                System.out.println("Correo nuevo: ");
                String correoact = lr.nextLine();

                System.out.println("Meses registrados: ");
                int mesesact = lr.nextInt();
                lr.nextLine();

                System.out.println("Escribe el nuevo tipo de Plan del usuario");
                System.out.printf("lista de planes actual:\n" +
                        " 1. Plan Basico\n" +
                        " 2. Plan Estandar\n" +
                        " 3. Plan Premium %n");
                String planact = lr.nextLine();

                try {
                    new Cuenta_Usuario(idact, correoact, mesesact, planact).update();
                    System.out.println("Usuario Actualizado");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case 3:
                if (Cuenta_Usuario.GetAll().isEmpty()){
                    System.out.println("No hay nada registrado en la base de datos");
                    break;
                }

                Cuenta_Usuario.GetAll().toString();

                System.out.println("Escibe el id de la cuenta:");
                int idel = lr.nextInt();

                try {
                    Cuenta_Usuario.findById(idel).delate();
                    System.out.println("usuario borrado");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case 4:

                if (Cuenta_Usuario.GetAll().isEmpty()){
                    System.out.println("No hay nada registrado en la base de datos");
                    break;
                }

                System.out.println("Lista de usuarios registados");
                for (Cuenta_Usuario cu : Cuenta_Usuario.GetAll()){
                    System.out.println(cu.toString());
                }
                break;
            case 5:

                if (Cuenta_Usuario.GetAll().isEmpty()){
                    System.out.println("No hay nada registrado en la base de datos");
                    break;
                }

                System.out.println("escribe el id del usuario:");
                int id = lr.nextInt();
                System.out.println(Cuenta_Usuario.findById(id));
                break;
            case 6:
                System.out.println("saliendo...");
                ciclo = false;
                break;
        }
    }while (ciclo);
}
