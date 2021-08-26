/*
* Descripcion:
   Clase Gestor que permite manipular las opciones (encriptar o desencriptar)
* Autor: 
   Jose Eduardo Hernandez de la Cruz
* Ultima Modificacion: 
   26 de Agosto del 2021
*/
package Clases;

import java.util.Scanner;

public class Gestor {
    // Parametro 
    public Archivo archivo;
    //
    public Encriptar encriptar;
    //
    public Desencriptar desencriptar;
    // Constructor de la clase Gestor que permite crear  a los objetos mensajesEncriptados y 
    // mensajesDescencriptados al momento de de crear el objeto
    public Gestor() throws Exception {
        archivo = new Archivo();
        encriptar = new Encriptar();
        desencriptar = new Desencriptar();
    }
    // Metodo que permite mostrar un menu de opciones para el usuario
    public void menu() throws Exception{
        System.out.println("*****Bienvenido al programa Encriptar-Descencriptar Mensajes*****");
        Scanner ent = new Scanner( System.in ); 
        Boolean seguir = true;
        do{
            System.out.println("¿Que deceas realizar?");
            System.out.println("1. Encriptar Mensaje");
            System.out.println("2. Descencriptar Mensaje");
            System.out.println("3. Salir");
            String opc = ent.nextLine();
            switch(opc){
                case "1":
                    String msg1 = ent.nextLine();
                    String res1 = encriptar.cifrar( "UAMAZC" ,  msg1 );
                    System.out.println( res1 );
                    opcionAlmacenamiento( "MensajesEncriptados.txt" , res1);
                break;
                case "2":
                    String msg2 = ent.nextLine();
                    String res2 = desencriptar.descifrar( "UAMAZC" , msg2 );
                    System.out.println( res2 );
                    opcionAlmacenamiento( "MensajesDesencriptados.txt" , res2 );
                break;
                case "3":
                    System.out.println("Adios");
                    seguir = false;
                break;
                default:
                    System.out.println( opc +  " No se encuentra en las opciones, intentalo de nuevo ");
            }
        }while( seguir );
    }
    
    public void opcionAlmacenamiento( String nombreArchivo , String dato ){
        Scanner ent = new Scanner( System.in ); 
        System.out.println("¿Decea gurdar el mensaje en el archivo " + nombreArchivo + " ?");
        System.out.println("1. Si");
        System.out.println("2. No");
        String opc = ent.nextLine();
        switch( opc ){
            case "1":
                archivo.agregarDato(dato, nombreArchivo);
                System.out.println("¡Listo!, el mensaje a sido guardado");
        }
    }
    
}
