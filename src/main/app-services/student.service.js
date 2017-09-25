angular
    .module('app')
    .factory('StudentService', StudentService);

StudentService.$inject = ['$http', '$q', '$location'];

function StudentService($http) {
    var service = {};
    const configUrl = location.protocol + "//" + location.hostname + ":" + 8080 + '/api/students/'; //this will not work for ipv6!
    const deleteStudentConfigUrl = location.protocol + "//" + location.hostname + ":" + 8080 + '/api/delete/student/'; //this will not work for ipv6!

    service.getAll = getAll;
    service.getById = getById;
    service.create = create;
    service.update = update;
    service.deleteStudent = deleteStudent;

    return service;

    function getAll() {
        return $http.get(configUrl).then(handleSuccess, handleError('Error getting all students'));
    }

    function getById(id) {
        if (id === 'admin') {
            id = 1;
        }
        return $http.get(configUrl + id).then(handleSuccess, handleError('Error loading the logged in student.'));
    }

    function deleteStudent(id) {
        return $http.delete(deleteStudentConfigUrl + id).then(handleSuccess, handleError('Error deleting this user.'));
    }

    function create(student) {
        return $http.post(configUrl, student).then(handleSuccess, handleError('Student with the same id already exists'));
    }

    function update(student) {
        return $http.put(configUrl, student).then(handleSuccess, handleError('Error updating student'));
    }

    function handleSuccess(res) {
        return res.data;
    }

    function handleError(error) {
        return function () {
            return {success: false, message: error};
        };
    }
}
