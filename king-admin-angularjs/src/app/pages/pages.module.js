(function () {
    'use strict';

    angular.module('KingAdmin.pages', [
        'ui.router',
        'KingAdmin.pages.config',
        'KingAdmin.pages.home',
        'KingAdmin.pages.common',
        'KingAdmin.pages.sys',
        'KingAdmin.pages.dict',

    ])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($urlRouterProvider) {
        $urlRouterProvider.otherwise("/home");

    }

})();
