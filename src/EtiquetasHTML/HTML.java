package EtiquetasHTML;

import java.util.Scanner;
import java.util.Stack;

public class HTML {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el nombre del fichero: ");
        String nombreFichero = teclado.nextLine();
        Fichero fichero = new Fichero(nombreFichero);
        if (fichero.valido()) {
            System.out.println("Prueba con Pila:");
            if (comprobarHTML(fichero)) {
                System.out.println("Correcto");
            }else{
                System.out.println("Incorrecto");
            }
        }
        fichero.cerrar();

        System.out.println();

        fichero = new Fichero(nombreFichero);
        if (fichero.valido()) {
            System.out.println("Prueba con Stack:");
            if (comprobarHTMLStack(fichero)) {
                System.out.println("Correcto");
            }else{
                System.out.println("Incorrecto");
            }
        }
        fichero.cerrar();
    }

    public static boolean esApertura(String palabra) {
        boolean flagComienzo = false;
        boolean flagFinal = false;

        for(int i = 0; i < palabra.length(); i++){
            if(palabra.charAt(i) == '<' && palabra.charAt(i+1) != '/') {
                flagComienzo = true;
            }else if(palabra.charAt(i) == '>'){
                flagFinal = true;
            }
        }
        return flagComienzo & flagFinal;
    }

    public static boolean esCierre(String palabra) {
        boolean flagComienzo = false;
        boolean flagFinal = false;

        for(int i = 0; i < palabra.length(); i++){
            if(palabra.charAt(i) == '<' && palabra.charAt(i+1) == '/') {
                flagComienzo = true;
            }else if(palabra.charAt(i) == '>'){
                flagFinal = true;
            }
        }
        return flagComienzo & flagFinal;
    }

    public static boolean emparejadas(String apertura, String cierre) {
        int i = 0;
        while(apertura.charAt(i) != '<'){
            i++;
        }
        i =+ 1;

        int j = 0;
        while(cierre.charAt(j) != '/'){
            j++;
        }
        j =+ 2;

        boolean iguales = false;
        if(apertura.length() + 1 == cierre.length()) {
            iguales = true;
            while (apertura.charAt(i) != '>' && iguales) {
                if (apertura.charAt(i) != cierre.charAt(j)) {
                    iguales = false;
                }
                i++;
                j++;
            }
        }

        return iguales;
    }

    public static boolean comprobarHTML(Fichero fichero) {
        boolean estado = true;
        String[] aux;
        Pila pila = new Pila();
        int numLinea = 0;

        // Comprobamos si los cierres y las ultimas aperturas estan emparejadas
        while (((aux = fichero.leerLinea()) != null) && estado){
            numLinea++;
            for(int i = 0; i < aux.length; i++){
                if(esApertura(aux[i])){
                    pila.apilar(aux[i]);
                }else if(esCierre(aux[i])){
                    if(!(emparejadas(pila.desapilar(), aux[i]))){
                        System.out.println("Error en línea" + numLinea + "al leer etiqueta " + aux[i]);
                        estado = false;
                    }
                }
            }
        }

        // Comprobamos si alguna apertura se quedo sin cierre
        if(!(pila.vacia()) && estado){

            String resultado = ""; //+
            if(!(pila.vacia())) {
                resultado += pila.desapilar();
                while (!(pila.vacia())) {
                    resultado += ", " + pila.desapilar();
                }
            }

            System.out.println("Final de fuente inesperado, fuentes sin cierre: " + resultado);
            estado = false;
        }

        return estado;
    }

    public static boolean comprobarHTMLStack(Fichero fichero) {

        return false;
    }


}
