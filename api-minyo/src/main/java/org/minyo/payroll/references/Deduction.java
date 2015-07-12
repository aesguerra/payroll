package org.minyo.payroll.references;

import javax.persistence.*;


@Entity
@Table(name="ref_deductions")
public class Deduction {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="deduction_id")
	private long id;
	
	
	@Column(name="is_voluntary", nullable=false)
	private boolean isVoluntary;
	
	@Column(name="deduction_name")
	private String name;
	
	@Column(name="provider")
	private String provider;

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
	 * @return the isVoluntary
	 */
	public boolean isVoluntary() {
		return isVoluntary;
	}

	/**
	 * @param isVoluntary the isVoluntary to set
	 */
	public void setVoluntary(boolean isVoluntary) {
		this.isVoluntary = isVoluntary;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
}
