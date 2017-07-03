(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.menu')
        .controller('MenuCtrl', MenuCtrl);

    /** @ngInject */
    function MenuCtrl($scope, $stateParams, $state,$uibModalInstance, MenuService,DictService) {

        var kt = this;
        kt.menu = {};
        if ($stateParams.isAdd) {
            kt.isAdd = true;
        } else {
            kt.isAdd = false;
        }

        kt.types = [];
        if (!kt.isAdd&&$stateParams.id) {
            MenuService.getInfo({id: $stateParams.id},
                function (data) {
                    kt.menu = data;
                })
        } else {
            kt.menu.parentId = $stateParams.id;
        }
        DictService.getList('MENUTYPE',function (data) {
            kt.types = data.result;
            kt.isShowType = true;
        });
        kt.save = function () {
            MenuService.save(kt.menu,function (data) {
                $uibModalInstance.close(true);
            });
        }
    }

})();
