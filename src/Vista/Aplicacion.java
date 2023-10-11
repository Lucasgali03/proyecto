package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Modelo.AdminGeneral;
import Modelo.AdminLocal;
import Modelo.Cliente;
import Modelo.Sede;
import Procesamiento.Empresa;
import Procesamiento.Loader;

public class Aplicacion {
	
	private Empresa calculadora;

	public void ejecutar() throws IOException{
		
		ArrayList<Cliente> clientes = Loader.cargarClientes();
		ArrayList<AdminLocal> admins = Loader.cargarAdmins();
		AdminGeneral admin = Loader.cargarAdmin();
		ArrayList<Sede> sedes = Loader.cargarSedes();
		
		System.out.println("Bienvenido!");
		System.out.println("1. Cliente\n2. Administrador local\n3. Administrador general");
		int rol = Integer.parseInt(input("Seleccione la opcion para la que desea iniciar sesion o registrese si no tiene una cuenta"));
		calculadora = new Empresa(clientes, admins, admin, sedes);
		switch(rol) {
			case(1):
				iniciarCliente();
				break;
			case(2):
				iniciarAdminLocal();
				break;
			case(3):
				iniciarAdminGeneral();
				break;
			default:
				System.out.println("Esa opcion no es valida, vuelva a iniciar la aplicacion");
		}
	}
	
	public void iniciarCliente() {
		
		String login = input("Login");
		String contrasena = input("Contraseña");
		Cliente cliente = calculadora.getCliente(login, contrasena);
		if(cliente != null) {
			boolean acabado = false;
			while(!acabado) {
				System.out.println("Bienvenido "+ cliente.getNombre() + "\n1. Crear reserva\n2. Cerrar sesión");
				int desicion = Integer.parseInt(input("Que desea hacer"));
				switch(desicion) {
					case(1):
						String recogida = input("Ingrese la fecha en que va a recoger el vehículo en el formato (DD/MM/AAAA)");
						String entrega = input("Ingrese la fecha en que va a entregar el vehículo en el formato (DD/MM/AAAA)");
						String tipoCarro = input("Ingrese el tipo de vehículo que desea");
						String sedeDevolucion = input("Ingrese el nombre de la sede donde devolverá el vehículo");
						String horaEntrega = input("Ingrese la hora en que va a entregar el vehículo");
						calculadora.crearReserva(recogida, entrega, tipoCarro, sedeDevolucion, horaEntrega);
						break;
					case(2):
						acabado = true;
						break;
					default:
						System.out.println("Esa opcion no es valida");
				}
			}
		}
		else {
			System.out.println("No se encontró este usuario, vuelva a iniciar la aplicacion si lo desea");
		}
		
	}
	
	public void iniciarAdminLocal() {
		
		
	}
	
	public void iniciarAdminGeneral() {
		
		
	}
	
	public void registrarUsuario() {
		
	}
	
	public static void main(String[] args) throws IOException {
		Aplicacion consola = new Aplicacion();
		consola.ejecutar();

	}
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}
