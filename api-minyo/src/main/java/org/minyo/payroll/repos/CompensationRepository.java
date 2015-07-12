package org.minyo.payroll.repos;

import org.minyo.payroll.references.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="reference compensations", path="compensations")
public interface CompensationRepository extends JpaRepository<Compensation, Long> {

}
