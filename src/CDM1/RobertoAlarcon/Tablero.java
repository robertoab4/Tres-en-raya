/*
 * @author Roberto Alarcon Bardon
 * @version 11-05-2021
 */

package CDM1.RobertoAlarcon;

public class Tablero {

	private String[][] tablero;
	
	/*
	 * Constructor dela clase Tablero
	 */
	public Tablero() {
		this.tablero = new String[3][3];
	}

	/*
	 * Llena los huecos del tablero
	 */
	public void llenarTablero() {
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = "| _ |";
			}
		}
	}
	
	/*
	 * Introduce la ficha del jugador en la posicion pasada por parametro 
	 * @param jugador El jugador que le toca jugar
	 * @param a La coordenada de la fila
	 * @param b La coordenada de la columna
	 */
	public void ponerFicha(Jugador jugador, int a, int b) {
		tablero[a][b] = jugador.getFicha();
	}
	
	/*
	 * Comprueba que hay dentro de una posicion dadas las coordenadas por parametro
	 * @param a Fila del tablero
	 * @param b Columna del tablero
	 * @return El string de una posicion del tablero
	 */
	public String comprobarPosicion(int a, int b) {
		String aDevolver = tablero[a][b];
		return aDevolver;
	}

	/*
	 * Imprime el tablero
	 */
	public void imprimirTablero() {
		String letra = "";
		System.out.println("\nTablero: ");
		System.out.println("    1    2    3  ");
		for (int i = 0; i < tablero.length; i++) {
			switch(i) {
				case 0:
					letra = "A ";
					break;
				case 1:
					letra = "B ";
					break;
				case 2:
					letra = "C ";
					break;
			}
			
			System.out.println(letra + tablero[i][0] + tablero[i][1]+ tablero[i][2]);
		}
		System.out.println();
	}
	
	/*
	 * 
	 */
	public boolean comprobacion() {
		boolean fin = false;
		// Comprobacion de que la primera fila sea igual
		if (((tablero[0][0].equals(tablero[0][1])) && (tablero[0][0].equals(tablero[0][2])) && (tablero[0][0]) != "| _ |")) {
			fin = true;
		}
		// Comprobacion de que la segunda fila sea igual
		else if (((tablero[1][0].equals(tablero[1][1])) && (tablero[1][0].equals(tablero[1][2])) && (tablero[1][0]) != "| _ |")) {
			fin = true;
		}
		// Comprobacion de que la tercera fila sea igual
		else if (((tablero[2][0].equals(tablero[2][1])) && (tablero[2][0].equals(tablero[2][2])) && (tablero[2][0]) != "| _ |")) {
			fin = true;
		}
		// Comprobacion de que la primera columna sea igual
		else if (((tablero[0][0].equals(tablero[1][0])) && (tablero[0][0].equals(tablero[2][0])) && (tablero[0][0]) != "| _ |")) {
			fin = true;
		}
		// Comprobacion de que la segunda columna sea igual
		else if (((tablero[0][1].equals(tablero[1][1])) && (tablero[0][1].equals(tablero[2][1])) && (tablero[0][1]) != "| _ |")) {
			fin = true;
		}
		// Comprobacion de que la tercera columna sea igual
		else if (((tablero[0][2].equals(tablero[1][2])) && (tablero[0][2].equals(tablero[2][2])) && (tablero[0][2]) != "| _ |")) {
			fin = true;
		}
		// Comprobacion de que la diagonal pricipal sea igual
		else if (((tablero[0][0].equals(tablero[1][1])) && (tablero[0][0].equals(tablero[2][2])) && (tablero[0][0]) != "| _ |")) {
			fin = true;
		}
		// Comprobacion de que la diagonal pricipal sea igual
		else if (((tablero[2][0].equals(tablero[1][1])) && (tablero[2][0].equals(tablero[0][2])) && (tablero[2][0]) != "| _ |")) {
			fin = true;
		}
		return fin;
	}
	
}
