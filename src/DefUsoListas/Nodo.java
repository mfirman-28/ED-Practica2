/**
 * @author Nombre y apellidos
 * */
package DefUsoListas;

public class Nodo {

	private Evaluacion ev;
	private Nodo siguiente;

	public Nodo(Evaluacion ev, Nodo siguiente) {
		this.ev = ev;
		this.siguiente = siguiente;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Evaluacion getDato() {
		return ev;
	}

	public void setDato(Evaluacion ev) {
		this.ev = ev;
	}
}
