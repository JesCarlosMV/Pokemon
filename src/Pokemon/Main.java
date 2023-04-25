package Pokemon;

import Pokemon.TiposEntrenador.Entrenador;
import Pokemon.TiposEntrenador.EntrenadorDeCalle;
import Pokemon.TiposEntrenador.EntrenadorDeGimnasio;
import Pokemon.TiposPokemon.*;
import Pokemon.auxiliares.agua;
import Pokemon.auxiliares.fuego;
import Pokemon.auxiliares.planta;
import Pokemon.auxiliares.volador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<Pokemon> LIST_POKEMONS = new ArrayList<>();
        List<Entrenador> LIST_ENTRENADORES = new ArrayList<>();

        cargarPokemonsEnSistema(LIST_POKEMONS);
        cargarEntrenadoresEnSistema(LIST_ENTRENADORES, LIST_POKEMONS);


        //boolean login;
        //do {
        //    login = login();
        //} while (!login);


        boolean salir = false;
        int opcion;
        Scanner sc = new Scanner(System.in);

        do {
            opcion = mostrarMenu(sc);

            switch (opcion) {
                case 1 -> mostrarTodosPokemon(LIST_POKEMONS);
                case 2 -> mostrarTodosEntrenadores(LIST_ENTRENADORES);
                case 3 -> mostrarPokemonDeUnEntrenador(LIST_ENTRENADORES, sc);
                case 4 -> agregarPokemonAlJuego(LIST_POKEMONS, sc);
                case 5 -> eliminarPokemonDelJuego(LIST_POKEMONS);
                case 6 -> ordenarPokemonsPorNivel(LIST_POKEMONS);
                case 7 -> ordenarPokemonsPorNombre(LIST_POKEMONS);
                case 9 -> intentarCapturarPokemon(LIST_POKEMONS);
                case 0 -> salir = true;
                default -> System.out.println("Opcion incorrecta");
            }
        } while (!salir);

    }

    private static void ordenarPokemonsPorNombre(List<Pokemon> listPokemons) {
        listPokemons.sort((o1, o2) -> {
            if (o1.getNombre().compareTo(o2.getNombre()) > 0) {
                return 1;
            } else if (o1.getNombre().compareTo(o2.getNombre()) < 0) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("Pokemons ordenados por nombre");
        mostrarTodosPokemon(listPokemons);
    }

    private static void intentarCapturarPokemon(List<Pokemon> listPokemons) {
        Pokemon p;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del pokemon a capturar");
        String nomb = sc.next().trim().toLowerCase();
        for (Pokemon pokemon : listPokemons) {
            if (pokemon.getNombre().trim().toLowerCase().equals(nomb.toLowerCase().trim())) {
                p = pokemon;
                if (p.isCapturado()) {
                    System.out.println("El pokemon ya esta capturado");
                    return;
                }
                System.out.println("Se intentara capturar el pokemon: " + p.toString());
                System.out.println("seguro capturar? (s/n)");
                String opcion = sc.next().trim().toLowerCase();
                if (opcion.equals("s")) {
                    if (resultadoCaptura()) {
                        p.setCapturado(true);
                        System.out.println("Pokemon capturado");
                        return;
                    } else {
                        System.out.println("No se capturo el pokemon");
                        return;
                    }
                } else {
                    System.out.println("No se capturo el pokemon");
                    return;
                }
            }
        }
        System.out.println("No se encontro el pokemon");
    }

    private static boolean resultadoCaptura() {
        int random = (int) (Math.random() * 100);
        if (random < 50) {
            System.out.println("El pokemon se ha escapado");
            return false;
        } else {
            System.out.println("El pokemon ha sido capturado");
            return true;
        }
    }

    private static void ordenarPokemonsPorNivel(List<Pokemon> listPokemons) {
        listPokemons.sort((o1, o2) -> {
            if (o1.getNivel() > o2.getNivel()) {
                return 1;
            } else if (o1.getNivel() < o2.getNivel()) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("Pokemons ordenados por nivel");
        mostrarTodosPokemon(listPokemons);
    }

    private static void eliminarPokemonDelJuego(List<Pokemon> LISTPOKEMONS) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del pokemon a eliminar");
        String nomb = sc.next().trim().toLowerCase();
        for (Pokemon p : LISTPOKEMONS) {
            if (p.getNombre().trim().toLowerCase().equals(nomb.toLowerCase().trim())) {
                System.out.println("Se eliminara el pokemon: " + p.toString());
                System.out.println("seguro eliminar? (s/n)");
                String opcion = sc.next().trim().toLowerCase();
                if (opcion.equals("s")) {
                    LISTPOKEMONS.remove(p);
                    System.out.println("Pokemon eliminado");
                    return;
                } else {
                    System.out.println("No se elimino el pokemon");
                    return;
                }
            }
        }
        System.out.println("No se encontro el pokemon");
    }

    private static void agregarPokemonAlJuego(List<Pokemon> LIST_POKEMONS, Scanner sc) {
        String nomb, pokeball, tipo;
        int lvl;
        boolean capturado, habilidadDeEspecie;
        Pokemon p;

        System.out.println("Ingrese el tipo del pokemon");
        tipo = sc.next().trim().toLowerCase();
        if (!tipo.equals("agua") && !tipo.equals("fuego") && !tipo.equals("planta") && !tipo.equals("volador")) {
            System.out.println("Tipo de pokemon incorrecto");
            return;
        }
        System.out.println("Ingrese el nombre del pokemon");
        nomb = sc.next().toLowerCase();
        if (nombreRepetido(LIST_POKEMONS, nomb)) {
            System.out.println("Nombre de pokemon repetido o has introducido un nombre vacio");
            return;
        }
        System.out.println("Ingrese el nivel del pokemon");
        lvl = sc.nextInt();
        if (lvl < 1 || lvl > 100) {
            System.out.println("Nivel de pokemon incorrecto");
            return;
        }
        System.out.println("Ingrese la pokeball del pokemon");
        pokeball = sc.next().trim().toLowerCase();
        System.out.println("Ingrese si el pokemon esta capturado");
        capturado = sc.nextBoolean();

        // si el lvl es > 20 entonces habilidadDeEspecie = true
        habilidadDeEspecie = lvl >= 20;

        if (tipo.equals("agua")) {
            agua[] ataques = new agua[2];
            p = new Agua(nomb, lvl, pokeball, capturado, ataques, habilidadDeEspecie);
            LIST_POKEMONS.add(p);
            System.out.println(" Pokemon agregado con exito " + p);
        } else if (tipo.equals("fuego")) {
            fuego[] ataques = new fuego[2];
            p = new Fuego(nomb, lvl, pokeball, capturado, ataques, habilidadDeEspecie);
            LIST_POKEMONS.add(p);
            System.out.println(" Pokemon agregado con exito " + p);
        } else if (tipo.equals("planta")) {
            planta[] ataques = new planta[2];
            p = new Planta(nomb, lvl, pokeball, capturado, ataques, habilidadDeEspecie);
            LIST_POKEMONS.add(p);
            System.out.println(" Pokemon agregado con exito " + p);
        } else if (tipo.equals("volador")) {
            volador[] ataques = new volador[2];
            p = new Volador(nomb, lvl, pokeball, capturado, ataques, habilidadDeEspecie);
            LIST_POKEMONS.add(p);
            System.out.println(" Pokemon agregado con exito " + p);
        } else {
            System.out.println("Tipo de pokemon incorrecto");
        }
    }

    private static boolean nombreRepetido(List<Pokemon> listPokemons, String nomb) {
        for (Pokemon p : listPokemons) {
            if (p.getNombre().trim().toLowerCase().equals(nomb)) {
                return true;
            }
        }
        return false;
    }

    private static int mostrarMenu(Scanner sc) {
        int opcion;
        System.out.println("--------------------------------------------------");
        System.out.println("Bienvenido al sistema de Pokemon");
        System.out.println("1. Listar Todos los pokemon de la pokedex");
        System.out.println("2. Listar Todos los entrenadores de la pokedex");
        System.out.println("3. Listar Todos los pokemon de un entrenador");
        System.out.println("4. Añadir un pokemon al juego");
        System.out.println("5. Eliminar un pokemon del juego");
        System.out.println("6. Ordenar los pokemon por nivel");
        System.out.println("7. Ordenar los pokemon por nombre");
        System.out.println("9. Intentar capturar un pokemon");
        System.out.println("0. Salir");
        System.out.println("--------------------------------------------------");
        opcion = sc.nextInt();
        return opcion;
    }

    private static void mostrarPokemonDeUnEntrenador(List<Entrenador> LIST_ENTRENADORES, Scanner sc) {
        System.out.println("Listado de Pokemons de un entrenador");
        System.out.println("Ingrese el nombre del entrenador");
        String nombreEntrenador = sc.next();
        for (Entrenador e : LIST_ENTRENADORES) {
            if (e.getNombre().trim().toUpperCase().equals(nombreEntrenador.toUpperCase().trim())) {
                System.out.println(e);
            }
        }
    }

    private static void mostrarTodosEntrenadores(List<Entrenador> LIST_ENTRENADORES) {
        System.out.println("Listado de Entrenadores del juego");
        for (Entrenador e : LIST_ENTRENADORES) {
            System.out.println(e);
        }
    }

    private static void mostrarTodosPokemon(List<Pokemon> LIST_POKEMONS) {
        System.out.println("Listado de Pokemons del juego");
        for (Pokemon p : LIST_POKEMONS) {
            System.out.println(p);
        }
    }

    private static boolean login() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su usuario: ");
        String usuario = sc.nextLine().trim().toLowerCase();
        System.out.println("Ingrese su contraseña: ");
        String contrasenya = sc.nextLine().trim().toLowerCase();
        if (usuario.equals("admin") && contrasenya.equals("admin")) {
            System.out.println("Bienvenido " + usuario);
            return true;
        } else {
            System.out.println("Usuario o contraseña incorrectos");
            return false;
        }
    }

    private static void cargarPokemonsEnSistema(List<Pokemon> LIST_POKEMONS) {
        Pokemon p1 = new Agua("Blastoise", 19, "Pokeball", false, null, false);
        Pokemon p2 = new Fuego("Charizar", 9, "Pokeball", false, null, false);
        Pokemon p3 = new Planta("Bulbasour", 69, "Pokeball", false, null, false);
        Pokemon p4 = new Volador("Pidgeot", 94, "Pokeball", false, null, false);
        Pokemon p5 = new Agua("Gyarados", 75, "Pokeball", false, null, false);
        Pokemon p6 = new Fuego("Arcanine", 2, "Pokeball", false, null, false);
        Pokemon p7 = new Planta("Venusaur", 85, "Pokeball", false, null, false);
        Pokemon p8 = new Volador("Fearow", 43, "Pokeball", false, null, false);
        Pokemon p9 = new Agua("Lapras", 25, "Pokeball", false, null, false);
        Pokemon p10 = new Fuego("Rapidash", 77, "Pokeball", false, null, false);
        Pokemon p11 = new Planta("Vileplume", 86, "Pokeball", false, null, false);
        Pokemon p12 = new Volador("Tous", 85, "Pokeball", false, null, false);
        Pokemon p13 = new Agua("Tortle", 9, "Pokeball", false, null, false);
        Pokemon p14 = new Fuego("Arwef", 2, "Pokeball", false, null, false);
        Pokemon p15 = new Planta("Palit", 13, "Pokeball", false, null, false);
        Pokemon p16 = new Volador("Trist", 18, "Pokeball", false, null, false);
        Pokemon p17 = new Agua("Ploow", 26, "Pokeball", false, null, false);
        Pokemon p18 = new Fuego("Kklqw", 64, "Pokeball", false, null, false);
        Pokemon p19 = new Planta("Maunx", 53, "Pokeball", false, null, false);
        Pokemon p20 = new Volador("Plmawr", 86, "Pokeball", false, null, false);
        LIST_POKEMONS.add(p1);
        LIST_POKEMONS.add(p2);
        LIST_POKEMONS.add(p3);
        LIST_POKEMONS.add(p4);
        LIST_POKEMONS.add(p5);
        LIST_POKEMONS.add(p6);
        LIST_POKEMONS.add(p7);
        LIST_POKEMONS.add(p8);
        LIST_POKEMONS.add(p9);
        LIST_POKEMONS.add(p10);
        LIST_POKEMONS.add(p11);
        LIST_POKEMONS.add(p12);
        LIST_POKEMONS.add(p13);
        LIST_POKEMONS.add(p14);
        LIST_POKEMONS.add(p15);
        LIST_POKEMONS.add(p16);
        LIST_POKEMONS.add(p17);
        LIST_POKEMONS.add(p18);
        LIST_POKEMONS.add(p19);
        LIST_POKEMONS.add(p20);
    }

    private static void cargarEntrenadoresEnSistema(List<Entrenador> LIST_ENTRENADORES, List<Pokemon> LIST_POKEMONS) {
        Entrenador e1 = new EntrenadorDeCalle("Ash", 6, 10);
        Entrenador e2 = new EntrenadorDeCalle("Misty", 19, new Pokemon[]{LIST_POKEMONS.get(0), LIST_POKEMONS.get(1), LIST_POKEMONS.get(2)}, 10);
        Entrenador e3 = new EntrenadorDeCalle("Brock", 29, new Pokemon[]{LIST_POKEMONS.get(3), LIST_POKEMONS.get(4), LIST_POKEMONS.get(5)}, 15);
        Entrenador e4 = new EntrenadorDeCalle("Gary", 36, new Pokemon[]{LIST_POKEMONS.get(6), LIST_POKEMONS.get(7), LIST_POKEMONS.get(8)}, 89);
        Entrenador e5 = new EntrenadorDeCalle("Tearri", 6, 10);

        Entrenador e10 = new EntrenadorDeGimnasio("Lebron", 6, 1, "CiudadVioleta");
        Entrenador e6 = new EntrenadorDeGimnasio("Jesus", 29, new Pokemon[]{LIST_POKEMONS.get(9), LIST_POKEMONS.get(10), LIST_POKEMONS.get(11)}, 1, "CiudadRoja");
        Entrenador e7 = new EntrenadorDeGimnasio("Carlos", 19, new Pokemon[]{LIST_POKEMONS.get(12), LIST_POKEMONS.get(13), LIST_POKEMONS.get(14)}, 2, "CiudadAzul");
        Entrenador e8 = new EntrenadorDeGimnasio("Yuliya", 6, new Pokemon[]{LIST_POKEMONS.get(15), LIST_POKEMONS.get(16), LIST_POKEMONS.get(17)}, 3, "CiudadVerde");
        Entrenador e9 = new EntrenadorDeGimnasio("Julia", 36, new Pokemon[]{LIST_POKEMONS.get(18), LIST_POKEMONS.get(19)}, 4, "CiudadAmarilla");

        LIST_ENTRENADORES.add(e1);
        LIST_ENTRENADORES.add(e2);
        LIST_ENTRENADORES.add(e3);
        LIST_ENTRENADORES.add(e4);
        LIST_ENTRENADORES.add(e5);
        LIST_ENTRENADORES.add(e6);
        LIST_ENTRENADORES.add(e7);
        LIST_ENTRENADORES.add(e8);
        LIST_ENTRENADORES.add(e9);
        LIST_ENTRENADORES.add(e10);
    }


}