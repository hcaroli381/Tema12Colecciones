package ejercicios12Arboles;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employee implements Comparable<Employee> {
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
		this.key = employee.key;
		this.name = employee.name;
		this.startDate = employee.startDate;
		this.endDate = employee.endDate;
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
		if (endDate != null) {
			return String.format(
					"%s Nombre: %s    Clave: %s  Fecha alta: %s  Fecha baja: %s  Días en la empresa : %d\n",
					key.getCategory(), name, key.toString(), startDate, endDate, daysWorked());
		} else {
			return String.format(
					"%s Nombre: %s    Clave: %s  Fecha alta: %s  Fecha baja: no tiene  Días en la empresa : %d\n",
					key.getCategory(), name, key.toString(), startDate, daysWorked());
		}

	}

	public Key getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	@Override
	public int compareTo(Employee employee) {
		int diffDays;
		diffDays = Long.compare(employee.daysWorked(), this.daysWorked());
		if (diffDays == 0) {
			return employee.name.compareTo(name);
		}
		return diffDays;
	}
}
