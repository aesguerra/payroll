package org.minyo.payroll.repos;

import java.util.List;

import org.minyo.payroll.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@Repository
@RepositoryRestResource(collectionResourceRel="persons", path="persons")
public interface PersonRepository extends CrudRepository<Person, Long>{
	
	public List<Person> findByLastName(@Param("name") String name);
	public List<Person> findByFirstName(@Param("name") String name);
	public List<Person> findByMiddleName(@Param("name") String name);

}
