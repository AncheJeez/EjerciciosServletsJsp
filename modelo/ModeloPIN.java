/*
 * Modelo de PIN.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jose
 */
public class ModeloPIN {
    private String clave;
    private List<Integer> pin;
    private List<Integer> intento;
    
    public ModeloPIN(String clave) {
        this.clave = clave;
        pin = new ArrayList();
        intento = new ArrayList();
        // Introducimos los dígitos 0..9 en la lista pin
        for (int i = 0; i < 10; i++) {
            pin.add(i);
        }
        // desordenamos la lista
        Collections.shuffle(pin);
    }

    // Obtener el pin
    public List<Integer> getPin() {
        return pin;
    }
    
    // Insertar un dígito en el intento a partir de la posición introducida
    public void insertarPosicion(int pos) {
        intento.add(pin.get(pos));
    }
    
    // Borrar el intento del usuario (botón borrar)
    public void borrarIntento() {
        intento.clear();
    }
    
    public boolean validar() {
        // Primero comprobamos que las longitudes de intento y pin son iguales
        boolean correcto = intento.size() == clave.length();
        if (correcto) {
            // comprobamos para cada posición que el caracter de clave coincida
            // con el dígito correspondiente de intento
            for (int i = 0; i < clave.length() && correcto; i++) {
                if (("" + intento.get(i)).charAt(0) != clave.charAt(i)) {
                    correcto = false;
                }
            }
        }
        return correcto;
    }
}
