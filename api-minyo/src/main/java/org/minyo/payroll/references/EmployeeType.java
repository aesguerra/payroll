package org.minyo.payroll.references;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ref_employee_types")
public class EmployeeType {


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "employee_type_id")
	private long id;
	
	
	@Column(name = "employee_type_name")
	private String employeeTypeName;
	
	@Column(name = "employee_type_description")
	private String employeeTypeDescription;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the employeeTypeName
	 */
	public String getEmployeeTypeName() {
		return employeeTypeName;
	}

	/**
	 * @param employeeTypeName the employeeTypeName to set
	 */
	public void setEmployeeTypeName(String employeeTypeName) {
		this.employeeTypeName = employeeTypeName;
	}

	/**
	 * @return the employeeTypeDescription
	 */
	public String getEmployeeTypeDescription() {
		return employeeTypeDescription;
	}

	/**
	 * @param employeeTypeDescription the employeeTypeDescription to set
	 */
	public void setEmployeeTypeDescription(String employeeTypeDescription) {
		this.employeeTypeDescription = employeeTypeDescription;
	}
	
	
	
	
}
