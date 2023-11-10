/**
 * 
 */
package com.curso.proyecto;

import java.util.Random;

/**
 * @author David Gavilanes de Dios
 * @version 1.0.0
 * @since 2013
 *
 */
public abstract class Pokemon {

	//Constante de clase
	public static final String CATEGORIA = "Criaturas Pokémon";
	
	//Variable estática compartida
	protected static int cantidadPokemonCapturados = 0;
	
	//Constante de instancia
	protected final String nombre;
	
	//Atributos de instancia
	protected int experiencia;
	protected int nivel;
	
	/**
	 * 
	 * @param nombre: Nombre del Pokémon
	 * @param nivel: Nivel del Pokémon
	 */
	public Pokemon(String nombre, int nivel) {
		this.nombre = nombre;
		Random rand =  new Random();
		this.experiencia = rand.nextInt(200) + 10;
		this.nivel = nivel;
	}
	
	//Método estático para obtener la cantidad total de Pokémon capturados
	public static int getCantidadPokemonCapturados() {
		return cantidadPokemonCapturados;
	}

	//Override de toString para mostrar la información del Pokémon
	@Override
	public String toString() {
		return this.nombre + " de nivel " + this.nivel;
	}
	
	
}
