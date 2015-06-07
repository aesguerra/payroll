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
	

}
