package org.minyo.payroll.entities;

import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="attendance_id")
	private long id;
	
	@ManyToOne(targetEntity=Employee.class, fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@Column(name="time_in", columnDefinition="timestamp")
	private Timestamp timeIn;

	@Column(name="time_out", columnDefinition="timestamp")
	private Timestamp timeOut;

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
	 * @return the timeIn
	 */
	public Timestamp getTimeIn() {
		return timeIn;
	}

	/**
	 * @param timeIn the timeIn to set
	 */
	public void setTimeIn(Timestamp timeIn) {
		this.timeIn = timeIn;
	}

	/**
	 * @return the timeOut
	 */
	public Timestamp getTimeOut() {
		return timeOut;
	}

	/**
	 * @param timeOut the timeOut to set
	 */
	public void setTimeOut(Timestamp timeOut) {
		this.timeOut = timeOut;
	}
	
}
