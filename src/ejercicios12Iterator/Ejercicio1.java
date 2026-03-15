package ejercicios12Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ejercicios12ArrayList.ConsoleInput;

public class Ejercicio1 {
	public void show() {
		Scanner keyboard = new Scanner(System.in);
		ConsoleInput entry = new ConsoleInput(keyboard);
		ArrayList<Integer> numeros = new ArrayList<>();
		Iterator<Integer> it;
		double suma = 0;
		double media;
		int num;

		for (int i = 0; i < 10; i++) {
			System.out.printf("Introduce el número %d :", i + 1);
			int n = entry.readInt();
			numeros.add(n);
			suma += n;
		}
		it = numeros.iterator();

		media = suma / numeros.size();
		System.out.printf("\nLa media es %.2f\n", media);

		System.out.printf("Numeros inferiores a la media y eliminados : \n");
		while (it.hasNext()) {
			num = it.next();
			if (num < media) {

				System.out.printf("%d ", num);

				it.remove();

			}
		}
		System.out.println();
		System.out.printf("Lista actualizada : %s", numeros.toString());

	}

	public static void main(String[] args) {
		new Ejercicio1().show();
	}

}