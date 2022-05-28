
//CLASE PADRE DE SUBLCLASES
import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
 private String nombre;//ENCAPSULAMIENTO DE DATOS
    private String apellidos;
 private String CODIGO; public Usuarios(String nombre, String apellidos, String CODIGO) {
        this.nombre = nombre;
      this.apellidos = apellidos;
        this.CODIGO = CODIGO;
    }
    public String getNombre() {
        return nombre;
    }
            public String getApellidos() {
                return apellidos;
            }
            public String getCODIGO() {
                return CODIGO;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
            public void setCODIGO(String CODIGO) {
                this.CODIGO = CODIGO;
            }
            static boolean usuarioExiste (String codigoUsuario, Organizacion orga) {//metodo para verificacion si algun usuario existe
                boolean existe = false;
        for (Usuarios cli : orga.getUsuarioss()) {
   if (cli.getCODIGO().equals(codigoUsuario)) {
                existe = true;
                break;
            }  }
        return existe;
    }
 static void borrarUsuarios(Organizacion orga, String codigoUsuario) {
   for (Usuarios usuario : orga.getUsuarioss()) {
        if (usuario.getCODIGO().equals(codigoUsuario)){
    orga.deleteUsuarios(usuario);
            break;
            }
        }
    }
    @Override  //MUESTRA LOS DATOS EN PANTALLA
    public String toString() {
        return "Datos del usuario: " + this.nombre + ", " + this.apellidos +
                ", CODIGO: " + this.CODIGO;
    }
}
