/**
 * Apps - Employee
 */

// Controllers
minyoControllers.controller('EmpCtrl', function($scope, $location, EmpCache, EmpService) {
	$scope.data = {};
	
	EmpService.query(function(data) {
		$scope.data = data._embedded.persons;
	}, function() {
		console.log('Error.');
	});
	
	$scope.open = function(b) {
		$location.path('/empdet');
		EmpCache.setAction(b);
	}
	
	$scope.removeRow = function(i, d){			
		var empFullName = d.lastName + " " + d.firstName + " " + d.middleName;	
		var r = confirm("Delete person " + empFullName + "?");
		if (r == true) {
			var href = d._links.self.href;
			EmpService.remove({id: href.substring(href.lastIndexOf('/') + 1)}, function() {
				alert('Person ' + empFullName + ' has been removed.');
				$scope.data.splice(i, 1);
			});
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
		$scope.emp = EmpCache.getData();
	}
	
	$scope.cancel = function() {
		var r = confirm('Are you sure you want to cancel?');
		if (r == true) {
			alert('Cancelled. Going back to Employees link..');
			console.log('Cancelled.');
			$location.path('/person');
		}
	};
	
	$scope.doAction = function(emp) {
		console.log('Do action for ' + JSON.stringify(emp) + ', action: ' + $scope.action);
		var empFullName = emp.lastName + ' ' + emp.firstName + ' ' + emp.middleName;
		if($scope.action == 'Hire') {
			EmpService.add(emp, function() {
				alert('Successfully added ' + empFullName + '.');
				console.log('Added employee ' + empFullName);
				$location.path('/person');
			}, function() {
				alert('Oops! Something smelly happened back there. Adding of employee failed.');
			});
		}
		if($scope.action == 'Update') {
			console.log('Updating employee ' + empFullName);
			var href = $scope.emp._links.self.href;
			EmpService.update({id: href.substring(href.lastIndexOf('/') + 1)}, emp, function() {
				alert('Successfully updated ' + empFullName + '.');
				console.log('Updated employee ' + empFullName);
				$location.path('/person');
			});
		}
	};
});

minyoControllers.service('EmpCache', function() {
	var action = '';
	var data = '';
	
	var setAction = function(a) {
		action = a;
	};
	
	var getAction = function(){
		return action;
	};

	var setData = function(d) {
		data = d;
	}
	
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
minyoServices.factory('EmpService', function($resource){
	return  $resource('http://localhost:51000/payroll/api/persons/:id', { id: '@id'}, 
			{ 
		query: { uri:'http://localhost:51000/payroll/api/persons', 'method' : 'GET', isArray: false },
		get: { method : 'GET', isArray: false },
		add : { method : 'POST' },
		update: { method : 'PUT' },
		remove: { method: 'DELETE'}
	});
});

