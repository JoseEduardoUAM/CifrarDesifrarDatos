/*
* Descripcion:
   Clase Desencriptar que permite descifrar un mensaje encriptado
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

public class Desencriptar {
    // Constructor de la clase Descencriptar que permite agregar el mensaje al momento de crear el objeto
    public Desencriptar() {
    }
    // Metodo que permite descifrar un mensaje encriptado y retornar el resultado
    public static String descifrar( String clave , String mensajeCifrado) {
        byte[] claveDisifrada = Base64.getDecoder().decode(clave);
        try {
            Cipher cifrado = Cipher.getInstance("AES");
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(claveDisifrada, 16), "AES");
            cifrado.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] mensajeDesifrado = cifrado.doFinal(Base64.getDecoder().decode(mensajeCifrado));
            return new String(mensajeDesifrado);
        } catch (Exception e) {
            throw new RuntimeException(
                "Ocurrio un error", e);
        }
    }  
    
}
