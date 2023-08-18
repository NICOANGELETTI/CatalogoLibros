
package excepciones;

public class AccesoDatosEx extends Exception{
    
    //Aplicamos el metodo para enviar un mensaje
    public AccesoDatosEx(String mensaje){
        super(mensaje);
    }
    
}
