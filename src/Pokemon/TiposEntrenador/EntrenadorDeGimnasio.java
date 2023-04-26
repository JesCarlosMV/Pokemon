/*Clase entrenadordegimnasio que extiende de entrenador para heredar.
  Con varios constructores ya que habran entrenadores sin pokemons y/o sin otra lista de entrenadores.
    Tambien tiene un ID y un nombre de gimnasio
* */
// TODO: Implementar toString() para mostrar el nombre del gimnasio
// TODO: Implementar getters y setters para ID? hacer ID final? ID++ para el siguiente entrenador?

package Pokemon.TiposEntrenador;

import Pokemon.TiposPokemon.Pokemon;


public class EntrenadorDeGimnasio extends Entrenador {
    protected int ID;
    protected String Gym;

    // Constructores
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
