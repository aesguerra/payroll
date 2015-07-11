package org.minyo.payroll.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="tbl_payroll_current")
public class PayrollCurrent {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="payroll_id")
	private long id;
	
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private Set<EmployeePayroll> employees;

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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the employees
	 */
	public Set<EmployeePayroll> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Set<EmployeePayroll> employees) {
		this.employees = employees;
	}
}
