package org.minyo.payroll.repos;


import org.minyo.payroll.references.PayrollType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;



@Repository
@RepositoryRestResource(collectionResourceRel="reference payroll types", path="payroll-types")
public interface PayrollTypeRepository extends JpaRepository<PayrollType, Long>{


	@Query("SELECT o FROM #{#entityName} o " + 
	       " WHERE LOWER(o.name) LIKE LOWER(CONCAT('%', :q, '%')) " +
			"   OR LOWER(o.description) LIKE LOWER(CONCAT('%', :q, '%'))")
	@RestResource(path="by-name-description")
	public Iterable<PayrollType> findBySearchTerm(@Param("q") String searchTerm);
}
