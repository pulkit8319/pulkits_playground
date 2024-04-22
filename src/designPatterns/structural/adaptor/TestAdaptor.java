package designPatterns.structural.adaptor;

import java.util.ArrayList;
import java.util.List;

public class TestAdaptor {
	public static void main(String[] args) {

		Employee employeeSimple = new EmployeeSimple("1", "Pulkit", "Srivastava", "SA");
		List<Employee> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(employeeSimple);

		EmployeeLDAP employeeLDAP = new EmployeeLDAP("2", "Jack", "Ryan", "ATL");
		listOfEmployees.add(new EmployeeLdapAdaptor(employeeLDAP));
		
		EmployeeFromDB employeeDB = new EmployeeFromDB(3, "Alok", "Kumar", "Director");
		listOfEmployees.add(new EmployeeDbAdaptor(employeeDB));

		System.out.println(listOfEmployees);
	}
}
