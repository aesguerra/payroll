package org.minyo.payroll.entities;

import javax.persistence.*;

import org.minyo.payroll.references.Compensation;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tbl_employee_compensations")
public class EmployeeCompensation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="employee_compensation_id")
	private long id;
	
	@OneToOne(targetEntity=Employee.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	
	@ManyToOne(targetEntity=Compensation.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="compensation_id")
	private Compensation compensation;
	
	
	/**
	 * if hourly rate
	 */
	@Column(name="hourly_rate")
	private float hourlyRate;
	
	/**
	 * if daily rate
	 */
	@Column(name="daily_rate")
	private float dailyRate;
	
	
	/**
	 * fixed amount
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
	 * @return the hourlyRate
	 */
	public float getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * @return the dailyRate
	 */
	public float getDailyRate() {
		return dailyRate;
	}

	/**
	 * @param dailyRate the dailyRate to set
	 */
	public void setDailyRate(float dailyRate) {
		this.dailyRate = dailyRate;
	}
	
}
