package org.minyo.payroll.repos;

import org.minyo.payroll.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="employees", path="employees")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@RestResource(path="by-employee-no")
	public Employee findByEmployeeNumberIgnoreCase(@Param("empno") String employeeNumber);
}
