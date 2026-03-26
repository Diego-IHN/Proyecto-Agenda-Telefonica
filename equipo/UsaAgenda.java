package equipo;

import java.util.Scanner;

public class UsaAgenda {
	public static void main(String[] args) {
		int eleccion;
		Scanner sc = new Scanner(System.in);

		System.out.println("Bienvenido a las operaciones disponibles. Elige una:"
				+ "\n1.- Imprimir todos los datos de la Agenda"
				+ "\n2.- Imprimir un listado de contactos por tipo de teléfono"
				+ "\n3.- Agregar una persona a la agenda"
				+ "\n4.- Agregar un correo a una persona"
				+ "\n5.- Agregar un teléfono a una persona"
				+ "\n6.- Eliminar un contacto"
				+ "\n7.- Eliminar el teléfono de un contacto"
				+ "\n8.- Consultar una persona (por nombre o por alias)");
		eleccion = sc.nextInt();
		
		Agenda agenda = new Agenda();
	}
}
