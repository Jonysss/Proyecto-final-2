
//CLASE PADRE DE SUBLCLASES
import java.util.Scanner;

public class Recursos {
    private int Numero;//ENCAPSULAMIENTO DE DATOS
    public Recursos(int Numero) {
        this.Numero = Numero;
    }
                  public int getNumero() {
        return Numero;
    }
           public void setNumero(int Numero) {//METODOS PARA RETORNO DE DA
        this.Numero = Numero;
    }
    static boolean organizacionExiste(int num, Organizacion orga) {
        boolean existe = false;
   for(Recursos hab : orga.getRecursoses()) {
            if (hab.getNumero() == num) {
     existe = true;
                break;
            }
        }
        return existe;
    }
    static void borrarRecursos(Organizacion orga, int numero) {//metodo para borrar algun recurso creado
        for (Recursos organizacion : orga.getRecursoses()) {
    if (organizacion.getNumero() == numero){
    orga.deleteRoom(organizacion);
      break;
            }
        }
    }

}
