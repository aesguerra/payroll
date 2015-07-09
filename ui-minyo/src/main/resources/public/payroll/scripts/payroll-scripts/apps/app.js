// App
var minyoApp = angular.module('MinyoApp', ['ngResource', 'ngRoute', 'MinyoControllers', 'ui.bootstrap']);

//Controllers
var minyoControllers = angular.module('MinyoControllers', ['MinyoServices', 'MinyoDirectives']);

minyoControllers.controller('MinyoController', function($scope) {
	$scope.home = "Home";
	$scope.menuToggle = function() {
		$("#wrapper").toggleClass("toggled");
	}
});

minyoControllers.controller('PersonController', function($scope, $modal, PersonService, PersonTool) {	

	$scope.isCollapsed = true;
	PersonTool.TableInit(PersonTool.TableHeader);

	PersonService.query(function(data) {
		PersonTool.TableLoad(data._embedded.persons);
	}, function() {
		console.log('Error.');
	});
	
	$scope.open = PersonTool.OpenModal;
	
	$scope.updatePerson = function(person) {
		console.log('Updating person: ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName);
	}
	
});

minyoControllers.controller('PersonModalInstanceCtrl', function($scope, $modalInstance, PersonService, PersonTool, personData, action) {
	$scope.person = personData;
	$scope.action = action;

	if(action == undefined) {
		$scope.action = 'Add';
	}
	
	$scope.doAction = function(person) {
		if($scope.action == 'Add') {
			console.log('Adding person: ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName);
			PersonTool.InsertRow(person);
			console.log('Person Added: ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName);
			
			PersonService.add(person, function() {
				alert('Successfully added ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName + '.');
				PersonTool.ClearFields(person);
			}, function() {
				alert('Oops! Something smelly happened back there. Adding of person failed.')
			});
		}
		if($scope.action == 'Update') {
			console.log('Updating person: ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName);
			PersonTool.UpdateRow(1, person);
			
			
			//EDIT HERE...............
		}
		$modalInstance.close('OK');
	};
	
	$scope.cancel = function () {
		console.log('Cancelled.');
	  	$modalInstance.dismiss('cancel');
	};
});

//Route Provider	
minyoApp.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/', {	templateUrl: 'views/home.html', controller: 'MinyoControllers' }).
		when('/home', {	templateUrl: 'views/home.html', controller: 'MinyoController' }).
		when('/person', { templateUrl: 'views/person.html', controller: 'PersonController' }).
		otherwise({ redirectTo: '/' });
	}
]);

//Services
var minyoServices = angular.module('MinyoServices', []);

minyoServices.factory('PersonService', function($resource){
	return  $resource('http://localhost:51000/payroll/api/persons/:id', { id: '@person_id'}, 
			{ 
		'query': { uri:'http://localhost:51000/payroll/api/persons', 'method' : 'GET', isArray: false },
		'get': { 'method' : 'GET', isArray: false },
		'add' : { 'method' : 'POST' },
		'update': { 'method' : 'PUT' }
	});
});

minyoServices.factory('PersonTool', function($modal, PersonService) {
	var showModal = function (action, personData) {
		$modal.open({
		      animation: true,
		      templateUrl: 'person-detail.html',
		      controller: 'PersonModalInstanceCtrl',
		      size: 'lg',
		      backdrop: 'static',
		      resolve: {
		    	  action: function() {
		    		  return action;
		    	  },
		    	  personData: function() {
		    		  return personData;
		    	  }
		      }
		    });
	};
	
	return {
		OpenModal: showModal,
		TableHeader: [{ field : 'action', title: 'Action', align: 'center',
			      	  	formatter: function (value, row, index) {
			      			return [
			      			        '<a class="edit" href="javascript:void(0)" title="Edit">',
			      			        '<i class="glyphicon glyphicon-edit"></i>',
			      			        '</a> ',
			      			        '<a class="remove" href="javascript:void(0)" title="Remove">',
			      			        '<i class="glyphicon glyphicon-remove"></i>',
			      			        '</a>'
			      			    ].join('');
			      		},
			      		events:
			      			window.actionEvents = {
			      			    'click .edit': function (e, value, row, index) {
			      			    	// alert('You click edit icon, row: ' + JSON.stringify(row));
			      			    	var href = row._links.self.href;
				      			    PersonService.get({id: href.substring(href.lastIndexOf('/') + 1)}, function(data) {
				      			    	showModal('Update', data);
				      			    });
			      			    },
			      			    'click .remove': function (e, value, row, index) {
			      			        alert('You click remove icon, row: ' + JSON.stringify(row));
			      			        console.log(value, row, index);
			      			    }
			      			}  
		              },
	                  { field : '_links', visible: false, formatter: function(value, row) {
	                	  return value.self.href;
	                  } },
	                  { field : 'lastName', title: 'Last Name', sortable: true },
	                  { field : 'firstName', title: 'First Name', sortable: true },
	                  { field : 'middleName', title : 'Middle Name', sortable: true  },
	                  { field : 'affix', title : 'Affix', sortable: true  },
	                  { field : 'age', title : 'Age', sortable: true },
	                  { field : 'gender', title : 'Gender', sortable: true },
	                  { field : 'dateOfBirth', title : 'Date of Birth', sortable: true },
	                  { field : 'civilStatus', title : 'Civil Status', sortable: true },
	                  { field : 'permanentResidence', title : 'Permanent Residence' },
	                  { field : 'currentResidence', title : 'Current Residence' }],
	                  
		TableInit: function(header) {
			$('#table-person').bootstrapTable({
				classes: "table table-hover table-condensed",
			    toolbar: '#toolbar',
			    search:"true",
			    buttonsAlign: 'right',
			    searchAlign: "left",
			    height: "600",
			    columns: header,
			    showRefresh: true,
			    showToggle: true
			});
		},
		TableLoad: function(data) {
			$('#table-person').bootstrapTable('load', data);
		},
		InsertRow: function(data) {
			$('#table-person').bootstrapTable('prepend', data);
		},
		UpdateRow: function(idx, data) {
			$('#table-person').bootstrapTable('updateRow', {
             index: idx,
             row: data
         });
		},
		ClearFields: function(data) { // gawin tong generic next time
			data.lastName = '';
			data.firstName = '';
			data.middleName = '';
			data.affix = '';
			data.age = '';
			data.gender = '';
			data.dateOfBirth = '';
			data.civilStatus = '';
			data.permanentResidence = '';
			data.currentResidence = '';
		}
	};
});

var minyoDirectives = angular.module('MinyoDirectives', []);
minyoDirectives.directive('mogSidebar', function() {
	return { templateUrl: 'views/sidebar.html' };
});
minyoDirectives.directive('mogHome', function() {
	return { templateUrl: 'views/home.html' };
});	