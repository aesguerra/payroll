package org.minyo.payroll.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.minyo.payroll.entities.Attendance;
import org.minyo.payroll.entities.Employee;
import org.minyo.payroll.entities.EmployeePayroll;
import org.minyo.payroll.entities.Payroll;
import org.minyo.payroll.entities.PayrollCalendar;
import org.minyo.payroll.repos.*;
//import org.minyo.payroll.repos.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestController
public class EmployeePayrollController {

	final private EmployeePayrollRepository employeePayrollRepository;
	final private AttendanceRepository attendanceRepository;
	final private PayrollRepository payrollRepository;
	final private EmployeePayrollCompensationRepository employeePayrollCompensationRepository;
	final private EmployeePayrollDeductionRepository employeePayrollDeductionRepository;
	final private PayrollCalendarRepository payrollCalendarRepository;

	@Autowired
	public EmployeePayrollController(
			EmployeePayrollRepository employeePayrollRepository,
			AttendanceRepository attendanceRepository,
			PayrollRepository payrollRepository,
			EmployeePayrollCompensationRepository employeePayrollCompensationRepository,
			EmployeePayrollDeductionRepository employeePayrollDeductionRepository,
			PayrollCalendarRepository payrollCalendarRepository) {
		this.employeePayrollRepository = employeePayrollRepository;
		this.attendanceRepository = attendanceRepository;
		this.payrollRepository = payrollRepository;
		this.employeePayrollCompensationRepository = employeePayrollCompensationRepository;
		this.employeePayrollDeductionRepository = employeePayrollDeductionRepository;
		this.payrollCalendarRepository = payrollCalendarRepository;
	}

	@RequestMapping(method=RequestMethod.POST, value="/employeepayroll/draft")
	public void generate(@RequestBody Payroll payroll) {
	
		Map<Date, PayrollCalendar> calendar = new HashMap<Date, PayrollCalendar>(); 
		
		for(PayrollCalendar payrollCalendar : payrollCalendarRepository.findByPayroll(payroll)) {
			calendar.put(payrollCalendar.getCalendarDate(), payrollCalendar);
		}
		
		Employee currentEmployee = null;
		EmployeePayroll employeePayroll = null;
		List<EmployeePayroll> employeePayrollList = new ArrayList<EmployeePayroll>();
		
		long hoursLogged = 0;
		long workingHoursLogged = 0;
		long overTime = 0;
		long underTime = 0;
		
		for(Attendance attendance : attendanceRepository.getAttendanceByDateRange(payroll.getStartDate(), payroll.getEndDate())) {
			Employee employee = attendance.getEmployee();
			if(employeePayroll != null && currentEmployee != employee) {
				// persist values
				employeePayroll.setHoursLogged(hoursLogged);
				employeePayroll.setWorkingHoursLogged(workingHoursLogged);
				employeePayroll.setOverTime(overTime);
				employeePayroll.setUnderTime(underTime);
				
				// save and flush
				employeePayrollList.add(employeePayroll);
				
				// set current to null
				currentEmployee = null;
			}
			
			if(currentEmployee == null) {
				currentEmployee = employee;
				employeePayroll = new EmployeePayroll();
				employeePayroll.setEmployee(attendance.getEmployee());
				employeePayroll.setPayroll(payroll);
				
				
				hoursLogged = 0;
				workingHoursLogged = 0;
				overTime = 0;
				underTime = 0;
			}
			
			PayrollCalendar payrollCalendar = calendar.get(new Date(attendance.getTimeIn().getTime()));
			long logged = (attendance.getTimeOut().getTime() - attendance.getTimeIn().getTime());
			
			// get hours_logged
			hoursLogged += logged;
			
			// get working hours logged
			if(payrollCalendar.isWorkingDay()) {
				workingHoursLogged += logged;
				long requiredWorkingHours = payrollCalendar.getRequiredWorkingHours();
				
				// get over time
				overTime += (logged - requiredWorkingHours > 0 ? logged - requiredWorkingHours : 0);
				
				// get under time
				underTime += (requiredWorkingHours - logged > 0 ? requiredWorkingHours - logged: 0);
			}
			else {
				overTime += logged;
			}
			
		}
		
		employeePayrollRepository.save(employeePayrollList);
		
	}
	
}
