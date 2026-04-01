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
		// TODO
		return false;  // Eliminar esta línea
	}

	public boolean estaAprobado(String nombreAsig) {
		// TODO
		return false;  // Eliminar esta línea
	}

	public Lista asignaturasAprobadas() {
		// TODO
		return null;  // Eliminar esta línea
	}

	public double mediaAprobadas() {
		// TODO
		return 0;  // Eliminar esta línea
	}

	public int getNumAprobadas() {
		// TODO
		return 0;  // Eliminar esta línea
	}

	public void mostrar() {
		// TODO
	}

}


