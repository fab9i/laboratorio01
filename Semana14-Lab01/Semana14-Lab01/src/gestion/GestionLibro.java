/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;
 
import clases.Libro;

/**
 *
 * @author ProfL3403
 */
public class GestionLibro {
    
    private Libro[] libros;
    private int totalLibros;
    
    public GestionLibro(){
        libros = new Libro[50];
        totalLibros=0;
    }
    
    public Libro buscarPorCodigo(String codigo){
        for (int i = 0; i < totalLibros; i++) {
            if(libros[i].getCodigo().equalsIgnoreCase(codigo)){
                return libros[i];
            }
        }
        return null;
    }
    
    
    public boolean registrar(Libro libro){
        //Verificar si esta lleno el arreglo
        if(totalLibros == libros.length){
            return false;
        }
       
        //Evitar duplicados
        if(buscarPorCodigo(libro.getCodigo())!=null)        
        { 
            return false;
        }
        
        //registras
        libros[totalLibros] = libro;
        totalLibros++;
        return true;
    }
    
    public boolean actualizar (Libro libro){
        for (int i = 0; i < totalLibros; i++) {
            if(libros[i].getCodigo().equalsIgnoreCase(libro.getCodigo())){
                libros[i].setTitulo(libro.getTitulo());
                libros[i].setAutor(libro.getAutor());
                libros[i].setPrecio(libro.getPrecio());
                return true;
            }
        }
        return false;
    }
    
    
    public boolean eliminar(String codigo){
        for (int i = 0; i < totalLibros; i++) {
            if(libros[i].getCodigo().equalsIgnoreCase(codigo)){
                
                //correr los demas elementos una posicion a la izquierda
                for ( int j=i ; j< totalLibros-1; j++){
                    libros[j]= libros[j+1];
                }
                
                //Limpiamos el ultimo casillero
                libros[totalLibros -1]= null;
                totalLibros--;
     
                return true;
            }
        }
        return false;
    }
    
    public Libro[] obtenerCursos(){
        return libros;
    }
    public int obtenerTotalLibros(){
        return totalLibros;
    }
    
}
