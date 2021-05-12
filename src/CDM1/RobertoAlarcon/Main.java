/*
 * @author Roberto Alarcon Bardon
 * @version 12-05-2021
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
	
	public static void main(String[] args) {

		bienvenidaYTirarDado();
		boolean finPartida;
		do {
			jugar(jugador1);
			finPartida = tablero.comprobacion();
			if(finPartida) {
				break; // Para que se salga del bucle y no haga la ejecucion de "jugar(juador2);"
			}
			jugar(jugador2);
			finPartida = tablero.comprobacion();
		}while(!finPartida);
		 
		scn.close();
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
	 * El jugador pasado como parametro coloca una ficha
	 * @param jugador El jugador que tiene el turno
	 */
	public static void jugar(Jugador jugador) {
		
		boolean fin; // Para comprobar si hay 3 en raya e imprimir el nombre del ganador
		boolean puesta = false; // Comprueba si la ficha ha sido colocada correctamente o no
		
		do {
			tablero.imprimirTablero();
			System.out.println("Turno de " + jugador.getNombre() + "\nIntroduce la letra y el número juntos sin separación");
			String posicion = scn.next().trim();
			if(posicion.matches("[A-Ca-c][1-3]")) {
				int a = 0;
				int b = 0;
				String fila = posicion.substring(0, 1);
				String columna = posicion.substring(1, 2);
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
					puesta = tablero.ponerFicha(jugador, a, b);
				}
				else if(tablero.comprobarPosicion(a, b).equals(jugador1.getFicha())) {
					System.out.println("\n" + jugador1.getNombre() + " ya ha colocado ahí una ficha, coloca la ficha en una posición libre");
				}
				else if(tablero.comprobarPosicion(a, b).equals(jugador2.getFicha())) {
					System.out.println("\n" + jugador2.getNombre() + " ya ha colocado ahí una ficha, coloca la ficha en una posición libre");
				}
				
			}else {
				System.out.println("\nHas introducido mal la posición, introducela bien.");
			}
		}while(!puesta);
		fin = tablero.comprobacion();
		if(fin) {
			tablero.imprimirTablero();
			System.out.println("¡Ha ganado " + jugador.getNombre() + "!");
		}
	}
}
