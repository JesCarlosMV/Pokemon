package Pokemon;

import Pokemon.TiposPokemon.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pokemon> LIST_POKEMONS;

        Pokemon p1 = new Agua("Blastoise", 19, "Pokeball", false, null, false);
        Pokemon p2 = new Fuego("Charizar", 19, "Pokeball", false, null, false);
        Pokemon p3 = new Planta("Bulbasour", 19, "Pokeball", false, null, false);
        Pokemon p4 = new Volador("Pidgeot", 19, "Pokeball", false, null, false);

        LIST_POKEMONS = List.of(p1, p2, p3, p4);



    }
}