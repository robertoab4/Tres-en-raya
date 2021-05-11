/*
 * @author Roberto Alarcon Bardon
 * @version 11-05-2021
 */

package CDM1.RobertoAlarcon;
import java.util.Scanner;
import java.util.Random;

public class Main {

	private static Scanner scn = new Scanner(System.in);
	private static Random random = new Random();
	private static Tablero tablero = new Tablero();
	private static Jugador jugador1 = new Jugador("| X |");
	private static Jugador jugador2 = new Jugador("| O |");
	private static boolean fin = false;
	
	public static void main(String[] args) {
		bienvenidaYTirarDado();
		do{
			jugar(jugador1);
			jugar(jugador2);
		}while(!fin);
	}
	
	/*
	 * Imprime la bienvenida al juego, pide el nombre de los dos jugadores, tira el dado para ver quien empieza y asigna los nombres a los atributos jugadores
	 */
	public static void bienvenidaYTirarDado() {
		
		String nombre1, nombre2;
		int dado1, dado2;
		//Bienvenida
		System.out.println("Bienvenid@s, vamos a juagr al 3 en raya.");
		System.out.println("Nombre del primer jugad@r: ");
		nombre1 = scn.next();
		System.out.println("\nNombre del segundo jugad@r: ");
		nombre2 = scn.next();
		
		//Tirar el dado
		do {
			System.out.println("\nVamos a tirar el dado de " + nombre1);
			dado1 = random.nextInt(6) + 1;
			System.out.println("\nA " + nombre1 + " le ha salido un " + dado1);
			System.out.println("\nVamos a tirar el dado de " + nombre2);
			dado2 = random.nextInt(6) + 1;
			System.out.println("\nA " + nombre2 + " le ha salido un " + dado2);
		}
		while(dado1 == dado2);
		
		//Asignar las variables nombre a los jugadores dependiendo del numero del dado
		if(dado1 > dado2) {
			jugador1.setNombre(nombre1);
			jugador2.setNombre(nombre2);
		}
		else {
			jugador1.setNombre(nombre2);
			jugador2.setNombre(nombre1);
		}
		
		tablero.llenarTablero();
	}

	/*
	 * 
	 */
	public static void jugar(Jugador jugador) {
		if(fin == false) {
			int a = 0;
			int b = 0;
			tablero.imprimirTablero();
			System.out.println("Turno de " + jugador.getNombre() + "\nIntroduce la letra y el numero juntos sin separacion");
			// No consigo que se pare ahi con scn.nextLine()
			String coordenadas = scn.next().trim();
			if(coordenadas.matches("[A-Ca-c][1-3]")) {
				String fila = coordenadas.substring(0, 1);
				String columna = coordenadas.substring(1, 2);
				switch(fila.toLowerCase()) {
				case "a":
					a = 0;
					break;
				case "b":
					a = 1;
					break;
				case "c":
					a = 2;
					break;
				}
	
				b = Integer.parseInt(columna) - 1;
				if(tablero.comprobarPosicion(a, b).equals("| _ |")) {
					tablero.ponerFicha(jugador, a, b);
				}
				if(tablero.comprobarPosicion(a, b).equals(jugador1.getFicha())) {
					System.out.println("\n" + jugador1.getNombre() + " ya ha colocado ahí una ficha, coloca la ficha en una posición libre");
				}
				if(tablero.comprobarPosicion(a, b).equals(jugador2.getFicha())) {
					System.out.println("\n" + jugador2.getNombre() + " ya ha colocado ahí una ficha, coloca la ficha en una posición libre");
				}
			}
			fin = tablero.comprobacion();
		}
		else {
			scn.close();
			tablero.imprimirTablero();
			System.out.println("¡Se acabo! Ha ganado " + jugador.getNombre());
		}
	}
}
