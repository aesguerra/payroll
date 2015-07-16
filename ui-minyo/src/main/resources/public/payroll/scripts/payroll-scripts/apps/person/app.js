/**
 * Apps - Person
 */


// Controllers
minyoControllers.controller('PersonController', function($scope, $location, $modal, PersonService, PersonTool, EmpCache) {	

	$scope.isCollapsed = true;
	PersonTool.TableInit(PersonTool.TableHeader);

	PersonService.query(function(data) {
		PersonTool.TableLoad(data._embedded.persons);
	}, function() {
		console.log('Error.');
	});
	
	$scope.open = function(b) {
		$location.path("/empdet");//PersonTool.OpenModal;
		EmpCache.setAction(b);
	}
	
	$scope.updatePerson = function(person) {
		console.log('Updating person: ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName);
	}
	
});

minyoControllers.controller('EmpDetCtrl', function($scope, EmpCache) {
	$scope.action = EmpCache.getAction();
});

minyoControllers.controller('PersonModalInstanceCtrl', function($scope, $modalInstance, PersonService, PersonTool, personData, action) {
	$scope.person = personData;
	$scope.action = action;

	if(action == undefined) {
		$scope.action = 'Add';
	}
	
	$scope.doAction = function(person) {
		if($scope.action == 'Add') {
			PersonService.add(person, function() {
				alert('Successfully added ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName + '.');
				console.log('Person Added: ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName);
				PersonTool.ClearFields(person);
				PersonTool.InsertRow(person);
			}, function() {
				alert('Oops! Something smelly happened back there. Adding of person failed.');
			});
		}
		if($scope.action == 'Update') {
			console.log('Updating person: ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName);
			var href = $scope.person._links.self.href;
			PersonService.update({id: href.substring(href.lastIndexOf('/') + 1)}, person, function() {
				alert('Successfully updated ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName + '.');
				console.log('Person Updated: ' + person.lastName + ' ' + person.firstName + ' ' + person.middleName);
				PersonTool.UpdateRow(href.substring(href.lastIndexOf('/') + 1), person);
			});
		}
		$modalInstance.close('OK');
	};
	
	$scope.cancel = function () {
		console.log('Cancelled.');
	  	$modalInstance.dismiss('cancel');
	};
});

minyoControllers.service('EmpCache', function() {
	var action = '';
	
	var setAction = function(a) {
		action = a;
	};
	
	var getAction = function(){
		return action;
	};
	
	return {
		setAction: setAction,
		getAction: getAction
	};
});


// Services
minyoServices.factory('PersonService', function($resource){
	return  $resource('http://localhost:51000/payroll/api/persons/:id', { id: '@id'}, 
			{ 
		query: { uri:'http://localhost:51000/payroll/api/persons', 'method' : 'GET', isArray: false },
		get: { method : 'GET', isArray: false },
		add : { method : 'POST' },
		update: { method : 'PUT' },
		remove: { method: 'DELETE'}
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
	
	var removeRow = function(idx) { $('#table-person').bootstrapTable('hideRow', { index: idx }) };
	
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
			      			        //alert('You click remove icon, row: ' + JSON.stringify(row));
									var r = confirm("Delete person " + row.lastName + " " + row.firstName + " " + row.middleName + "?");
									if (r == true) {
										var href = row._links.self.href;
										PersonService.remove({id: href.substring(href.lastIndexOf('/') + 1)}, function() {
											alert('Person ' + row.lastName + " " + row.firstName + " " + row.middleName + ' has been removed.');
											removeRow(index);
										});
									}
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