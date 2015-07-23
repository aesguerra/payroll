/**
 * Apps - Timer
 */

// Controllers
minyoControllers.controller('TimeCtrl', function($scope, $interval, $timeout, TimeTool) {
	$scope.info = true;

	$scope.punch = function() {
    	alert("Employee number " + $scope.empNo + " has been logged at time " + $scope.currDateTime);
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