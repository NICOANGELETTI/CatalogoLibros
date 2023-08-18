
package datos;

import domain.Libros;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccesoDatosImpl implements IAccesoDatos {

    //Implementacion de los metodos
    
    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
    File archivo = new File(nombreRecurso); 
    //Retorna verdadero o falso
    return archivo.exists();
    
    
    
    }

    @Override
    public List<Libros> listar(String nombreRecurso) throws LecturaDatosEx {
       var archivo = new File(nombreRecurso);
       List<Libros> libros = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null; 
            linea = entrada.readLine(); 
            while(linea != null)
                    {
           var pelicula = new Libros(linea);
           libros.add(pelicula);
           linea = entrada.readLine();
                    }
            //Cierre de flujo
            entrada.close();
                        
        } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        } catch (IOException ex) {
                ex.printStackTrace();
                throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        }
        //Retornamos  el array de peliculas
        return libros;
       
 }

    @Override
    public void escribir(Libros libro, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        
        var archivo = new File(nombreRecurso);
        try{
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(libro.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo: " + libro);
        }catch(IOException ex){
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir peliculas: " + ex.getMessage());
        }
              
        
        
        
        
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
       
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                break;
            }
                linea = entrada.readLine();
                indice++;
            }
                entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar peliculas:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar peliculas:" + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
    
        var archivo = new File(nombreRecurso);
        try {
            var salida= new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear archivo:" + ex.getMessage());
        }
        
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
   var archivo = new File(nombreRecurso);
   if(archivo.exists())
   archivo.delete();
        System.out.println("Se ha borrado el archivo");
   
   
    }
    
    
}
