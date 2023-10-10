package Modelo;

public class AdminLocal implements Usuario{
	private String login;
	private String contrasena;
	private String sede;
	
	public AdminLocal(String login, String contrasena, String sede) {
		this.login = login;
		this.contrasena = contrasena;
		this.sede = sede;
	}
	
	public String getLogin() {
		return login;
	}
	public String getContrasena() {
		return contrasena;
	}
}
