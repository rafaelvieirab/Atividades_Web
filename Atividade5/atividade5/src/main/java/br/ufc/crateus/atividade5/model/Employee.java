package br.ufc.crateus.atividade5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "employers")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String office;
	private String birthDate;
	private String entryDate;
	
	public Employee(String name, String office, String birthDate, String entryDate) {
		this.name = name;
		this.office = office;
		this.birthDate = birthDate;
		this.entryDate = entryDate;
	}
	
	public Employee() {
	}
	
	public Employee(int id, String name, String office, String birthDate, String entryDate) {
		this.id = id;
		this.name = name;
		this.office = office;
		this.birthDate = birthDate;
		this.entryDate = entryDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", office=" + office + ", birthDate=" + birthDate
				+ ", entryDate=" + entryDate + "]";
	}
	
}
