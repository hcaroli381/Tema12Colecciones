package ejercicios12Arboles;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employee {
	private Key key;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;

	public Employee(Key key, String name, LocalDate startDate, LocalDate endDate) {
		this.key = key;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	private Employee(Employee employee) {
		employee = new Employee(key, name, startDate, endDate);
	}

	public Employee copy() {
		return new Employee(this);
	}

	private long daysWorked() {
		if (endDate != null) {
			return ChronoUnit.DAYS.between(startDate, endDate);
		} else {
			return ChronoUnit.DAYS.between(startDate, LocalDate.now());
		}
	}

	@Override
	public String toString() {
		return String.format("%s Nombre: %s    Clave: %s  Fecha alta: %s  Fecha baja: %s  Días en la empresa : %d");
	}
}
