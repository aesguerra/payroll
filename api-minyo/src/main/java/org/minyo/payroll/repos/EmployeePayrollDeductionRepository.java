package org.minyo.payroll.repos;

import org.minyo.payroll.entities.EmployeePayrollDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="employee payroll deductions", path="employeepayrolldeductions")
public interface EmployeePayrollDeductionRepository extends
		JpaRepository<EmployeePayrollDeduction, Long> {

}
