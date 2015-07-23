package org.minyo.payroll.repos;

import org.minyo.payroll.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="employees", path="employees")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	public Employee findByEmployeeNumber(@Param("empno") String employeeNumber);
	//public EmployeeMinimal findByEmployeeNumber(@Param("empno") String employeeNumber);
}
