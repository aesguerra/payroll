package org.minyo.payroll.repos;

import java.util.List;

import org.minyo.payroll.entities.Employee;
import org.minyo.payroll.entities.EmployeeDeduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDeductionRepository extends JpaRepository<EmployeeDeduction, Long> {
	
	
	public List<EmployeeDeduction> findByEmployee(Employee employee);

}
