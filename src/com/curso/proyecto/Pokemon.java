/**
 * 
 */
package com.curso.proyecto;

import java.util.ArrayList;
import java.util.Random;

import com.curso.enumerados.Tipo;

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
	
	//Constantes de instancia
	protected final String nombre;
	protected final Tipo[] tipo;
	
	//Atributos de instancia
	protected int experiencia;
	protected int nivel;
	
	/**
	 * 
	 * @param nombre: Nombre del Pokémon
	 * @param nivel: Nivel del Pokémon
	 * @param tipo: Tipo/s del Pokémon
	 */
	public Pokemon(String nombre, int nivel, Tipo... tipo) {
		this.nombre = nombre;
		Random rand =  new Random();
		this.experiencia = rand.nextInt(200) + 10;
		this.nivel = nivel;
		this.tipo = tipo;
	}
	
	//Método estático para obtener la cantidad total de Pokémon capturados
	public static int getCantidadPokemonCapturados() {
		return cantidadPokemonCapturados;
	}
	
	
	//Get del tipo del Pokemon
	public Tipo[] getTipo() {
		return this.tipo;
	}

	//Override de toString para mostrar la información del Pokémon
	@Override
	public String toString() {
		StringBuilder tiposString = new StringBuilder();
	    for (Tipo tipo : this.getTipo()) {
	        tiposString.append(tipo).append(", ");
	    }
	    tiposString.delete(tiposString.length() - 2, tiposString.length()); // Elimina la última coma y espacio

	    return this.nombre + " de nivel " + this.nivel + ". Tipo/s: " + tiposString.toString();	
	}
	
	
}
