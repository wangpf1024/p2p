var app=angular.module('welcome', []);

app.controller('company', function($scope, $http){
    $http.get('test.do').
        success(function(data) {
            $scope.company = data
        });
});