package org.minyo.payroll.repos;

import org.minyo.payroll.references.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "reference organizations", path = "organizations")
public interface OrganizationRepository extends
		JpaRepository<Organization, Integer> {

}