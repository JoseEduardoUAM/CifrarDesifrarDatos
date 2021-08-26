/*
* Descripcion:
   Clase Archivo que permite agregar datos a un archivo .txt, estos datos pueden ser 
   mensajes encriptados o mensajes desencriptados
* Autor: 
   Jose Eduardo Hernandez de la Cruz
* Ultima Modificacion: 
   26 de Agosto del 2021
*/

package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
    // Constructor de la clase Archivo
    public Archivo(){
    }
    // Metodo que permite agregar un dato (encriptado o desencriptado) al archivo  
    public void agregarDato( String dato , String nombreArchivo ){
        BufferedWriter bw = null;
        FileWriter fw = null;  
        try {
            File archivo = new File( "Archivos/" + nombreArchivo);
            fw = new FileWriter(archivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write( "\n"+dato );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }  
    }
    
}
