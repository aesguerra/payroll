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
	private String deductionName;
	
	@Column(name="provider_name")
	private String providerName;
	
}
