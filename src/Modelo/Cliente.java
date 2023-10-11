package Modelo;

public class Cliente implements Usuario{
	private String login;
	private String contrasena;
	private String nombre;
	private String nacimiento;
	private String nacionalidad;
	private Tarjeta tarjeta;
	private Licencia licencia;
	
	public Cliente(String login, String contrasena, String nombre, String nacimiento, String nacionalidad, int numTar, String metodo, String vencimientoTar, int numLic, String paisLic, String vencimientoLic, String imagen) {
		this.login = login;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.tarjeta = new Tarjeta(numTar, metodo, vencimientoTar);
		this.licencia = new Licencia(numLic, paisLic, vencimientoLic, imagen);
	}
	
	public String getLogin() {
		return login;
	}
	public String getContrasena() {
		return contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	
}
