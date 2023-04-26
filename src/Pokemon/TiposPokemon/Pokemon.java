/*Clase abstracta Pokemon para que no se permitan crear objetos Pokemon.
 De la que heredaran todos los pokemons, implementa Ensenyar para que sea obligatorio
* en todos los objetos de los que hereden de pokemon*/
package Pokemon.TiposPokemon;

import Pokemon.Interfaces.Ensenyar;

public abstract class Pokemon implements Ensenyar {
    protected String nombre;
    protected int nivel;
    protected String tipoPokeball;
    protected boolean capturado;

    // Constructor
    public Pokemon(String nombre, int nivel, String tipoPokeball, boolean capturado) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipoPokeball = tipoPokeball;
        this.capturado = capturado;
    }

    // Getters y setters
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
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    // Métodos
    public String toString() {
        return this.nombre + " Nivel: " + this.nivel + " Tipo de pokeball: " + this.tipoPokeball + " Capturado: " + this.capturado;
    }
    public void ensenyar() {
        System.out.println(this.nombre + " ha aprendido su habilidad");
    }
    public void ataqueBasico() {
        System.out.println(this.nombre + " hizo un Ataque común");
    }
    public void huida() {
        System.out.println(this.nombre + " ha huido");
    }
    public void subirNivel() {
        this.nivel++;
        if (this.nivel >= 100) {
            System.out.println("El pokemon ha llegado al nivel máximo");
            this.nivel = 100;
        } else {
            System.out.println(this.nombre + " ha subido de nivel");
            if (this.nivel == 20) {
                System.out.println(this.nombre + " ha evolucionado");
                ensenyar();
            }
        }

    }

    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}
