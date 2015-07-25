package org.minyo.payroll.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.minyo.payroll.entities.Attendance;
import org.minyo.payroll.entities.Employee;
import org.minyo.payroll.entities.EmployeeCompensation;
import org.minyo.payroll.entities.EmployeeDeduction;
import org.minyo.payroll.entities.EmployeePayroll;
import org.minyo.payroll.entities.EmployeePayrollCompensation;
import org.minyo.payroll.entities.EmployeePayrollDeduction;
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

	final private static long MILLIS_TO_HOUR = 1000 * 60 * 60;
	
	final private EmployeePayrollRepository employeePayrollRepository;
	final private AttendanceRepository attendanceRepository;
	final private PayrollRepository payrollRepository;
	final private EmployeePayrollCompensationRepository employeePayrollCompensationRepository;
	final private EmployeePayrollDeductionRepository employeePayrollDeductionRepository;
	final private PayrollCalendarRepository payrollCalendarRepository;
	final private EmployeeCompensationRepository employeeCompensationRepository;
	final private EmployeeDeductionRepository employeeDeductionRepository;

	@Autowired
	public EmployeePayrollController(
			EmployeePayrollRepository employeePayrollRepository,
			AttendanceRepository attendanceRepository,
			PayrollRepository payrollRepository,
			EmployeePayrollCompensationRepository employeePayrollCompensationRepository,
			EmployeePayrollDeductionRepository employeePayrollDeductionRepository,
			PayrollCalendarRepository payrollCalendarRepository,
			EmployeeCompensationRepository employeeCompensationRepository,
			EmployeeDeductionRepository employeeDeductionRepository) {
		this.employeePayrollRepository = employeePayrollRepository;
		this.attendanceRepository = attendanceRepository;
		this.payrollRepository = payrollRepository;
		this.employeePayrollCompensationRepository = employeePayrollCompensationRepository;
		this.employeePayrollDeductionRepository = employeePayrollDeductionRepository;
		this.payrollCalendarRepository = payrollCalendarRepository;
		this.employeeCompensationRepository = employeeCompensationRepository;
		this.employeeDeductionRepository = employeeDeductionRepository;
	}

	@RequestMapping(method=RequestMethod.POST, value="/employeepayroll/draft")
	public void generate(@RequestBody Payroll payroll) {
	
		Map<Date, PayrollCalendar> calendar = new HashMap<Date, PayrollCalendar>(); 
		Map<Date, Boolean> employeeCalendar = new HashMap<Date, Boolean>();
		final Boolean FALSE = new Boolean(false);
		final Boolean TRUE = new Boolean(true);
		
		for(PayrollCalendar payrollCalendar : payrollCalendarRepository.findByPayroll(payroll)) {
			calendar.put(payrollCalendar.getCalendarDate(), payrollCalendar);
			if(payrollCalendar.isWorkingDay()) {
				employeeCalendar.put(payrollCalendar.getCalendarDate(), FALSE);
			}
		}
		
		Employee currentEmployee = null;
		EmployeePayroll employeePayroll = null;
		List<EmployeePayroll> employeePayrollList = new ArrayList<EmployeePayroll>();
		List<EmployeePayrollCompensation> employeePayrollCompensationList = new ArrayList<EmployeePayrollCompensation>();
		List<EmployeePayrollDeduction> employeePayrollDeductionList = new ArrayList<EmployeePayrollDeduction>();
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
				int awol = 0;
				int workingDaysLogged = 0;
				for(Map.Entry<Date, Boolean> entry : employeeCalendar.entrySet()) {
					if(!entry.getValue()) {
						awol++;
					} else {
						workingDaysLogged++;
					}
					employeeCalendar.put(entry.getKey(), FALSE);
				}
				employeePayroll.setAwol(awol);
				employeePayroll.setWorkingDaysLogged(workingDaysLogged);
			
			
				// compute for gross income
				float grossIncome = 0;
				for(EmployeeCompensation employeeCompensation : employeeCompensationRepository.findByEmployee(currentEmployee)) {
					float amount = 0;
					if(employeeCompensation.getAmount() != 0) {
						amount = employeeCompensation.getAmount();
					}
					else if(employeeCompensation.getHourlyRate() != 0) {
						amount = (employeeCompensation.getAmount() * (employeePayroll.getHoursLogged() / this.MILLIS_TO_HOUR));
					}
					else if(employeeCompensation.getDailyRate() != 0) {
						amount = (employeeCompensation.getDailyRate() * employeePayroll.getDaysLogged());
					}
					else {
						// nothing to do here
						continue;
					}
					
					EmployeePayrollCompensation employeePayrollCompensation = new EmployeePayrollCompensation();
					employeePayrollCompensation.setPayroll(payroll);
					employeePayrollCompensation.setEmployee(currentEmployee);
					employeePayrollCompensation.setCompensation(employeeCompensation.getCompensation());
					employeePayrollCompensation.setAmount(amount);
					grossIncome += amount;
					employeePayrollCompensationList.add(employeePayrollCompensation);
				}
				// set gross income
				employeePayroll.setGrossIncome(grossIncome);
				
				// compute for the deductions
				float totalDeductions = 0;
				for(EmployeeDeduction employeeDeduction : employeeDeductionRepository.findByEmployee(currentEmployee)) {
					float amount = 0;
					
					if(employeeDeduction.getPctFromGrossIncome() != 0) {
						amount = grossIncome * employeeDeduction.getPctFromGrossIncome();
					}
					else if(employeeDeduction.getAmount() != 0) {
						amount = employeeDeduction.getAmount();
					}
					else {
						continue;
					}
					EmployeePayrollDeduction employeePayrollDeduction = new EmployeePayrollDeduction();
					employeePayrollDeduction.setPayroll(payroll);
					employeePayrollDeduction.setEmployee(currentEmployee);
					employeePayrollDeduction.setDeduction(employeeDeduction.getDeduction());
					employeePayrollDeduction.setAmount(amount);
					totalDeductions += amount;
				
					employeePayrollDeductionList.add(employeePayrollDeduction);
				}
				// set total deductions
				employeePayroll.setTotalDeductions(totalDeductions);
				
				// set net income
				employeePayroll.setNetIncome(grossIncome - totalDeductions); 
				
				// save and flush
				employeePayrollList.add(employeePayroll);
				
				// set current to null
				currentEmployee = null;
			}
			
			// new employee to
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
			Date loggedDate = new Date(attendance.getTimeIn().getTime());
			PayrollCalendar payrollCalendar = calendar.get(loggedDate);
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
				
				employeeCalendar.put(loggedDate, TRUE);
				
			}
			else {
				overTime += logged;
			}
			
		}
		if(employeePayrollList.size() > 0) {
			employeePayrollCompensationRepository.save(employeePayrollCompensationList);
			employeePayrollDeductionRepository.save(employeePayrollDeductionList);
			employeePayrollRepository.save(employeePayrollList);
			
			employeePayrollCompensationRepository.flush();
			employeePayrollDeductionRepository.flush();
			employeePayrollRepository.flush();
		}
		
	}
	
}
