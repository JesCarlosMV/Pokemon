package Pokemon.TiposPokemon;

import java.util.List;

public class Fuego extends Pokemon {
    protected boolean puedeIncendiar;

    public Fuego(String nombre, int nivel, String tipoPokeball, boolean capturado, List<String> ataques, boolean puedeIncendiar) {
        super(nombre, nivel, tipoPokeball, capturado, ataques);
        this.puedeIncendiar = puedeIncendiar;
    }

    @Override
    public void ensenyar() {
        puedeIncendiar = true;
        System.out.println(this.nombre + " ha aprendido a incendiar");
    }

    public void incendiar() {
        System.out.println(this.nombre + " está incendiando");
    }
}
