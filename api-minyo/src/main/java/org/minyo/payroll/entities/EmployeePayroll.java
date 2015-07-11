package org.minyo.payroll.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="tbl_employee_payroll")
public class EmployeePayroll {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="employee_payroll_id")
	private long id;
	

	@ManyToOne(targetEntity=PayrollCurrent.class)
	@JoinColumn(name="payroll_id")
	private PayrollCurrent payroll;
	
	@OneToOne(targetEntity=Employee.class)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	
	@OneToMany(mappedBy="employeePayroll", cascade=CascadeType.ALL)
	private Set<EmployeePayrollDeduction> deductions;

	@OneToMany(mappedBy="employeePayroll", cascade=CascadeType.ALL)
	private Set<EmployeePayrollCompensation> compensations;

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
	 * @return the payroll
	 */
	public PayrollCurrent getPayroll() {
		return payroll;
	}


	/**
	 * @param payroll the payroll to set
	 */
	public void setPayroll(PayrollCurrent payroll) {
		this.payroll = payroll;
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


	/**
	 * @return the deductions
	 */
	public Set<EmployeePayrollDeduction> getDeductions() {
		return deductions;
	}


	/**
	 * @param deductions the deductions to set
	 */
	public void setDeductions(Set<EmployeePayrollDeduction> deductions) {
		this.deductions = deductions;
	}
	
	
}
