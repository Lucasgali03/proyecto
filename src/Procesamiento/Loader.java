package Procesamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Modelo.AdminGeneral;
import Modelo.AdminLocal;
import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.Sede;
import Modelo.Vehiculo;

public class Loader {
	
	public static ArrayList<Cliente> cargarClientes() throws IOException{
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		BufferedReader br = new BufferedReader(new FileReader("./data/usuarios"));
		
		String x = br.readLine();
	
		while (x != null) {
			String[] linea = x.split(";");
			if(linea[0].equals("C")) {
				clientes.add(new Cliente(linea[1],linea[2],linea[3],linea[4],linea[5],linea[6], linea[7], linea[8], Integer.parseInt(linea[9]), linea[10], linea[11], linea[12]));
			}
			
			x = br.readLine();
		}
		br.close();
		
		return clientes;
	}
	
	public static ArrayList<AdminLocal> cargarAdmins() throws IOException{

		ArrayList<AdminLocal> admins = new ArrayList<AdminLocal>();

		BufferedReader br = new BufferedReader(new FileReader("./data/usuarios"));

		String x = br.readLine();

		while (x != null) {
			
			String[] linea = x.split(";");

			if(linea[0].equals("AL")) {
				admins.add(new AdminLocal(linea[1],linea[2],linea[3]));
			}

			x = br.readLine();
			
		}
		br.close();

		return admins;
	}
	
	public static AdminGeneral cargarAdmin() throws IOException{

		AdminGeneral admin = null;

		BufferedReader br = new BufferedReader(new FileReader("./data/usuarios"));

		String x = br.readLine();
		

		while (x != null) {
			
			String[] linea = x.split(";");

			if(linea[0].equals("AG")) {
				admin = new AdminGeneral(linea[1],linea[2]);
				br.close();
				return admin;
			}

			x = br.readLine();
		}
		br.close();
		return admin;
	}
	
	public static ArrayList<Sede> cargarSedes() throws IOException{
		ArrayList<Sede> res = new ArrayList<Sede>();
		BufferedReader br = new BufferedReader(new FileReader("./data/sedes"));
		
		String x = br.readLine();
		
		while (x != null) {
			String[] linea =x.split(";");
			res.add(new Sede(linea[0], linea[1], linea[2], linea[3], linea[4]));
			x = br.readLine();
		}
		br.close();
		return res;
	}
	
	public static HashMap<Categoria, ArrayList<Vehiculo>> cargarInventario(ArrayList<Cliente> clientes) throws IOException{
		HashMap<Categoria, ArrayList<Vehiculo>> inventario = new HashMap<Categoria, ArrayList<Vehiculo>>();
		ArrayList<Vehiculo> carros = new ArrayList<Vehiculo>();
		BufferedReader br = new BufferedReader(new FileReader("./data/inventario"));
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		String x = br.readLine();
		boolean alquilado = false;
		Categoria categoria = null;
		Cliente cliente = null;

		while (x != null) {
			String[] linea =x.split(";");
			if(linea[6].equals("1")){
				alquilado = true;
			}
			for(Cliente i:clientes) {
				if(i.getLogin().equals(linea[8])) {
					cliente = i;
					break;
				}
			}

			categoria = new Categoria(linea[5]);
			for(Categoria i: categorias) {
				if(i.getId() == categoria.getId()) {
						categoria = i;
						break;
					}
				}
			categorias.add(categoria);

			if(inventario.containsKey(categoria)) {
				carros = inventario.get(categoria);
			}

			carros.add(new Vehiculo(linea[0], linea[1], linea[2], linea[3], linea[4], categoria, alquilado, linea[7], cliente));

			inventario.put(categoria, carros);
			x = br.readLine();
		}
		br.close();
		return inventario;
	}
}
