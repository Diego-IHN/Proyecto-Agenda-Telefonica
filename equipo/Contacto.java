package equipo;
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
	
	//Método para agregar un teléfono: valida primero que la entrada no venga completamente vacía, de lo contrario no se guarda.
	public void agregarTelefono(Telefono t) {
		if (t != null) { this.telefonos.add(t); 
		} else {
			System.out.println("-- ERROR: ENTRADA VACÍA --");
		}
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
}
