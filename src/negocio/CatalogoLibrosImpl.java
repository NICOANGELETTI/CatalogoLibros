
package negocio;

import datos.AccesoDatosImpl;
import datos.IAccesoDatos;
import domain.Libros;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CatalogoLibrosImpl implements ICatalogoLibros{

    private final IAccesoDatos datos;

    public CatalogoLibrosImpl() {
        this.datos = new AccesoDatosImpl();
       
        
    }
    
    @Override
    public void agregarLibro(String nombrePelicula) {
        Libros pelicula = new Libros(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);

        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
        
    }

    @Override
    public void listarLibros() {
        try {
            var libros = this.datos.listar(NOMBRE_RECURSO);
           //Para que nos imprimica cada pelicula
            for(var libro: libros){
                System.out.println("Libro: " + libro);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace();
        }
        
    }

    @Override
    public void buscarLibro(String buscar) {
   
    String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error acceso datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }
    

    @Override
    public void iniciarCatalogoLibros() {
        try {
            /*Si existe NOMBRE_RECURSO lo volvemos a inicializar
            borrandolo y volviendolo a iniciar*/
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                //Si no solo lo creamos
                datos.crear(NOMBRE_RECURSO);
            }   } catch (AccesoDatosEx ex) {
                System.out.println("Error al iniciar catalogo de peliculas");
                ex.printStackTrace(System.out);
            
            }
    
    }
    
}
