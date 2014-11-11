//****************************************************************
// Autores: Otto Wantland Carne: 13663 Diego Rodriguez Carne: 13111 Andrea Barrera Carne:13655
// Seccion: 20
//Fecha 12/9/14
// Nombre de Archivo: Archivo.java
// Breve Descripcion: Clase que se encarga de cargar el archivo de texto para poder usarlo en el programa
//*****************************************************************
package lab9;
import java.util.*;

public class lab9 {
   
    public static void main(String[] args) {
        Archivo grafo;
        grafo = new Archivo("grafos");
        grafo.LeerArchivo();
        Scanner scan = new Scanner(System.in);
        Grafo miGrafo = new Grafo();        
        
        String[][] matriz = grafo.GetMatriz();
        int[][] adyacencia = miGrafo.generarAdyacencia(matriz);
        
        String Menu = "............................................\n1. Determinar Ruta \n2. Ver ciudad central \n3. Agregar trayectoria \n4. Salir \n............................................\nIngrese el numero de la opción a realizar: ";
        int opcion = 0;
       
        while (opcion != 4){
          
            String Ciudades = "";
            
            for (int i = 0; i < miGrafo.ListaVertices.size();i++)
               Ciudades += miGrafo.ListaVertices.get(i).vert + ", ";
            if (Ciudades.length() > 0)   Ciudades = Ciudades.substring(0, Ciudades.length()-2);
            System.out.println("\n\n--------------------------------------------");
            System.out.println("Ciudades: " + Ciudades);
            
            System.out.print(Menu);
            
            opcion = scan.nextInt();
            switch(opcion){
                case 1:{
                    System.out.print("Ciudad de origen: ");
                    String Origen = scan.next();
                    System.out.print("Ciudad de destino: ");
                    String Destino = scan.next();
                    if (Origen.equals(Destino)) System.out.println("Ciudad de origen debe ser distinta a la de destino");
                    else if ((!Ciudades.toUpperCase().contains(Origen.toUpperCase())) || (!Ciudades.toUpperCase().contains(Destino.toUpperCase())))  System.out.println("Alguna de las ciudades no existe");
                    else {
                       //matriz = grafo.GetMatriz();
                        for (int i = 0; i < miGrafo.ListaVertices.size();i++)
                            Ciudades += miGrafo.ListaVertices.get(i).vert + ", ";
                        if (Ciudades.length() > 0)   Ciudades = Ciudades.substring(0, Ciudades.length()-2) + ".";  
                        System.out.println("\nLos numeros estan en el orden en que se presentan las ciudade al inicio del programa");
                        System.out.println(miGrafo.floyd(adyacencia));
                        System.out.println(miGrafo.Distancia(Origen, Destino, adyacencia)+"\n"); 
                            
                           
                    }
                    //matriz = grafo.GetMatriz();
                }break;
                
                case 2:{
                    //adyacencia = miGrafo.generarAdyacencia(matriz);
                    String ciudad = ""; 
                    Double exc = Double.MAX_VALUE; 
                    for (int i = 0; i < miGrafo.ListaVertices.size();i++){
                        Double dminima = 0.0;
                        for (int j = 0; j < miGrafo.ListaVertices.size();j++)
                            dminima += adyacencia[i][j];
                        if ((dminima < exc) && (dminima != 0)){
                            ciudad = miGrafo.ListaVertices.get(i).vert;
                            exc = dminima;
                        }
                    }
                    System.out.println("Ciudad central: " + ciudad);
                }break;
                
                case 3:{
                    System.out.print("Origen: ");
                    String Origen = scan.next();
                    System.out.print("Destino: ");
                    String Destino = scan.next();
                    if ((Ciudades.toUpperCase().contains(Origen.toUpperCase())) && (Ciudades.toUpperCase().contains(Destino.toUpperCase())))
                            System.out.println("Ruta ya existente");
                    else{
                        System.out.print("Distacia: ");
                        int valor = scan.nextInt();
                        if (valor < 0) System.out.println("La distancia debe ser positiva");
                        else {
                            grafo.EscribirArchivo(Origen + " " + Destino + " " + valor,true);
                        }
                        System.out.println("Trayectoia agregada");
                    }
                    matriz = grafo.GetMatriz();
                    adyacencia = miGrafo.generarAdyacencia(matriz);
                }break;
            }
        }
    }
}