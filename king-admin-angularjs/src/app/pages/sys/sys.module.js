(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys', [
        'KingAdmin.pages.sys.user',
        'KingAdmin.pages.sys.menu',
        'KingAdmin.pages.sys.role',
    ])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('sys', {
                url: '/sys',
                template: '<ui-view></ui-view>',
                abstract: true,
                title: '系统管理',
                sidebarMeta: {
                    icon: 'ion-grid',
                    order: 300,
                },
            });
    }

})();
