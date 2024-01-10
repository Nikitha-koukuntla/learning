package com.nikki.learning;


import com.nikki.learning.entity.Employee;
import com.nikki.learning.enums.Role;

import javax.naming.Name;
import java.util.*;

//@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		grouping();
		sorting();
		filtering();




	}

	public static void grouping(){
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "John", Role.HUMAN_RESOURCES));
		employees.add(new Employee(2, "Alice", Role.SOFTWARE_DEVELOPER));
		employees.add(new Employee(3, "Bob", Role.HUMAN_RESOURCES));
		employees.add(new Employee(4, "Charlie", Role.SOFTWARE_DEVELOPER));
		System.out.println(employees);

		// Grouping employees by role manually
		Map<Role, List<Employee>> groupedByRole = new HashMap<>();
		for (int i = 0; i < employees.size() ; i++) {
			Role role = employees.get(i).getRole();

			if (!groupedByRole.containsKey(role)) {
				groupedByRole.put(role, new ArrayList<>());
			}
			groupedByRole.get(role).add(employees.get(i));
		}
		//groupedByRole.put(Role.HUMAN_RESOURCES,new ArrayList<>());
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
			for (Employee employee : employeeList) {
				System.out.println(employee.getId()+"  " + employee.getName());
			}
		});
	}
	public static void sorting() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(3, "Bob", Role.HUMAN_RESOURCES));
		employees.add(new Employee(1, "John", Role.HUMAN_RESOURCES));
		employees.add(new Employee(4, "Charlie", Role.SOFTWARE_DEVELOPER));
		employees.add(new Employee(2, "Alice", Role.SOFTWARE_DEVELOPER));
		int n = employees.size();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				// Compare the IDs and swap if necessary
				if (employees.get(j).id > employees.get(j + 1).id) {
					Employee temp = employees.get(j);
					employees.set(j, employees.get(j + 1));
					employees.set(j + 1, temp);
				}
			}
		}

		// Print the sorted list of employees
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
		public static void filtering () {
			List<Employee> employees = new ArrayList<>();
			List<Employee> filteredEmployee = new ArrayList<>();
			employees.add(new Employee(3, "Bob", Role.HUMAN_RESOURCES));
			employees.add(new Employee(1, "John", Role.HUMAN_RESOURCES));
			employees.add(new Employee(4, "Charlie", Role.SOFTWARE_DEVELOPER));
			employees.add(new Employee(2, "Alice", Role.SOFTWARE_DEVELOPER));
			for (Employee employee : employees) {
				if (employee.getName().startsWith("S")) {
					filteredEmployee.add(employee);
				}
			}

			// Display the filtered employees
			System.out.println("Employees whose names start with 'S':");
			for (Employee employee : filteredEmployee) {
				System.out.println(employee.getName());
			}
		}
	}
