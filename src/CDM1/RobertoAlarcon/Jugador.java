/*
 * @author Roberto Alarcon Bardon
 * @version 07-05-2021
 */

package CDM1.RobertoAlarcon;
public class Jugador {

	private String nombre;
	private int numero;
	private String ficha;
	
	public Jugador() {
		this.nombre = "";
		this.ficha = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFicha() {
		return ficha;
	}

	public void setFicha(String ficha) {
		this.ficha = ficha;
	}
	
}
