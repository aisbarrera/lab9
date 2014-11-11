//****************************************************************
// Autores: Otto Wantland Carne: 13663 Diego Rodriguez Carne: 13111 Andrea Barrera Carne:13655
// Seccion: 20
//Fecha 12/9/14
// Nombre de Archivo: Archivo.java
// Breve Descripcion: Clase que se encarga de cargar el archivo de texto para poder usarlo en el programa
//*****************************************************************
package lab9;

import java.io.*;
public class Archivo {
    
    int CantLineas = 0;
    private File archivo;
    private BufferedReader br, Buffer;
    private FileReader fr;
    private String datos;
    
   
    public Archivo(String texto)
    {
            archivo = new File(texto+".txt");
            if(!archivo.exists()){
                    System.out.print("El archivo no se encuentra");
            }else{
                    try {
                            fr = new FileReader(archivo);
                            br = new BufferedReader(fr);
                    }
                    catch (Exception e){
                            System.out.println(e.getMessage());
                    }
            }
    }
     //Encontrado en: http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
    public String LeerArchivo(){
           try{
            datos = br.readLine();	
    	}
    catch (IOException e){
    	e.printStackTrace();
    }
    finally{
    	return datos;
    }
    }
    
    
    public void ContarLineas(){
        int cont = 0;
        try{
             fr = new FileReader(archivo);
             Buffer = new BufferedReader(fr);
            String Linea;
            while ((Linea = Buffer.readLine()) != null)
                if (!Linea.equals(""))  cont++;
        } catch (Exception e){
            System.err.println("Error en lectura " + e.getMessage());
        }
        CantLineas = cont;
    }
    
    
    public String[][] GetMatriz(){
        String[][] MatVar = null;
        ContarLineas();
        try{
            fr = new FileReader(archivo);
            Buffer = new BufferedReader(fr);
            String Linea;
            //Separamos el texto que viene en cada linea
            MatVar = new String[CantLineas][3];
            for (int i = 0; i < CantLineas; i++){
                if ((Linea = Buffer.readLine()) != null) {
                    String[] vec = Linea.split(" ");
                    MatVar[i][0] = vec[0]; //el primer nombre
                    MatVar[i][1] = vec[1]; //el segundo nombre
                    MatVar[i][2] = vec[2]; //la distancia entre ellos
                }
            }
        } catch (Exception e){
            System.err.println("Error en lectura " + e.getMessage());
        }
        return MatVar;
    }
    
    
    public void EscribirArchivo(String texto, boolean reiniciar){
        try{      
           //FileWriter(para escribir)
            FileWriter escribir = new FileWriter(archivo,reiniciar);
            escribir.write(texto+"\n");
            escribir.close();
        }
        catch(Exception e){
            System.out.println("Error al escribir");
        }
    }     
}
