var app=angular.module('welcome', []);

app.controller('company', function($scope, $http){
    $http.get('indexRest.do').
        success(function(data) {
            console.log(data);
            $scope.company = data
    });
});