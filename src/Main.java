import MODELOs.Conexion;
import MODELOs.Pokemon;

void main() throws Exception {

    Scanner lr = new Scanner(System.in);
    boolean ciclo = true;

    do {
        System.out.println("1. Registrar Pokemon");
        System.out.println("2. Ver todos los pokemon");
        System.out.println("3. Buscar por id");
        System.out.println("4. Buscar por nombre");
        System.out.println("5. Reporte por una region en especifica");
        System.out.println("6. Reporte por una poder en especifica");
        System.out.println("7. Salir");

        int menu = lr.nextInt();
        lr.nextLine();

        switch (menu){
            case 1:
                System.out.println("Registro de un nuevo pokemon");

                System.out.print("Nombre: ");
                String nombre = lr.nextLine();

                System.out.print("Tipo: ");
                String tipo = lr.nextLine();

                System.out.print("Region: ");
                String region = lr.nextLine();

                System.out.print("Poder: ");
                String poder = lr.nextLine();

                try {
                    new Pokemon(nombre, tipo, region, poder).save();
                    System.out.println("Pokemon registrado!");
                }catch (Exception e){
                    e.getMessage();
                }

                break;
            case 2:
                if (Pokemon.getAll().isEmpty()){
                    System.out.println("No hay pokemon registrados");
                    break;
                }

                System.out.println("--Lista de pokemon registrados--");

                Pokemon.getAll().forEach(pokemon -> {
                    System.out.println("Pokemon: " + pokemon.toString());
                });

                break;
            case 3:

                System.out.print("Escribe el id del pokemon: ");
                int id = lr.nextInt();
                lr.nextLine();

                if (Pokemon.find(id) != null){
                    Pokemon p = Pokemon.find(id);
                    System.out.println("el pokemon " + p.getNombre() + " se encuentra en la base de datos");
                }
                else{
                    System.out.println("No hay pokemon con tal id  en la base de datos");
                }

                break;
            case 4:
                System.out.print("Escribe el nombre del pokemon: ");
                String nomfind = lr.nextLine();

                if (Pokemon.findByNombre(nomfind) != null){
                    Pokemon p = Pokemon.findByNombre(nomfind);
                    System.out.println("el pokemon " + p.getNombre() + " se encuentra en la base de datos");
                }
                else{
                    System.out.println("No hay pokemon con tal nombre en la base de datos");
                }
                break;
            case 5:
                System.out.println("Escriba la region que quiera generar el reporte");
                String regionR = lr.nextLine();

                System.out.println("--LISTA DE POKEMON DE LA REGION " + regionR.toUpperCase() + "--" );

                if (Pokemon.generarReportePorRegion(regionR).isEmpty()){
                    System.out.println("No hay pokemon o no existe esa region");
                    break;
                }

                Pokemon.generarReportePorRegion(regionR).forEach(pokemon -> {
                    System.out.println("Pokemon: " + pokemon.toString());
                });

                System.out.println();
                break;
            case 6:
                System.out.println("Escriba el poder que quiera generar el reporte");
                String poderR = lr.nextLine();

                System.out.println("--LISTA DE POKEMON POR EL PODER " + poderR + "--" );

                if (Pokemon.generarReportePokemonMasPoderoso(poderR).isEmpty()){
                    System.out.println("No hay pokemon con tal poder");
                    break;
                }

                Pokemon.generarReportePokemonMasPoderoso(poderR).forEach(pokemon -> {
                    System.out.println("Pokemon: " + pokemon.toString());
                });

                System.out.println();

                break;
            case 7:
                System.out.println("Saliendo...");
                ciclo = false;
                break;
            default:
                System.out.println("Eliga una opcion valida");
                break;
        }



    }while (ciclo);


}
