
package domain;

//Clase de Entidad(Tabla de base datos)
public class Libros {
    
    //Columna en la tabla
    private String nombre;

    public Libros() {
    }

    public Libros(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
