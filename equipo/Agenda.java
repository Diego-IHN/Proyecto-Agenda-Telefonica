package equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// clase Agenda
public class Agenda {
	// Valores de prueba para la agenda, eliminarlos al final
	Telefono t1 = new Telefono('m', "52", "6671257890");
	Telefono t2 = new Telefono('m', "52", "6516513187");
	Contacto c1 = new Contacto("Luis", "Vea", "luve", 'M', "luve@gmail.com", new ArrayList<Telefono>(List.of(t1, t2)));
	Telefono t3 = new Telefono('m', "52", "1651315848");
	Contacto c2 = new Contacto("Pepe", "Arroz", "peps", 'M', "peps@gmail.com", new ArrayList<Telefono>(List.of(t3)));
	// Dejar vacíos los paréntesis finales, es de prueba
	ArrayList<Contacto> agenda = new ArrayList<>(List.of(c1, c2));
	
	// Método para eliminar los teléfonos de un contacto
	public void eliminarTelefonoContacto(Contacto c1, Telefono t1) {
		// Dos índices requeridos para claridad
		int indexContacto = 0;
		int indexTelefono = 0;
		for (Contacto c : agenda) {
			// Se busca el correo iterando en la agenda y si se encuentra 
			// se termina el ciclo comparando correo y alias
			if (c1.getCorreo().equals(c.getCorreo()) && c1.getAlias().equals(c.getAlias())) {
				break;
			}
			indexContacto++;
		}
		// Se consigue el contacto del cual se quiere eliminar un teléfono
		Contacto c = agenda.get(indexContacto);
		// Se obtiene su lista de teléfonos
		List<Telefono> listaTelefonos = c.getTelefonos();
		for (Telefono t : listaTelefonos) {
			// Se busca el index del teléfono que se quiere eliminar comparando
			// los números y los prefijos
			if (t1.getNumTel().equals(t.getNumTel()) && t1.getPrefijo().equals(t.getPrefijo())) {
				break;
			}
			indexTelefono++;
		}
		// Se elimina de la lista de teléfonos del contacto
		listaTelefonos.remove(indexTelefono);
	}
	
	// Método para eliminar un contacto de la agenda
	public void eliminarContacto(Contacto c1) {
		int index = 0;
		for (Contacto c : agenda) {
			// Se busca el correo iterando en la agenda y si se encuentra 
			// se termina el ciclo comparando el correo y el alias
			if (c1.getCorreo().equals(c.getCorreo()) && c1.getAlias().equals(c.getAlias())) {
				break;
			}
			index++;
		}
		// Se elimina de la agenda usando el método remove de los ArrayList
		agenda.remove(index);
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
	
	// main de prueba
	public static void main(String[] args) {
		Telefono t1 = new Telefono('m', "52", "6671257890");
		Telefono t2 = new Telefono('m', "52", "6516513187");
		Contacto c1 = new Contacto("Luis", "Vea", "luve", 'M', "luve@gmail.com", new ArrayList<Telefono>(List.of(t1, t2)));
		Telefono t3 = new Telefono('m', "52", "1651315848");
		Contacto c2 = new Contacto("Pepe", "Arroz", "peps", 'M', "peps@gmail.com", new ArrayList<Telefono>(List.of(t3)));
		Agenda agenda1 = new Agenda();
		System.out.println(agenda1);
		agenda1.eliminarContacto(c2);
		// Probando si se eliminó correctamente
		System.out.println("Tras eliminar un contacto: \n" + agenda1);
		agenda1.eliminarTelefonoContacto(c1, t1);
		System.out.println("Tras eliminar teléfono: \n" + agenda1);
	}
}
