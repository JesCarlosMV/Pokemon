package Pokemon.TiposPokemon;

import java.util.List;

public abstract class Pokemon {
    protected String nombre;
    protected int nivel;
    protected String tipoPokeball;
    protected boolean capturado;
    protected List<String> ataques;

    public Pokemon(String nombre, int nivel, String tipoPokeball, boolean capturado, List<String> ataques) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipoPokeball = tipoPokeball;
        this.capturado = capturado;
        this.ataques = ataques;
    }



}
