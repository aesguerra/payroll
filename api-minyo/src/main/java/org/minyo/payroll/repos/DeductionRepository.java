package org.minyo.payroll.repos;


import org.minyo.payroll.references.Deduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(collectionResourceRel="reference deductions",path="deductions")
public interface DeductionRepository extends JpaRepository<Deduction, Long> {

		@Query("SELECT o FROM #{#entityName} o " + 
		       " WHERE LOWER(o.name) LIKE LOWER(CONCAT('%', :q, '%')) " +
				"   OR LOWER(o.provider) LIKE LOWER(CONCAT('%', :q, '%'))")
		@RestResource(path="by-name-provider")
		public Iterable<Deduction> findBySearchTerm(@Param("q") String searchTerm);
}
