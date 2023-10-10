package Modelo;

public class Cliente implements Usuario{
	private String login;
	private String contrasena;
	private String nombre;
	private String nacimiento;
	private String nacionalidad;
	
	public Cliente(String login, String contrasena, String nombre, String nacimiento, String nacionalidad) {
		this.login = login;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
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
