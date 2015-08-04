/**
 * Apps - Maintenance - Compensation 
 */

// Controllers
minyoControllers.controller('MtnceCtrl', function($scope, MtnceService) {
	$scope.oneAtATime = true;
	
	$scope.isAdminClpsed = true;
	$scope.isCmpenClpsed = true;
	$scope.isDeducClpsed = true;
	$scope.isEmtypClpsed = true;
	$scope.isEmsttClpsed = true;
	$scope.isOrgnzClpsed = true;
	
	$scope.cmpen = {};
	$scope.deduc = {};
	$scope.emtyp = {};
	$scope.emstt = {};
	$scope.orgnz = {};
	
	// 1 - Admin
	// 2 - Compensation
	// 3 - Deduction
	// 4 - Employee Types
	// 5 - Employment Status
	// 6 - Organizations
	
	$scope.addRow = function(d, i) {
		console.log(JSON.stringify(d));
		switch(i) {
		case 1: break;
		case 2: 
			MtnceService.CmpenAdd(d, 
					function(data, status, headers, config) {
				alertAndLog('Successfully added compensation ' + d.name);
				$scope.compensations.push({link: headers('Location'), name: d.name, description: d.description });
				d.name = '';
				d.description = '';
			}, errorResponse);
			break;
		case 3: 
			MtnceService.DeducAdd(d, 
					function(data, status, headers, config) {
				alertAndLog('Successfully added deduction ' + d.name);
				$scope.deductions.push({link: headers('Location'), name: d.name, provider: d.provider, voluntary: d.voluntary });
				d.name = '';
				d.provider = '';
				d.volundary = '';
			}, errorResponse);
			break;
		case 4: 
			MtnceService.EmtypAdd(d, 
					function(data, status, headers, config) {
				alertAndLog('Successfully added employee status ' + d.name);
				$scope.empTypes.push({link: headers('Location'), name: d.name, description: d.description });
				d.name = '';
				d.description = '';
			}, errorResponse);
			break;
		case 5:
			MtnceService.EmsttAdd(d, 
					function(data, status, headers, config) {
				alertAndLog('Successfully added employment type ' + d.name);
				$scope.empStatuses.push({link: headers('Location'), name: d.name, description: d.description });
				d.name = '';
				d.description = '';
			}, errorResponse);
			break;
		case 6:
			MtnceService.OrgnzAdd(d, 
					function(data, status, headers, config) {
				alertAndLog('Successfully added organization ' + d.name);
				$scope.empStatuses.push({link: headers('Location'), name: d.name, description: d.description,
					organization: d.organization, manager: d.manager });
				d.name = '';
				d.description = '';
			}, errorResponse);
			break;
		}
	};
	
	$scope.open = function(i) {
		switch(i) {
		case 1: break;
		case 2:
			$scope.isCmpenClpsed = false;
			$scope.cmpenAction = 'Add';
			$scope.cmpen.name = '';
			$scope.cmpen.description = '';
			break;
		case 3:
			$scope.isDeducClpsed = false;
			$scope.deducAction = 'Add';
			$scope.deduc.name = '';
			$scope.deduc.provider = '';
			$scope.deduc.voluntary = '';
			break;
		case 4:
			$scope.isEmtypClpsed = false;
			$scope.emtypAction = 'Add';
			$scope.emtyp.name = '';
			$scope.emtyp.description = '';
			break;
		case 5:
			$scope.isEmsttClpsed = false;
			$scope.emsttAction = 'Add';
			$scope.emstt.name = '';
			$scope.emstt.description = '';
			break;
		case 6:
			$scope.isOrgnzClpsed = false;
			$scope.orgnzAction = 'Add';
			$scope.orgnz.name = '';
			$scope.orgnz.description = '';
			break;
		}
	};
	
	$scope.editRow = function(d, i) {
		switch(i) {
		case 1: break;
		case 2:
			$scope.cmpenAction = 'Update';
			$scope.isCmpenClpsed = false;
			
			$scope.cmpen.link = d.link;
			$scope.cmpen.name = d.name;
			$scope.cmpen.description = d.description;	
			break;
		case 3:
			$scope.deducAction = 'Update';
			$scope.isDeducClpsed = false;
			
			$scope.deduc.link = d.link;
			$scope.deduc.name = d.name;
			$scope.deduc.provider = d.provider;
			$scope.deduc.voluntary = d.voluntary;	
			break;
		case 4:
			$scope.emtypAction = 'Update';
			$scope.isEmtypClpsed = false;
			
			$scope.emtyp.link = d.link;
			$scope.emtyp.name = d.name;
			$scope.emtyp.description = d.description;
			break;
		case 5:
			$scope.emsttAction = 'Update';
			$scope.isEmsttClpsed = false;
			
			$scope.emstt.link = d.link;
			$scope.emstt.name = d.name;
			$scope.emstt.description = d.description;
			break;
		case 6:
			$scope.orgnzAction = 'Update';
			$scope.isOrgnzClpsed = false;
			
			$scope.orgnz.link = d.link;
			$scope.orgnz.name = d.name;
			$scope.orgnz.description = d.description;
			break;
		}
	};
	
	$scope.updateRow = function(d, i, idx) {
		switch(i) {
		case 1: break;
		case 2: 
			MtnceService.Update(d, function(data, status, headers, config) {
				alertAndLog('Updated.');
				$scope.isCmpenClpsed = true;
				$scope.reload(2);
			}, errorResponse);
			break;
		case 3: 
			MtnceService.Update(d, function(data, status, headers, config) {
				alertAndLog('Updated.');
				$scope.isDeducClpsed = true;
				$scope.reload(3);
			}, errorResponse);
			break;
		case 4: 
			MtnceService.Update(d, function(data, status, headers, config) {
				alertAndLog('Updated.');
				$scope.isEmtypClpsed = true;
				$scope.reload(4);
			}, errorResponse);
			break;
		case 5: 
			MtnceService.Update(d, function(data, status, headers, config) {
				alertAndLog('Updated.');
				$scope.isEmsttClpsed = true;
				$scope.reload(5);
			}, errorResponse);
			break;
		case 5: 
			MtnceService.Update(d, function(data, status, headers, config) {
				alertAndLog('Updated.');
				$scope.isOrgnzClpsed = true;
				$scope.reload(6);
			}, errorResponse);
			break;
		}
	}
	
	$scope.deleteRow = function(d, i) {
		var c = confirm('Are you sure to delete record?');
		if(c) {
			switch(i) {
			case 1: break;
			case 2: 
				MtnceService.Delete(d, function(data, status, headers, config) {
					alertAndLog('Deleted.');
					$scope.reload(2);
				});
				break;
			case 3: 
				MtnceService.Delete(d, function(data, status, headers, config) {
					alertAndLog('Deleted.');
					$scope.reload(3);
				});
				break;
			case 4: 
				MtnceService.Delete(d, function(data, status, headers, config) {
					alertAndLog('Deleted.');
					$scope.reload(4);
				});
				break;
			case 5: 
				MtnceService.Delete(d, function(data, status, headers, config) {
					alertAndLog('Deleted.');
					$scope.reload(5);
				});
				break;
			case 6: 
				MtnceService.Delete(d, function(data, status, headers, config) {
					alertAndLog('Deleted.');
					$scope.reload(6);
				});
				break;
			}
		}
	}
	
	$scope.setAction = function(a, d, i) {
		switch(a) {
			case 'Add': 
				$scope.addRow(d, i); 
				break;
			case 'Update':
				$scope.updateRow(d, i);
				break;
		}
	}
	
	$scope.actionMtnce = function(d, i) {
		switch(i) {
		case 1: break;
		case 2:
			$scope.setAction($scope.cmpenAction, d, i);
			break;
		case 3: 
			$scope.setAction($scope.deducAction, d, i);
			break;
		case 4: 
			$scope.setAction($scope.emtypAction, d, i);
			break;
		case 5: 
			$scope.setAction($scope.emsttAction, d, i);
			break;
		case 6: 
			$scope.setAction($scope.orgnzAction, d, i);
			break;
		}	
	}
	
	$scope.close = function(i) {
		switch(i) {
		case 1: break;
		case 2:
			$scope.isCmpenClpsed = true;
			break;
		case 3:
			$scope.isDeducClpsed = true;
			break;
		case 4:
			$scope.isEmtypClpsed = true;
			break;
		case 5:
			$scope.isEmsttClpsed = true;
			break;
		case 6:
			$scope.isOrgnzClpsed = true;
			break;
		}
	};
	
	$scope.reload = function(i) {
		switch(i) {
		case 1: break;
		case 2: 
			MtnceService.CmpenGetStar(function(data, status, headers, config) {
				var compensations = [];
				data._embedded['reference compensations'].forEach(function(entry) {
					compensations.push({
						link : entry._links.self.href,
						name : entry.name,
						description : entry.description});
				});
				$scope.compensations = compensations;
			}, errorResponse);
			break;
		case 3: 
			MtnceService.DeducGetStar(function(data, status, headers, config) {
				var deductions = [];
				data._embedded['reference deductions'].forEach(function(entry) {
					deductions.push({
						link : entry._links.self.href,
						name : entry.name,
						provider : entry.provider,
						voluntary : entry.voluntary});
				});
				$scope.deductions = deductions;
			}, errorResponse);
			break;
		case 4: 
			MtnceService.EmtypGetStar(function(data, status, headers, config) {
				var empTypes = [];
				data._embedded['reference employee types'].forEach(function(entry) {
					empTypes.push({
						link : entry._links.self.href,
						name : entry.name,
						description : entry.description});
				});
				$scope.empTypes = empTypes;
			}, errorResponse);
			break;
		case 5: 
			MtnceService.EmsttGetStar(function(data, status, headers, config) {
				var empStatuses = [];
				data._embedded['reference employment status'].forEach(function(entry) {
					empStatuses.push({
						link : entry._links.self.href,
						name : entry.name,
						description : entry.description});
				});
				$scope.empStatuses = empStatuses;
			}, errorResponse);
			break;
		case 6: 
			MtnceService.OrgnzGetStar(function(data, status, headers, config) {
				var organizations = [];
				data._embedded['reference organizations'].forEach(function(entry) {
					organizations.push({
						link : entry._links.self.href,
						name : entry.name,
						description : entry.description,
						parent: entry.parent,
						manager: entry.manager });
				});
				$scope.organizations = organizations;
			}, errorResponse);
			break;
		}
	}
		
	$scope.reload(2);
	$scope.reload(3);
	$scope.reload(4);
	$scope.reload(5);
	$scope.reload(6);
	
});

