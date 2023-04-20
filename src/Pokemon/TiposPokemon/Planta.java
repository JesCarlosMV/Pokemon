package Pokemon.TiposPokemon;

import java.util.List;

public class Planta extends Pokemon {
    protected boolean puedePlantar;

    public Planta(String nombre, int nivel, String tipoPokeball, boolean capturado, List<String> ataques, boolean puedePlantar) {
        super(nombre, nivel, tipoPokeball, capturado, ataques);
        this.puedePlantar = puedePlantar;
    }

    @Override
    public void ensenyar() {
        puedePlantar = true;
        System.out.println(this.nombre + " ha aprendido a plantar");
    }

    public void growUp() {
        System.out.println(this.nombre + " está plantando");
    }
}
