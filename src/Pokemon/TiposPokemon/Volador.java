package Pokemon.TiposPokemon;

import java.util.List;

public class Volador extends Pokemon {
    protected boolean puedeVolar;

    public Volador(String nombre, int nivel, String tipoPokeball, boolean capturado, List<String> ataques, boolean puedeVolar) {
        super(nombre, nivel, tipoPokeball, capturado, ataques);
        this.puedeVolar = puedeVolar;
    }

    @Override
    public void ensenyar() {
        puedeVolar = true;
        System.out.println(this.nombre + " ha aprendido a volar");
    }

    public void vuelo() {
        System.out.println(this.nombre + " está volando");
    }


}
