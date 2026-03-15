package ejercicios12ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
	public void show() {
		Scanner keyboard = new Scanner(System.in);
		ConsoleInput entry = new ConsoleInput(keyboard);
		ArrayList<Integer> numeros = new ArrayList<>();
		double suma = 0;
		double media;

		for (int i = 0; i < 10; i++) {
			System.out.printf("Introduce el número %d :", i + 1);
			int n = entry.readInt();
			numeros.add(n);
			suma += n;
		}

		media = suma / numeros.size();
		System.out.printf("\nLa media es %.2f\n", media);

		System.out.printf("Numeros inferiores a la media : \n");
		for (int num : numeros) {
			if (num < media) {
				System.out.printf("%d ", num);
			}
		}

	}

	public static void main(String[] args) {
		new Ejercicio1().show();
	}

}
