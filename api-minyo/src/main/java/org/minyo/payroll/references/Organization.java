package org.minyo.payroll.references;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.minyo.payroll.entities.Employee;


@Entity
@Table(name="ref_organizations")
public class Organization {
	
	@Id
	@Column(name="organization_id")
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	
	@Column(name="organization_name")
	private String name;
	
	
	@Column(name="organization_description")
	private String description;
	
	@ManyToOne(targetEntity=Organization.class)
	@JoinColumn(name="parent_organization_id")
	private Organization parent;
	
	@ManyToOne(targetEntity=Employee.class)
	@JoinColumn(name="manager_employee_id")
	private Employee manager;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the parent
	 */
	public Organization getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Organization parent) {
		this.parent = parent;
	}

	/**
	 * @return the manager
	 */
	public Employee getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	

}