var errorResponse = function(d) {
	alertAndLog('Oops. Something smelly happened back there. Please try again.');
}

var includeHeader = function(d,h) {
	return {data : d, header : h};
};

minyoControllers.factory('MtnceService', function($resource, $http) {
	var URI = 'http://localhost:51000/payroll/api/';
	var compensations = URI + 'compensations/';
	var deductions = URI + 'deductions/';
	var employeeTypes = URI + 'employee-types/';
	var employmentStatus = URI + 'employment-status/';
	var organizations = URI + 'organizations/';
	
	return {
		CmpenAdd: function(d, s, e) {
			var req = {
				 method: 'POST',
				 url: compensations,
				 data: d
			};
			
			$http(req).success(s).error(e);
		},
		CmpenGetStar: function(s, e) {
			var req = {
				 method: 'GET',
				 url: compensations
			};
			
			$http(req).success(s).error(e);
		},
		DeducAdd: function(d, s, e) {
			var req = {
				 method: 'POST',
				 url: deductions,
				 data: d
			};
			
			$http(req).success(s).error(e);
		},
		DeducGetStar: function(s, e) {
			var req = {
				 method: 'GET',
				 url: deductions
			};
			
			$http(req).success(s).error(e);
		},
		EmtypAdd: function(d, s, e) {
			var req = {
				 method: 'POST',
				 url: employeeTypes,
				 data: d
			};
			
			$http(req).success(s).error(e);
		},
		EmtypGetStar: function(s, e) {
			var req = {
				 method: 'GET',
				 url: employeeTypes
			};
			
			$http(req).success(s).error(e);
		},
		EmsttAdd: function(d, s, e) {
			var req = {
				 method: 'POST',
				 url: employmentStatus,
				 data: d
			};
			
			$http(req).success(s).error(e);
		},
		EmsttGetStar: function(s, e) {
			var req = {
				 method: 'GET',
				 url: employmentStatus
			};
			
			$http(req).success(s).error(e);
		},
		OrgnzAdd: function(d, s, e) {
			var req = {
				 method: 'POST',
				 url: organizations,
				 data: d
			};
			
			$http(req).success(s).error(e);
		},
		OrgnzGetStar: function(s, e) {
			var req = {
				 method: 'GET',
				 url: organizations
			};
			
			$http(req).success(s).error(e);
		},
		Get: function(d, s, e) {
			var req = {
				 method: 'GET',
				 url: d
			};
			
			$http(req).success(s).error(e);
		},
		Update: function(d, s, e) {
			var req = {
				 method: 'PATCH',
				 url: d.link,
				 data: d
			};
			$http(req).success(s).error(e);
		},
		Delete: function(d, s, e) {
			var req = {
				 method: 'DELETE',
				 url: d.link,
				 data: d
			};
			$http(req).success(s).error(e);
		}
	};

});

function alertAndLog(d) {
	alert(d);
	console.log(d);
}