/**
 * Apps - Employee
 */

// Controllers
minyoControllers.controller('EmpCtrl', function($scope, $location, EmpCache, EmpService) {
	$scope.data = [];
	
	EmpService.empGetStar(function(data, status, headers, config) {
		var empData = data._embedded['employees'];
		$scope.data = [];		
		for(d in empData) {
			var empLink = empData[d]._links.person.href;
			EmpService.get(empLink, function(data2, status, headers, config) {
				console.log('empData[d].employeeNumber>> ' + empData[d].employeeNumber);
				var temp = {
					perLink: data2._links.self.href,
					empLink: empLink,
					empNo: empData[d].employeeNumber,
					lastName: data2.lastName,
					firstName: data2.firstName,
					middleName: data2.middleName,
					affix: data2.affix,
					gender: data2.gender
				};
				$scope.data.push(temp);
			}, errorResponse);
		}
	}, errorResponse);
	
	$scope.open = function(b) {
		$location.path('/empdet');
		EmpCache.setAction(b);
	}
	
	$scope.removeRow = function(i, d){			
		var empFullName = d.lastName + " " + d.firstName + " " + d.middleName;	
		var r = confirm("Delete person " + empFullName + "?");
		if (r == true) {
			console.log(d.empLink + "~" + d.perLink);
			EmpService.deleteRow(d.empLink, function(data, status, headers, config) {
				EmpService.deleteRow(d.perLink, function(data, status, headers, config) {
					alertAndLog('Person ' + empFullName + ' has been removed.');
					$scope.data.splice(i, 1);
				}, errorResponse);
			}, errorResponse);
		}
	};
	
	$scope.edit = function(d) {
		EmpCache.setAction('Update');
    	EmpCache.setData(d);
    	$location.path('/empdet');
	};
});

minyoControllers.controller('EmpDetCtrl', function($scope, $location, EmpCache, EmpService) {
	$scope.action = EmpCache.getAction();
	
	if($scope.action == 'Update') {
		var links = EmpCache.getData();
		EmpService.get(links.per, function(data, status, headers, config) {
			EmpService.get(links.per + '/employee', function(data2, status, headers, config) {
				$scope.per = data;
				$scope.emp = data2;
			}, errorResponse);
		}, errorResponse);
	}
	
	$scope.cancel = function() {
		var r = confirm('Are you sure you want to cancel?');
		if (r == true) {
			alert('Cancelled. Going back to Employees link..');
			console.log('Cancelled.');
			$location.path('/person');
		}
	};
	
	$scope.doAction = function(d, e) {
		console.log('Action set to ' + JSON.stringify(d) + ', action: ' + $scope.action);
		var perFullName = d.lastName + ' ' + d.firstName + ' ' + d.middleName;
		if($scope.action == 'Hire') {
			EmpService.addPerson(d, function(data, status, headers, config) {
				var empData = {
					employeeNumber: e.employeeNumber,
					pagibig: e.pagibig,
					philhealth: e.philhealth,
					taxExemptionStatus: e.taxExemptionStatus,
					dateHired: e.dateHired,
					sss: e.socialSecurityNumber,
					tin: e.taxIdentificationNumber,
					person: headers('Location')
				};
				EmpService.Hire(empData, function(data2, status, headers, config) {
					alertAndLog('Successfully added ' + perFullName);
					$location.path('/person');
				}, errorResponse);
			}, errorResponse);
		}
		if($scope.action == 'Update') {
			console.log('Updating employee ' + perFullName);
			EmpService.update(d, function(data, status, headers, config) {
				EmpService.update(e, function(data, status, headers, config) {
					alertAndLog('Successfully updated ' + perFullName + '.');
					$location.path('/person');
				}, errorResponse);
			}, errorResponse);
		}
	};
});

function debugme(c, d) {
	console.log(c + ": " + JSON.stringify(d));
}

minyoControllers.service('EmpCache', function() {
	var action = '';
	var data = {};
	
	var setAction = function(a) {
		action = a;
	};
	
	var getAction = function(){
		return action;
	};

	var setData = function(d) {
		data = { per: d.perLink, emp : d.empLink };
	};
	
	var getData = function() {
		return data;
	};
	
	return {
		setAction: setAction,
		getAction: getAction,
		setData: setData,
		getData: getData
	};
});


// Services
minyoServices.factory('EmpService', function($http){
	var URI = 'http://localhost:51000/payroll/api/';
	var persons = URI + 'persons/';
	var employees = URI + 'employees/';
	
	return { 
		addPerson: function(d, s, e) {
			var req = {
				 method: 'POST',
				 url: persons,
				 data: d
			};
			
			$http(req).success(s).error(e);
		},
		hire: function(d, s, e) {
			var req = {
				 method: 'POST',
				 url: employees,
				 data: d
			};
			
			$http(req).success(s).error(e);
		},
		perGetStar: function(s, e) {
			var req = {
				 method: 'GET',
				 url: persons
			};
			
			$http(req).success(s).error(e);
		},
		empGetStar: function(s, e) {
			var req = {
				 method: 'GET',
				 url: employees
			};
			
			$http(req).success(s).error(e);
		},
		get: function(d, s, e) {
			var req = {
				 method: 'GET',
				 url: d
			};
			
			$http(req).success(s).error(e);
		},
		update: function(d, s, e) {
			var req = {
				 method: 'PATCH',
				 url: d._links.self.href,
				 data: d
			};
			$http(req).success(s).error(e);
		},
		deleteRow: function(d, s, e) {
			var req = {
				 method: 'DELETE',
				 url: d.link,
				 data: d
			};
			$http(req).success(s).error(e);
		}
	};
});

var errorResponse = function(d) {
	alertAndLog('Oops. Something smelly happened back there. Please try again.');
}

function alertAndLog(d) {
	alert(d);
	console.log(d);
}
