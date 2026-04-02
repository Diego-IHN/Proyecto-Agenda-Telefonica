package equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsaAgenda {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Valores de prueba para la agenda, eliminarlos al final
		Telefono t1 = new Telefono('m', "52", "6671257890");
		Telefono t2 = new Telefono('f', "52", "6516513187");
		Contacto c1 = new Contacto("Luis", "Vea", "luve", 'M', "luve@gmail.com", new ArrayList<Telefono>(List.of(t1, t2)));
		Telefono t3 = new Telefono('m', "52", "1651315848");
		Contacto c2 = new Contacto("Pepe", "Arroz", "peps", 'M', "peps@gmail.com", new ArrayList<Telefono>(List.of(t3)));
		// Dejar vacíos los paréntesis finales, es de prueba
		ArrayList<Contacto> datosPredeterminados = new ArrayList<>(List.of(c1, c2));
		Agenda miAgenda = new Agenda(datosPredeterminados);
		
		// Para que el programa permita hacer múltiples elecciones
		while (true) {			
			int eleccion;
			char tipo;
			String alias, prefijo, numeroTel;
			System.out.println("--- Bienvenido a las operaciones disponibles. Elige una: ---"
					+ "\n1.- Imprimir todos los datos de la Agenda"
					+ "\n2.- Imprimir un listado de contactos por tipo de teléfono"
					+ "\n3.- Agregar una persona a la agenda"
					+ "\n4.- Agregar un correo a una persona"
					+ "\n5.- Agregar un teléfono a una persona"
					+ "\n6.- Eliminar un contacto"
					+ "\n7.- Eliminar el teléfono de un contacto"
					+ "\n8.- Consultar una persona (por nombre o por alias)"
					+ "\n9.- Salir");
			while (!sc.hasNextInt()) {sc.next();}
			eleccion = sc.nextInt();
			sc.nextLine();
			//Imprimir todos los datos de la Agenda
			if (eleccion == 1) {
				System.out.println(miAgenda);
				System.out.println();
				continue;
			//Imprimir un listado de contactos por tipo de teléfono
			} else if (eleccion == 2) {
				System.out.println("Escoja el tipo de teléfono: Móvil (m)/ Fijo (f)");
				tipo = sc.next().toLowerCase().charAt(0);
				while (tipo != 'm' && tipo != 'f') { sc.next(); tipo = sc.next().toLowerCase().charAt(0); } //Validación del tipo de teléfono
				miAgenda.imprimirListadoDeContactosPorTipoDeTelefono(tipo);
				System.out.println();
				continue;
			//Agregar una persona a la agenda
			} else if (eleccion == 3) {
				continue;
			//Agregar un correo a una persona
			} else if (eleccion == 4) {
				continue;
			//Agregar un teléfono a una persona
			} else if (eleccion == 5) {
				System.out.println("-- Ingrese el alias del contacto --");
				alias = sc.nextLine();
				while (!miAgenda.validarAlias(alias)) { System.out.println("-- Error: No se encontró ningún contacto con el alias ingresado --"); alias = sc.nextLine(); }
				
				//Validación del tipo de teléfono
				System.out.println("-- Ingrese el tipo de teléfono: Móvil (m) / Fijo (f) --");
				tipo = sc.next().toLowerCase().charAt(0);
				while (tipo != 'm' && tipo != 'f') { tipo = sc.next().toLowerCase().charAt(0); }
				sc.nextLine();
				
				//Validación del prefijo 
				System.out.println("-- Ingrese el prefijo (2 dígitos) --");
				prefijo = sc.nextLine();
				while (!prefijo.matches("\\d{2}")) {System.out.println("-- Error: Ingrese un prefijo de 2 dígitos --"); prefijo = sc.nextLine();}
				
				//Validación del número de teléfono
				System.out.println("-- Ingrese el número de teléfono (10 dígitos) --");
				numeroTel = sc.nextLine();
				while (!numeroTel.matches("\\d{10}")) {System.out.println("-- Error: Ingrese un número de 10 dígitos --"); numeroTel = sc.nextLine();}
				
				Telefono t = new Telefono(tipo, prefijo, numeroTel);
				miAgenda.agregarTelefonoAContacto(alias,t);
				System.out.println();
				continue;
			//Eliminar un contacto
			} else if (eleccion == 6) {
				continue;
			//Eliminar el teléfono de un contacto
			} else if (eleccion == 7) {
				continue;
			//Consultar una persona (por nombre o por alias)
			} else if (eleccion == 8) {
				continue;
			//Salir
			} else if (eleccion == 9) {
				break;
			//Entrada inválida
			} else {
				System.out.println("Elige una opción válida");
			}
		}
		System.out.println("Programa terminado");
	}
}
