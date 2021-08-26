/*
* Descripcion:
   Clase Principal que contiene al main e invoca a la Clase Gestora
* Autor: 
   Jose Eduardo Hernandez de la Cruz
* Ultima Modificacion: 
   26 de Agosto del 2021
*/
package Clases;

public class Inicio {
    public static void main(String[] args) throws Exception {
        Gestor gestor = new Gestor();
        gestor.menu();
    }
}
