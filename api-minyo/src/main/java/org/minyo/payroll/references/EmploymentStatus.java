package org.minyo.payroll.references;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ref_employment_status")
public class EmploymentStatus {
	
	@Id
	@Column(name="employment_status_id")
	@GeneratedValue
	private int id;
	
	@Column(name="employment_status_name")
	private String employmentStatusName;
	
	@Column(name="employment_status_description")
	private String employmentStatusDescription;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the employmentStatusName
	 */
	public String getEmploymentStatusName() {
		return employmentStatusName;
	}

	/**
	 * @param employmentStatusName the employmentStatusName to set
	 */
	public void setEmploymentStatusName(String employmentStatusName) {
		this.employmentStatusName = employmentStatusName;
	}

	/**
	 * @return the employmentStatusDescription
	 */
	public String getEmploymentStatusDescription() {
		return employmentStatusDescription;
	}

	/**
	 * @param employmentStatusDescription the employmentStatusDescription to set
	 */
	public void setEmploymentStatusDescription(String employmentStatusDescription) {
		this.employmentStatusDescription = employmentStatusDescription;
	}
	
	
	
	

}
