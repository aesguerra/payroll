package org.minyo.payroll.repos;

import java.util.List;

import org.minyo.payroll.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;



@Repository
@RepositoryRestResource(collectionResourceRel="persons", path="persons")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	
	public List<Person> findByLastName(@Param("name") String name);
	public List<Person> findByFirstName(@Param("name") String name);
	public List<Person> findByMiddleName(@Param("name") String name);
	
	
	@Query("SELECT p FROM Person p " +
		   " WHERE LOWER(p.firstName) LIKE LOWER(CONCAT('%',:searchTerm,'%')) " +
			"   OR LOWER(p.lastName) LIKE LOWER(CONCAT('%',:searchTerm,'%')) " +
			"   OR LOWER(p.middleName) LIKE LOWER(CONCAT('%',:searchTerm,'%')) ")
	@RestResource(path="by-name")
	public List<Person> findByNameIgnoreCase(@Param("searchTerm") String searchTerm);
	 
}
