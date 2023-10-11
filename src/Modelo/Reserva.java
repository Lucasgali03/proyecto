package Modelo;

public class Reserva {
	private String recogida;
	private String entrega;
	private String tipoCarro;
	private String sedeDevolucion;
	private String horaEntrega;
	private Double cobroPendiente;
	
	public Reserva(String recogida, String entrega, String tipoCarro, String sedeDevolucion, String horaEntrega, Double cobroPendiente) {
		this.recogida = recogida;
		this.entrega = entrega;
		this.tipoCarro = tipoCarro;
		this.sedeDevolucion = sedeDevolucion;
		this.horaEntrega = horaEntrega;
		this.cobroPendiente = cobroPendiente;
	}
}
