import Modelos.Alumno;


void main() {
    boolean ciclo = true;
    Scanner lr = new Scanner(System.in);

    do {
        System.out.println("1. Crear Alumno");
        System.out.println("2. Ver todos los alumnos en la base de datos");
        System.out.println("3. Actualizar Alumno por matricula");
        System.out.println("4. Eliminar Alumno por matricula");
        System.out.println("5. Ver cuantos hombres y mujeres hay en la base de datos");
        System.out.println("6. Salir");
        int menu = lr.nextInt();
        lr.nextLine();

        switch (menu){
            case 1:
                System.out.println("Creacion del alumno!");
                System.out.println("Matricula");
                int Matricula = lr.nextInt();
                lr.nextLine();
                System.out.println("Nombre");
                String Nombre = lr.nextLine();
                System.out.println("Edad");
                int Edad = lr.nextInt();
                lr.nextLine();
                System.out.println("Sexo");
                String Sexo = lr.nextLine();
                System.out.println("Correo");
                String Correo = lr.nextLine();

                try {
                    Alumno.crearAlumno(Matricula, Nombre, Edad, Sexo, Correo).save();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case 2:
                System.out.print("Alumnos en la base de datos: ");
                try {
                    System.out.println(Alumno.getAll());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                System.out.println("Alumnos");

                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Saliendo...");
                ciclo = false;
                break;
            default:
                break;
        }

    }while (ciclo);
}
