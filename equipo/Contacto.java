package equipo;
/*
 * Asignatura: POO (Programación Orientada a Objetos)
 * Unidad 3: Proyecto en equipo
 * Clase: Contacto
 * Docente: María Lucía Barrón Estrada
 * -- Integrantes: -- 
 * Luis Angel Vea Chairez 25171325
 * Diego Antonio López Olivas 25171090
 * Didier Montoya Samaniego 25170896
 */
import java.util.ArrayList;
import java.util.List;
//Clase Contacto extiende Persona
public class Contacto extends Persona {
	//Atributos
	private String correo;
	private List<Telefono> telefonos;
	
	//Getters y setters
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		String regex = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,3}(\\.[a-z]{2,3})*$";
		if (correo != null && correo.matches(regex)) { this.correo = correo; } 
		else { System.out.println("-- ERROR: CORREO INVÁLIDO --"); }
	}
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = (telefonos != null) ? telefonos : new ArrayList<>();
	}
	//
	
	//Constructor
	public Contacto(String nombre, String apellidos, String alias, char sexo, String correo,
			List<Telefono> telefonos) {
		super(nombre, apellidos, alias, sexo);
		setCorreo(correo);
		setTelefonos(telefonos);	
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    // Usamos super.toString() para traer lo que ya imprime Persona (Nombre, alias, etc.)
	    // Si Persona no tiene toString, puedes poner: getNombre() + " " + getApellidos()
	    sb.append("--- Contacto: ").append(getNombre()).append(" ").append(getApellidos()).append(" ---\n");
	    sb.append("Sexo: ").append(getSexo()).append("\n");
	    sb.append("Alias: ").append(getAlias()).append("\n");
	    sb.append("Correo: ").append(this.correo).append("\n");
	    sb.append("Teléfonos:\n");
	    
	    if (this.telefonos.isEmpty()) {
	        sb.append("  -- No hay teléfonos registrados --\n");
	    } else {
	        for (Telefono t : this.telefonos) {
	            sb.append("  -> ").append(t.toString()).append("\n");
	        }
	    }
	    return sb.toString();
	}
}
