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
	
	@ManyToOne(targetEntity=Employee.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	
	@ManyToOne(targetEntity=Payroll.class, fetch=FetchType.LAZY)
	@JoinColumn(name="payroll_id")
	private Payroll payroll;
	

	@OneToOne(targetEntity=Compensation.class)
	@JoinColumn(name="compensation_id")
	private Compensation compensation;


	@Column(name="amount")
	private float amount;
	
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


	/**
	 * @return the payroll
	 */
	public Payroll getPayroll() {
		return payroll;
	}


	/**
	 * @param payroll the payroll to set
	 */
	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}


	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}


	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}


	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
