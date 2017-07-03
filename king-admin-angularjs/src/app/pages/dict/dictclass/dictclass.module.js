(function () {
    'use strict';

    angular.module('KingAdmin.pages.dict.dictclass', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('dict.dictclass', {
                url: '/dictclass',
                templateUrl: 'app/pages/dict/dictclass/dictclasslist.html',
                controller: 'DictClassListCtrl',
                controllerAs: 'kt',
                title: '字典分类',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();
