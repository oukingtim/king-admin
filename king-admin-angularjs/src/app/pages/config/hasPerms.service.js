(function () {
    'use strict';

    angular.module('KingAdmin.pages.config')
        .factory('hasPermsService', hasPermsService);

    /** @ngInject */
    function hasPermsService($rootScope,$window) {
        var permissionList = [];
        return {
            setPermissions: function (permissions) {
                permissionList = permissions;
                $rootScope.$broadcast('permissionsChanged')
            },
            hasPermission: function (permission) {
                if (permissionList.length ==0){
                    $window.open('auth.html', '_self');
                    return false;
                }
                permission = permission.trim();
                var flag = false;
                for (var i = 0; i < permissionList.length; i++) {
                    if (permission === permissionList[i]) {
                        flag = true;
                        break;
                    }
                }
                return flag;
            }
        };
    }

})();
