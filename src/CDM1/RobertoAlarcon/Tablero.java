/*
 * @author Roberto Alarcon Bardon
 * @version 07-05-2021
 */

package CDM1.RobertoAlarcon;

import java.util.Arrays;

public class Tablero {

	private int[][] tablero;
	
	public Tablero() {
		this.tablero = new int[3][3];
	}

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	public void imprimirTablero() {
		System.out.println("\nMatriz resultado: ");
		for (int i = 0; i < tablero.length; i++) {
			System.out.println(Arrays.toString(tablero[i]));
		}
		System.out.println();
	}
	
}
