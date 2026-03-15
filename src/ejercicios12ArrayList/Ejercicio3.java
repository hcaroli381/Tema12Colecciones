package ejercicios12ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {
	public void mostrarMenu() {
		System.out.println("1. Nueva lista");
		System.out.println("2. Número de cadenas");
		System.out.println("3. Añadir cadena");
		System.out.println("4. Eliminar última cadena");
		System.out.println("5. Contiene cadena");
		System.out.println("6. Mostrar lista entera");
		System.out.println("7. Salir");
	}

	public void nuevaLista(List<String> lista) {
		lista.clear();
	}

	public void contarCadenas(List<String> lista) {
		System.out.println(lista.size());

	}

	public void addCadena(List<String> lista, String cadena) {
		lista.add(cadena);
	}

	public void eliminarUltimaCadena(List<String> lista) {
		lista.removeLast();
	}

	public void contieneCadena(List<String> lista, String cadena) {
		System.out.println(lista.contains(cadena));
	}

	public void mostrarLista(List<String> lista) {
		System.out.println(lista.toString());
	}

	public void ejecutarMenu() {
		Scanner sc = new Scanner(System.in);
		ConsoleInput consola = new ConsoleInput(sc);
		List<String> lista = new ArrayList<>();
		int opcion = 0;
		do {
			mostrarMenu();
			opcion = consola.readInt();
			switch (opcion) {
			case 1 -> nuevaLista(lista);
			case 2 -> contarCadenas(lista);
			case 3 -> {
				System.out.println("Introduce una cadena : ");
				String cadena = consola.readString();
				addCadena(lista, cadena);
			}
			case 4 -> eliminarUltimaCadena(lista);
			case 5 -> {
				System.out.println("Introduce una cadena :");
				String cadena = consola.readString();
				contieneCadena(lista, cadena);
			}
			case 6 -> mostrarLista(lista);
			case 7 -> System.out.println("Hasta pronto!!");
			default -> System.out.println("Opcion no valida");
			}
		} while (opcion != 7);
	}

	public static void main(String[] args) {
		new Ejercicio3().ejecutarMenu();
	}

}
