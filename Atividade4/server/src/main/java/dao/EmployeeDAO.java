package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Employee;

public class EmployeeDAO {
	
	private static Map<Integer,Employee> employeeMap = new HashMap<Integer, Employee>();
	private static int nextId;
	
	static {
		initEmployees();
	}

	private static void initEmployees() {
		Employee emp1 = new Employee(0, "Rafael", "Estudante", "2000-08-29", "2017-03-03");
		Employee emp2 = new Employee(0, "Natan", "Funcionário", "2000-08-29", "2017-03-03");
		Employee emp3 = new Employee(0, "Romeu", "Gerente", "2000-08-29", "2017-03-03");

		employeeMap.put(emp1.getId(), emp1);
		employeeMap.put(emp2.getId(), emp2);
		employeeMap.put(emp3.getId(), emp3);
	}

	public static Employee getEmployee(int id) {
		return employeeMap.get(id);
	}

	public static List<Employee> getNEmployees(int numberEmployees) {
		if(numberEmployees >= 0)
			return getAllEmployees().subList(0, numberEmployees);
		return null;
	}
	
	public static Employee getEmployeeByOffice(String office) {
		List<Employee> list = getAllEmployees(); 
		
		for(Employee emp : list)
			if(emp.getOffice().equals(office))
				return emp;
		
		return null;
	}

	public static List<Employee> getEmployeeByOffice2(String office) {
		List<Employee> list = getAllEmployees(); 
		List<Employee> response = new LinkedList<Employee>();
		
		for(Employee emp : list)
			if(emp.getOffice().equals(office))
				response.add(emp);
		
		return response;
	}
	
	public static Employee addEmployee(String name, String office, String birthDate, String entryDate) {
		Employee emp = new Employee(nextId, name, office, birthDate, entryDate);
		employeeMap.put(emp.getId(), emp);
		nextId++;
		return emp;
	}

	public static Employee updateEmployee(int id, String name, String office, String birthDate, String entryDate) {
		Employee emp = new Employee(id, name, office, birthDate, entryDate);
		employeeMap.put(emp.getId(), emp);
		return emp;
	}

	public static void deleteEmployee(int id) {
		if(employeeMap.containsKey(id))
			employeeMap.remove(id);
	}

	public static List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(employeeMap.values());
	}
	
}
