package EtiquetasHTML;

public class Nodo {

    private String cadena;
    private Nodo siguiente;

    public Nodo(String cadena, Nodo siguiente) {
        this.cadena = cadena;
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String texto) {
        this.cadena = texto;
    }
}

