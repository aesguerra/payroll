package org.minyo.payroll.repos;


import org.minyo.payroll.references.EmployeeType;
import org.minyo.payroll.references.EmploymentStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "employee-types", path = "employee-types")
public interface EmployeeTypeRepository extends CrudRepository<EmployeeType, Long>{

}
