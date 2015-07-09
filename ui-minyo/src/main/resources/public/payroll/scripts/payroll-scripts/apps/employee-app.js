/**
 * Angular application for Employee
 */

var employeeApp = angular.module('EmployeeApp', []);

employeeApp.controller('EmployeeController', function($scope) {
	$scope.hireEmployee = function(employee) {
		console.log("Here goes details of Employee.");
		console.log(employee);
	};
});