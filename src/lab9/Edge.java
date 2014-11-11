//****************************************************************
// Autores: Otto Wantland Carne: 13663 Diego Rodriguez Carne: 13111 Andrea Barrera Carne:13655
// Seccion: 20
//Fecha 12/9/14
// Nombre de Archivo: Archivo.java
// Breve Descripcion: Clase que se encarga de cargar el archivo de texto para poder usarlo en el programa
//*****************************************************************
package lab9;

public class Edge {
    public Vertice Origen;
    public Vertice Destino;
    public int distancia;
    
    public Edge(Vertice origen, Vertice destino, int valor){
        Origen = origen;
        Destino = destino;
        distancia = valor;
    }
    
    public void setOrigen(Vertice origen)
    {
        Origen = origen;
    }
    
    public void setDestino(Vertice destino)
    {
        Destino = destino;
    }
    
    public void setDistancia(int valor)
    {
        distancia = valor;
    }
    
    public Vertice getOrigen()
    {
        return Origen;
    }
    
    public Vertice getDestino()
    {
        return Destino;
    }
    
    public int getDistancia()
    {
        return distancia;
    }
}
