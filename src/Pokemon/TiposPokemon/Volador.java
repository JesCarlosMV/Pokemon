package Pokemon.TiposPokemon;

import Pokemon.Interfaces.IVolador;
import Pokemon.auxiliares.volador;

public class Volador extends Pokemon implements IVolador {
    protected boolean puedeVolar;
    protected volador[] ataques;

    public Volador(String nombre, int nivel, String tipoPokeball, boolean capturado, volador[] ataques, boolean puedeVolar) {
        super(nombre, nivel, tipoPokeball, capturado);
        this.puedeVolar = puedeVolar;
        ataques = new volador[2];
        ataques[0] = volador.picotazo;
        ataques[1] = volador.ataqueaereo;
    }

    @Override
    public void ensenyar() {
        puedeVolar = true;
        System.out.println(this.nombre + " ha aprendido a volar");
    }

    public void vuelo() {
        System.out.println(this.nombre + " está volando");
    }

    @Override
    public void vuelokamikaze() {
        System.out.println(this.nombre + " ha usado vuelokamikaze");
    }

    @Override
    public void vueloimpacto() {
        System.out.println(this.nombre + " ha usado vueloimpacto");
    }
}
