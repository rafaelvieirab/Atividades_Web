package br.ufc.crateus.atividade5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.atividade5.model.Employee;
import br.ufc.crateus.atividade5.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRep;
	
	public Employee addEmployee(Employee employee) {
		return empRep.save(employee);
	}
	
	public Employee getEmployeeById(Integer id) {
		return empRep.findById(id).orElse(null);
	}

	public List<Employee> getEmployers(String office, Integer limit) {
		if(limit == null || limit < 0)
			limit = Integer.MAX_VALUE;
		
		if(office == null || office.length() <= 0) 
			office = "";
		
		return empRep.findTopNByOfficeByOrderAsc(office, limit);
	}
	
	public Employee updateEmployee(Integer id, Employee employee) {
		if(empRep.existsById(id)) {
			Employee newEmp = empRep.save(employee);
			return newEmp;
		}
		return null;
	}
	
	public boolean removeEmployee(Integer id) {
		if(empRep.existsById(id)) {
			empRep.deleteById(id);
			return true;
		}
		return false;
	}
}
