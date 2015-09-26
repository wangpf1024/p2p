var app=angular.module('welcome', []);

app.controller('company', function($scope, $http){
    $http.get('static/data/index.json').
        success(function(data) {
            $scope.company = data
        });
});