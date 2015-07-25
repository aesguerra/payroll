package org.minyo.payroll.repos;

import org.minyo.payroll.entities.EmployeePayrollCompensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="employee payroll compensations", path="employeepayrollcompensations")
public interface EmployeePayrollCompensationRepository extends
		JpaRepository<EmployeePayrollCompensation, Long> {

}
