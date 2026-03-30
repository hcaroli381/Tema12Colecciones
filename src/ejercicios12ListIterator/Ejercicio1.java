package ejercicios12ListIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import ejercicios12ArrayList.ConsoleInput;

public class Ejercicio1 {
	public void mostrarMenu() {
		System.out.println("1. Mostrar la lista");
		System.out.println("2. Mostrar siguiente");
		System.out.println("3. Mostrar anterior");
		System.out.println("4. Añadir elemento");
		System.out.println("5. Eliminar el último mostrado");
		System.out.println("6. Sustituir el último mostrado");
		System.out.println("7. Salir");
	}

	public void mostrarLista(List<Float> lista) {
		if (!lista.isEmpty()) {
			System.out.printf("%s\n", lista.toString());
		} else {
			System.out.println("lista vacia\n");
		}
	}

	public void mostrarSiguiente(ListIterator<Float> it) {

		if (!it.hasNext()) {
			while (it.hasPrevious()) {
				it.previous();
			}

		}

		if (it.hasNext()) {
			System.out.printf("%f\n", it.next());
		}

	}

	public void addElemento(ListIterator<Float> lista, ConsoleInput entrada) {
		System.out.println("Introduce el valor :");
		float valor = entrada.readFloat();
		lista.add(valor);
	}

	public void mostrarAnterior(ListIterator<Float> lista) {
		if (lista.hasPrevious()) {
			System.out.printf("%f\n", lista.previous());
		}

	}

	public void eliminarUltimo(ListIterator<Float> lista) {
		lista.remove();
		System.out.println("Último elemento borrado");
	}

	public void sustituirUltimo(ListIterator<Float> lista, ConsoleInput entrada) {
		System.out.println("Introduce el valor : ");
		float sustitucion = entrada.readFloat();
		lista.set(sustitucion);
		System.out.println("Elemento sustituido");
	}

	public void ejecutar() {
		Scanner keyboard = new Scanner(System.in);
		ConsoleInput entry = new ConsoleInput(keyboard);
		List<Float> lista = new ArrayList<>();
		ListIterator<Float> it = lista.listIterator();

		int opcion = 0;
		do {
			mostrarMenu();
			opcion = entry.readMenuOption(1, 7);
			switch (opcion) {
			case 1 -> mostrarLista(lista);
			case 2 -> mostrarSiguiente(it);
			case 3 -> mostrarAnterior(it);
			case 4 -> addElemento(it, entry);
			case 5 -> eliminarUltimo(it);
			case 6 -> sustituirUltimo(it, entry);
			case 7 -> System.out.println("Saliendo...");
			}
		} while (opcion != 7);
	}

	public static void main(String[] args) {
		new Ejercicio1().ejecutar();

	}

}
