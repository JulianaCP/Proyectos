/**
 * Created by Erwin on 25/10/2016.
 */

angular.module('userModule')
    .controller('dashboardCtrl', function($scope,MessageResource) {
    /* config object */

        valor = 5;
    $scope.getMessages=MessageResource.getMessages(valor,function (res) {
        console.log("res ", res);
        $scope.messages=res
    });
        $scope.postMessage=function() {
            MessageResource.setMessage($scope.message);

        }
});