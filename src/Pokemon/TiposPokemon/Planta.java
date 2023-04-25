package Pokemon.TiposPokemon;

import Pokemon.Interfaces.IPlanta;
import Pokemon.auxiliares.planta;

import java.util.List;

public class Planta extends Pokemon implements IPlanta {
    protected boolean puedePlantar;
    protected planta[] ataques;

    public Planta(String nombre, int nivel, String tipoPokeball, boolean capturado,planta[]ataques, boolean puedePlantar) {
        super(nombre, nivel, tipoPokeball, capturado);
        this.puedePlantar = puedePlantar;
        ataques = new planta[2];
        ataques[0] = planta.tierrasismica;
        ataques[1] = planta.terremoto;
    }

    @Override
    public void ensenyar() {
        puedePlantar = true;
        System.out.println(this.nombre + " ha aprendido a plantar");
    }

    public void growUp() {
        System.out.println(this.nombre + " está plantando");
    }

    @Override
    public void tierrasismica() {
        System.out.println(this.nombre + " ha usado tierrasismica");
    }

    @Override
    public void terremoto() {
        System.out.println(this.nombre + " ha usado terremoto");
    }
}
