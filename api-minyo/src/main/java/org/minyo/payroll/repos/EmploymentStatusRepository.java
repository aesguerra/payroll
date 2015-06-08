package org.minyo.payroll.repos;

import org.minyo.payroll.references.EmploymentStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "employment-status", path = "employment-status")
public interface EmploymentStatusRepository extends
		CrudRepository<EmploymentStatus, Integer> {

}
