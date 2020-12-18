package br.ufc.crateus.atividade5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufc.crateus.atividade5.model.Employee;
import br.ufc.crateus.atividade5.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api/employers")
public class EmployeeController {
	
	@Autowired
	EmployeeService empServ;

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployers(
			@RequestParam(name= "office", required = false) String office,
			@RequestParam(name = "limit", required = false) Integer limit 
	) {
		return  new ResponseEntity<List<Employee>>(empServ.getEmployers(office, limit), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") Integer id) {
			Employee emp = empServ.getEmployeeById(id);
			
			if(emp != null)
				return new ResponseEntity<Employee>(emp, HttpStatus.OK);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(empServ.addEmployee(employee),HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		Employee updateEmp = empServ.updateEmployee(id, employee);
		
		if(updateEmp != null)
			return new ResponseEntity<Employee>(updateEmp, HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
		if(empServ.removeEmployee(id))
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
}
