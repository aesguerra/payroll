package org.minyo.payroll.entities;


import javax.persistence.*;

import org.minyo.payroll.references.Deduction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tbl_employee_deductions")
public class EmployeeDeduction {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="employee_deduction_id")
	private long id;
	
	@OneToOne(targetEntity=Employee.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne(targetEntity=Deduction.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="deduction_id")
	private Deduction deduction;
	
	
	/**
	 * percent from gross income
	 */
	@Column(name="pct_from_gross_income")
	private float pctFromGrossIncome;
	
	/**
	 * for fixed amount
	 */
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
	 * @return the employee
	 */
	@JsonIgnore
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	 * @return the pctFromGrossIncome
	 */
	public float getPctFromGrossIncome() {
		return pctFromGrossIncome;
	}

	/**
	 * @param pctFromGrossIncome the pctFromGrossIncome to set
	 */
	public void setPctFromGrossIncome(float pctFromGrossIncome) {
		this.pctFromGrossIncome = pctFromGrossIncome;
	}
	
}
