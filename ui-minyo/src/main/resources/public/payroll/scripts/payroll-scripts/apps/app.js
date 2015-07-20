// App
var minyoApp = angular.module('MinyoApp', ['ngResource', 'ngRoute', 'ui.bootstrap', 'MinyoControllers']);

//Controllers
var minyoControllers = angular.module('MinyoControllers', ['MinyoServices', 'MinyoDirectives']);

minyoControllers.controller('MinyoController', function($scope) {
	$scope.home = "Home";
	$scope.menuToggle = function() {
		$("#wrapper").toggleClass("toggled");
	}
});

//Route Provider	
minyoApp.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/', {	templateUrl: 'views/home.html', controller: 'MinyoControllers' }).
		when('/home', {	templateUrl: 'views/home.html', controller: 'MinyoController' }).
		when('/person', { templateUrl: 'views/person.html', controller: 'EmpCtrl' }).
		when('/empdet', { templateUrl: 'views/employee-detail.html', controller: 'EmpDetCtrl' }).
		when('/attendance', { templateUrl: 'views/time.html', controller: 'TimeCtrl' }).
		when('/paygen', { templateUrl: 'views/payroll-gen.html', controller: 'PaygenController' }).
		otherwise({ redirectTo: '/' });
	}
]);

//Services
var minyoServices = angular.module('MinyoServices', []);

var minyoDirectives = angular.module('MinyoDirectives', []);
minyoDirectives.directive('mogSidebar', function() {
	return { templateUrl: 'views/sidebar.html' };
});
minyoDirectives.directive('mogHome', function() {
	return { templateUrl: 'views/home.html' };
});	