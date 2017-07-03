(function () {
    'use strict';

    angular.module('KingAdmin.pages.dict', [
        'KingAdmin.pages.dict.dict',
        'KingAdmin.pages.dict.dictclass',
    ]).config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('dict', {
                url: '/dict',
                template: '<ui-view></ui-view>',
                abstract: true,
                title: '字典管理',
                sidebarMeta: {
                    icon: 'ion-grid',
                    order: 300,
                },
            });
    }

})();
