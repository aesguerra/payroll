package org.minyo.payroll.references;

import javax.persistence.*;

@Entity
@Table(name="ref_compensations")
public class Compensation {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="compensation_id")
	private long id;
	
	@Column(name="compensation_name")
	private String compensationName;

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
	 * @return the compensationName
	 */
	public String getCompensationName() {
		return compensationName;
	}

	/**
	 * @param compensationName the compensationName to set
	 */
	public void setCompensationName(String compensationName) {
		this.compensationName = compensationName;
	}
	
}
