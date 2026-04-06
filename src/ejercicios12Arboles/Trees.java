package ejercicios12Arboles;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Trees {
	public Set<Employee> defaultSet() {
		Set<Employee> arbol = new TreeSet<Employee>();
		return arbol;
	}

	public Set<Employee> alphabeticalOrder() {
		Set<Employee> arbol;
		arbol = new TreeSet<>(new Comparator<Employee>() {

			@Override
			public int compare(Employee e0, Employee e1) {
				int response;
				response = e1.getName().compareToIgnoreCase(e0.getName());
				if (response == 0) {
					return e1.getKey().toString().compareTo(e0.getKey().toString());
				}
				return response;
			}
		});
		return arbol;
	}

	public Map<String, Employee> categoryNumber() {
		Map<String, Employee> arbol;
		arbol = new TreeMap<>(new Comparator<String>() {

			public int compare(String s1, String s2) {
				char c1, c2;
				int n1, n2;

				c1 = s1.charAt(0);
				c2 = s2.charAt(0);
				n1 = getOrder(c1);
				n2 = getOrder(c2);
				if (n1 != n2) {
					return Integer.compare(n1, n2);
				} else {
					n1 = Integer.parseInt(s1.substring(1));
					n2 = Integer.parseInt(s2.substring(1));
					return Integer.compare(n1, n2);
				}

			}

			private int getOrder(char c) {
				return switch (c) {
				case 'B' -> 1;
				case 'M' -> 2;
				case 'E' -> 3;
				default -> 4;

				};
			}

		});
		return arbol;
	}

	public void introducirUsuarios(Set<Employee> set1, Set<Employee> set2, Map<String, Employee> map) {
		Category b, m, e;
		b = Category.BOSS;
		m = Category.MANAGER;
		e = Category.EMPLOYEE;
		Employee pepe = new Employee(new Key(e), "Pepe", LocalDate.of(2011, 3, 21), LocalDate.of(2023, 4, 22));
		Employee juan = new Employee(new Key(m), "Juan", LocalDate.of(2012, 2, 29), null);
		Employee maria = new Employee(new Key(b), "Maria", LocalDate.of(2010, 4, 30), LocalDate.of(2014, 5, 31));
		Employee laura = new Employee(new Key(e), "Laura", LocalDate.of(2010, 12, 31), null);
		Employee esteban = new Employee(new Key(m), "Esteban", LocalDate.of(2010, 5, 11), LocalDate.of(2024, 2, 20));
		Employee pedro = new Employee(new Key(b), "Pedro", LocalDate.of(2009, 8, 16), null);
		Employee yolanda = new Employee(new Key(e), "Yolanda", LocalDate.of(2012, 7, 27), LocalDate.of(2013, 10, 1));
		Employee nuria = new Employee(new Key(b), "Nuria", LocalDate.of(2009, 8, 31), null);

		Employee antonio = new Employee(new Key(m), "Antonio", LocalDate.of(2011, 1, 28), LocalDate.of(2024, 5, 14));
		Employee cpPepe = pepe.copy();
		Employee cpEsteban = esteban.copy();
		Employee cpPedro = pedro.copy();

		addUsuarios(maria, set1, set2, map);
		addUsuarios(pedro, set1, set2, map);
		addUsuarios(nuria, set1, set2, map);
		addUsuarios(pepe, set1, set2, map);
		addUsuarios(laura, set1, set2, map);
		addUsuarios(yolanda, set1, set2, map);
		addUsuarios(esteban, set1, set2, map);
		addUsuarios(juan, set1, set2, map);
		addUsuarios(antonio, set1, set2, map);
		addUsuarios(cpPepe, set1, set2, map);
		addUsuarios(cpEsteban, set1, set2, map);
		addUsuarios(cpPedro, set1, set2, map);

	}

	public void addUsuarios(Employee e, Set<Employee> set1, Set<Employee> set2, Map<String, Employee> map) {
		set1.add(e);
		set2.add(e);
		map.put(e.getKey().toString(), e);
	}

	public void main() {
		Set<Employee> arbol1, arbol2;
		Map<String, Employee> arbol3;
		arbol1 = defaultSet();
		arbol2 = alphabeticalOrder();
		arbol3 = categoryNumber();

		introducirUsuarios(arbol1, arbol2, arbol3);
		System.out.printf("Arbol1 :\n %s", arbol1.toString());
		System.out.printf("Arbol2 :\n %s", arbol2.toString());
		System.out.printf("Arbol3 : \n %s", arbol3.toString());
	}

	public static void main(String[] args) {
		new Trees().main();
	}

}
