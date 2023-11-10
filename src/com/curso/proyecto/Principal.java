/**
 * 
 */
package com.curso.proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.curso.enumerados.Tipo;

/**
 * @author David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 *
 */
public class Principal {

	/**
	 * @param args: Argumentos de main
	 */
	public static void main(String[] args) {
		
		ArrayList<PokemonComun> pokemonComunes = leerPokemonArchivo("C:\\Users\\Admin\\eclipse-workspace\\Proyecto\\src\\com\\curso\\Proyecto\\comunes.txt", PokemonComun.class);
		ArrayList<PokemonLegendario> pokemonLegendarios = leerPokemonArchivo("C:\\Users\\Admin\\eclipse-workspace\\Proyecto\\src\\com\\curso\\Proyecto\\legendarios.txt", PokemonLegendario.class);
		
		System.out.println("Vamos a mostrar todos los Pokémon que hay guardados en el archivo:");
		
		mostrarInfo(pokemonComunes, pokemonLegendarios);
		
		System.out.println("\n¡Vamos a capturar Pokémon!");
		
		sorteoCapturaPokemon(pokemonComunes, pokemonLegendarios);
		
		System.out.println("\nSe han capturado " + ((Pokemon) pokemonComunes.get(0)).getCantidadPokemonCapturados() + " Pokemon.");
	}
	
	/**
	 * Función que muestra la información de los Pokemon
	 * @param pokemonComunes: ArrayList de los Pokemon Comunes
	 * @param pokemonLegendarios: ArrayList de los Pokemon Legendarios
	 */
	private static void mostrarInfo(ArrayList<PokemonComun> pokemonComunes, ArrayList<PokemonLegendario> pokemonLegendarios) {
		
		System.out.println("\n*****POKÉMON COMUNES*****");
		for(PokemonComun i: pokemonComunes) {
			System.out.println(i.toString());
		}
		
		System.out.println("\n*****POKÉMON LEGENDARIOS*****");
		for(PokemonLegendario i: pokemonLegendarios) {
			System.out.println(i.toString());
		}
	}
	
	/**
	 * Función que permite capturar Pokémon aleatoriamente
	 * @param pokemonComunes: ArrayList de los Pokemon Comunes creados
	 * @param pokemonLegendarios: ArrayList de los Pokemon Legendarios creados
	 */
	private static void sorteoCapturaPokemon(ArrayList<PokemonComun> pokemonComunes, ArrayList<PokemonLegendario> pokemonLegendarios) {
		Random random = new Random();
		int contadorComunes = 0, contadorLegendarios = 0;
		
		System.out.println("\n*****POKÉMON COMÚN*****");
		for(int i = 0; i<pokemonComunes.size(); i++) {
			int capturaComun = random.nextInt(100);
			if(capturaComun > 50) {
				if(pokemonComunes.get(i) instanceof PokemonComun) {
					((PokemonComun) pokemonComunes.get(i)).capturar();
					contadorComunes++;
				} 
			}
		}
		if(contadorComunes == 0) {
			System.out.println("No has capturado ningún Pokémon Común.");
		}
		
		System.out.println("\n*****POKÉMON LEGENDARIO*****");
		for(int i = 0; i<pokemonLegendarios.size(); i++) {
			double capturaLegendaria = random.nextInt(100) * 0.6;
			if(capturaLegendaria > 40) {
				if(pokemonLegendarios.get(i) instanceof PokemonLegendario) {
					((PokemonLegendario) pokemonLegendarios.get(i)).capturar();
					contadorLegendarios++;
				} 
			}
		}
		if(contadorLegendarios == 0) {
			System.out.println("No has capturado ningún Pokémon Legendario.");
		}
	}
	
	/**
	 * Función que lee los archivos con los nombres de los Pokemon
	 * @param nombreArchivo: nombre del archivo para obtener los Pokémon
	 * @param tipoPokemon: tipo de los Pokémon a obtener
	 * @return Pokémon del archivo especificado
	 */
	private static <T extends Pokemon> ArrayList<T> leerPokemonArchivo(String nombreArchivo, Class<T> tipoPokemon) {
		ArrayList<T> pokemon = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				String nombre = partes[0].trim();
				int nivel = new Random().nextInt(96) + 5;
				
				Tipo[] tipos = new Tipo[partes.length-1];
				for (int i = 1; i<partes.length; i++) {
					String tipoStr = partes[i].trim();
					try {
						tipos[i -1] = Tipo.valueOf(tipoStr);
					} catch (IllegalArgumentException e) {
						System.err.println( new ExceptionPersonalizada(ExceptionPersonalizada.TIPO_NO_ENCONTRADO).getMessage());
					}
				}
				
				T pokemons = tipoPokemon.getDeclaredConstructor(String.class, int.class, Tipo[].class).newInstance(nombre, nivel, tipos);
				pokemon.add(pokemons);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pokemon;
	}
}
