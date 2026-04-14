/**
 * @author Nombre y apellidos
 * */

package DefUsoListas;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS **********");

        Evaluacion ev1 = new Evaluacion("ED", "Junio 19", 4.5);
        Evaluacion ev2 = new Evaluacion("ED", "Junio 19", -1);
        Evaluacion ev3 = new Evaluacion("ED", "Junio 20", 7.4);
        Evaluacion ev4 = new Evaluacion("Algebra", "Junio 18", 6.4);

        Lista listaEv = new Lista();

        listaEv.insertar(ev1);
        listaEv.insertar(ev2);
        listaEv.insertar(ev3);
        listaEv.insertar(ev4);

        Iterador iterador = listaEv.getIterador();

        while(iterador.hasNext()){
            iterador.next().mostrar();
        }

        System.out.println("Convocatorias en ED: " + listaEv.numConvocatorias("ED"));
        System.out.println("Convocatorias en Algebra: " + listaEv.numConvocatorias("Algebra"));
        System.out.println("Convocatorias en Fundamentos de Programacion: " + listaEv.numConvocatorias("Fundamentos de Programación"));
        System.out.println();

        // Pruebas Alumnos
        Alumno alumno1 = new Alumno("Felipe García Gómez", 1253);
        Alumno alumno2 = new Alumno("Alicia Blázquez Martín", 5622);

        iterador = listaEv.getIterador();
        while(iterador.hasNext()){
            alumno1.nuevaEvaluacion(iterador.next()); // Para incluir las evaluaciones de la listaEv en alumno1
        }

        alumno1.nuevaEvaluacion(new Evaluacion("ED", "Junio 20", 3));


        Lista aprobadosAlumno1 = alumno1.asignaturasAprobadas();

        iterador = aprobadosAlumno1.getIterador();
        while(iterador.hasNext()){
            iterador.next().mostrar();
        }

        Lista aprobadosAlumno2 = alumno2.asignaturasAprobadas();

        iterador = aprobadosAlumno2.getIterador();
        while(iterador.hasNext()){
            iterador.next().mostrar();
        }

        alumno1.mostrar();
        alumno2.mostrar();
    }
}
