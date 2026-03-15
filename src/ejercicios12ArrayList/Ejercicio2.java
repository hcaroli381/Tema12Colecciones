package ejercicios12ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ejercicio2 {
	public void show() {
		List<Integer> listaEnteros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.printf("Lista enteros : %s\n", listaEnteros.toString());
		System.out.printf("Lista enteros inversa : %s\n", invertirLista(listaEnteros).toString());
	}

	public <T> List<T> invertirLista(List<T> lista) {
		Collections.reverse(lista);
		return lista;
	}

	public static void main(String[] args) {
		new Ejercicio2().show();
	}

}
