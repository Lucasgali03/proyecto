package Modelo;

public class Vehiculo {
	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String tipoTransmision;
	private Categoria categoria;
	private boolean enAlquiler;
	private String fechaDisponibilidad;
	private Cliente cliente;
	
	public Vehiculo(String placa, String marca, String modelo, String color, String tipoTransmision, Categoria categoria, boolean enAlquiler, String fechas, Cliente cliente) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipoTransmision = tipoTransmision;
		this.categoria = categoria;
		this.enAlquiler = enAlquiler;
		this.fechaDisponibilidad = fechas;
		this.cliente = cliente;
	}
}
