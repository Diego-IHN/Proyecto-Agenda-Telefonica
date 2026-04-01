package equipo;

import java.util.Scanner;

public class UsaAgenda {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		// Para que el programa permita hacer múltiples elecciones
		while (true) {			
			int eleccion;
			System.out.println("Bienvenido a las operaciones disponibles. Elige una:"
					+ "\n1.- Imprimir todos los datos de la Agenda"
					+ "\n2.- Imprimir un listado de contactos por tipo de teléfono"
					+ "\n3.- Agregar una persona a la agenda"
					+ "\n4.- Agregar un correo a una persona"
					+ "\n5.- Agregar un teléfono a una persona"
					+ "\n6.- Eliminar un contacto"
					+ "\n7.- Eliminar el teléfono de un contacto"
					+ "\n8.- Consultar una persona (por nombre o por alias)"
					+ "\n9.- Salir");
			eleccion = sc.nextInt();
			
			if (eleccion == 1) {
				continue;
			} else if (eleccion == 2) {
				continue;
			} else if (eleccion == 3) {
				continue;
			} else if (eleccion == 4) {
				continue;
			} else if (eleccion == 5) {
				continue;
			} else if (eleccion == 6) {
				continue;
			} else if (eleccion == 7) {
				continue;
			} else if (eleccion == 8) {
				continue;
			} else if (eleccion == 9) {
				break;
			} else {
				System.out.println("Elige una opción válida");
			}
		}
		System.out.println("Programa terminado");
	}
}
