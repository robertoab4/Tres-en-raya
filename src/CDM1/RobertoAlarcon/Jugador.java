/*
 * @author Roberto Alarcon Bardon
 * @version 11-05-2021
 */

package CDM1.RobertoAlarcon;
public class Jugador {

	private String nombre;
	private String ficha;
	
	public Jugador(String ficha) {
		this.nombre = "";
		this.ficha = ficha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFicha() {
		return ficha;
	}
	
}