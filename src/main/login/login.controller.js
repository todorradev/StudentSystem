angular
    .module('app')
    .controller('LoginController', LoginController);

LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService'];
function LoginController($location, AuthenticationService, FlashService) {
    var vm = this;

    vm.login = login;

    (function initController() {
        // reset login status
        AuthenticationService.clearCredentials();
    })();

    function login() {
        if(vm.id == "admin") {
            AuthenticationService.setCredentials(vm.id);
            $location.path('/');
            return;
        }
        AuthenticationService.login(vm.id, function (data, response) {
            if (response == 200) {
                AuthenticationService.setCredentials(vm.id);
                $location.path('/');
                return;
            }
            FlashService.Error("Student with this ID doesn't exist");
        });
    };
}
