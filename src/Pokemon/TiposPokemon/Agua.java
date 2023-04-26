/*Implementa Interfaz agua que obliga a implementar los metodos */
package Pokemon.TiposPokemon;

import Pokemon.Interfaces.IAgua;
import Pokemon.auxiliares.agua;

public class Agua extends Pokemon implements IAgua {
    protected boolean puedeSurfear;
    protected agua[] ataques;

    // Constructor
    public Agua(String nombre, int nivel, String tipoPokeball, boolean capturado, agua[] ataques, boolean puedeSurfear) {
        super(nombre, nivel, tipoPokeball, capturado);
        this.puedeSurfear = puedeSurfear;

        ataques = new agua[2];
        ataques[0] = agua.hidrobomba;
        ataques[1] = agua.aguapolar;
    }

    // Métodos
    @Override
    public void ensenyar() {
        puedeSurfear = true;
        System.out.println(this.nombre + " ha aprendido a surfear");
    }
    public void surfeo() {
        System.out.println(this.nombre + " está surfeando");
    }
    @Override
    public void hidrobomba() {
        System.out.println(this.nombre + " ha usado hidrobomba");
    }
    @Override
    public void aguapolar() {
        System.out.println(this.nombre + " ha usado aguapolar");
    }
}
