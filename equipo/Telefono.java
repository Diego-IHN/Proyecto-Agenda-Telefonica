package equipo;

import java.util.regex.Pattern;

/*
 * 16/03/2026
 * Asignatura: POO (Programación Orientada a Objetos)
 * Unidad 3: Proyecto en equipo
 * Clase: Teléfono
 * Docente: María Lucía Barrón Estrada
 * -- Integrantes: -- 
 * Luis Angel Vea Chairez 25171325
 * Diego Antonio López Olivas 25171090
 * Didier Montoya Samaniego 25170896
 */
public class Telefono {
	//Atributos
	private char tipo;
	private String prefijo, numTel;
	
	//Constructor, reutiliza los métodos setters para simplificar código
	public Telefono(char tipo, String prefijo, String numTel) {
		setTipo(tipo);
		setPrefijo(prefijo);
		setNumTel(numTel);
	}
	
	//Getter y setters
	public char getTipo() {
		return tipo;
	}
	//Setter con validación de tipo de teléfono móvil (m) y fijo (f)
	public void setTipo(char tipo) {
		if (tipo == 'm' || tipo == 'f') { this.tipo = tipo;}
		else {
			this.tipo = 'X';
		}
	}
	public String getPrefijo() {
		return prefijo;
	}
	//Setter con validación de prefijo (valida que no esté vacío y que contenga únicamente dos dígitos)
	public void setPrefijo(String prefijo) {
		//Que sean SÓLO dos ({2}) dígitos ([0-9]) de principio (^) a fin ($)
		Pattern p = Pattern.compile("^[0-9]{2}$");
		if (prefijo != null && p.matcher(prefijo).matches()) { 
			this.prefijo = prefijo; 
		}
		else {
			this.prefijo = "XX";
		}
	}
	public String getNumTel() {
		return numTel;
	}
	//Setter con validación del número de teléfono (valida que no esté vacío y que contenga única y exclusivamente 10 dígitos)
	public void setNumTel(String numTel) {
		// SÓLO 10 dígitos
		Pattern p = Pattern.compile("^[0-9]{10}$");
		if (numTel != null && numTel.matches("\\d{10}")) { this.numTel = numTel;}
		else {
			this.numTel = "0000000000";
		}
	}
	
	//Método toString
	public String toString() {
		return String.format("[%c](+%s)%s", tipo, prefijo, numTel);
	}
}
