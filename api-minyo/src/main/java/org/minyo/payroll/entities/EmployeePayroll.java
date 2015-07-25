package org.minyo.payroll.entities;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_employee_payroll")
public class EmployeePayroll {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="employee_payroll_id")
	private long id;
	

	@ManyToOne(targetEntity=Payroll.class, fetch=FetchType.LAZY)
	@JoinColumn(name="payroll_id")
	private Payroll payroll;
	
	@OneToOne(targetEntity=Employee.class, fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	
	@OneToMany(mappedBy="payroll", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<EmployeePayrollDeduction> deductions;

	@OneToMany(mappedBy="payroll", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<EmployeePayrollCompensation> compensations;

	
	@Column(name="hours_logged_ms")
	private long hoursLogged;
	
	@Column(name="workings_hours_logged_ms")
	private long workingHoursLogged;
	
	@Column(name="days_logged")
	private int daysLogged;
	
	@Column(name="working_days_logged")
	private int workingDaysLogged;
	
	@Column(name="awol")
	private int awol;
	
	@Column(name="tardiness_frequency")
	private int tardinessFrequency;
	
	@Column(name="tardiness_ms")
	private long tardiness;
	
	@Column(name="over_time_frequency")
	private int overTimeFrequency;
	
	@Column(name="over_time_ms")
	private long overTime;
	
	@Column(name="under_time_frequency")
	private int underTimeFrequency;
	
	@Column(name="under_time_ms;")
	private long underTime;
	
	
	@Column(name="gross_income")
	private float grossIncome;
	
	@Column(name="net_income")
	private float netIncome;
	
	@Column(name="total_deductions")
	private float totalDeductions;
	
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
	@JsonIgnore
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
	 * @return the deductions
	 */
	@JsonIgnore
	public Set<EmployeePayrollDeduction> getDeductions() {
		return deductions;
	}


	/**
	 * @param deductions the deductions to set
	 */
	public void setDeductions(Set<EmployeePayrollDeduction> deductions) {
		this.deductions = deductions;
	}


	/**
	 * @return the compensations
	 */
	@JsonIgnore
	public Set<EmployeePayrollCompensation> getCompensations() {
		return compensations;
	}


	/**
	 * @param compensations the compensations to set
	 */
	public void setCompensations(Set<EmployeePayrollCompensation> compensations) {
		this.compensations = compensations;
	}


	/**
	 * @return the hoursLogged
	 */
	public long getHoursLogged() {
		return hoursLogged;
	}


	/**
	 * @param hoursLogged the hoursLogged to set
	 */
	public void setHoursLogged(long hoursLogged) {
		this.hoursLogged = hoursLogged;
	}


	/**
	 * @return the workingHoursLogged
	 */
	public long getWorkingHoursLogged() {
		return workingHoursLogged;
	}


	/**
	 * @param workingHoursLogged the workingHoursLogged to set
	 */
	public void setWorkingHoursLogged(long workingHoursLogged) {
		this.workingHoursLogged = workingHoursLogged;
	}


	/**
	 * @return the daysLogged
	 */
	public int getDaysLogged() {
		return daysLogged;
	}


	/**
	 * @param daysLogged the daysLogged to set
	 */
	public void setDaysLogged(int daysLogged) {
		this.daysLogged = daysLogged;
	}


	/**
	 * @return the workingDaysLogged
	 */
	public int getWorkingDaysLogged() {
		return workingDaysLogged;
	}


	/**
	 * @param workingDaysLogged the workingDaysLogged to set
	 */
	public void setWorkingDaysLogged(int workingDaysLogged) {
		this.workingDaysLogged = workingDaysLogged;
	}


	/**
	 * @return the awol
	 */
	public int getAwol() {
		return awol;
	}


	/**
	 * @param awol the awol to set
	 */
	public void setAwol(int awol) {
		this.awol = awol;
	}


	/**
	 * @return the tardinessFrequency
	 */
	public int getTardinessFrequency() {
		return tardinessFrequency;
	}


	/**
	 * @param tardinessFrequency the tardinessFrequency to set
	 */
	public void setTardinessFrequency(int tardinessFrequency) {
		this.tardinessFrequency = tardinessFrequency;
	}


	/**
	 * @return the tardiness
	 */
	public long getTardiness() {
		return tardiness;
	}


	/**
	 * @param tardiness the tardiness to set
	 */
	public void setTardiness(long tardiness) {
		this.tardiness = tardiness;
	}


	/**
	 * @return the overTimeFrequency
	 */
	public int getOverTimeFrequency() {
		return overTimeFrequency;
	}


	/**
	 * @param overTimeFrequency the overTimeFrequency to set
	 */
	public void setOverTimeFrequency(int overTimeFrequency) {
		this.overTimeFrequency = overTimeFrequency;
	}


	/**
	 * @return the overTime
	 */
	public long getOverTime() {
		return overTime;
	}


	/**
	 * @param overTime the overTime to set
	 */
	public void setOverTime(long overTime) {
		this.overTime = overTime;
	}


	/**
	 * @return the underTimeFrequency
	 */
	public int getUnderTimeFrequency() {
		return underTimeFrequency;
	}


	/**
	 * @param underTimeFrequency the underTimeFrequency to set
	 */
	public void setUnderTimeFrequency(int underTimeFrequency) {
		this.underTimeFrequency = underTimeFrequency;
	}


	/**
	 * @return the underTime
	 */
	public long getUnderTime() {
		return underTime;
	}


	/**
	 * @param underTime the underTime to set
	 */
	public void setUnderTime(long underTime) {
		this.underTime = underTime;
	}


	/**
	 * @return the grossIncome
	 */
	public float getGrossIncome() {
		return grossIncome;
	}


	/**
	 * @param grossIncome the grossIncome to set
	 */
	public void setGrossIncome(float grossIncome) {
		this.grossIncome = grossIncome;
	}


	/**
	 * @return the netIncome
	 */
	public float getNetIncome() {
		return netIncome;
	}


	/**
	 * @param netIncome the netIncome to set
	 */
	public void setNetIncome(float netIncome) {
		this.netIncome = netIncome;
	}


	/**
	 * @return the totalDeductions
	 */
	public float getTotalDeductions() {
		return totalDeductions;
	}


	/**
	 * @param totalDeductions the totalDeductions to set
	 */
	public void setTotalDeductions(float totalDeductions) {
		this.totalDeductions = totalDeductions;
	}
	
	
}
