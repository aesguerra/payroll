/**
 * Apps - Timer
 */

// Controllers
minyoControllers.controller('TimeCtrl', function($scope, $interval, $timeout, TimeTool, TimeService) {
	$scope.info = true;

	$scope.punch = function() {
		// ******Still not ok.. finish me
		TimeService.punch($scope.empNo, function(data, status, headers, config) {
			alert("Employee number " + $scope.empNo + " has been logged at time " + $scope.currDateTime);
		}, errorResponse);
    };
    
    var onTimeout = function() {
    	var dttm = new Date();
    	$scope.currDateTime = TimeTool.prettyfyTime(dttm.getMonth() + 1) + '-'
    		+ TimeTool.prettyfyTime(dttm.getDate()) + '-'
    		+ TimeTool.prettyfyTime(dttm.getFullYear()) + ' '
    		+ TimeTool.prettyfyTime(dttm.getHours()) + ':'
    		+ TimeTool.prettyfyTime(dttm.getMinutes()) + ':'
    		+ TimeTool.prettyfyTime(dttm.getSeconds());
    	
        timer = $timeout(onTimeout, 1000);
    };
    
    var timer = $timeout(onTimeout, 1000);
    
    $scope.$on("$destroy", function() {
        if (timer) {
            $timeout.cancel(timer);
        }
    });
    
});

minyoServices.factory('TimeTool', function() {
	return {
		prettyfyTime: function(d) {
			return parseInt(d) < 10 ? '0' + d : d;
		}
	};
});

//Services
minyoServices.factory('TimeService', function($http){
	var URI = "http://localhost:51000/payroll/api/timeLogs/";
	
	return { 
		// ***still not ok. finish me
		punch: function(d, s, e) {
			var req = {
				 method: 'POST',
				 url: URI + d
			};
			
			$http(req).success(s).error(e);
		}
	};

});

var errorResponse = function(d) {
	alertAndLog('Oops. Something smelly happened back there. Please try again.');
}