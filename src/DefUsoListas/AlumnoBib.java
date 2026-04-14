/**
 * @author Nombre y apellidos
 * */

package DefUsoListas;

import java.util.Iterator;
import java.util.LinkedList;

public class AlumnoBib {

    private String nombre;
    private int matricula;
    private LinkedList<Evaluacion> expediente;

    public AlumnoBib(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new LinkedList<Evaluacion>();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean nuevaEvaluacion(Evaluacion evaluacion) {
        Iterator<Evaluacion> iterador = expediente.iterator();
        boolean estado = false;
        boolean iguales = false;

        if(expediente.size() != 0) {
            while (iterador.hasNext()){
                Evaluacion evaluacionAlumno = iterador.next();

                if (evaluacionAlumno.mismaEvaluacion(evaluacion)) {
                    if (evaluacionAlumno.getNota() == evaluacion.getNota()) {
                        estado = true; // ¿se puede un return dentro de while?
                        iguales = true;
                    } else {
                        System.out.println("Calificación previamente insertada con nota: " + evaluacionAlumno.getNota());
                        iguales = true;
                    }
                }

            }

            if(!iguales){
                expediente.add(evaluacion);
                estado = true;
            }

        } else{
            expediente.add(evaluacion);
            estado = true;
        }

        return estado;
    }

    public boolean estaAprobado(String nombreAsig) {
        Iterator<Evaluacion> iterador = expediente.iterator();
        boolean aprobado = false;
        boolean existe = false;

        while(iterador.hasNext()){
            Evaluacion evaluacion = iterador.next();
            if(evaluacion.getNombreAsignatura().equals(nombreAsig)){
                if(evaluacion.getNota() >= 5){
                    aprobado = true;
                }
                existe = true;
            }
        }

        if(!existe){
            System.out.println("La asignatura " + nombreAsig + " no existe"); // extra
        }

        return aprobado;
    }

    public LinkedList<Evaluacion> asignaturasAprobadas() {
        LinkedList<Evaluacion> aprobados = new LinkedList<Evaluacion>();
        Iterator<Evaluacion> iterador = expediente.iterator();

        while(iterador.hasNext()){
            Evaluacion asignatura = iterador.next();
            if(asignatura.getNota() >= 5){
                aprobados.add(asignatura);
            }
        }

        return aprobados;
    }

    public double mediaAprobadas() {
        double media = 0;
        double suma = 0;
        LinkedList<Evaluacion> aprobadas = this.asignaturasAprobadas();

        if(aprobadas.size() > 0) {
            Iterator<Evaluacion> iterador = aprobadas.iterator();

            while (iterador.hasNext()) {
                suma += iterador.next().getNota();
            }

            media = suma/aprobadas.size();
        }

        return media;
    }

    public int getNumAprobadas() {
        if(this.asignaturasAprobadas().size() > 0) {
            return this.asignaturasAprobadas().size();
        }
        else{
            return 0;
        }
    }

    public void mostrar() {
        System.out.println(nombre + ". Matricula: " + matricula);

        if (expediente.size() > 0) {
            Iterator<Evaluacion> iterador = expediente.iterator();

            while (iterador.hasNext()) {
                iterador.next().mostrar();
            }

            System.out.println(expediente.size() + " evaluaciones y " + this.getNumAprobadas() +
                    " asignaturas aprobadas con calificación media " + this.mediaAprobadas());

        } else{
            System.out.println("No ha realizado ninguna evaluación");
        }
    }
}
