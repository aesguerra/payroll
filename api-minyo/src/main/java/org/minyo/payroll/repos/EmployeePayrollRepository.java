package org.minyo.payroll.repos;

import org.minyo.payroll.entities.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="employee payroll", path="employeepayroll")
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Long> {

}
