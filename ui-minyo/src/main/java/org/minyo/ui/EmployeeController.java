package org.minyo.ui;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	/*
	 * @PathVariable String string - if value in path
	 * @Request String string - if value after ?
	 * 
	 * */
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Employee createEmployee(
			@RequestParam(value="id", defaultValue="") int id,
			@RequestParam(value="name", defaultValue="") String name) {
		
		// Put something here
		
		return new Employee();
	}
}
