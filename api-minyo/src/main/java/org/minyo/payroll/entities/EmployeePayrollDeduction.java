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

	@Column(name="amount")
	private Double amount;
	
	@ManyToOne(targetEntity=EmployeePayroll.class)
	@JoinColumn(name="employee_payroll_id")
	private EmployeePayroll employeePayroll;

	
	@OneToOne(targetEntity=Deduction.class)
	@JoinColumn(name="deduction_id")
	private Deduction deduction;


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
	public Double getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
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
}
