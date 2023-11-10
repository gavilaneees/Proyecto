/**
 * 
 */
package com.curso.proyecto;

import com.curso.enumerados.Tipo;
import com.curso.interfaces.Capturable;

/**
 * @author David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 * @see Pokemon
 * @see Capturable
 *
 */
public final class PokemonLegendario extends Pokemon implements Capturable {
	
	//Constante de clase
	private static final int BONUS_EXPERIENCIA = 150;
	
	/**
	 * 
	 * @param nombre: Nombre del Pokémon
	 */
	public PokemonLegendario(String nombre, int nivel, Tipo... tipo) {
		super(nombre, nivel, tipo);
	}
	
	/**
	 * Override del método de capturar de Capturable
	 * @see Capturable
	 */
	@Override
	public void capturar() {
		int experiencia =  this.experiencia * this.nivel + BONUS_EXPERIENCIA;
		System.out.println(nombre + " ha sido capturado con éxito! Experiencia obtenida: " + experiencia);
		cantidadPokemonCapturados++;
	}

}
