(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.user', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('sys.user', {
                url: '/user',
                templateUrl: 'app/pages/sys/user/userlist.html',
                controller: 'UserListCtrl',
                controllerAs: 'kt',
                title: '用户管理',
                sidebarMeta: {
                    order: 0,
                    icon: 'ion-grid',
                },
            }).state('sys.user.add', {
            url: '/add',
            title: '新增用户',
            views: {
                '@': {
                    templateUrl: 'app/pages/sys/user/user.html',
                    controller: 'UserCtrl',
                    controllerAs: 'kt',
                }
            }
            }).state('sys.user.edit', {
                url: '/edit/:id',
                title: '编辑用户',
                views: {
                    '@': {
                        templateUrl: 'app/pages/sys/user/user.html',
                        controller: 'UserCtrl',
                        controllerAs: 'kt',
                    }
                }
            }).state('sys.user.view', {
                url: '/view/:id?isView',
                title: '查看用户',
                views: {
                    '@': {
                        templateUrl: 'app/pages/sys/user/user.html',
                        controller: 'UserCtrl',
                        controllerAs: 'kt',
                    }
                }
            });
        $urlRouterProvider.when('/sys', '/sys/user');
    }

})();
