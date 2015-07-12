package org.minyo.payroll.repos;

import org.minyo.payroll.references.PayrollType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;



@Repository
@RepositoryRestResource(collectionResourceRel="reference payroll types", path="payroll-types")
public interface PayrollTypeRepository extends JpaRepository<PayrollType, Long>{

}
