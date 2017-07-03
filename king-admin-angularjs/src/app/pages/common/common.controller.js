
(function () {
    'use strict';

    angular.module('KingAdmin.pages.common')
        .controller('CommomCtrl', CommomCtrl);

    /** @ngInject */
    function CommomCtrl($scope,$uibModalInstance,items,UserService) {
        $scope.items = items;
        $scope.user = {};
        $scope.save = function () {
            UserService.password($scope.user,function (data) {
                $uibModalInstance.close(true);
            });
        }
        $scope.arePasswordsEqual = function () {
            return $scope.user.newpassword == $scope.newpassword;
        };
    }

})();
