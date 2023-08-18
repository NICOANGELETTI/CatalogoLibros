
package datos;

import domain.Libros;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;

//Contiene los metodos pero no la forma en la que se ejecutan
public interface IAccesoDatos {
    
    //Definimos metodos que vamos a utilizar(Solo definimos las reglas)
   
    //Lo que regresa                         //La implementancion puede arrojar una excepcion
    boolean existe(String nombreRecurso)throws AccesoDatosEx;
                                               //Implementacion de exepcion mas especifica
    List<Libros> listar(String nombreRecurso) throws LecturaDatosEx;
   
    
    void escribir(Libros libro,String nombreRecurso,boolean anexar) throws EscrituraDatosEx;
        
    String buscar(String nombreRecurso , String buscar) throws LecturaDatosEx;
    
    void crear(String nombreRecurso) throws AccesoDatosEx;
    
    void borrar (String nombreRecurso) throws AccesoDatosEx;
   
}
