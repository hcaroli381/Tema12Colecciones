package ejercicios12EnumSet;

import java.util.EnumSet;

public class Ejercicio1 {
	public void allMonth() {
		EnumSet<Mes> todosLosMeses = EnumSet.allOf(Mes.class);
		System.out.printf("todos los meses : %s\n", todosLosMeses.toString());
	}

	public EnumSet<Mes> verano() {
		EnumSet<Mes> empty = EnumSet.noneOf(Mes.class);
		empty.add(Mes.JUNIO);
		empty.add(Mes.JULIO);
		empty.add(Mes.AGOSTO);
		System.out.printf("Meses de verano : %s\n", empty.toString());

		return empty;
	}

	public EnumSet<Mes> restoVerano(EnumSet<Mes> verano) {
		EnumSet<Mes> restoVerano = EnumSet.complementOf(verano);
		System.out.printf("Meses que no pertenecen a verano : %s\n", restoVerano.toString());
		return restoVerano;
	}

	public void copia(EnumSet<Mes> original) {
		EnumSet<Mes> copia = EnumSet.copyOf(original);
		System.out.printf("Copia del anterior : %s\n", copia.toString());
	}

	public void septiembreADiciembre() {
		EnumSet<Mes> finAnio = EnumSet.range(Mes.SEPTIEMBRE, Mes.DICIEMBRE);
		System.out.printf("De septiembre a diciembre : %s\n", finAnio.toString());
	}

	public void main() {
		EnumSet<Mes> verano, restoVerano, copia;
		allMonth();
		verano = verano();
		restoVerano = restoVerano(verano);
		copia(restoVerano);
		septiembreADiciembre();
	}

	public static void main(String[] args) {
		new Ejercicio1().main();
	}

}
