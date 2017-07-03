(function () {
    'use strict';

    angular.module('KingAdmin.pages.config', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($httpProvider) {

        $httpProvider.interceptors.push('authExpiredInterceptor');
    }

})();
