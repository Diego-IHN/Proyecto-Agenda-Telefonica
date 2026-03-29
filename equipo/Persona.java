/*
 * Asignatura: POO (Programación Orientada a Objetos)
 * Unidad 3: Proyecto en equipo
 * Docente: María Lucía Barrón Estrada
 * -- Integrantes: -- 
 * Luis Angel Vea Chairez
 * Diego Antonio López Olivas
 * Didier Montoya Samaniego
 */
package equipo;
//Clase Persona
public class Persona {
	//Atributos
	protected String nombre, apellidos, alias;
	protected char sexo;
	
	//Constructor
	public Persona(String nombre, String apellidos, String alias, char sexo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.alias = alias;
		this.sexo = sexo;
	}
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	//Método toString
	public String toString() {
		return String.format("Nombre: %s %s | Alias: %s | Sexo: %c ", nombre, apellidos, alias, sexo);
	}
	
	//Main de prueba
	public static void main(String[]args) {
		Persona p1 = new Persona("Diego", "López Olivas", "Ego", 'H');
		System.out.println(p1);
	}
}
