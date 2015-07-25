package org.minyo.payroll.controllers;


import java.sql.Timestamp;

import org.minyo.payroll.entities.Attendance;
import org.minyo.payroll.entities.Employee;
import org.minyo.payroll.entities.TimeLog;
import org.minyo.payroll.repos.AttendanceRepository;
import org.minyo.payroll.repos.EmployeeRepository;
import org.minyo.payroll.repos.TimeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class TimeLogController {

	final private TimeLogRepository timeLogRepository;
	final private EmployeeRepository employeeRepository;
	final private AttendanceRepository attendanceRepository;
	
	@Autowired
	public TimeLogController(TimeLogRepository timeLogRepository, EmployeeRepository employeeRepository, AttendanceRepository attendanceRepository) {
		this.timeLogRepository = timeLogRepository;
		this.employeeRepository = employeeRepository;
		this.attendanceRepository = attendanceRepository;
		System.out.println("TimeLogService initialized.");
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/timelogs/{empno}")
	public @ResponseBody TimeLog log(@PathVariable("empno") String employeeNumber) {

		
		System.out.println("here");
		TimeLog ret = null;
		boolean isTimeIn = false;

		Employee employee = employeeRepository.findByEmployeeNumberIgnoreCase(employeeNumber);
		TimeLog timeLog = timeLogRepository.findByEmployeeId(employee.getId());

		if(timeLog == null) {
			isTimeIn = true;
			timeLog = new TimeLog();
		}
		else if(timeLog.getTimeIn() == null) {
			isTimeIn = true;
		}
		else {
			isTimeIn = false;
		}
		
		if(isTimeIn) {
			// time in
			timeLog.setEmployee(employee);
			timeLog.setTimeIn(new Timestamp(System.currentTimeMillis()));
			ret = timeLogRepository.saveAndFlush(timeLog);
		}
		else {
			// time out
			ret = new TimeLog();
			ret.setEmployee(employee);
			ret.setTimeIn(timeLog.getTimeIn());
			ret.setTimeOut(new Timestamp(System.currentTimeMillis()));
			timeLog.setTimeIn(null);
			timeLog.setTimeOut(null);
			timeLogRepository.saveAndFlush(timeLog);
			
			Attendance attendance = new Attendance();
			attendance.setEmployee(employee);
			attendance.setTimeIn(ret.getTimeIn());
			attendance.setTimeOut(ret.getTimeOut());
			attendanceRepository.saveAndFlush(attendance);
		}
		return ret;
	}
}
