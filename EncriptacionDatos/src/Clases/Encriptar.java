/*
* Descripcion:
   Clase Encriptar que permite cifrar un mensaje
* Autor: 
   Jose Eduardo Hernandez de la Cruz
* Ultima Modificacion: 
   26 de Agosto del 2021
*/
package Clases;

import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encriptar {
    // Constructor de la clase Descencriptar que permite agregar el mensaje al momento de crear el objeto
    public Encriptar() {
    }
    // Metodo que permite cifrar un mensaje y retornar el resultado
    public static String cifrar( String clave , String mensaje) {
        byte[] claveDesifrada = Base64.getDecoder().decode(clave);
        try {
            Cipher cifrado = Cipher.getInstance("AES");
            SecretKey claveOriginal = new SecretKeySpec(Arrays.copyOf(claveDesifrada, 16), "AES");
            cifrado.init(Cipher.ENCRYPT_MODE, claveOriginal);
            byte[] mensajeCifrado = cifrado.doFinal(mensaje.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(mensajeCifrado);
        } catch (Exception e) {
            throw new RuntimeException(
                "Ocurrio un error", e);
        }

    }
}
