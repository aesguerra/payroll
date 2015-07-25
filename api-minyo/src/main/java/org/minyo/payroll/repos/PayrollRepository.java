package org.minyo.payroll.repos;

import org.minyo.payroll.entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="payroll", path="payrolls")
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}
