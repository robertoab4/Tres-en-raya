/*
 * @author Roberto Alarcon Bardon
 * @version 07-05-2021
 */

package CDM1.RobertoAlarcon;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

	private static Scanner scn;
	private static Random random;
	private static Tablero tablero;
	
	public static void main(String[] args) {
		scn = new Scanner(System.in);
		random = new Random();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		bienvenida(jugador1, jugador2);
		do {
			tirarDado(jugador1);
			tirarDado(jugador2);
		}while(jugador1.getNumero() == jugador2.getNumero());
		orden(jugador1, jugador2);
	}
	
	/*
	 * Imprime la bienvenida al juego y pide el nombre de los dos jugadores.
	 */
	public static void bienvenida(Jugador jugador1, Jugador jugador2) {
		System.out.println("Bienvenid@s, vamos a juagr al 3 en raya.");
		System.out.println("Nombre del primer jugad@r: ");
		jugador1.setNombre(scn.next());
		System.out.println("\nNombre del segundo jugad@r: ");
		jugador2.setNombre(scn.next());		
	}
	
	/*
	 * Tira un dado del 1 al 6 para un jugador.
	 */
	public static int tirarDado(Jugador jugador) {
		System.out.println("\nVamos a tirar el dado de " + jugador.getNombre());
		jugador.setNumero(random.nextInt(7));
		System.out.println("\nA " + jugador.getNombre() + " le ha salido un " + jugador.getNumero());
		return jugador.getNumero();
	}
	
	public static void orden(Jugador jugador1, Jugador jugador2) {
		
		if(jugador1.getNumero() > jugador2.getNumero()) {
			jugador1.setFicha("X");
			jugador2.setFicha("O");
			System.out.println("\n" + jugador1.getNombre() + " empieza con las fichas " + jugador1.getFicha());
		}
		
		if(jugador2.getNumero() > jugador1.getNumero()) {
			jugador2.setFicha("X");
			jugador1.setFicha("O");
			System.out.println("\n" + jugador2.getNombre() + " empieza con las fichas " + jugador2.getFicha());
		}
		
		System.out.println("\nComienza el juego");
	}

}
