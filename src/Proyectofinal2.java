
import java.time.LocalDate;
import java.util.Scanner;

public class Proyectofinal2 { 
    private static Organizacion ho = new Organizacion ("Alquiler", "San Juan sac", "Guatemala");//UBICACION DE LA ORGANIZACION 
    private static boolean exit;

    public static void main (String[] args) throws Exception {
        
        Organizacion.cargarDatos(ho);  runMenu();
    }  
    public static void runMenu() throws Exception{
        while(!exit){
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }
    private static void printMenu() {//menu prinicipal del sistema creado.
        System.out.println("\n--------Sistema de Reserva de Recursos Compartidos-------------------- ");//PARA MOSTRARA DATOS EN PANTALLA PRINCIPLA
         System.out.println("**************BIENVENIDOS AL SISTEMA, DIGITE SU OPCION*****************");
        System.out.println("1. Gestionar recurso");
          System.out.println("2. Gestionar usuarios");
        System.out.println("3. Gestionar recursos");
        System.out.println("4. Reportes de las reservas.");
        
        
                System.out.println("5. Entregar/rechazar recurso.");
                System.out.println("6. Reportes.");
                System.out.println("7. carga automatica de archivos.");
              System.out.println("Preione 0 para salir del sistema: ");
            }
private static int getInput() throws NumberFormatException{
Scanner entrada = new Scanner(System.in);
int choice = -1;
while(choice < 0 || choice > 7){
try { //creacion de seleccion de menus
      System.out.print("\nInserte el numeral de su opcion: \n");
        choice = Integer.parseInt(entrada.nextLine());
            }
      catch(NumberFormatException e){
                System.out.println("EL NUMERO INTRODUCIDO NO ES VALIDO\n");
            }
        }return choice;
    }
private static void performAction(int choice) throws Exception {  // Esto lo utilice para las diferentes opciones selcionads.
        switch (choice) {
case 0 -> exit = true;
 case 3 -> gestionReservas(ho);
case 1 -> gestionRecursoses(ho);
 case 2 -> gestionUsuarioss(ho);
case 7 -> organizacionesPeriodo(ho);
case 5 -> reservasPeriodo(ho);
case 6 -> reservasUsuariosPeriodo(ho);
   case 4 -> listarDatos(ho);
            default ->
                    
                    System.out.println("NO SE ENCONTRARON DATOS");//salida de datos con error
        }
    } private static void gestionUsuarioss(Organizacion Organizacion) throws Exception {
        while(!exit){
            menuUsuarioss();
            int choice = getInput();
            accionUsuarioss(Organizacion, choice);  }
    }
        private static void menuUsuarioss() {
            System.out.println("\nSELECCIONES LA OPCION QUE DESEE: ");
             System.out.println("---------------------");
            System.out.println("0. Regresar a la pantalla principal");
        System.out.println("1. Crear Usuario");
            System.out.println("2. Inactivar usuario");
            System.out.println("3. Modificar usuarios");
        }private static void accionUsuarioss(Organizacion Organizacion, int choice) throws Exception {
        switch(choice){
            case 0 -> runMenu();
                 case 1 -> crearUsuarios(Organizacion);
              case 2 -> borrarUsuarios(Organizacion);
            case 3 -> listarUsuarioss(Organizacion); }
    }
 private static void crearUsuarios(Organizacion Organizacion) {
        Usuarios usuario;
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca el codigo de usuario: ");
        String codigoUsuario = sc.nextLine();
        if(!Usuarios.usuarioExiste(codigoUsuario, Organizacion)) {
            System.out.print("Introduzca el nombre del usuario: ");
            String nombre = sc.nextLine();
                    System.out.print("Introduzca los apellidos del usuario: ");
                    String apellidos = sc.nextLine();
                    System.out.print("Introduzca correo electronico: ");
                            String correo = sc.nextLine();
                            System.out.print("Introduzca el numero de telefono: ");
                    int telefono = sc.nextInt();
            System.out.print("Introduzca la direccion del usuario: ");
            String direccion = sc.nextLine();
                usuario = new Usuarios(nombre, apellidos, codigoUsuario);
                Organizacion.addUsuarios(usuario);
                System.out.println(usuario + 
                     "\n" + " Correo electronico: " + correo + " Telefono: " + 
                   telefono + " Direccion: " + direccion + " se ha agregado");
        } else  {
            System.out.println("Este usuario ya existe");
        }
    }
    private static void borrarUsuarios(Organizacion Organizacion) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------");
        System.out.println(" 😍               INACTIVAR USUARIOS                    😍");
            System.out.println("-----------------------------------------------------------");

            System.out.print("Introduca el codigo Usuario del usuario: ");
        String codigoUsuarioUsuariosBorrar = sc.nextLine();
        Usuarios.borrarUsuarios(ho, codigoUsuarioUsuariosBorrar);
        System.out.print("El usuario se ha inactivado.");
    }
    private static void listarUsuarioss(Organizacion Organizacion) {
         System.out.println("////////////////////////////////////////////");
        System.out.println(" MODIFICAR USUSARIO (PRESIONE 1 SI NO EJECUTA) : ");
        for (Usuarios usuario : ho.getUsuarioss()) {
            System.out.println(usuario);
        }
    }
    private static void gestionRecursoses(Organizacion Organizacion) throws Exception {
        while(!exit){
            menuRecursoses();
            int choice = getInput();
            accionRecursoses(Organizacion, choice);
        }
    } private static void menuRecursoses() {
        System.out.println("\nSeleccione la accion: ");
          System.out.println("---------------------");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Crear un recurso nuevo");
        System.out.println("2. Borrar un recurso");
           System.out.println("3. Listar de recursos ");
    } private static void accionRecursoses(Organizacion Organizacion, int choice) throws Exception {
        switch(choice){
            case 0 -> runMenu();
           case 1 -> crearRecursos(Organizacion);
            case 2 -> borrarRecursos(Organizacion);
          case 3 -> listarRecursoses(Organizacion);
           }
    } 
    private static void crearRecursos(Organizacion Organizacion) throws Exception {
        Scanner sc = new Scanner(System.in);
        int numero = 0;

        try {
            System.out.print("Introduzca un codigo para el recurso: ");
            numero = Integer.parseInt(sc.nextLine());
        } catch (Exception e){
            System.err.println("Introduzca un codigo valido\n" + e);
        }
        if (Recursos.organizacionExiste(numero, Organizacion)) {
            System.out.println("Esta recurso ya existe.");
        } else {

            System.out.println("Introduzca el tipo de recurso");
            System.out.println("---------------------");
         System.out.println("0. Volver al menu");
    System.out.println("1. Crear recurso Salon");// OPCION PARA ELECCION DE SUBMENUS
            System.out.println("2. Crear recurso Cañonera");
   System.out.println("3. Crear recurso Mesas");

            int choice = -1;
            while (choice < 0 || choice > 3) {
                try {
                    System.out.print("\nIntroduzca la opcion: \n");
                    choice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Introduzca un numero valido\n");
                }
                switch (choice) {
            case 0 -> runMenu();
               case 1 -> crearOrganizacion(Organizacion, numero);
                 case 2 -> crearCañonera(Organizacion, numero);
           case 3 -> crearMesas(Organizacion, numero);
                    
                }
            }
        }
    }private static void crearOrganizacion(Organizacion Organizacion, int numero) {
        Salon salon;
        Scanner sc = new Scanner(System.in);
System.out.println("***************************************************");
        System.out.print("Ingrese los dias maximos de uso: ");
        double dias = sc.nextDouble();
         System.out.println("Ingrese el nombre del recurso: ");// OPCION PARA ELECCION DE SUBMENUS
        String nombre = sc.nextLine();
        System.out.print("Introduzca el precio si lo hay si no coloque 0: ");
        
        
      double precio = sc.nextDouble();
        
        salon = new Salon(numero, dias, precio);
       
        Organizacion.addRecursos(salon);
        System.out.println(salon);
    }

