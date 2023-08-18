
package negocio;


public interface ICatalogoLibros {
    
    //Constante
    String NOMBRE_RECURSO = "libros.txt"; 
    
    
    void agregarLibro(String nombrelibro);
    
    void listarLibros();
    
    void buscarLibro(String buscar);
    
    void iniciarCatalogoLibros();
    
    
    
}
