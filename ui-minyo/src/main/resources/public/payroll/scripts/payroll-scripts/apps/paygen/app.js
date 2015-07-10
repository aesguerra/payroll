/**
 * Apps - Payroll Generator
 */

// Controllers

minyoControllers.controller('PaygenController', function($scope, PaygenTool) {	
	PaygenTool.TableInit(PaygenTool.TableHeader);
	
	var sampleData = [{ref: '102384', startDate: '2015-06-16', endDate: '2015-06-30', payrollMaster: 'Trisha Marie Macas', status: 'Pending', remarks: ''},
	                  {ref: '102383', startDate: '2015-06-01', endDate: '2015-06-15', payrollMaster: 'Trisha Marie Macas', status: 'Completed', remarks: 'None'},
	                  {ref: '102382', startDate: '2015-05-16', endDate: '2015-05-31', payrollMaster: 'Trisha Marie Macas', status: 'Completed', remarks: 'None'},
	                  {ref: '102381', startDate: '2015-05-01', endDate: '2015-05-15', payrollMaster: 'Trisha Marie Macas', status: 'Completed', remarks: 'None'}];
	PaygenTool.TableLoad(sampleData);
});


// Services
minyoServices.factory('PaygenTool', function() {
	return {
		TableHeader: [{ field : 'action', title: 'Action', align: 'center',  sortable: true,
			      	  	formatter: function (value, row, index) {
			      			return [
			      			        '<a class="gen" href="javascript:void(0)" title="Generate">',
			      			        '<i class="glyphicon glyphicon-exclamation-sign"></i>',
			      			        '</a>  ',
			      			        '<a class="save" href="javascript:void(0)" title="Save">',
			      			        '<i class="glyphicon glyphicon-saved"></i>',
			      			        '</a>',
			      			        '<a class="view" href="javascript:void(0)" title="View">',
			      			        '<i class="glyphicon glyphicon-eye-open"></i>',
			      			        '</a>'
			      			    ].join('');
			      		},
			      		events:
			      			window.actionEvents = {
			      			    'click .gen': function (e, value, row, index) {
			      			    	alert('You click gen icon, row: ' + JSON.stringify(row));
			      			    },
			      			    'click .save': function (e, value, row, index) {
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
			          { field : 'ref', title: 'Reference Number', sortable: true },
          			  { field : 'startDate', title: 'Start Date', sortable: true },
			          { field : 'endDate', title: 'End Date', sortable: true },
			          { field : 'payrollMaster', title : 'Payroll Master', sortable: true  },
			          { field : 'status', title : 'Status', sortable: true  },
			          { field : 'remarks', title : 'Remarks', sortable: true }],
          
			TableInit: function(header) {
				$('#table-paygen').bootstrapTable({
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
				$('#table-paygen').bootstrapTable('load', data);
			}
		}
});