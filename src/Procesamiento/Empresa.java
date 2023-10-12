package Procesamiento;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

import Modelo.AdminGeneral;
import Modelo.AdminLocal;
import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.Reserva;
import Modelo.Sede;
import Modelo.Vehiculo;

public class Empresa {
	
	private AdminGeneral admingeneral;
	private ArrayList<Cliente> clientes;
	private ArrayList<Sede> sedes;
	private ArrayList<AdminLocal> adminlocales;
	private HashMap<Categoria, ArrayList<Vehiculo>> inventario;
	
	
		public Empresa(ArrayList<Cliente> clientes, ArrayList<AdminLocal> adminlocales, AdminGeneral admingeneral,  ArrayList<Sede> sedes, HashMap<Categoria, ArrayList<Vehiculo>> inventario) {
		this.admingeneral = admingeneral;
		this.clientes = clientes;
		this.sedes = sedes;
		this.adminlocales = adminlocales;
		this.inventario = inventario;
	}
	
	public AdminGeneral getAdminGeneral(String login, String contrasena) {
		AdminGeneral admin = null;
			if((admingeneral.getLogin().equals(login)) && (admingeneral.getContrasena().equals(contrasena))) {
				return admingeneral;
				
			}
		return admin;
	}
	
	public AdminLocal getAdminLocal(String login, String contrasena) {
		AdminLocal admin = null;
			for(AdminLocal i: adminlocales) {
				if((i.getLogin().equals(login)) && (i.getContrasena().equals(contrasena))) {
					return i;
				}
			}
		return admin;
	}
	
	public Cliente getCliente(String login, String contrasena, boolean inicioSesion) {
		Cliente cliente = null;
		if(inicioSesion) {
			for(Cliente i: clientes) {
				if((i.getLogin().equals(login)) && (i.getContrasena().equals(contrasena))) {
					return i;
				}
			}
		}
		else {
			for(Cliente i: clientes) {
				if((i.getLogin().equals(login))) {
					return i;
				}
			}
		}

		return cliente;
	}
		
		
	
	
	public Reserva crearReserva(String recogida, String entrega, String tipoCarro, String sedeDevolucion, String horaEntrega) {
		Double cobroPendiente = 0.0;
		LocalDate date1 = LocalDate.of(Integer.parseInt(recogida.substring(6)), Integer.parseInt(recogida.substring(3,5)), Integer.parseInt(recogida.substring(0, 2)));
		LocalDate date2 = LocalDate.of(Integer.parseInt(entrega.substring(6)), Integer.parseInt(entrega.substring(3,5)), Integer.parseInt(entrega.substring(0, 2)));
		long dias = ChronoUnit.DAYS.between(date1, date2);
		
		Reserva reserva = new Reserva(recogida, entrega, tipoCarro, sedeDevolucion, horaEntrega, cobroPendiente);
		return reserva;
	}
	
	
}