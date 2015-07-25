package org.minyo.payroll.repos;

import java.util.List;

import org.minyo.payroll.entities.EmployeeDependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="dependents", path="dependents")
public interface EmployeeDependentRepository extends JpaRepository<EmployeeDependent, Long>  {

}
