//SUBCLASE QUE EXTIENDE
import java.util.Scanner;

public class Mesas extends Recursos{
    private double M2Mesaspeq;//ENCAPSULAMIENTO DE DATOS
 private double M2Mesasp;
    private double precio;
 public Mesas(int numero, double M2Mesaspeq, double M2Mesasp, double precio) {
      super(numero);
        this.M2Mesaspeq = M2Mesaspeq;//METODO PARA LA GESTION
    this.M2Mesasp = M2Mesasp;
        this.precio = precio;
    }
   public double getM2Mesaspeq() {
        return M2Mesaspeq;
    }
 public double getM2Mesasp() {
        return M2Mesasp;
    }
    public double getPrecio() {
        return precio;
    }
                public void setM2Mesaspeq(double M2Mesaspeq) {
                      this.M2Mesaspeq = M2Mesaspeq;
                  }
               public void setM2Mesasp(double M2Mesasp) {
        this.M2Mesasp = M2Mesasp;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override  //MUESTRA LOS DATOS EN PANTALLA
    public String toString() {
        return "EL codigo del recurso es el: " + getNumero() + " Dias maximos de uso : " 
                + this.M2Mesasp + ", precio: " + this.precio;
    }
}