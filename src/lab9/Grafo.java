//****************************************************************
// Autores: Otto Wantland Carne: 13663 Diego Rodriguez Carne: 13111 Andrea Barrera Carne:13655
// Seccion: 20
//Fecha 12/9/14
// Nombre de Archivo: Archivo.java
// Breve Descripcion: Clase que se encarga de cargar el archivo de texto para poder usarlo en el programa
//*****************************************************************
package lab9;
import java.util.ArrayList;

public class Grafo implements InterfazGrafos 
{
    public ArrayList<Vertice> ListaVertices = new ArrayList<>();
    public ArrayList<Edge> ListaEdge = new ArrayList<>();   
    public int[][] Adyacencia;
    
    public Grafo(){}
    
    public int[][] generarAdyacencia(String[][] matriz){
        ListaVertices.clear();
        if (matriz.length > 0){
            for(int i=0; i<matriz.length; i++){
                Vertice ciudad = new Vertice(matriz[i][0]);
                Vertice destino = new Vertice(matriz[i][1]);
                int distancia = Integer.parseInt(matriz[i][2]);
                Edge trayecto = new Edge(ciudad, destino, distancia);
                int parametro = 0;
                for(int a=0; a<ListaVertices.size(); a++){
                    if (ciudad.comparaNombres(ListaVertices.get(a)) == true){
                        parametro = 1;
                    }
                }
                if(parametro == 0){
                    ListaVertices.add(ciudad);
                }
                parametro = 0;
                for(int b=0; b<ListaVertices.size(); b++){
                    if (destino.comparaNombres(ListaVertices.get(b)) == true){
                        parametro = 1;
                    }
                }
                if(parametro == 0){
                    ListaVertices.add(destino);
                }
                parametro = 0;
                for(int c=0; c<ListaEdge.size(); c++){
                    if (distancia == ListaEdge.get(c).distancia){
                        parametro = 1;
                    }
                }
                if(parametro == 0){
                    ListaEdge.add(trayecto);
                }
            }
           Adyacencia = new int[ListaVertices.size()][ListaVertices.size()];
            for(int j=0; j<Adyacencia.length;j++ ){
                for(int k=0; k<Adyacencia.length; k++){
                    if (j != k) Adyacencia[j][k] = 999999999;
                    Vertice A = ListaVertices.get(j);
                    Vertice B = ListaVertices.get(k);
                    for(int l=0; l<ListaEdge.size(); l++){
                        Edge arco = ListaEdge.get(l);
                        if(arco.Origen.vert.equals(A.vert) == true){
                            if (arco.Destino.vert.equals(B.vert) == true) {
                                Adyacencia[j][k] = arco.distancia;
                            }
                        }
                    }

                }
            }
            return Adyacencia;
        }
        return new int[0][0];
    }
    
    
    @Override
    public void addEdge(Edge e){
        ListaEdge.add(e);
    }
    
    
    @Override
    public void addVertice(Vertice v){
        ListaVertices.add(v);
    }    
   
    
    public String Distancia (String Ciudad, String Destino, int[][] matriz){
    for (int i = 0; i < ListaVertices.size(); i++)
        for (int j = 0; j < ListaVertices.size(); j++)
            if ((ListaVertices.get(i).vert.toUpperCase().equals(Ciudad.toUpperCase())) & (ListaVertices.get(j).vert.toUpperCase().equals(Destino.toUpperCase())))
                if (matriz[i][j] >= 999999999)
                    return "No existe distancia o camino entre " + Ciudad + " y " + Destino;
                else return "Distancia:" + Integer.toString(matriz[i][j]);
    return "";
    }  
    
    
    public boolean Contiene(String Ciudad){
        for (int i = 0; i < ListaVertices.size();i++)
            if (ListaVertices.get(i).vert.toUpperCase().equals(Ciudad.toUpperCase()))
                return true;
        return false;
    }
   
  // Link: http://es.wikibooks.org/wiki/Implementación_del_algoritmo_de_Floyd_en_Java
   public String floyd(int[][] adyacencia)
   {
                int n=adyacencia.length;
                int D[][]=adyacencia;
 
                String enlaces[][]=new String [n][n];
                String[][] aux_enlaces=new String[adyacencia.length][adyacencia.length];
 
                     for (int i = 0; i < n; i++) {
                         for (int j = 0; j < n; j++) {
                              enlaces[i][j]="";
                              aux_enlaces[i][j]="";
                        }
                     }
                String enl_rec="";
                   for (int k = 0; k < n; k++) {
                      for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                       float aux=D[i][j];
                                       float aux2=D[i][k];
                                       float aux3=D[k][j];
                                       float aux4=aux2+aux3;
                                       float res=Math.min(aux,aux4);
                                       if(aux!=aux4)
                                        {
                                          if(res==aux4)
                                             {
                                                      enl_rec="";
                                                      aux_enlaces[i][j]=k+"";
                                                      enlaces[i][j]=enlaces(i,k,aux_enlaces,enl_rec)+(k+1);
                                             }
                                        }
                                     D[i][j]=(int) res;
                                }
                         }
                }
 
                String cadena="";
                for (int i = 0; i < n; i++) {
                   for (int j = 0; j < n; j++) {
                          cadena+=D[i][j]+" ";
                         }
                       cadena+="\n";
                 }
 
                String enlacesres="";
                   for (int i = 0; i <n; i++) {
                          for (int j = 0; j < n; j++) {
                                 if(i!=j)
                                     {
                                        if(enlaces[i][j].equals("")==true)
                                          {
                                            enlacesres+=" De ( "+(i+1)+" a "+(j+1)+" ) = "+"( "+(i+1)+" , "+(j+1)+" )"+"\n";
                                          }
                                       else
                                       enlacesres+=" De ( "+(i+1)+" a "+(j+1)+" ) = ( "+(i+1)+" , "+enlaces[i][j]+" , "+(j+1)+")\n";
                                }
                          }
                   }
 
                    return "los caminos minimos entre nodos son:\n"+enlacesres;
              }
 
        public String enlaces(int i,int k,String[][] aux_enlaces,String enl_rec)
          {
            if(aux_enlaces[i][k].equals("")==true)
              {
                return "";
              }
               else
               {
 enl_rec+=enlaces(i,Integer.parseInt(aux_enlaces[i][k].toString()),aux_enlaces,enl_rec)+(Integer.parseInt(aux_enlaces[i][k].toString())+1)+" , ";
                return enl_rec;
               }
          }
}
