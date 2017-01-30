angular
	.module('app', ['ngRoute', 'ngCookies'])
	.config(config)
	.run(run);

config.$inject = ['$routeProvider', '$locationProvider'];
function config($routeProvider, $locationProvider) {
	$routeProvider
		.when('/', {
			controller: 'HomeController',
			templateUrl: 'main/home/home.view.html',
			controllerAs: 'vm'
		})

		.when('/login', {
			controller: 'LoginController',
			templateUrl: 'main/login/login.view.html',
			controllerAs: 'vm'
		})

		.otherwise({ redirectTo: '/login' });
}

run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
function run($rootScope, $location, $cookieStore, $http) {
	// keep student logged in after page refresh
	$rootScope.globals = $cookieStore.get('globals') || {};
	if ($rootScope.globals.currentStudent) {
		$http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentStudent.authdata; // jshint ignore:line
	}

	$rootScope.$on('$locationChangeStart', function (event, next, current) {
		// redirect to login page if not logged in and trying to access a restricted page
		var restrictedPage = $.inArray($location.path(), ['/login']) === -1;
		var loggedIn = $rootScope.globals.currentStudent;
		if (restrictedPage && !loggedIn) {
			$location.path('/login');
		}
	});
}