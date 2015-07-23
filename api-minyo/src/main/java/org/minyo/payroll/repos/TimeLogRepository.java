package org.minyo.payroll.repos;



import org.minyo.payroll.entities.Employee;
import org.minyo.payroll.entities.TimeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="time logging", path="timelogs")
public interface TimeLogRepository extends JpaRepository<TimeLog, Long>{
	
	@Query("select t from TimeLog t where t.employee.id = ?1")
	public TimeLog findByEmployeeId(long employeeId);
}
