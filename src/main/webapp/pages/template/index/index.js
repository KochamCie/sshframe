var app = angular.module('demo', []);

app.controller('demoController', function($scope,$http) {

    $http({
        url:'user/findAll',
        method:'GET'
    }).success(function(data,header,config,status){
        $scope.users=data.list;
    //响应成功
    }).error(function(data,header,config,status){
    //处理响应失败
    });

});
