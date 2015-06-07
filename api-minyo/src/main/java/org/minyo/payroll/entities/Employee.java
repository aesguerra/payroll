package org.minyo.payroll.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.minyo.payroll.references.EmploymentStatus;


@Entity
@Table(name="tbl_employees")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "employee_id")
	private long id;

	@OneToOne(optional=false)
	@JoinColumn(name="person_id")
	private Person person;
	
	@Column(name = "employee_number")
	private String employeeNumber;
	
	
	@Column(name="pagibig_reference_number",nullable=true)
	private String pagibig;
	
	
	@Column(name="philheatlh_reference_number",nullable=true)
	private String philhealth;
	
	@Column(name="social_security_number",nullable=true)
	private String SSS;
	
	
	@Column(name="tax_identification_number",nullable=true)
	private String TIN;
	
	@Column(name="tax_exemption_status",nullable=true)
	private String taxExemptionStatus;

	@Column(name="date_hired",nullable=true)
	private Date dateHired;
	
	
	@OneToOne
	@JoinColumn(name="employment_status_id",nullable=true)
	private EmploymentStatus employmentStatus;
	
	@ManyToOne(targetEntity=Employee.class)
	@JoinColumn(name="manager_employee_id", nullable=true)
	private Employee manager;
	
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
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the employeeNumber
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * @return the pagibig
	 */
	public String getPagibig() {
		return pagibig;
	}

	/**
	 * @param pagibig the pagibig to set
	 */
	public void setPagibig(String pagibig) {
		this.pagibig = pagibig;
	}

	/**
	 * @return the philhealth
	 */
	public String getPhilhealth() {
		return philhealth;
	}

	/**
	 * @param philhealth the philhealth to set
	 */
	public void setPhilhealth(String philhealth) {
		this.philhealth = philhealth;
	}

	/**
	 * @return the sSS
	 */
	public String getSSS() {
		return SSS;
	}

	/**
	 * @param sSS the sSS to set
	 */
	public void setSSS(String sSS) {
		SSS = sSS;
	}

	/**
	 * @return the tIN
	 */
	public String getTIN() {
		return TIN;
	}

	/**
	 * @param tIN the tIN to set
	 */
	public void setTIN(String tIN) {
		TIN = tIN;
	}

	/**
	 * @return the taxExemptionStatus
	 */
	public String getTaxExemptionStatus() {
		return taxExemptionStatus;
	}

	/**
	 * @param taxExemptionStatus the taxExemptionStatus to set
	 */
	public void setTaxExemptionStatus(String taxExemptionStatus) {
		this.taxExemptionStatus = taxExemptionStatus;
	}
	
	
	
}
