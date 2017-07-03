(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.role', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('sys.role', {
                url: '/role',
                templateUrl: 'app/pages/sys/role/rolelist.html',
                controller: 'RoleListCtrl',
                controllerAs: 'kt',
                title: '角色管理',
                sidebarMeta: {
                    order: 1,
                },
            }).state('sys.role.add', {
            url: '/add',
            title: '新增角色',
            views: {
                '@': {
                    templateUrl: 'app/pages/sys/role/role.html',
                    controller: 'RoleCtrl',
                    controllerAs: 'kt',
                }
            }
        }).state('sys.role.edit', {
            url: '/edit/:id',
            title: '编辑角色',
            views: {
                '@': {
                    templateUrl: 'app/pages/sys/role/role.html',
                    controller: 'RoleCtrl',
                    controllerAs: 'kt',
                }
            }
        }).state('sys.role.view', {
            url: '/view/:id?isView',
            title: '查看角色',
            views: {
                '@': {
                    templateUrl: 'app/pages/sys/role/role.html',
                    controller: 'RoleCtrl',
                    controllerAs: 'kt',
                }
            }
        });
    }

})();
