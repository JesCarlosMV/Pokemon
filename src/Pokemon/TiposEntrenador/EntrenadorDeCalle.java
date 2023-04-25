package Pokemon.TiposEntrenador;

import Pokemon.TiposPokemon.Pokemon;


public class EntrenadorDeCalle extends Entrenador {

    protected int numLuchasCalle;

    public EntrenadorDeCalle(String nombre, int lvl, int numLuchasCalle) {
        super(nombre, lvl);
        this.numLuchasCalle = numLuchasCalle;
    }

    public EntrenadorDeCalle(String nombre, int lvl, Pokemon[] EQUIPOPOKEMON, int numLuchasCalle) {
        super(nombre, lvl, EQUIPOPOKEMON);
        this.numLuchasCalle = numLuchasCalle;
    }

    public EntrenadorDeCalle(String nombre, int lvl, Pokemon[] EQUIPOPOKEMON, Entrenador[] ENTRENADORES , int numLuchasCalle) {
        super(nombre, lvl, EQUIPOPOKEMON, ENTRENADORES);
        this.numLuchasCalle = numLuchasCalle;
    }


}
