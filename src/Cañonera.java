   //SUBCLASE QUE EXTIENDE
import java.util.Scanner;

public class Cañonera extends Recursos {
    private double M2;//ENCAPSULAMIENTO DE DATOS
private double Precio;
  private String TipoCañonera;

    public Cañonera(int numero, double M2, double Precio, String TipoCañonera) {
      super(numero);//METODO PARA LA GESTION
   this.M2 = M2;
   this.Precio = Precio;
        this.TipoCañonera = TipoCañonera;
    }
    public double getM2() {
        return M2;
            }
            public double getPrecio() {
                return Precio;
    }
    public String getTipoCañonera() {
        return TipoCañonera;
    }
                public void setM2(double M2) {
                    this.M2 = M2;
                }
                public void setPrecio(double Precio) {
                    this.Precio = Precio;
    }
    public void setTipoCañonera(String TipoCañonera) {
        this.TipoCañonera = TipoCañonera;
    }
    @Override //MUESTRA LOS DATOS EN PANTALLA
    public String toString() {
             return "Codigo del recurso cañonera: " + getNumero() + ", " + this.M2 + 
                     " Dias maximos de uso: " + this.TipoCañonera + ", precio: " + this.Precio;
    }
}