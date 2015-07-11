package org.minyo.payroll.entities;


import javax.persistence.*;

import org.minyo.payroll.references.Compensation;

@Entity
@Table(name="tbl_employee_payroll_compensations")
public class EmployeePayrollCompensation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="employee_payroll_compensation_id")
	private long id;
	
	
	@ManyToOne(targetEntity=EmployeePayroll.class)
	@JoinColumn(name="employee_payroll_id")
	private EmployeePayroll employeePayroll;
	

	@OneToOne(targetEntity=Compensation.class)
	@JoinColumn(name="compensation_id")
	private Compensation compensation;


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
	 * @return the employeePayroll
	 */
	public EmployeePayroll getEmployeePayroll() {
		return employeePayroll;
	}


	/**
	 * @param employeePayroll the employeePayroll to set
	 */
	public void setEmployeePayroll(EmployeePayroll employeePayroll) {
		this.employeePayroll = employeePayroll;
	}


	/**
	 * @return the compensation
	 */
	public Compensation getCompensation() {
		return compensation;
	}


	/**
	 * @param compensation the compensation to set
	 */
	public void setCompensation(Compensation compensation) {
		this.compensation = compensation;
	}
	
}
