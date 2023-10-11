package Procesamiento;

import java.util.ArrayList;

import Modelo.AdminGeneral;
import Modelo.AdminLocal;
import Modelo.Cliente;
import Modelo.Reserva;
import Modelo.Sede;

public class Empresa {
	
	private AdminGeneral admingeneral;
	private ArrayList<Cliente> clientes;
	private ArrayList<Sede> sedes;
	private ArrayList<AdminLocal> adminlocales;
	
	public Empresa(ArrayList<Cliente> clientes, ArrayList<AdminLocal> adminlocales, AdminGeneral admingeneral,  ArrayList<Sede> sedes) {
		this.admingeneral = admingeneral;
		this.clientes = clientes;
		this.sedes = sedes;
		this.adminlocales = adminlocales;
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
	
	public Cliente getCliente(String login, String contrasena) {
		Cliente cliente = null;
			for(Cliente i: clientes) {
				if((i.getLogin().equals(login)) && (i.getContrasena().equals(contrasena))) {
					return i;
				}
			}
		return cliente;
	}
	
	public Reserva crearReserva(String recogida, String entrega, String tipoCarro, String sedeDevolucion, String horaEntrega) {
		Double cobroPendiente = 0.0;
		Reserva reserva = new Reserva(recogida, entrega, tipoCarro, sedeDevolucion, horaEntrega, cobroPendiente);
		return reserva;
	}
	
	
}