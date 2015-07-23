/**
 * Apps - Maintenance - Compensation 
 */

// Controllers
minyoControllers.controller('MtnceCmpenCtrl', function($scope, $location, MtnceCmpenCache, MtnceCmpenService) {
	$scope.data = {};
	
	MtnceCmpenService.query(function(data) {
		$scope.data = data._embedded.persons;
	}, function() {
		console.log('Error.');
	});
	
	$scope.open = function(b) {
		$location.path('/empdet');
		MtnceCmpenCache.setAction(b);
	}
	
	$scope.removeRow = function(i, d){			
		var empFullName = d.lastName + " " + d.firstName + " " + d.middleName;	
		var r = confirm("Delete person " + empFullName + "?");
		if (r == true) {
			var href = d._links.self.href;
			MtnceCmpenService.remove({id: href.substring(href.lastIndexOf('/') + 1)}, function() {
				alert('Person ' + empFullName + ' has been removed.');
				$scope.data.splice(i, 1);
			});
		}
	};
	
	$scope.edit = function(d) {
		MtnceCmpenCache.setAction('Update');
		MtnceCmpenCache.setData(d);
    	$location.path('/empdet');
	};
});

minyoControllers.controller('MtnceCmpenCtrl', function($scope, $location, MtnceCmpenCache, MtnceCmpenService) {
	$scope.action = MtnceCmpenCache.getAction();
	
	if($scope.action == 'Update') {
		$scope.emp = MtnceCmpenCache.getData();
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
			MtnceCmpenService.add(emp, function() {
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
			MtnceCmpenService.update({id: href.substring(href.lastIndexOf('/') + 1)}, emp, function() {
				alert('Successfully updated ' + empFullName + '.');
				console.log('Updated employee ' + empFullName);
				$location.path('/person');
			});
		}
	};
});

minyoControllers.service('MtnceCmpenCache', function() {
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
minyoServices.factory('MtnceCmpenService', function($resource){
	return  $resource('http://localhost:51000/payroll/api/organizations/:id', { id: '@id'}, 
			{ 
		query: { uri:'http://localhost:51000/payroll/api/organizations', 'method' : 'GET', isArray: false },
		get: { method : 'GET', isArray: false },
		add : { method : 'POST' },
		update: { method : 'PUT' },
		remove: { method: 'DELETE'}
	});
});
