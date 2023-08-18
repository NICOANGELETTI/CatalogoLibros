
package vista;

import java.util.Scanner;
import negocio.CatalogoLibrosImpl;
import negocio.ICatalogoLibros;

public class presentacion {
    
    
    
    
    public static void main(String[] args) {
        
      //Variables
      var opcion = -1; 
      var scanner = new Scanner(System.in);
         
//      
//      ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
//      
//      
//      while(opcion != 0){
//          System.out.println("Elige una opcion: \n "
//          + "1. Iniciar catalogo de libros\n"
//          + "2. Agregar libro\n"
//          + "3. Listar libros\n"
//          + "4. Buscar libros\n"
//          + "0. Salir\n");
//          
//          //Tomo en una variable lo que puse el usuario pasandolo de String a Int
//          opcion = Integer.parseInt(scanner.nextLine());
//    
//          switch(opcion){
//              case 1: 
//                  catalogo.iniciarCatalogoPeliculas();
//                  break;
//              case 2: 
//                  System.out.println("Proporcione el nombre de la pelicula");
//                  var nombre = scanner.nextLine();
//                  catalogo.agregarPelicula(nombre);
//                  break;
//              case 3:
//                  catalogo.listarPeliculas();
//                  break;
//              case 4:
//                  System.out.println("Introduce una pelicula a buscar");
//                  var buscar = scanner.nextLine();
//                  catalogo.buscarPelicula(buscar);
//                  break;
//              case 0: 
//                  System.out.println("Hasta pronto");
//                  break;
//              default:
//                  System.out.println("Opcion no reconocida");
//                  break;
//          }
//          
//      }
//        
//        
//        
        
      
     //Definimos las varibales
     
     var opcionDos = -1;
     ICatalogoLibros catalogoDos = new CatalogoLibrosImpl();
        
     
     var scannerDos = new Scanner(System.in);
     
     
     while(opcionDos != 0){
         System.out.println(
                 "Elige una opcion : \n" + 
                   "1. Iniciar Catalogo Libros \n"
                 + "2.Agregar Libro \n"
                 + "3.Buscar Libro \n"
                 + "4.Listar Libros \n"
                 + "0. Salir"
               
                 );
           opcionDos = Integer.parseInt(scanner.nextLine());
        switch(opcionDos){
            case 1:
                catalogoDos.iniciarCatalogoLibros();
                   System.out.println("Se ha creado el catalogo con exito!");
                break;
            case 2: 
                System.out.println("Ingrese el nombre del nuevo Libro: ");
                var nombreLibroDos = scannerDos.nextLine();
                catalogoDos.agregarLibro(nombreLibroDos);
                break;
            case 3:
                System.out.println("Ingrese el nombre del libro a buscar: ");
                var libroBuscado = scannerDos.nextLine();
                catalogoDos.buscarLibro(libroBuscado);
                break; 
            case 4:
                catalogoDos.listarLibros();
                break; 
            case 0:
                System.out.println("Hasta pronto");
                break; 
            default:
                System.out.println("Opcion no reconocida");
                break; 
        }
     
     }
    }
}
