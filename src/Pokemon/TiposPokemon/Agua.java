package Pokemon.TiposPokemon;

import java.util.List;

public class Agua extends Pokemon  {
    protected boolean puedeSurfear;

    public Agua(String nombre, int nivel, String tipoPokeball, boolean capturado, List<String> ataques, boolean puedeSurfear) {
        super(nombre, nivel, tipoPokeball, capturado, ataques);
        this.puedeSurfear = puedeSurfear;
    }

    @Override
    public void ensenyar() {
        puedeSurfear = true;
        System.out.println(this.nombre + " ha aprendido a surfear");
    }

    public void surfeo() {
        System.out.println(this.nombre + " está surfeando");
    }


}
