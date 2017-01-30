angular
    .module('app')
    .factory('AuthenticationService', AuthenticationService);

AuthenticationService.$inject = ['$http', '$cookieStore', '$rootScope'];
function AuthenticationService($http, $cookieStore, $rootScope) {
    const configUrl = location.protocol + "//" + location.hostname + ":" + 8080 + '/api/students/'; //this will not work for ipv6!

    var service = {};

    service.login = login;
    service.setCredentials = setCredentials;
    service.clearCredentials = clearCredentials;

    return service;

    function login(id, callback) {
        $http.get(configUrl + id)
            .success(function (data, response) {
                callback(data, response);
            })
            .error(function (data, response) {
                callback(data, response);
            })
    }

    function setCredentials(id) {
        $rootScope.globals = {
            currentStudent: {
                id: id
            }
        };

        $cookieStore.put('globals', $rootScope.globals);
    }

    function clearCredentials() {
        $rootScope.globals = {};
        $cookieStore.remove('globals');
    }
}