package Pokemon.TiposPokemon;

import Pokemon.Interfaces.Ensenyar;

import java.util.List;

public class Agua extends Pokemon implements Ensenyar {
    protected boolean puedeSurfear;

    public Agua(String nombre, int nivel, String tipoPokeball, boolean capturado, List<String> ataques,boolean puedeSurfear) {
        super(nombre, nivel, tipoPokeball, capturado, ataques);
        this.puedeSurfear = puedeSurfear;
    }


    public void ensenyar(){
        puedeSurfear = true;
    }


}
