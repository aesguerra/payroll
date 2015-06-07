package org.minyo.payroll.repos;

import java.util.List;

import org.minyo.payroll.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="employees", path="employees")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	
	public List<Employee> findByEmployeeNumber(@Param("empno") String employeeNumber);
}
