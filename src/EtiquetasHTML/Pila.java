package EtiquetasHTML;

public class Pila {

    private Nodo cima;
    private int numElementos;

    public Pila() {   // Iniciar pila vac�a
        cima = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return cima == null;
    }

    public void apilar(String texto) {
        Nodo nuevo = new Nodo(texto, cima);
        cima = nuevo;
        numElementos++;
    }

    public String desapilar() {
        String cadena;
        if (this.vacia()) {
            cadena = null;
        } else {
            cadena = cima.getCadena();
            cima = cima.getSiguiente();
            numElementos--;
        }
        return cadena;
    }

    public String getCima() {
        String cadena;
        if (this.vacia()) {
            cadena = null;
        } else {
            cadena = cima.getCadena();
        }
        return cadena;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public String toString() {
        String resultado = "Cima -> [";
        if (!this.vacia()) {
            resultado += cima.getCadena();
            Nodo aux = cima.getSiguiente();
            while (aux != null) {
                resultado += "," + aux.getCadena();
                aux = aux.getSiguiente();
            }
        }
        resultado += "]";
        return resultado;
    }

}
	
