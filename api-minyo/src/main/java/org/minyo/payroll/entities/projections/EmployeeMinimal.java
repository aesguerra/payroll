package org.minyo.payroll.entities.projections;

import org.minyo.payroll.entities.Employee;
import org.springframework.data.rest.core.config.Projection;


@Projection(types=Employee.class)
public interface EmployeeMinimal {

	public String getEmployeeNumber();
	public long getId();
}
