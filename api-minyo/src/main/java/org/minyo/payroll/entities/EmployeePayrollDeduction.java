package org.minyo.payroll.entities;


import javax.persistence.*;

import org.minyo.payroll.references.Deduction;

@Entity
@Table(name="tbl_employee_payroll_deductions")
public class EmployeePayrollDeduction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="employee_payroll_deduction_id")
	private long id;

	@ManyToOne(targetEntity=Employee.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne(targetEntity=Payroll.class, fetch=FetchType.LAZY)
	@JoinColumn(name="payroll_id")
	private Payroll payroll;

	
	@OneToOne(targetEntity=Deduction.class, fetch=FetchType.LAZY)
	@JoinColumn(name="deduction_id")
	private Deduction deduction;

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
	 * @return the deduction
	 */
	public Deduction getDeduction() {
		return deduction;
	}


	/**
	 * @param deduction the deduction to set
	 */
	public void setDeduction(Deduction deduction) {
		this.deduction = deduction;
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
		payroll = payroll;
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
