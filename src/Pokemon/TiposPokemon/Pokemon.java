package Pokemon.TiposPokemon;

import Pokemon.Interfaces.Ensenyar;

import java.util.List;

public abstract class Pokemon implements Ensenyar {
    protected String nombre;
    protected int nivel;
    protected String tipoPokeball;
    protected boolean capturado;
    protected List<String> ataques;

    // Constructor
    public Pokemon(String nombre, int nivel, String tipoPokeball, boolean capturado, List<String> ataques) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipoPokeball = tipoPokeball;
        this.capturado = capturado;
        this.ataques = ataques;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTipoPokeball() {
        return tipoPokeball;
    }

    public boolean isCapturado() {
        return capturado;
    }

    public List<String> getAtaques() {
        return ataques;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", tipoPokeball='" + tipoPokeball + '\'' +
                ", capturado=" + capturado +
                ", ataques=" + ataques +
                '}';
    }

    public void subirNivel() {
        this.nivel++;
        System.out.println(this.nombre + " ha subido de nivel");
        if (this.nivel == 20) {
            System.out.println(this.nombre + " ha evolucionado");
            ensenyar();
        }
    }
    public void ensenyar() {
        System.out.println(this.nombre + " ha aprendido su habilidad");
    }
    public void ataqueComun() {
        System.out.println(this.nombre + " hizo un Ataque común");
    }

    public void huida() {
        System.out.println(this.nombre + " ha huido");
    }


}
