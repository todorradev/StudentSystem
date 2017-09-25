angular
    .module('app')
    .controller('HomeController', HomeController);

HomeController.$inject = ['StudentService', '$rootScope', 'FlashService'];

function HomeController(StudentService, $rootScope, FlashService) {
    var vm = this;

    vm.id = $rootScope.globals.currentStudent.id
    vm.student = null;
    vm.allStudents = [];
    vm.createStudent = createStudent;
    vm.updateStudent = updateStudent;
    vm.deleteStudent = deleteStudent;

    loadCurrentStudent();
    loadAllStudents();

    function loadCurrentStudent() {
        StudentService.getById($rootScope.globals.currentStudent.id)
            .then(function (data) {
                if (data.message != null)
                    FlashService.Error(data.message);
                else {
                    vm.student = data;
                    loadAllStudents();
                }
            });
    }

    function loadAllStudents() {
        StudentService.getAll()
            .then(function (data) {
                if (data.message != null)
                    FlashService.Error(data.message);
                else
                    vm.allStudents = data;
            });
    }

    function createStudent(student) {
        StudentService.create(student)
            .then(function (data) {
                if (data.message != null)
                    FlashService.Error(data.message);
                else {
                    loadCurrentStudent();
                    loadAllStudents();
                }
            });
    }

    function updateStudent(student) {
        StudentService.update(student)
            .then(function (data) {
                if (data.message != null)
                    FlashService.Error(data.message);
                else {
                    loadCurrentStudent();
                    loadAllStudents();
                }
            });
    }

    function deleteStudent(id) {
        StudentService.deleteStudent(id)
            .then(function (data) {
                if (data.message != null)
                    FlashService.Error(data.message);
                else {
                    loadCurrentStudent();
                    loadAllStudents();
                }
            });
    }
}