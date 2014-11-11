//****************************************************************
// Autores: Otto Wantland Carne: 13663 Diego Rodriguez Carne: 13111 Andrea Barrera Carne:13655
// Seccion: 20
//Fecha 12/9/14
// Nombre de Archivo: Archivo.java
// Breve Descripcion: Clase que se encarga de cargar el archivo de texto para poder usarlo en el programa
//*****************************************************************
package lab9;

public class Vertice{
    public String vert;
    
    public Vertice(String vertice){
        vert = vertice;
    }
    
    public boolean comparaNombres(Vertice e){
    return vert.equals(e.vert);
    }
    
    public void setVertice(String nombre){
        vert = nombre;
    }
    
    
    public String getVertice(){
        return vert;
    }
}
