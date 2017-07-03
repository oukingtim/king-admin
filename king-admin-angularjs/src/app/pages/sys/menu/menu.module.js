(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.menu', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('sys.menu', {
                url: '/menu',
                templateUrl: 'app/pages/sys/menu/menulist.html',
                controller: 'MenuListCtrl',
                controllerAs: 'kt',
                title: '菜单管理',
                sidebarMeta: {
                    order: 3,
                },
            }).state('sys.menu.edit', {
                url: '/edit/:id',
                title: '编辑菜单',
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/pages/sys/menu/menu.html',
                        controller: 'MenuCtrl',
                        controllerAs: 'kt',
                        backdrop: 'static',
                        size: 'lg'
                    }).result.then(function () {
                        $state.go('sys.menu', null, {reload: true});
                    }, function () {
                        $state.go('^');
                    });
                }]
            }).state('sys.menu.add', {
                url: '/add/:id?isAdd',
                title: '新增菜单',
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/pages/sys/menu/menu.html',
                        controller: 'MenuCtrl',
                        controllerAs: 'kt',
                        backdrop: 'static',
                        size: 'lg'
                    }).result.then(function () {
                        $state.go('sys.menu', null, {reload: true});
                    }, function () {
                        $state.go('^');
                    });
                }]
            });
    }

})();
