/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokedex;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author grier
 */
public class Pokedex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc = 0;
        ArrayList<String> pokedex = new ArrayList<String>();
        do {
            opc = menu(pokedex);
            switch (opc) {
                case 1:
                    fillpokedex(pokedex);
                    break;
                case 2:
                    addpokemon(pokedex);
                    break;
                case 3:
                    addpokemonatposition(pokedex);
                    break;
                case 4:
                    deletepokemon(pokedex);
                    break;
                case 5:
                    deletepokemonatposition(pokedex);
                    break;
                case 6:
                    findpokemon(pokedex);
                    break;
                case 7:
                    showallpokemon(pokedex);
                    break;
                case 8:
                    getpokemonatposition(pokedex);
                    break;
                case 9:
                    countpokemon(pokedex);
                    break;
                case 10:
                    hackpokedex(pokedex);
                    break;
                case 11:
                    erasepokedexinfo(pokedex);
                    break;
                default:
                    System.out.println("Hasta otra, hazte con todos!");
            }
        } while (opc != 0);
    }

    public static int menu(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[1] Agregar 5 pokemons predeterminados");
        System.out.println("[2] Agregar 1 pokemon");
        System.out.println("[3] Agregar 1 pokemon en X posicion");
        System.out.println("[4] Eliminar 1 pokemon");
        System.out.println("[5] Eliminar 1 pokemon en X posicion");
        System.out.println("[6] Buscar pokemon");
        System.out.println("[7] Muestra todos los pokemons");
        System.out.println("[8] Muestra 1 pokemon por su posicion");
        System.out.println("[9] Pokemons totales");
        System.out.println("[10] Hackear pokedex");
        System.out.println("[11] Eliminar toda la pokedex");
        System.out.println("[0] Para salir");
        System.out.print("Su opcion: ");
        int opcion = sc.nextInt();
        return opcion;
    }

    public static void fillpokedex(ArrayList<String> pokedex) {
        String[] pokedexAux = {"Charmander", "Bulbasur", "Squirtle", "Eevee", "Pikachu"};
        for (int i = 0; i < pokedexAux.length; i++) {

            if (pokedex.contains(pokedexAux[i])) {
                System.out.println(pokedexAux[i] + " ya fue agregado anteriormente (No se puede duplicar)");
            } else {
                pokedex.add(pokedexAux[i]);
            }
        }
        System.out.println("Pokemons: " + pokedex);
    }

    public static void addpokemon(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Agregue a un pokemon nuevo: ");
        String pokemon = sc.nextLine();
        boolean trueorfalse = pokedex.contains(pokemon);
        if (trueorfalse == false) {
            pokedex.add(pokemon);
            System.out.println(pokemon + " agregado correctamente");
        } else {
            System.out.println(pokemon + " ya fue agregado anteriormente (No se puede duplicar)");
        }
        System.out.println("Pokemons: " + pokedex);
    }

    public static void addpokemonatposition(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca un pokemon nuevo: ");
        String pokemon = sc.nextLine();
        System.out.print("Introduzca una posicion que quiera guardar: ");
        int posicion = sc.nextInt();
        System.out.println(pokemon + " introducido en la posicion " + posicion);
        if (posicion > pokedex.size()) {
            System.out.println("El pokemon esta fuera de rango. Por favor introduzca del numero 1 - " + pokedex.size());
        } else {
            boolean trueorfalse = pokedex.contains(pokemon);
            if (trueorfalse == false) {
                pokedex.add(posicion - 1, pokemon);
                System.out.println(pokemon + " agregado correctamente");
            } else {
                System.out.println(pokemon + " ya fue agregado anteriormente (No se puede duplicar)");
            }
            System.out.println("Pokemons: " + pokedex);
        }
    }

    public static void deletepokemon(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el pokemon que desee eliminar: ");
        String pokemon = sc.nextLine();
        boolean trueorfalse1 = pokedex.contains(pokemon);
        if (trueorfalse1 == true) {
            pokedex.remove(pokemon);
            System.out.println(pokemon + " eliminado correctamente");
        } else {
            System.out.println("No hay ningun pokemon guardado (No se realizo ningun cambio)");
        }
        System.out.println("Pokemons: " + pokedex);
    }

    public static void deletepokemonatposition(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la posicion que desee eliminar: ");
        int posicion = sc.nextInt();
        if (posicion > pokedex.size()) {
            System.out.println("No hay ningun pokemon en la posicion " + posicion);
        } else {
            pokedex.remove(posicion - 1);
            System.out.println("Posicion " + posicion + " eliminado correctamente");
        }
        System.out.println("Pokemons: " + pokedex);
    }

    public static void findpokemon(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el pokemon que desee buscar: ");
        String pokemon = sc.nextLine();

        if (pokedex.contains(pokemon)) {
            System.out.println("El pokemon " + pokemon + " esta en la Pokedex.");
        } else {
            System.out.println("El pokemon " + pokemon + " no esta en la Pokedex.");
        }
    }

    public static void showallpokemon(ArrayList<String> pokedex) {
        if (pokedex.isEmpty()) {
            System.out.println("No tiene ningun pokemon guardado");
        } else {
            System.out.println("Pokemons: " + pokedex);
        }
    }

    public static void getpokemonatposition(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca una posicion: ");
        int posicion = sc.nextInt() - 1;
        if (posicion > pokedex.size()) {
            System.out.println("No tiene ningun pokemon guardado en esta posicion");
        } else {
            System.out.println((posicion + 1) + " " + pokedex.get(posicion));
        }
    }

    public static void countpokemon(ArrayList<String> pokedex) {
        System.out.println("Tienes " + pokedex.size() + " pokemons");
    }

    public static void hackpokedex(ArrayList<String> pokedex) {
        for (int i = 0; i < pokedex.size(); i++) {
            pokedex.set(i, "Ditto");
        }
        System.out.println(pokedex);
    }

    public static void erasepokedexinfo(ArrayList<String> pokedex) {
        pokedex.removeAll(pokedex);
        System.out.println(pokedex);
    }
}
