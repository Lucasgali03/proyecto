package Modelo;

public class AdminGeneral implements Usuario{
	private String login;
	private String contrasena;
	
	public AdminGeneral(String login, String contrasena) {
		this.login = login;
		this.contrasena = contrasena;
	}
	
	public String getLogin() {
		return login;
	}
	public String getContrasena() {
		return contrasena;
	}
}
