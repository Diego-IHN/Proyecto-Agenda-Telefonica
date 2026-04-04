package equipo;
/*
 * Asignatura: POO (Programación Orientada a Objetos)
 * Unidad 3: Proyecto en equipo
 * Clase: UsaAgenda
 * Docente: María Lucía Barrón Estrada
 * -- Integrantes: -- 
 * Luis Angel Vea Chairez 25171325
 * Diego Antonio López Olivas 25171090
 * Didier Montoya Samaniego 25170896
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsaAgenda {
	// Como se necesita crear 2 veces teléfono es mejor crear un método para reutilizar el código
	// este método se usa en las opciones 5 y 7
	public static Telefono crearTelefono(Scanner sc) {
		String prefijo, numeroTel;
		char tipo;
		
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
		
		return new Telefono(tipo, prefijo, numeroTel);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Valores de prueba para la agenda, eliminarlos al final
		Telefono t1 = new Telefono('m', "52", "6671257890");
		Telefono t2 = new Telefono('f', "52", "6516513187");
		Contacto c1 = new Contacto("Luis", "Vea", "luve", 'H', "luve@gmail.com", new ArrayList<Telefono>(List.of(t1, t2)));
		Telefono t3 = new Telefono('m', "52", "1651315848");
		Contacto c2 = new Contacto("Pepe", "Ernesto", "peps", 'H', "peps@gmail.com", new ArrayList<Telefono>(List.of(t3)));
		Telefono t4 = new Telefono('m', "52", "6721221165");
		Telefono t5 = new Telefono('f', "64", "6675211478");
		Contacto c3 = new Contacto("Diego", "Lopez Olivas", "Ego", 'h', "dgo_antonio@gmail.com", new ArrayList<Telefono>(List.of(t4, t5)));
		// Dejar vacíos los paréntesis finales, es de prueba
		ArrayList<Contacto> datosPredeterminados = new ArrayList<>(List.of(c1, c2, c3));
		Agenda miAgenda = new Agenda(datosPredeterminados);
		
		// Para que el programa permita hacer múltiples elecciones
		while (true) {			
			int eleccion;
			char tipo;
			String alias, correo, nombre, apellidos;
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
			//Imprimir un listado de contactos por tipo de teléfono
			} else if (eleccion == 2) {
				System.out.println("Escoja el tipo de teléfono: Móvil (m)/ Fijo (f)");
				tipo = sc.next().toLowerCase().charAt(0);
				while (tipo != 'm' && tipo != 'f') { tipo = sc.next().toLowerCase().charAt(0); } //Validación del tipo de teléfono
				miAgenda.imprimirListadoDeContactosPorTipoDeTelefono(tipo);
				System.out.println();
			//Agregar una persona a la agenda
			} else if (eleccion == 3) {
				// SÓLO FALTA ESTE
				continue;
			//cambiar el correo a una persona
			} else if (eleccion == 4) {
				// Se consiguen los datos
				System.out.println("-- Ingrese el nombre y apellidos del contacto --");
				System.out.print("-- Nombre: ");
				nombre = sc.nextLine();
				while (!miAgenda.validarNombre(nombre)) { System.out.println("-- Error: No se encontró ningún contacto con el nombre ingresado --"); nombre = sc.nextLine(); }
				System.out.print("-- Apellidos: ");
				apellidos = sc.nextLine();
				while (!miAgenda.validarApellidos(apellidos)) { System.out.println("-- Error: No se encontró ningún contacto con los apellidos ingresados --"); apellidos = sc.nextLine(); }
				System.out.println("-- Ingresa el nuevo correo del contacto --");
				correo = sc.nextLine();
				// Se cambia el correo
				miAgenda.cambiarCorreo(nombre, apellidos, correo);
				System.out.println();
			//Agregar un teléfono a una persona
			} else if (eleccion == 5) {
				// Se obtiene de forma aparte el alias
				System.out.println("-- Ingrese el alias del contacto --");
				alias = sc.nextLine();
				while (!miAgenda.validarAlias(alias)) { System.out.println("-- Error: No se encontró ningún contacto con el alias ingresado --"); alias = sc.nextLine(); }
				// Se consigue el teléfono y se crea
				Telefono t = crearTelefono(sc);
				miAgenda.agregarTelefonoAContacto(alias,t);
				System.out.println();
			//Eliminar un contacto
			} else if (eleccion == 6) {
				// Obteniendo los datos a buscar
				System.out.println("-- Ingrese el correo del usuario a eliminar --");
				correo = sc.nextLine();
				System.out.println("-- Ingrese el alias del usuario a eliminar --");
				alias = sc.nextLine();
				// Se elimina el contacto
				miAgenda.eliminarContacto(correo, alias);
				System.out.println();
			//Eliminar el teléfono de un contacto
			} else if (eleccion == 7) {
				// Se obtiene el alias
				System.out.println("-- Ingrese el alias del contacto --");
				alias = sc.nextLine();
				while (!miAgenda.validarAlias(alias)) { System.out.println("-- Error: No se encontró ningún contacto con el alias ingresado --"); alias = sc.nextLine(); }
				// Se obtiene el teléfono y se elimina el teléfono del contacto
				Telefono t = crearTelefono(sc);
				miAgenda.eliminarTelefonoDeContacto(alias, t.getTipo() ,t);
				System.out.println();
			//Consultar una persona (por nombre o por alias)
			} else if (eleccion == 8) {
				System.out.println("¿Desea buscar por alias o por nombre?"
						+ "\n1.- Alias"
						+ "\n2.- Nombre");
				while (!sc.hasNextInt()) { sc.next(); }
				int op = sc.nextInt();
				sc.nextLine();
				if (op == 1) {
					// Caso de consulta por alias
					System.out.println("-- Ingrese el alias del contacto --");
					alias = sc.nextLine();
					while (!miAgenda.validarAlias(alias)) { System.out.println("-- Error: No se encontró ningún contacto con el alias ingresado --"); alias = sc.nextLine(); }
					miAgenda.consultarPersona(alias);
				} else if (op == 2) {
					// Caso de consulta por nombre y apellidos
					System.out.println("-- Ingrese el nombre y apellidos del contacto --");
					System.out.print("-- Nombre: ");
					nombre = sc.nextLine();
					while (!miAgenda.validarNombre(nombre)) { System.out.println("-- Error: No se encontró ningún contacto con el nombre ingresado --"); nombre = sc.nextLine(); }
					System.out.print("-- Apellidos: ");
					apellidos = sc.nextLine();
					while (!miAgenda.validarApellidos(apellidos)) { System.out.println("-- Error: No se encontró ningún contacto con el apellido ingresado --"); apellidos = sc.nextLine(); }
					miAgenda.consultarPersona(nombre, apellidos);
				} else {
					// Caso default en que el usuario no elige ninguna opción válida
					System.out.println("Ingrese una opción válida");
				}
				System.out.println();
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