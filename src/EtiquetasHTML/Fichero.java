package EtiquetasHTML;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fichero {
    private BufferedReader entrada;

    public Fichero(String nombre) {
        try {
            entrada = new BufferedReader(new FileReader(nombre));
        } catch (FileNotFoundException ex) {
            System.out.println("EtiquetasHTML.Fichero no encontrado " + nombre);
        }
    }

    public boolean valido() {
        return entrada != null;
    }

    public String[] leerLinea() {
        String[] resultado = null;
        if (entrada != null) {
            try {
                String linea = entrada.readLine();
                if (linea != null) {
                    resultado = linea.trim().split(" +");
                }
            } catch (IOException es) {
                System.out.println("Error en fichero ");
            }
        }
        return resultado;
    }


    public void cerrar() {
        if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException ex) {
                System.out.println("Error en fichero ");
            }
        }
    }
}
