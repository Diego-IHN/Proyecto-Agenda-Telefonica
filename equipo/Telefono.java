package equipo;
//Clase Teléfono

//TODO: Eliminar el main
public class Telefono {
	//Atributos
	protected char tipo;
	protected String prefijo, numTel;
	
	//Constructor
	public Telefono(char tipo, String prefijo, String numTel) {
		this.tipo = tipo;
		this.prefijo = (prefijo == null) ? "XX" : prefijo;
		this.numTel = (numTel == null) ? "Sin número" :numTel;
	}
	
	//Getter y setters
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	//Método toString
	public String toString() {
		return String.format("[%c](+%s)%s", tipo, prefijo, numTel);
	}
	
	//Main de prueba
	public static void main(String[]args) {
		Telefono t1 = new Telefono('o',"52","6721221165");
		System.out.println(t1);
	}
}
