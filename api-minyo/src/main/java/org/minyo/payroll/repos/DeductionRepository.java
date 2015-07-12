package org.minyo.payroll.repos;

import org.minyo.payroll.references.Deduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(collectionResourceRel="reference deductions",path="deductions")
public interface DeductionRepository extends JpaRepository<Deduction, Long> {

}
