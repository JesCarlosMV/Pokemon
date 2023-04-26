/* Clase abstracta Entrenador para que no se permita crear objetos Entrenador, y
 de la que heredaran los 2 entrenadores ( Gym y Calle ),
* con varios constructores ya que habran entrenadores sin pokemons y/o sin otra lista de entrenadores*/
package Pokemon.TiposEntrenador;

import Pokemon.TiposPokemon.Pokemon;

public abstract class Entrenador {
    protected String nombre;
    protected int lvl;
    protected Pokemon[] EQUIPOPOKEMON = new Pokemon[100];
    protected Entrenador[] ENTRENADORES = new Entrenador[100];

    // Constructores
    public Entrenador(String nombre, int lvl) {
        this.nombre = nombre;
        this.lvl = lvl;
    }
    public Entrenador(String nombre, int lvl, Pokemon[] EQUIPOPOKEMON) {
        this.nombre = nombre;
        this.lvl = lvl;
        this.EQUIPOPOKEMON = EQUIPOPOKEMON;
    }
    public Entrenador(String nombre, int lvl, Pokemon[] EQUIPOPOKEMON, Entrenador[] ENTRENADORES) {
        this.lvl = lvl;
        this.EQUIPOPOKEMON = EQUIPOPOKEMON;
        this.ENTRENADORES = ENTRENADORES;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    // Metodos
    public String toString() {
        return "\nNombre: " + this.nombre + " - Nivel: " + this.lvl + "\nEquipo pokemon: \n" + mostrarPokemons() + "Entrenadores: " + mostrarEntrenadores();
    }
    public void subirLvl() {
        this.lvl++;
        System.out.println("El entrenador " + this.nombre + " ha subido de nivel, ahora es nivel " + this.lvl);
    }
    public String mostrarPokemons() {
        String pokemons = "";

        for (int i = 0; i < EQUIPOPOKEMON.length; i++) {
            if (EQUIPOPOKEMON[i] != null) {
                pokemons += EQUIPOPOKEMON[i] + "\n";
            }
        }
        return pokemons;
    }
    public String mostrarEntrenadores() {
        String entrenadores = "";

        for (int i = 0; i < ENTRENADORES.length; i++) {
            if (ENTRENADORES[i] != null) {
                entrenadores += ENTRENADORES[i] + "\n";
            }
        }
        return entrenadores;
    }
    public void agregarPokemon(Pokemon pokemon) {
        for (int i = 0; i < EQUIPOPOKEMON.length; i++) {
            if (EQUIPOPOKEMON[i] == null) {
                EQUIPOPOKEMON[i] = pokemon;
                break;
            }
        }
    }
}
