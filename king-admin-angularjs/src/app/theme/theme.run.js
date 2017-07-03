/**
 * @author v.lugovksy
 * created on 15.12.2015
 */
(function () {
    'use strict';

    angular.module('KingAdmin.theme')
        .run(themeRun);

    /** @ngInject */
    function themeRun($timeout, $rootScope, layoutPaths, preloader
        , $q, baSidebarService, themeLayoutSettings, stateHandler
        , $window, UserService, hasPermsService) {
        var whatToWait = [
            preloader.loadAmCharts(),
            $timeout(1000)
        ];

        var theme = themeLayoutSettings;
        if (theme.blur) {
            if (theme.mobile) {
                whatToWait.unshift(preloader.loadImg(layoutPaths.images.root + 'blur-bg-mobile.jpg'));
            } else {
                whatToWait.unshift(preloader.loadImg(layoutPaths.images.root + 'blur-bg.jpg'));
                whatToWait.unshift(preloader.loadImg(layoutPaths.images.root + 'blur-bg-blurred.jpg'));
            }
        }
        $rootScope.content = {};
        $q.all(whatToWait).then(function () {
            UserService.isLogin(
                function (data) {
                    if (data.code == '0') {
                        $rootScope.account = data.result.user;
                        $rootScope.menuItems = data.result.menu;
                        hasPermsService.setPermissions(data.result.perms);
                        $rootScope.$pageFinishedLoading = true;
                        stateHandler.initialize();
                    } else {
                        $window.open('auth.html', '_self');
                    }
                }
            );
        });
        $rootScope.$baSidebarService = baSidebarService;
    }

})();