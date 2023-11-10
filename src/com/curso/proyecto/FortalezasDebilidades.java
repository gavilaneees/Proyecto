package com.curso.proyecto;
import java.util.HashMap;
import java.util.Map;

import com.curso.enumerados.Tipo;

/**
 * 
 * @author David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 *
 */
public class FortalezasDebilidades {

	//Tabla que guardará un tipo y a quién le gana
    private static final Map<Tipo, Tipo[]> TABLA_RELACIONES = new HashMap<>();

    static {
        TABLA_RELACIONES.put(Tipo.AGUA, new Tipo[]{Tipo.FUEGO, Tipo.TIERRA, Tipo.ROCA});
        TABLA_RELACIONES.put(Tipo.FUEGO, new Tipo[]{Tipo.ACERO, Tipo.PLANTA, Tipo.HIELO, Tipo.BICHO});
        TABLA_RELACIONES.put(Tipo.PLANTA, new Tipo[]{Tipo.ROCA, Tipo.TIERRA, Tipo.AGUA});
        TABLA_RELACIONES.put(Tipo.ELÉCTRICO, new Tipo[]{Tipo.AGUA, Tipo.VOLADOR});
        TABLA_RELACIONES.put(Tipo.VENENO, new Tipo[]{Tipo.PLANTA});
        TABLA_RELACIONES.put(Tipo.VOLADOR, new Tipo[]{Tipo.BICHO, Tipo.LUCHA, Tipo.PLANTA});
        TABLA_RELACIONES.put(Tipo.NORMAL, new Tipo[]{});
        TABLA_RELACIONES.put(Tipo.FANTASMA, new Tipo[]{Tipo.FANTASMA, Tipo.PSÍQUICO});
        TABLA_RELACIONES.put(Tipo.SINIESTRO, new Tipo[]{Tipo.FANTASMA, Tipo.PSÍQUICO});
        TABLA_RELACIONES.put(Tipo.PSÍQUICO, new Tipo[]{Tipo.LUCHA, Tipo.VENENO});
        TABLA_RELACIONES.put(Tipo.BICHO, new Tipo[]{Tipo.PLANTA, Tipo.PSÍQUICO, Tipo.SINIESTRO});
        TABLA_RELACIONES.put(Tipo.LUCHA, new Tipo[]{Tipo.NORMAL, Tipo.HIELO, Tipo.ACERO, Tipo.SINIESTRO, Tipo.ROCA});
        TABLA_RELACIONES.put(Tipo.HADA, new Tipo[]{Tipo.DRAGÓN, Tipo.LUCHA, Tipo.SINIESTRO});
        TABLA_RELACIONES.put(Tipo.HIELO, new Tipo[]{Tipo.VOLADOR, Tipo.TIERRA, Tipo.PLANTA, Tipo.DRAGÓN});
        TABLA_RELACIONES.put(Tipo.DRAGÓN, new Tipo[]{Tipo.DRAGÓN});
        TABLA_RELACIONES.put(Tipo.ACERO, new Tipo[]{Tipo.HIELO, Tipo.ROCA});
        TABLA_RELACIONES.put(Tipo.ROCA, new Tipo[]{Tipo.BICHO, Tipo.FUEGO, Tipo.HIELO, Tipo.VOLADOR});
        TABLA_RELACIONES.put(Tipo.TIERRA, new Tipo[]{Tipo.FUEGO, Tipo.ACERO, Tipo.ELÉCTRICO, Tipo.ROCA, Tipo.VENENO});
    }

    /**
     * Función que muestra las fortalezas y debilidades de Pokémon
     * @param tipo: Tipo del Pokémon para mostrar fortalezas y debilidades
     */
    public static void mostrarFortalezasDebilidades(Tipo tipo) {
        System.out.println("Fortalezas y Debilidades para el tipo " + tipo + ":");

        Tipo[] fortalezas = TABLA_RELACIONES.get(tipo);
        if (fortalezas.length > 0) {
            System.out.println("Fortalezas: " + arrayToString(fortalezas));
        } else {
            System.out.println("Fortalezas: Ninguna conocida");
        }

        Tipo[] debilidades = obtenerDebilidades(tipo);
        if (debilidades != null) {
            System.out.println("Debilidades: " + arrayToString(debilidades));
        } else {
            System.out.println("Debilidades: Ninguna conocida");
        }
    }

    /**
     * 
     * @param tipo: Tipo para obtener las debilidades
     * @return devuelve las debilidades del Tipo
     */
    private static Tipo[] obtenerDebilidades(Tipo tipo) {
        // Invertir las relaciones para obtener las debilidades
        Map<Tipo, Tipo[]> relacionesInvertidas = new HashMap<>();
        for (Map.Entry<Tipo, Tipo[]> entry : TABLA_RELACIONES.entrySet()) {
            Tipo tipoActual = entry.getKey();
            Tipo[] tiposRelacionados = entry.getValue();
            for (Tipo tipoRelacionado : tiposRelacionados) {
                if (!relacionesInvertidas.containsKey(tipoRelacionado)) {
                    relacionesInvertidas.put(tipoRelacionado, new Tipo[]{tipoActual});
                } else {
                    Tipo[] anteriores = relacionesInvertidas.get(tipoRelacionado);
                    Tipo[] nuevos = new Tipo[anteriores.length + 1];
                    System.arraycopy(anteriores, 0, nuevos, 0, anteriores.length);
                    nuevos[anteriores.length] = tipoActual;
                    relacionesInvertidas.put(tipoRelacionado, nuevos);
                }
            }
        }
        return relacionesInvertidas.get(tipo);
    }

    /**
     * 
     * @param tipos: Array de tipos a pasar a String
     * @return String que se mostrará en la salida
     */
    private static String arrayToString(Tipo[] tipos) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < tipos.length; i++) {
            result.append(tipos[i]);
            if (i < tipos.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}