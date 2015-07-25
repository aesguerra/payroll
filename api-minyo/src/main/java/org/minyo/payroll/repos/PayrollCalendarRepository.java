package org.minyo.payroll.repos;

import java.util.List;

import org.minyo.payroll.entities.Payroll;
import org.minyo.payroll.entities.PayrollCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollCalendarRepository extends JpaRepository<PayrollCalendar, Long> {

	public List<PayrollCalendar> findByPayroll(Payroll payroll);
}
