package equipo;
/*
 * 16/03/2026
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
import java.util.regex.Pattern;
//Clase Contacto extiende Persona
public class Contacto extends Persona {
	//Atributos
	private String correo;
	private List<Telefono> telefonos;
	// Para no crear el pattern con cada Contacto nuevo
	/*
	 * Expresión regular que valida (por partes):
	 * 1.- Inicio de la cadena
	 * 2.- Puede tener letras, números, puntos y guiones
	 * 3.- Un arroba
	 * 4.- Nuevamente letras, números, puntos y guiones
	 * 5.- Un punto
	 * 6.- 2 o 3 letras minúsculas
	 * 7.- Extensiones (el * significa que puede aparecer 0 o más veces en la cadena)
	 * 8.- Fin de la cadena
	 */
	private static final Pattern regexCorreo = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,3}(\\.[a-z]{2,3})*$");
	//Constructor
	public Contacto(String nombre, String apellidos, String alias, char sexo, String correo,
			List<Telefono> telefonos) {
		super(nombre, apellidos, alias, sexo);
		setCorreo(correo);
		setTelefonos(telefonos);	
	}
	//Getters y setters
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		// Usa la expresión regular
		if (correo != null && regexCorreo.matcher(correo).matches()) { 
			this.correo = correo;
		} 
		else {
			System.out.println("-- ERROR: CORREO INVÁLIDO --"); 
		}
	}
	//Método auxiliar para validar correo
	// Es estática porque no es necesario que sea única para cada objeto
	public static boolean validarCorreo(String correo) {
		/*
		 * Expresión regular que valida (por partes):
		 * 1.- Inicio de la cadena
		 * 2.- Puede tener letras, números, puntos y guiones
		 * 3.- Un arroba
		 * 4.- Nuevamente letras, números, puntos y guiones
		 * 5.- Un punto
		 * 6.- 2 o 3 letras minúsculas
		 * 7.- Extensiones (el * significa que puede aparecer 0 o más veces en la cadena)
		 * 8.- Fin de la cadena
		 */
		boolean verificado = regexCorreo.matcher(correo).matches();
		// Regresa si el correo cumple con la expresión regular
		return verificado;
	}
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = (telefonos != null) ? telefonos : new ArrayList<>();
	}
	//Método para listar teléfonos del Contacto
	public void obtenerListaDeTelefonos() {
		System.out.println("Teléfonos de " + nombre + ": ");
		if (telefonos.isEmpty()) {
			System.out.println("-- No hay teléfonos registrados --");
		} else {
			for (int i=0; i<telefonos.size(); i++) {
				System.out.println("["+ (i+1) +"]: " + telefonos.get(i).toString());
			}
		}
	}
	//Método para eliminar un teléfono
	public void eliminarTelefono(int index) {
		if (index >= 0 && index < telefonos.size()) {
			telefonos.remove(index);
			System.out.println("-- Teléfono eliminado con éxito --");
		} else {
			System.out.println("-- ERROR: El teléfono seleccionado no existe --");
		}
	}
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    // Usamos super.toString() para traer lo que ya imprime Persona (Nombre, alias, etc.)
	    // Si Persona no tiene toString, puedes poner: getNombre() + " " + getApellidos()
	    sb.append("--- Contacto: ").append(getNombre()).append(" ").append(getApellidos()).append(" ---\n");
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
