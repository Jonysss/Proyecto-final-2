//CLASE PADRE DE SUBLCLASES
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Organizacion {
          private String nombre;//encapsulamiento de datos
    private String direccion;
        private String recursoss;
 private ArrayList<Usuarios> usuarios;
    private ArrayList<Reservas> reservas;
            private ArrayList<Recursos> organizaciones;
    public Organizacion(String nombre, String direccion, String recursoss) {//creacion de metodo
        this.nombre = nombre;
    this.direccion = direccion;
        this.recursoss = recursoss;
     usuarios = new ArrayList<>();
        reservas = new ArrayList<>();
         organizaciones = new ArrayList<>();
    }
    public String getNombre() { return nombre; }
 public String getDireccion() { return direccion; }
   public String getPoblacion() { return recursoss; }
  public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
            }
            public void setPoblacion(String recursoss) {
                this.recursoss = recursoss;
            } 
            public ArrayList<Reservas> getReservas() {
                return reservas;
            }
    public  ArrayList<Usuarios> getUsuarioss() {
        return usuarios;
    }
    public Usuarios getUsuarios(String dni) {
        Usuarios usuario = null;
        boolean encontrado = false;
        Iterator<Usuarios> it = usuarios.iterator();
        while (!encontrado && it.hasNext()) {
   Usuarios c = it.next();
            if (c.getCODIGO().equals(dni)) {
                usuario = c;
     encontrado = true;
            }
        }
 return usuario;
    }
     public ArrayList<Recursos> getRecursoses() {
  return organizaciones;
    }
 public Recursos getRecursos(int num) {
Recursos organizacion = null;
    boolean encontrado = false;
        Iterator<Recursos> it = organizaciones.iterator();
        while (!encontrado && it.hasNext()) {
            Recursos r = it.next();
            if (r.getNumero() == num){
                organizacion = r;
   encontrado = true;
            }
        } return organizacion;
    }
    public void addReserva(Reservas reserva) {
        reservas.add(reserva);
    }
    public void addUsuarios(Usuarios usuario) {
        usuarios.add(usuario);
            }
            public void addRecursos(Recursos organizacion) {
                organizaciones.add(organizacion);
            }
            public void deleteReservation(Reservas reserva) { reservas.remove(reserva);}
                  public void deleteUsuarios(Usuarios usuario) { usuarios.remove(usuario);}
             public void deleteRoom(Recursos organizacion) { organizaciones.remove(organizacion);}
    public void borrarDatos() {
        reservas.clear();
    usuarios.clear();
        organizaciones.clear();
    }
    public static void cargarDatos(Organizacion recursos) {
        Salon salon;
        Cañonera cañonera;
        Mesas mesas;
        Recursos organizacion;
        Usuarios usuario;
        Reservas reserva;
        recursos.borrarDatos();
        
        cañonera = new Cañonera(0, 8, 100, "Organizacion de Empaquetado");
                recursos.addRecursos(cañonera);
                  cañonera = new Cañonera(0, 30.1, 123, "Organizacion de produccion");
            recursos.addRecursos(cañonera);
        cañonera = new Cañonera(0, 30.1, 122, "Organizacion de mantenimiento");
     recursos.addRecursos(cañonera);
     
   usuario = new Usuarios("Jonathan ", "Sequen", "1027900");
     recursos.addUsuarios(usuario);
        usuario = new Usuarios("Osvaldo", "Iquite", "5036459");
     recursos.addUsuarios(usuario);
        usuario = new Usuarios("Miguel  ", " Keme ", "12364155");
     recursos.addUsuarios(usuario);
        usuario = recursos.getUsuarios("2345");
        
            LocalDate fechaEntrada = LocalDate.of(2022, 1, 21);
        LocalDate fechaSalida = LocalDate.of(2022, 10, 3);
                  reserva = new Reservas(1, fechaEntrada, fechaSalida);
                  organizacion = recursos.getRecursos(1);
        reserva.addRecursos(organizacion);
                    reserva.addUsuarios(usuario);
        recursos.addReserva(reserva);
        usuario = recursos.getUsuarios("326");
       fechaEntrada = LocalDate.of(2022, 12, 02);
     fechaSalida = LocalDate.of(2022, 1, 12);
     reserva = new Reservas(5, fechaEntrada, fechaSalida);
   organizacion = recursos.getRecursos(1);
     reserva.addRecursos(organizacion);
        reserva.addUsuarios(usuario);
        recursos.addReserva(reserva);
                    usuario = recursos.getUsuarios("33529651R");
                    fechaEntrada = LocalDate.of(2022, 12, 24);
                      fechaSalida = LocalDate.of(2022, 12, 28);
                      reserva = new Reservas(2, fechaEntrada, fechaSalida);
                    organizacion = recursos.getRecursos(4);
                     reserva.addRecursos(organizacion);
                    reserva.addUsuarios(usuario);
                    recursos.addReserva(reserva);
    }

    @Override  //muetra datos en pantalla
    public String toString() {
        return "Organizacion" + this.nombre + " esta reservado para la organizacion"
                + this.direccion + ", dentro de la " + this.recursoss;
    }
}
