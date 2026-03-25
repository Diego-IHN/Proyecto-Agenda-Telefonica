package equipo;
import java.util.ArrayList;
import java.util.List;
//Clase Contacto extiende Persona

//TODO: Eliminar el main
public class Contacto extends Persona {
	//Atributos
	private String email;
	private ArrayList<Telefono> telefonos;
	
	//Getters y setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	//
	
	//Constructor
	public Contacto(String nombre, String apellidos, String fechaNacimiento, char sexo, String email,
			List<Telefono> telefonos) {
		super(nombre, apellidos, fechaNacimiento, sexo);
		this.email = email;
		this.telefonos = new ArrayList<>();	
	}
	
	//Método para agregar un teléfono: valida primero que la entrada no venga completamente vacía, de lo contrario no se guarda.
	public void agregarTelefono(Telefono t) {
		if (t != null) { this.telefonos.add(t); 
		} else {
			System.out.println("-- ERROR: ");
		}
	} 
	
	//Método para listar teléfonos del Contacto
	public void listarContactos() {
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
