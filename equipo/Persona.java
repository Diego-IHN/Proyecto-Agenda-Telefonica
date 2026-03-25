package equipo;
//Clase Persona

//TODO: Eliminar el main
public class Persona {
	//Atributos
	protected String nombre, apellidos, fechaNacimiento;
	protected char sexo;
	
	//Constructor
	public Persona(String nombre, String apellidos, String fechaNacimiento, char sexo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
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
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	//Método toString
	public String toString() {
		return String.format("Nombre: %s %s | Sexo: %c | Fecha de nacimiento: %s ", nombre, apellidos, sexo, fechaNacimiento );
	}
	
	//Main de prueba
	public static void main(String[]args) {
		Persona p1 = new Persona("Diego", "López Olivas", "09-04-2007", 'H');
		System.out.println(p1);
	}
}
