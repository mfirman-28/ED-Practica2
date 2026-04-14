package DefUsoListas;

public class Iterador {

	private Nodo actual;

	public Iterador(Nodo nodo) {
		actual = nodo;
	}

	public boolean hasNext() {
		return actual != null;
	} // ¿no seria actual.getSiguiente != null?

	public Evaluacion next() {
		Evaluacion resultado = actual.getDato();
		actual = actual.getSiguiente();
		return resultado;
	}
}