    private static void crearCañonera(Organizacion Organizacion, int numero) throws Exception{
        Cañonera cañonera;
        Scanner sc = new Scanner(System.in);
        double dias = 0, precio = 0;

        try {
       System.out.println("***************************************************");
            System.out.print("Ingrese los dias maximo de uso del recurso : ");// OPCION PARA ELECCION DE SUBMENUS
            dias = Double.parseDouble(sc.nextLine());
            System.out.print("Introduzca el precio si lo hay si no coloque 0: ");
            precio = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.err.println("Introduzca un numero valido.\n" + e);
        }
        System.out.print("Introduzca el tipo de cañonera: ");
        String tipoCama = sc.nextLine();
 cañonera = new Cañonera(numero, dias, precio, tipoCama);
       
     Organizacion.addRecursos(cañonera);
        System.out.println(cañonera);
    }
    private static void crearMesas(Organizacion Organizacion, int numero) throws Exception{
        Mesas mesa;
       Scanner sc = new Scanner(System.in);
    double diasMax =0.0, diasP = 0.0, precioMesas = 0.0;

        try {
             System.out.println("***************************************************");
            System.out.print("Ingrese los dias maximos de uso del recurso:  ");// OPCION PARA ELECCION DE SUBMENUS
            diasMax = Double.parseDouble(sc.nextLine());
            System.out.print("Introduzca el precio si lo hay si no coloque 0: ");
          diasP = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.err.println("Introduzca un numero valido.\n" + e);
        }
        mesa = new Mesas(numero, diasMax, diasP, precioMesas);
   Organizacion.addRecursos(mesa);
        System.out.println(mesa);
    }
    private static void borrarRecursos(Organizacion Organizacion) throws Exception {
        Scanner sc = new Scanner(System.in);
      
        System.out.println(" ^^^^^^^^^^  Borrar recurso  ^^^^^^^^^^^^^^ ");
      System.out.print("Introduca el codigo del recurso: ");
        int numeroRecursosBorrar = Integer.parseInt(sc.nextLine());// OPCION PARA ELECCION DE SUBMENUS
        Recursos.borrarRecursos(ho, numeroRecursosBorrar);
        System.out.print("El recurso se ha borrado");
    }
    private static void listarRecursoses(Organizacion Organizacion) {
        Salon salon;
     Cañonera cañonera;
        Mesas mesa;
    System.out.println(" Listado de recursos");
        
for (Recursos organizacion : Organizacion.getRecursoses()) {
            if (organizacion instanceof Salon) {
                salon = (Salon) organizacion;
                System.out.println(salon);
            } else if (organizacion instanceof Cañonera) {
                cañonera = (Cañonera) organizacion;
                System.out.println(cañonera);
            } else if (organizacion instanceof Mesas) {
                mesa = (Mesas) organizacion;
                System.out.println(mesa);
            }
        }
    }
    private static void gestionReservas(Organizacion Organizacion) throws Exception {
        while(!exit){
            menuReservas();
            int choice = getInput();
            accionReservas(Organizacion, choice);
        }
    }
    private static void menuReservas() {// OPCION PARA ELECCION DE SUBMENUS
        System.out.println("\nSeleccione la accion: ");
        System.out.println("---------------------");
      System.out.println("0. Volver al menu principal");
     System.out.println("1. Crear una reserva de recurso nueva");
        System.out.println("2. Borrar una reserva de recurso");
      System.out.println("3. Listar reservas de recursos");
    }

