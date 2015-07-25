package org.minyo.payroll.repos;

import java.util.List;

import org.minyo.payroll.entities.Employee;
import org.minyo.payroll.entities.EmployeeCompensation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCompensationRepository extends JpaRepository<EmployeeCompensation, Long> {
	
	public List<EmployeeCompensation> findByEmployee(Employee employee);

}
