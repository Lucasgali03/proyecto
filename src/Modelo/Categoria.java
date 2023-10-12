package Modelo;

public class Categoria {
	private int idCategoria;
	private double tarifaDiaTAlta;
	private double tarifaDiaTBaja;
	private double valorExtraSede;
	private double valorExtraConductor;
	
	public Categoria(String categoria) {
		if(categoria.equals("sedan")) {
			this.idCategoria = 1;
			this.tarifaDiaTAlta = 110000.0;
			this.tarifaDiaTBaja = 100000.0;
			this.valorExtraSede = 20000.0;
			this.valorExtraConductor = 10000.0;
		}
		else if(categoria.equals("camioneta")) {
			this.idCategoria = 2;
			this.tarifaDiaTAlta = 130000.0;
			this.tarifaDiaTBaja = 110000.0;
			this.valorExtraSede = 20000.0;
			this.valorExtraConductor = 10000.0;
		}
		else {
			this.idCategoria = 3;
			this.tarifaDiaTAlta = 150000.0;
			this.tarifaDiaTBaja = 140000.0;
			this.valorExtraSede = 20000.0;
			this.valorExtraConductor = 20000.0;
		}
	}
}
