package org.minyo.payroll.repos;

import org.minyo.payroll.references.EmploymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "reference employment status", path = "employment-status")
public interface EmploymentStatusRepository extends
		JpaRepository<EmploymentStatus, Integer> {

}
