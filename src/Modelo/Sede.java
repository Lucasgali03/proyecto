package Modelo;

public class Sede{
	private String localidad;
	private String ubicacion;
	private String horarios;
	private String nombre;
	private String diasAtencion;
	
	public Sede(String localidad, String ubicacion, String horarios, String nombre, String dias) {
		this.localidad = localidad;
		this.ubicacion = ubicacion;
		this.horarios = horarios;
		this.nombre = nombre;
		this.diasAtencion = dias;
	}
}
