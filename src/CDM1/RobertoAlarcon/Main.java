/*
 * @author Roberto Alarcon Bardon
 * @version 18-05-2021
 */

package CDM1.RobertoAlarcon;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Main {

	private static Scanner scn;
	private static Random random;
	private static Tablero tablero;
	private static Jugador jugador1 = new Jugador("| X |");
	private static Jugador jugador2 = new Jugador("| O |");
	private static ArrayList<String> textoAEscribir;
	private static String fecha;
	private static int contador;
	
	public static void main(String[] args) {

		scn = new Scanner(System.in);	
		tablero = new Tablero();
		textoAEscribir = new ArrayList<>();
		fecha = new SimpleDateFormat("dd-MM-yyyy - HHmm").format(new Date());
		contador = 0;
		boolean finPartida;
		boolean finJuego = true;
		
		while(finJuego) {
			contador++;
			bienvenidaYTirarDado();
			do {
				jugar(jugador1);
				finPartida = tablero.comprobacion();
				if(!finPartida) {
					jugar(jugador2);
					finPartida = tablero.comprobacion();
				}
			}while(!finPartida);
			
			finJuego = seguirJugando();
		}
		
		scn.close();
		escribirFichero();
	}
	
	/*
	 * Imprime la bienvenida al juego, pide el nombre de los dos jugadores, tira el dado para ver quien empieza y asigna los nombres a los atributos jugadores
	 */
	public static void bienvenidaYTirarDado() {
		
		random = new Random();
		String nombre1, nombre2;
		int dado1, dado2;
		//Bienvenida
		System.out.println("\nBienvenid@s, vamos a juagr al 3 en raya.");
		System.out.println("Nombre del primer jugad@r: ");
		nombre1 = scn.nextLine();
		System.out.println("\nNombre del segundo jugad@r: ");
		nombre2 = scn.nextLine();
		
		//Tirar el dado
		do {
			System.out.println("\nVamos a tirar el dado de " + nombre1);
			dado1 = random.nextInt(6) + 1;
			System.out.println("\nA " + nombre1 + " le ha salido un " + dado1);
			System.out.println("\nVamos a tirar el dado de " + nombre2);
			dado2 = random.nextInt(6) + 1;
			System.out.println("\nA " + nombre2 + " le ha salido un " + dado2);
			
			// Se añade algo a el ArrayList para luego escribir el archivo log
			textoAEscribir.add(fecha + " " + nombre1 + " ha sacado un " + dado1);
			textoAEscribir.add(fecha + " " + nombre2 + " ha sacado un " + dado2);
		}
		while(dado1 == dado2);
		
		//Asignar las variables nombre a los jugadores dependiendo del numero del dado
		if(dado1 > dado2) {
			jugador1.setNombre(nombre1);
			jugador2.setNombre(nombre2);
			
			// Se añade algo a el ArrayList para luego escribir el archivo log
			textoAEscribir.add(fecha + " " + nombre1 + " se ha asignado al jugador1. Ficha '| X |'");
			textoAEscribir.add(fecha + " " + nombre2 + " se ha asignado al jugador2. Ficha '| O |'");
		}
		else {
			jugador1.setNombre(nombre2);
			jugador2.setNombre(nombre1);
			
			// Se añade algo a el ArrayList para luego escribir el archivo log
			textoAEscribir.add(fecha + " " + nombre2 + " se ha asignado al jugador1. Ficha '| X |'");
			textoAEscribir.add(fecha + " " + nombre1 + " se ha asignado al jugador2. Ficha '| O |'");
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
			String posicion;
			posicion = scn.nextLine().trim();
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
					
					// Se añade algo a el ArrayList para luego escribir el archivo log
					textoAEscribir.add(fecha + " " + jugador.getNombre() + " ha colocado su ficha " + jugador.getFicha() + " en la posición " + posicion);
				}
				else if(tablero.comprobarPosicion(a, b).equals(jugador1.getFicha())) {
					System.out.println("\n" + jugador1.getNombre() + " ya ha colocado ahí una ficha, coloca la ficha en una posición libre");
					
					// Se añade algo a el ArrayList para luego escribir el archivo log
					textoAEscribir.add(fecha + " " + jugador.getNombre() + " ha intentado colocar su ficha en la posicion " + posicion + " pero esa posición ya estaba ocupada por una ficha " + jugador1.getFicha());
				}
				else if(tablero.comprobarPosicion(a, b).equals(jugador2.getFicha())) {
					System.out.println("\n" + jugador2.getNombre() + " ya ha colocado ahí una ficha, coloca la ficha en una posición libre");
					
					// Se añade algo a el ArrayList para luego escribir el archivo log
					textoAEscribir.add(fecha + " " + jugador.getNombre() + " ha intentado colocar su ficha en la posicion " + posicion + " pero esa posición ya estaba ocupada por una ficha " + jugador2.getFicha());
				}
				
			}else {
				System.out.println("\nHas introducido mal la posición, introducela bien.");
				
				// Se añade algo a el ArrayList para luego escribir el archivo log
				textoAEscribir.add(fecha + " " + jugador.getNombre() + " ha introducido mal las coordenadas (" + posicion + ")");
			}
		}while(!puesta);
		fin = tablero.comprobacion();
		if(fin) {
			tablero.imprimirTablero();
			System.out.println("¡Ha ganado " + jugador.getNombre() + "!");
			
			// Se añade algo a el ArrayList para luego escribir el archivo log
			textoAEscribir.add(fecha + " " + jugador.getNombre() + " ha ganado");
		}
	}
	
	/*
	 * Escribe el archivo '.txt' con los datos del ArrayList 'aEscribir'
	 */	
	public static void escribirFichero() {
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter(fecha + " partida" + contador + ".txt");
			pw = new PrintWriter(fichero);
		
			for(int i = 0; i < textoAEscribir.size(); i++ ) {
				pw.println("Linea " + (i + 1) + " - " + textoAEscribir.get(i));
			}
			
		}catch(IOException e){
			System.out.println("Se ha producido un error al ecribir el fichero");
		}
		
		try {
			if(fichero != null) {
				fichero.close();
				pw.close();
			}
		}catch(IOException e) {
			System.out.println("Se ha producido un error al cerrar el fichero");
		}
	}
	
	/*
	 * Pregunta si se quiere jugar otra partida despues de acabar una partida
	 * @return Si se sigue o no jugando al juego
	 */
	public static boolean seguirJugando() {
		boolean seguir = false;
		System.out.println("\n¿Quereis seguir jugando? Escribe 'Si' o 'No'.");
		String respuesta  = scn.nextLine().trim().toLowerCase();
		if(respuesta.equals("si")) {
			seguir = true;
			textoAEscribir.clear();
		}
		else {
			System.out.println("\n¡Hasta luego amig@s!");
		}
		return seguir;
	}
}