    private static void accionReservas(Organizacion Organizacion, int choice) throws Exception {
        switch(choice){
            case 0 -> runMenu();
     case 1 -> crearReserva(Organizacion);
          case 2 -> borrarReserva(Organizacion);
       case 3 -> listarReservas(Organizacion);
            default ->
           
                    System.out.println("Los datos no son validos: ");
        }
    } 
    private static void crearReserva(Organizacion Organizacion) throws Exception {
        Reservas reserva;
    Usuarios usuario = null;
     Recursos organizacion;
        int numeroRecursos = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el CODIGO USUARIO del usuario: ");
        String cl = sc.nextLine();
        try {
            if (Usuarios.usuarioExiste(cl, Organizacion)) {
                usuario = Organizacion.getUsuarios(cl);
                System.out.println("informacion del usuario: " + usuario);
            } else {
                System.out.println("Este usuario no existe");
                runMenu();
            }
        } catch (Exception e) {
            System.err.println("Introduce un usuario valido" + e);
        }
        int numeroReserva = Reservas.ultimaReserva(Organizacion);
        System.out.println("Numero de la reserva: " + numeroReserva);
        LocalDate fechaEntrada;
        do {
            System.out.print("Introduzca la fecha de entrada (formato año-mes-dia): ");
            fechaEntrada = Reservas.parseFecha(sc.nextLine());
        } while ((fechaEntrada == null) || (fechaEntrada.isBefore(LocalDate.now())));
        LocalDate fechaSalida;
        do {
            System.out.print("Introduzca la fecha de salida       (formato año-mes-dia): ");
            fechaSalida = Reservas.parseFecha(sc.nextLine());
        } while (fechaSalida == null || fechaSalida.isBefore(fechaEntrada));
        System.out.println("Los recursos libres para para fechas son: -----------------------------------------");
        Reservas.organizacionesPeriodo(Organizacion, fechaEntrada, fechaSalida);
        try {
            System.out.print("Introduzca el numero de la organizacion: ");
            numeroRecursos = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.err.println("Introduce una organizacion valida" + e);
        }
        organizacion = Organizacion.getRecursos(numeroRecursos);
        for (Reservas res : Organizacion.getReservas()) {
            if (numeroRecursos == organizacion.getNumero()) {
                LocalDate salidaComprobar = res.getFechaSalida();
                if (Reservas.noCoincideTiempo(fechaEntrada, salidaComprobar)) {
             System.out.println("Se ha agregado a la reserva la organizacion: " + numeroRecursos);
                reserva = new Reservas(numeroReserva, fechaEntrada, fechaSalida);
            reserva.addUsuarios(usuario);
         reserva.addRecursos(organizacion); System.out.println(reserva);
                   Organizacion.addReserva(reserva);
                } else {
                    System.out.println("Ya hay una reserva para ese dia : " + salidaComprobar);
                }
            }
                   }
    }
    private static void borrarReserva(Organizacion Organizacion) throws Exception {
        Scanner sc = new Scanner(System.in);
   System.out.println("    eliminar reserva   ");
        System.out.println("////////////////////////////////////");
    System.out.print("Introduca el numero de la reserva: ");// OPCION PARA ELECCION DE SUBMENUS
            int numeroReservaBorrar = Integer.parseInt(sc.nextLine());
        Reservas.borrarReserva(ho, numeroReservaBorrar);
                 System.out.print("La reserva se ha eliminado correctamente.");
    }
    private static void listarReservas(Organizacion Organizacion) {
System.out.println("   Listado de reservas   ");
        System.out.println("---------------------------------------------------------------");for (Reservas reserva : Organizacion.getReservas()) {
            System.out.println(reserva);
        }
    }
    private static void organizacionesPeriodo(Organizacion Organizacion) throws Exception{
        String fechaEntrada = "Introduzca la fecha inicial del periodo a comprobar (año-mes-dia): ";// OPCION PARA ELECCION DE SUBMENUS
        LocalDate inicioPeriodo = Reservas.parseFecha(fechaEntrada);
    String fechaSalida = "Inserte las fechas (año-mes-dia): ";
        LocalDate finPeriodo = Reservas.parseFecha(fechaSalida);
        System.out.println("Recursoses disponibles entre " + inicioPeriodo + " y " + finPeriodo);
    
        System.out.println("Salons libres");
  

        for (Recursos organizacion : Organizacion.getRecursoses()) {
            if (organizacion instanceof Salon) {
                Reservas.organizacionesPeriodoComprobacion(Organizacion, inicioPeriodo, finPeriodo, organizacion);
            }
        }

     
        System.out.println("Cañoneras libres");
   
        for (Recursos organizacion : Organizacion.getRecursoses()) {
            
            if (organizacion instanceof Cañonera) {
                Reservas.organizacionesPeriodoComprobacion(Organizacion, inicioPeriodo, finPeriodo, organizacion);
            }
        }
        System.out.println("Mesass libres");
        for (Recursos organizacion : Organizacion.getRecursoses()) {
            if (organizacion instanceof Mesas) {
                Reservas.organizacionesPeriodoComprobacion(Organizacion, inicioPeriodo, finPeriodo, organizacion);
            }
        }
    }
    private static void reservasPeriodo(Organizacion Organizacion) throws Exception {
        String fechaEntrada = "Introduzca la fecha inicial del periodo a comprobar (año-mes-dia): ";// OPCION PARA ELECCION DE SUBMENUS
   LocalDate inicioPeriodo = Reservas.parseFecha(fechaEntrada);     
String fechaSalida = "Introduzca la fecha final del periodo a comprobar (año-mes-dia): ";
        LocalDate finPeriodo = Reservas.parseFecha(fechaSalida);
        if (!Organizacion.getReservas().isEmpty()) {
            System.out.println("Reservas para el periodo introducido");

   boolean encontrada = false;
            for (Reservas reserva : Organizacion.getReservas()) {
     LocalDate fechaDeSalida = reserva.getFechaSalida();
     LocalDate fechaDeEntrada = reserva.getFechaEntrada();
                if (Reservas.fechaEnPeriodo(inicioPeriodo, finPeriodo, fechaDeEntrada, fechaDeSalida)) {
          System.out.println(reserva);
                    encontrada = true;
                }
            } if (!encontrada) {
 System.out.println("No tenems reservas de recursos para este dia ");
            }
        } else {
            System.out.println("No tenemos reservaciones de recursos este dia de fecha");
        }
    }
    private static void reservasUsuariosPeriodo(Organizacion Organizacion) throws Exception{
            String fechaEntrada = "Introduzca una fecha de inicio (año-mes-dia): ";
        LocalDate inicioPeriodo = Reservas.parseFecha(fechaEntrada);

        String fechaSalida = "introduzca una fecha final (año-mes-dia): ";
              LocalDate finPeriodo = Reservas.parseFecha(fechaSalida);

        for (Usuarios usuario : Organizacion.getUsuarioss()) {
            boolean estaEnReserva = false;
            for (Reservas reserva : Organizacion.getReservas()) {
       LocalDate entrada = reserva.getFechaEntrada();
             LocalDate salida = reserva.getFechaSalida();
                        if (Reservas.fechaEnPeriodo(inicioPeriodo, finPeriodo, entrada, salida) &&
                        (reserva.getUsuarios().contains(usuario))) {
         estaEnReserva = true;
                }
                if (estaEnReserva) {
                    System.out.println(reserva);
                }
                estaEnReserva = false;
            }
        }
    }
    private static void listarDatos (Organizacion Organizacion) {
        Salon salon;
   Cañonera cañonera;
                   Mesas mesa;
System.out.println("Recursos");

        for (Recursos organizacion : Organizacion.getRecursoses()) {
            if (organizacion instanceof Salon) {
     salon = (Salon) organizacion;
         System.out.println(salon);
            } else if (organizacion instanceof Cañonera) {
       cañonera = (Cañonera) organizacion;
                System.out.println(cañonera);
            } else if (organizacion instanceof Mesas) {
                mesa = (Mesas) organizacion;
                System.out.println(mesa);
            }
        }
System.out.println("Usuarioss");
                                   
                                   for (Usuarios usuario : Organizacion.getUsuarioss()) {
                                       System.out.println(usuario);
                                   }
                                    
                                   System.out.println("Reservas");

                                   Organizacion.getReservas().forEach(System.out::println);
    }


}
