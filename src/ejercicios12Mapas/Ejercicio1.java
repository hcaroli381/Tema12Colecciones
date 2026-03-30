package ejercicios12Mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio1 {
	public List<Libro> listarLibros(ConsoleInput entry) {
		int libros;
		int isbn;
		String titulo, autor;
		List<Libro> lista = new ArrayList<>();
		System.out.println("¿Cuantos libros quieres introducir?");
		libros = entry.readInt();

		for (int i = 0; i < libros; i++) {
			System.out.printf("Libro %d :\n", i);
			System.out.println("Introduce ISBN :");
			isbn = entry.readInt();
			System.out.println("Introduce titulo :");
			titulo = entry.readString();
			System.out.println("Introduce el autor : ");
			autor = entry.readString();
			lista.add(new Libro(titulo, isbn, autor));
		}

		return lista;
	}

	public Map<Libro, Integer> listarMapa(List<Libro> lista) {
		Map<Libro, Integer> mapaLibros = new HashMap<>();

		for (int i = 0; i < lista.size(); i++) {
			if (mapaLibros.containsKey(lista.get(i))) {
				mapaLibros.put(lista.get(i), mapaLibros.get(lista.get(i)) + 1);
			} else {
				mapaLibros.put(lista.get(i), 1);
			}
		}
		return mapaLibros;
	}

	public void comprobarClave(Map<Libro, Integer> mapaLibros, Libro libro) {
		if (mapaLibros.containsKey(libro)) {
			System.out.println(mapaLibros.get(libro));
			mapaLibros.remove(libro);
		} else {
			System.out.println("El libro no está registrado!! ISBN añadido X Autor X Titulo");
			mapaLibros.put(libro, 1);
		}

	}

	public void prestar(Map<Libro, Integer> mapaLibros, ConsoleInput entry) {
		int isbn;
		System.out.println("Escribe un ISBN para eliminarlo y ver las veces que ha sido prestado :");
		isbn = entry.readInt();
		comprobarClave(mapaLibros, new Libro("", isbn, ""));
	}

	public void imprimir(Map<Libro, Integer> mapaLibros) {
		for (Map.Entry<Libro, Integer> entrada : mapaLibros.entrySet()) {
			System.out.printf("Libro: %s, Veces prestado: %d%n", entrada.getKey(), entrada.getValue());
		}
	}

	public void main() {
		Scanner sc = new Scanner(System.in);
		ConsoleInput ci = new ConsoleInput(sc);
		List<Libro> libros = listarLibros(ci);
		Map<Libro, Integer> mapaLibros = listarMapa(libros);
		boolean continuar = true;
		do {
			prestar(mapaLibros, ci);
			imprimir(mapaLibros);
			System.out.println("Introduce s para ver mas libros o n para salir");
			ci.readBooleanUsingChar('s', 'n');
			;
		} while (continuar);
	}

	public static void main(String[] args) {
		new Ejercicio1().main();
	}

}
