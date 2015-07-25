package org.minyo.payroll.repos;

import java.util.*;

import org.minyo.payroll.references.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RepositoryRestResource(collectionResourceRel="reference compensations", path="compensations")
public interface CompensationRepository extends JpaRepository<Compensation, Long> {

	@RestResource(path="by-name-description")
	public Iterable<Compensation> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
}
