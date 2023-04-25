package Pokemon.TiposEntrenador;

import Pokemon.TiposPokemon.Pokemon;


public class EntrenadorDeGimnasio extends Entrenador {
    protected int ID;
    protected String Gym;


    public EntrenadorDeGimnasio(String nombre, int lvl, int ID, String gym) {
        super(nombre, lvl);
        this.ID = ID;
        this.Gym = gym;
    }

    public EntrenadorDeGimnasio(String nombre, int lvl, Pokemon[] EQUIPOPOKEMON, int ID, String gym) {
        super(nombre, lvl, EQUIPOPOKEMON);
        this.ID = ID;
        this.Gym = gym;
    }

    public EntrenadorDeGimnasio(String nombre, int lvl, Pokemon[] EQUIPOPOKEMON, Entrenador[] ENTRENADORES, int ID, String gym) {
        super(nombre, lvl, EQUIPOPOKEMON, ENTRENADORES);
        this.ID = ID;
        this.Gym = gym;
    }
}
