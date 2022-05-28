
//SUBCLASE QUE EXTIENDE
import java.util.Scanner;

public class Salon extends Recursos {
    private double M2;//ENCAPSULAMIENTO DE DATOS
    private double precio;

    public Salon(int Numero, double M2, double precio) {//METODO PARA LA GESTION
        super(Numero);
        this.M2 = M2;
        this.precio = precio;
    }
            public double getM2() {
                return M2;
            }
            public double getPrecio() {
                return precio;
    }
    public void setM2(double M2) {
        this.M2 = M2;
    }
    public void setPrecio(double precio) {this.precio = precio;}
    @Override   //MUESTRA LOS DATOS EN PANTALLA
    public String toString() {
        return "El salon reservado para esta organizacion es " + getNumero() +
                " con numero de org. " + this.M2 + " por, precio: " + this.precio;
    }
}
