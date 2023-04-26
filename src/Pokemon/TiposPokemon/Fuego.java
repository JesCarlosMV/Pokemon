/*Implementa Interfaz fuego que obliga a implementar los metodos */

package Pokemon.TiposPokemon;

import Pokemon.Interfaces.IFuego;
import Pokemon.auxiliares.fuego;

public class Fuego extends Pokemon implements IFuego {
    protected boolean puedeIncendiar;
    protected fuego[] ataques;

    // Constructor
    public Fuego(String nombre, int nivel, String tipoPokeball, boolean capturado, fuego[] ataques, boolean puedeIncendiar) {
        super(nombre, nivel, tipoPokeball, capturado);
        this.puedeIncendiar = puedeIncendiar;

        ataques = new fuego[2];
        ataques[0] = fuego.llamarada;
        ataques[1] = fuego.lanzallamas;

    }

    // Métodos
    @Override
    public void ensenyar() {
        puedeIncendiar = true;
        System.out.println(this.nombre + " ha aprendido a incendiar");
    }
    public void incendiar() {
        System.out.println(this.nombre + " está incendiando");
    }
    @Override
    public void llamarada() {
        System.out.println(this.nombre + " está lanzando una llamarada");
    }
    @Override
    public void lanzallamas() {
        System.out.println(this.nombre + " está lanzando llamas");
    }
}
