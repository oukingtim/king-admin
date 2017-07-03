(function () {
    'use strict';

    angular.module('KingAdmin.pages.config')
        .factory('stateHandler', stateHandler);

    /** @ngInject */
    function stateHandler($rootScope, $state,$window, $location,toastr, hasPermsService) {
        return {
            initialize: initialize
        };

        function initialize() {

            var stateChangeStart = $rootScope.$on('$stateChangeStart', function (event, toState, toStateParams, fromState) {
                $rootScope.toState = toState;
                $rootScope.toStateParams = toStateParams;
                $rootScope.fromState = fromState;

                if (toState.external) {
                    event.preventDefault();
                    $window.open(toState.url, '_self');
                }

                if (toState.name != 'home' && !hasPermsService.hasPermission(toState.name)) {
                    toastr.warning("没有权限访问该页面", "提示", {"progressBar": true,});
                    $location.path('/home');
                }


            });

            var stateChangeSuccess = $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {

            });

            $rootScope.$on('$destroy', function () {
                if (angular.isDefined(stateChangeStart) && stateChangeStart !== null) {
                    stateChangeStart();
                }
                if (angular.isDefined(stateChangeSuccess) && stateChangeSuccess !== null) {
                    stateChangeSuccess();
                }
            });
        }
    }
})();
