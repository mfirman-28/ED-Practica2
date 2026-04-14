/**
 * @author Nombre y apellidos
 * */

package DefUsoListas;

public class Alumno {

	private String nombre;
	private int matricula;
	private Lista expediente;

	public Alumno(String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
		expediente = new Lista();
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
		Iterador iterador = expediente.getIterador();
		boolean estado = false;
		boolean iguales = false;

		if(expediente.getNumElementos() != 0) {
			while (iterador.hasNext()) {
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
				expediente.insertar(evaluacion);
				estado = true;
			}

		} else{
			expediente.insertar(evaluacion);
			estado = true;
		}

		return estado;
	}

	public boolean estaAprobado(String nombreAsig) {
		Iterador iterador = expediente.getIterador();
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

	public Lista asignaturasAprobadas() {
		Lista aprobados = new Lista();
		Iterador iterador = expediente.getIterador();

		while(iterador.hasNext()){
			Evaluacion asignatura = iterador.next();
			if(asignatura.getNota() >= 5){
				aprobados.insertar(asignatura);
			}
		}

		return aprobados;
	}

	public double mediaAprobadas() {
		double media = 0;
		double suma = 0;
		Lista aprobadas = this.asignaturasAprobadas();

		if(aprobadas.getNumElementos() > 0) {
			Iterador iterador = aprobadas.getIterador();

			while (iterador.hasNext()) {
				suma += iterador.next().getNota();
			}

			media = suma/aprobadas.getNumElementos();
		}

		return media;
	}

	public int getNumAprobadas() {
		if(this.asignaturasAprobadas().getNumElementos() > 0){
			return this.asignaturasAprobadas().getNumElementos();
		} else{
			return 0;
		}
	}

	public void mostrar() {
		System.out.println(nombre + ". Matricula: " + matricula);

		if (expediente.getNumElementos() > 0) {
			Iterador iterador = expediente.getIterador();

			while (iterador.hasNext()) {
				iterador.next().mostrar();
			}

			System.out.println(expediente.getNumElementos() + " evaluaciones y " + this.getNumAprobadas() +
					" asignaturas aprobadas con calificación media " + this.mediaAprobadas());

		} else{
			System.out.println("No ha realizado ninguna evaluación");
		}
	}
}


