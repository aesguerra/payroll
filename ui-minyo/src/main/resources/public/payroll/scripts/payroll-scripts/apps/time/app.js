/**
 * Apps - Timer
 */

// Controllers
minyoControllers.controller('TimeCtrl', function($scope, $interval) {

    $scope.callAtInterval = function() {
    	var dttm = new Date();
        console.log((dttm.getMonth() + 1) + "-" +dttm.getDate() + "-" + dttm.getFullYear() + " ");
    }

    $interval(function(){ $scope.callAtInterval(); }, 1000);
});
