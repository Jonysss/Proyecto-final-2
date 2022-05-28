//CLASE PADRE DE SUBCLASES
import java.time.LocalDate;
 import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservas {
    private int NumeroReserva;
     private LocalDate FechaEntrada;//ENCAPSULAMIENTO DE DATOS
         private LocalDate FechaSalida;
            private ArrayList<Usuarios> usuario;
    private ArrayList <Recursos> organizacion;

    public Reservas(int NumeroReservas, LocalDate FechaEntrada, LocalDate FechaSalida) {
        this.NumeroReserva = NumeroReservas;
     this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;//METODO PARA LA GESTION
        usuario = new ArrayList<>();
      organizacion = new ArrayList<>();
    }
    public int getNumeroReserva() {
        return NumeroReserva;
    }
  public LocalDate getFechaEntrada() {
        return FechaEntrada;
    }
             public LocalDate getFechaSalida() {
       return FechaSalida;
    }
   public ArrayList<Usuarios> getUsuarios() {
        return usuario;
    }
    public ArrayList<Recursos> getRecursos() {
        return organizacion;
    }
public void setNumeroReservas(int NumeroReservas) {
        this.NumeroReserva = NumeroReservas;
    }
    public void setFechaEntrada(LocalDate FechaEntrada) {
        this.FechaEntrada = FechaEntrada;
    }
public void setFechaSalida(LocalDate FechaSalida) {
        this.FechaSalida = FechaSalida;
    }
    public void setUsuarios(ArrayList<Usuarios> usuario) {
        this.usuario = usuario;
    }
    public void setRecursos(ArrayList<Recursos> organizacion) {
        this.organizacion = organizacion;
    } public static int ultimaReserva(Organizacion orga) {//METODO PARA ENLISTAR RESERVAS
        int numeroUltimaReserva = 0;
        ArrayList<Reservas> reserva = orga.getReservas();
    numeroUltimaReserva = (reserva.get(reserva.size() - 1).getNumeroReserva()) + 1;
        return numeroUltimaReserva;
    }
    public void addUsuarios(Usuarios usuarios) {
        usuario.add(usuarios);
    } public void addRecursos(Recursos organizaciones) {
        organizacion.add(organizaciones);
    }
    public static LocalDate parseFecha(String string) throws Exception{
        LocalDate fechaParsing = null;
        Scanner sc = new Scanner(System.in);  do try {
            System.out.print(string);
      String fechaString = sc.nextLine();
            fechaParsing = LocalDate.parse(fechaString);
        } catch (DateTimeParseException e) {
        } while (fechaParsing == null);
        return fechaParsing;
    }
    public static boolean noCoincideTiempo(LocalDate entradaReservaNueva, LocalDate salidaReservaExistente) {//METODO PARA LA GESTION
        return entradaReservaNueva.isAfter(salidaReservaExistente) &&
                entradaReservaNueva.isEqual(salidaReservaExistente);}
    public static boolean fechaEnPeriodo(LocalDate inicioPeriodo, LocalDate finPeriodo,
                                         LocalDate fechaEntrada, LocalDate fechaSalida) {
        return fechaSalida.isAfter(inicioPeriodo) && fechaEntrada.isBefore(finPeriodo);
    }
            public static void organizacionesPeriodo(Organizacion orga, LocalDate inicioPeriodo, LocalDate finPeriodo) {
                for (Recursos organizacion : orga.getRecursoses()) {
                    if (organizacion instanceof Salon) {
                        organizacionesPeriodoComprobacion(orga, inicioPeriodo, finPeriodo, organizacion);
                    }
                }
                for (Recursos organizacion : orga.getRecursoses()) {
                    if (organizacion instanceof Cañonera) {
                        organizacionesPeriodoComprobacion(orga, inicioPeriodo, finPeriodo, organizacion);
                    }
                }
                for (Recursos organizacion : orga.getRecursoses()) {
                    if (organizacion instanceof Mesas) {
                 organizacionesPeriodoComprobacion(orga, inicioPeriodo, finPeriodo, organizacion);
                    }}
            }
    public static void organizacionesPeriodoComprobacion(Organizacion orga, LocalDate inicioPeriodo,//METODO PARA COMPROBAR PERIODO
         LocalDate finPeriodo, Recursos organizacion) {
        boolean ocupada = false;
        for (Reservas reserva : orga.getReservas()) {
            LocalDate entrada = reserva.getFechaEntrada();
            LocalDate salida = reserva.getFechaSalida();
            if (fechaEnPeriodo(inicioPeriodo, finPeriodo, entrada, salida) &&
                    (reserva.getRecursos().contains(organizacion))) {
             ocupada = true;
            }
        }
        if (!ocupada) {
            System.out.println(organizacion);   }
    }
    static void borrarReserva(Organizacion orga, int numero) {
        for (Reservas reserva : orga.getReservas()) {
            if (reserva.getNumeroReserva() == numero){
                orga.deleteReservation(reserva);
                break;}
        }
    }
    @Override  //MUESTRA LOS DATOS EN PANTALLA
    public String toString() {
        return "Numero de la reserva: " + this.NumeroReserva + ", el usuario: " + this.usuario + "En la organizacion: "
      + this.organizacion + ", fecha de recepcion: " + this.FechaEntrada + ", fecha de regreso: "
                + this.FechaSalida;
    }
}
