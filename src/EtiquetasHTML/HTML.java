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
            }
        }
        fichero.cerrar();
        fichero = new Fichero(nombreFichero);
        if (fichero.valido()) {
            System.out.println("Prueba con Stack:");
            if (comprobarHTMLStack(fichero)) {
                System.out.println("Correcto");
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
        j =+ 1;

        boolean iguales = true;
        while(apertura.charAt(i) != '>'){
            if(apertura.charAt(i) != cierre.charAt(j)){
                iguales = false;
            }
            i++;
            j++;
        }

        return iguales;
    }

    public static boolean comprobarHTML(Fichero fichero) {
        boolean estado = true;
        String[] aux;
        Pila pila = new Pila();
        while ((aux = fichero.leerLinea()) != null){
            for(int i = 0; i < aux.length; i++){
                if(esApertura(aux[i])){
                    pila.apilar(aux[i]);
                }else if(esCierre(aux[i])){
                    if(emparejadas(pila.desapilar(), pila.getCima())){
                        estado = false;
                    }
                }
            }
        }

        return estado;
    }

    public static boolean comprobarHTMLStack(Fichero fichero) {
        boolean estado = true;
        String[] aux;
        Pila pila = new Pila();
        while ((aux = fichero.leerLinea()) != null){
            for(int i = 0; i < aux.length; i++){
                if(esApertura(aux[i])){
                    pila.apilar(aux[i]);
                }else if(esCierre(aux[i])){
                    if(emparejadas(pila.desapilar(), pila.getCima())){
                        estado = false;
                    }
                }
            }
        }

        return estado;
    }


}
