package equipo;
/*
 * 16/03/2026
 * Asignatura: POO (Programación Orientada a Objetos)
 * Unidad 3: Proyecto en equipo
 * Clase: Agenda
 * Docente: María Lucía Barrón Estrada
 * -- Integrantes: -- 
 * Luis Angel Vea Chairez 25171325
 * Diego Antonio López Olivas 25171090
 * Didier Montoya Samaniego 25170896
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
	private ArrayList<Contacto> agenda;
	//Constructor para los datos iniciales / predeterminados de la agenda
	public Agenda(ArrayList<Contacto> listaPredeterminada) {
		this.agenda = listaPredeterminada;
	}
	//b) Método para obtener el listado de contactos por tipo de teléfono
	public void imprimirListadoDeContactosPorTipoDeTelefono(char tipoTel) {
		for (Contacto c : agenda) {
			boolean contactoImpreso = false;	
			//Recorre todos los telefonos del contacto
			for (Telefono tel : c.getTelefonos()) {
				if (tel.getTipo() == tipoTel) {
					//Si el encabezado del contacto no ha sido impreso se imprime
					if (!contactoImpreso) {
						System.out.println("\n--- Contacto: " + c.getNombre() + " " + c.getApellidos() + " ---");
						contactoImpreso = true;
					}
					//Si el tipo de teléfono coincide se imprime ese teléfono
					System.out.println("Teléfono: " + tel.toString());
				}
			}
		}
	}
	
	//c) Método para agregar una Persona a la agenda
	
	//d) Método para cambiar el correo de un contacto
	public void cambiarCorreo(String dato, String nuevoCorreo) {
	    boolean encontrado = false;
	    // Primero se busca el contacto y al encontrarse se le cambia el correo
	    for (Contacto c : agenda) {
	        if (c.getNombre().equalsIgnoreCase(dato) || 
	            c.getAlias().equalsIgnoreCase(dato)) {
	            c.setCorreo(nuevoCorreo);
	            System.out.println("Correo agregado correctamente.");
	            encontrado = true;
	            break;
	        }
	    }
	    if (!encontrado) {
	        System.out.println("No se encontró el contacto.");
	    }
	}
	//Método auxiliar para validar un alias dentro de la lista de contactos
	public boolean validarAlias(String alias) {
		for (Contacto c : agenda) {
			if (c.getAlias().equalsIgnoreCase(alias.trim())){
				return true;
			}
		}
		return false;
	}
	//Método auxiliar para validar un nombre dentro de la lista de contactos
	public boolean validarNombre(String nombre) {
		for (Contacto c : agenda) {
			if (c.getNombre().equalsIgnoreCase(nombre.trim())){
				return true;
			}
		}
		return false;
	}
	//e) Método para agregar un teléfono: valida primero que la entrada no venga completamente vacía, de lo contrario no se guarda.
		public void agregarTelefonoAContacto(String alias, Telefono t) {
			boolean encontrado = false;
			for (Contacto c: agenda) {
				if (c.getAlias().equalsIgnoreCase(alias.trim())) {
					c.getTelefonos().add(t);
					System.out.println("-- Teléfono agregado con éxito --");
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				System.out.println("-- Error: No se pudo guardar el teléfono en el contacto --");
			}
		} 
		
	//f) Método para eliminar un contacto de la agenda
		public void eliminarContacto(String correo, String alias) {
			int index = 0;
			for (Contacto c : agenda) {
				// Se busca el correo iterando en la agenda y si se encuentra 
				// se termina el ciclo comparando el correo y el alias
				if (correo.equals(c.getCorreo()) && alias.equals(c.getAlias())) {
					break;
				}
				index++;
			}
			// Se elimina de la agenda usando el método remove de los ArrayList
			agenda.remove(index);
			System.out.println("-- Contacto eliminado --");
		}
	
	//g) Método para eliminar los teléfonos de un contacto
	public void eliminarTelefonoContacto(String alias, Telefono t1) {
		// Dos índices requeridos para claridad
		int indexContacto = 0;
		int indexTelefono = 0;
		for (Contacto c : agenda) {
			// Se busca el correo iterando en la agenda y si se encuentra 
			// se termina el ciclo comparando el alias
			if (alias.equals(c.getAlias())) {
				break;
			}
			indexContacto++;
		}
		// Se consigue el contacto del cual se quiere eliminar un teléfono
		Contacto c = agenda.get(indexContacto);
		// Se obtiene su lista de teléfonos
		for (Telefono t : c.getTelefonos()) {
			// Se busca el index del teléfono que se quiere eliminar comparando
			// los números y los prefijos
			if (t1.getNumTel().equals(t.getNumTel()) && t1.getPrefijo().equals(t.getPrefijo())) {
				break;
			}
			indexTelefono++;
		}
		// Se elimina de la lista de teléfonos del contacto
		c.getTelefonos().remove(indexTelefono);
		System.out.println("-- Teléfono eliminado del contacto --");
	}
	//h) Método para consultar a una persona y obtener sus datos
		public void consultarPersona(String dato) {
		    boolean encontrado = false;
		    // Se busca y se imprime el toString del contacto, el cual incluye
		    // el toString de persona y el toString de sus teléfonos
		    for (Contacto c : agenda) {
		        if (c.getNombre().equalsIgnoreCase(dato) || 
		            c.getAlias().equalsIgnoreCase(dato)) {
		            System.out.println(c.toString());
		            encontrado = true;
		            break;
		        }
		    }
		    if (!encontrado) {
		        System.out.println("Persona no encontrada.");
		    }
		}
	// Método toString
	public String toString() {
		// StringBuilder usado para no crear muchisimos Strings
		StringBuilder sb = new StringBuilder();
		for (Contacto c : agenda) {
			sb.append(c.toString());
			sb.append("\n");
		}
		// Elimina el último salto de linea que se agrega de más
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}