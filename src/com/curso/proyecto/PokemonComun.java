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
public final class PokemonComun extends Pokemon implements Capturable {

	/**
	 * 
	 * @param nombre: Nombre del Pokémon
	 * @param nivel: Nivel del Pokémon
	 */
	public PokemonComun(String nombre, int nivel, Tipo... tipo) {
		super(nombre, nivel, tipo);
	}
	
	/**
	 * Override del método capturar de Capturable
	 * @see Capturable
	 */
	@Override
	public void capturar() {
		int experiencia = this.experiencia * this.nivel;
		System.out.println(nombre + " ha sido capturado con éxito! Experiencia obtenida: " + experiencia);
		cantidadPokemonCapturados++;
	}
	
}
