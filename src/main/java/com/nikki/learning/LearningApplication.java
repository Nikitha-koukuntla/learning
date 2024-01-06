package com.nikki.learning;


import com.nikki.learning.entity.Employee;
import com.nikki.learning.enums.Role;

import java.util.*;

//@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "John", Role.HUMAN_RESOURCES));
		employees.add(new Employee(2, "Alice", Role.SOFTWARE_DEVELOPER));
		employees.add(new Employee(3, "Bob", Role.HUMAN_RESOURCES));
		employees.add(new Employee(4, "Charlie", Role.SOFTWARE_DEVELOPER));
		System.out.println(employee);

		// Grouping employees by role manually
		Map<Role, List<Employee>> groupedByRole = new HashMap<>();
		for (int i = 0; i < employees.size() ; i++) {
			Role role = employees.get(i).getRole();

			if (!groupedByRole.containsKey(role)) {
				groupedByRole.put(role, new ArrayList<>());
			}
			groupedByRole.get(role).add(employees.get(i));
		}
//		for (Employee employee : employees) {
//			Role role = employee.getRole();
//			if (!groupedByRole.containsKey(role)) {
//				groupedByRole.put(role, new ArrayList<>());
//			}
//			groupedByRole.get(role).add(employee);
//		}

		// Print the grouped result
		groupedByRole.forEach((role, employeeList) -> {
			System.out.println("Employees in role " + role + ":");
			for (Employee employees : employeeList) {
				System.out.println(employees.getId()+"  " + employees.getName());
			}
		});
		sorting();



		//SpringApplication.run(LearningApplication.class, args);

	}
	public static void sorting(){
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(3, "Bob", UserRole.HUMAN_RESOURCES));
		employees.add(new Employee(1, "John", UserRole.HUMAN_RESOURCES));
		employees.add(new Employee(4, "Charlie", UserRole.SOFTWARE_DEVELOPER));
		employees.add(new Employee(2, "Alice", UserRole.SOFTWARE_DEVELOPER));

		// Sorting employees based on ID
		Collections.sort(employees, (e1, e2) -> Integer.compare(e1.getId(), e2.getId()));

		// Displaying the sorted employees
		for (Employee employee : employees) {
			System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName());
		}
	}
}

class Employee {
	private int id;
	private String name;
	private UserRole role;

	// Constructors, getters, and setters...

	public Employee(int id, String name, UserRole role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public UserRole getRole() {
		return role;
	}
}

enum UserRole {
	HUMAN_RESOURCES,
	SOFTWARE_DEVELOPER
}
		});



		//SpringApplication.run(LearningApplication.class, args);

	}



}
