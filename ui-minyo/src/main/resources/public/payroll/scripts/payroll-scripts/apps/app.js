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

//Route Provider	
minyoApp.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/', {	templateUrl: 'views/home.html', controller: 'MinyoControllers' }).
		when('/home', {	templateUrl: 'views/home.html', controller: 'MinyoController' }).
		when('/person', { templateUrl: 'views/person.html', controller: 'PersonController' }).
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