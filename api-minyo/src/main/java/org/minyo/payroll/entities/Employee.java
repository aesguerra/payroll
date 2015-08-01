package org.minyo.payroll.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.minyo.payroll.references.EmployeeType;
import org.minyo.payroll.references.EmploymentStatus;
import org.minyo.payroll.references.Organization;


@Entity
@Table(name="tbl_employees")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "employee_id")
	private long id;

	@OneToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	
	@Column(name = "employee_number")
	private String employeeNumber;
	
	
	@Column(name="pagibig_reference_number",nullable=true)
	private String pagibig;
	
	
	@Column(name="philheatlh_reference_number",nullable=true)
	private String philhealth;
	
	@Column(name="social_security_number",nullable=true)
	private String socialSecurityNumber;
	
	
	@Column(name="tax_identification_number",nullable=true)
	private String taxIdentificationNumber;
	
	@Column(name="tax_exemption_status",nullable=true)
	private String taxExemptionStatus;

	@Column(name="date_hired",nullable=true)
	private Date dateHired;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employment_status_id",nullable=true)
	private EmploymentStatus employmentStatus;
	
	@ManyToOne(targetEntity=Employee.class)
	@JoinColumn(name="manager_employee_id", nullable=true)
	private Employee manager;
	
	@ManyToOne(targetEntity=Organization.class)
	@JoinColumn(name="organization_id", nullable=true)
	private Organization organization;
	
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private Set<EmployeeDependent> dependents;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_type_id",nullable=true)
	private EmployeeType employeeType;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<TimeLog> timeLogs;
	
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

	/**
	 * @return the dateHired
	 */
	public Date getDateHired() {
		return dateHired;
	}

	/**
	 * @param dateHired the dateHired to set
	 */
	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	/**
	 * @return the employmentStatus
	 */
	public EmploymentStatus getEmploymentStatus() {
		return employmentStatus;
	}

	/**
	 * @param employmentStatus the employmentStatus to set
	 */
	public void setEmploymentStatus(EmploymentStatus employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	/**
	 * @return the manager
	 */
	public Employee getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * @return the dependents
	 */
	public Set<EmployeeDependent> getDependents() {
		return dependents;
	}

	/**
	 * @param dependents the dependents to set
	 */
	public void setDependents(Set<EmployeeDependent> dependents) {
		this.dependents = dependents;
	}

	/**
	 * @return the employeeType
	 */
	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	/**
	 * @param employeeType the employeeType to set
	 */
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	/**
	 * @return the socialSecurityNumber
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * @param socialSecurityNumber the socialSecurityNumber to set
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	/**
	 * @return the taxIdentificationNumber
	 */
	public String getTaxIdentificationNumber() {
		return taxIdentificationNumber;
	}

	/**
	 * @param taxIdentificationNumber the taxIdentificationNumber to set
	 */
	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		this.taxIdentificationNumber = taxIdentificationNumber;
	}

	/**
	 * @return the timeLogs
	 */
	public Set<TimeLog> getTimeLogs() {
		return timeLogs;
	}

	/**
	 * @param timeLogs the timeLogs to set
	 */
	public void setTimeLogs(Set<TimeLog> timeLogs) {
		this.timeLogs = timeLogs;
	}
	
	
	
}
