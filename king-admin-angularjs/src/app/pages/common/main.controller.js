(function () {
    'use strict';

    angular.module('KingAdmin.pages.common')
        .controller('MainController', MainController);

    /** @ngInject */
    function MainController($scope,$rootScope,$window, UserService,CommonService) {

        $scope.signout = function () {
            UserService.signout({}, function (data) {
                $window.open('auth.html', '_self');
            });
        };

        $scope.password = function () {
            CommonService.show('app/pages/common/modalTemplates/password.html', 'lg','CommomCtrl')
        }


    }
})();

