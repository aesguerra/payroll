package org.minyo.payroll.entities;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name="tbl_payroll_calendar")
public class PayrollCalendar {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="payroll_calendar_id")
	private long id;
	
	@ManyToOne(targetEntity=Payroll.class, fetch=FetchType.LAZY)
	@JoinColumn(name="payroll_id")
	private Payroll payroll;
	
	@Column(name="payroll_calendar_date")
	private Date calendarDate;
	
	@Column(name="is_working_day")
	private boolean isWorkingDay;

	@Column(name="required_working_hours_ms")
	private long requiredWorkingHours;
	
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
	 * @return the calendarDate
	 */
	public Date getCalendarDate() {
		return calendarDate;
	}

	/**
	 * @param calendarDate the calendarDate to set
	 */
	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}

	/**
	 * @return the isWorkingDay
	 */
	public boolean isWorkingDay() {
		return isWorkingDay;
	}

	/**
	 * @param isWorkingDay the isWorkingDay to set
	 */
	public void setWorkingDay(boolean isWorkingDay) {
		this.isWorkingDay = isWorkingDay;
	}

	/**
	 * @return the requiredWorkingHours
	 */
	public long getRequiredWorkingHours() {
		return requiredWorkingHours;
	}

	/**
	 * @param requiredWorkingHours the requiredWorkingHours to set
	 */
	public void setRequiredWorkingHours(long requiredWorkingHours) {
		this.requiredWorkingHours = requiredWorkingHours;
	}

	
}
