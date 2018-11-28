package classProperties;

import java.util.List;

public class ActionsConfiguration {
	private List<String> avanzar;
	private List<String> derecha;
	private List<String> izquierda;
	private List<String> luz;

	public ActionsConfiguration(List<String> avanzar, List<String> derecha, List<String> izquierda, List<String> luz) {
		super();
		this.avanzar = avanzar;
		this.derecha = derecha;
		this.izquierda = izquierda;
		this.luz = luz;
	}

	public List<String> getAvanzar() {
		return avanzar;
	}

	public void setAvanzar(List<String> avanzar) {
		this.avanzar = avanzar;
	}

	public List<String> getDerecha() {
		return derecha;
	}

	public void setDerecha(List<String> derecha) {
		this.derecha = derecha;
	}

	public List<String> getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(List<String> izquierda) {
		this.izquierda = izquierda;
	}

	public List<String> getLuz() {
		return luz;
	}

	public void setLuz(List<String> luz) {
		this.luz = luz;
	}
}
