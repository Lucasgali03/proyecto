package Procesamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Modelo.AdminGeneral;
import Modelo.AdminLocal;
import Modelo.Cliente;
import Modelo.Sede;

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
}
