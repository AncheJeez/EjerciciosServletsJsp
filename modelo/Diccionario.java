/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AndJe
 */
public class Diccionario {
    
    private Map<String, String> definiciones;

    public Diccionario() {
        definiciones = new HashMap<>();
        // Definiciones de ejemplo
        definiciones.put("java", "Lenguaje de programación orientado a objetos, multiplataforma.");
        definiciones.put("servlet", "Componente Java que genera contenido dinámico en un servidor web.");
        definiciones.put("jsp", "Tecnología Java para crear páginas web dinámicas usando etiquetas HTML.");
        definiciones.put("html", "Lenguaje de marcado para estructurar páginas web.");
    }

    // Buscar término
    public String buscar(String termino) {
        if (termino == null) return null;
        return definiciones.get(termino.toLowerCase());
    }
}
