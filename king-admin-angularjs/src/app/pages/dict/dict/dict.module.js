(function () {
    'use strict';

    angular.module('KingAdmin.pages.dict.dict', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('dict.dict', {
                url: '/dict',
                templateUrl: 'app/pages/dict/dict/dictlist.html',
                controller: 'DictListCtrl',
                controllerAs: 'kt',
                title: '字典管理',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();
