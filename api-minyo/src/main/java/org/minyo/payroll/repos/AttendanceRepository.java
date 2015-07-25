package org.minyo.payroll.repos;

import java.sql.Date;
import java.util.List;

import org.minyo.payroll.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
//@RepositoryRestResource(exported = false)
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

	@Query("SELECT a FROM Attendance a WHERE a.timeIn BETWEEN ?1 AND ?2 ORDER BY a.employee.id, a.timeIn")
	public List<Attendance> getAttendanceByDateRange(Date start, Date end);
}
