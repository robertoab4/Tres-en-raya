/*
 * @author Roberto Alarcon Bardon
 * @version 01-05-2021
 */

// package CDM1.RobertoAlarcon;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

	private static Scanner scn;
	private static Random random;
	private static Jugador jugador1;
	private static Jugador jugador2;
	
	public static void main(String[] args) {
		scn = new Scanner(System.in);
		random = new Random();
		jugador1 = new Jugador("X");
		jugador2 = new Jugador("O");
		bienvenida();
		tirarDado();
		System.out.println(jugador1.getNombre());
		System.out.println(jugador2.getNombre());
	}
	
	/*
	 * Imprime la bienvenida al juego y pide el nombre de los dos jugadores.
	 */
	public static void bienvenida() {
		System.out.println("Bienvenid@s, vamos a juagr al 3 en raya.");
		System.out.println("Nombre del primer jugad@r: ");
		jugador1.setNombre(scn.next());
		System.out.println("\nNombre del segundo jugad@r: ");
		jugador2.setNombre(scn.next());		
	}
	
	/*
	 * Tira un dado del 1 al 6 para cada jugador a ver cual empieza antes.
	 */
	public static void tirarDado() {
		System.out.println("\nVamos a tirar el dado de " + jugador1.getNombre());
		jugador1.setNumero(random.nextInt(7));
		System.out.println("\nA " + jugador1.getNombre() + " le ha salido un " + jugador1.getNumero());
		System.out.println("\nAhora el de " + jugador2.getNombre());
		jugador1.setNumero(random.nextInt(7));
		System.out.println("\nA " + jugador2.getNombre() + " le ha salido un " + jugador2.getNumero());
	}
	
	public static void jugar() {
		if(jugador1.getNumero() > jugador2.getNumero()) {
			System.out.println("\nA " + jugador1.getNombre() + " le ha salido un " + jugador1.getNumero());
		}
	}

}
