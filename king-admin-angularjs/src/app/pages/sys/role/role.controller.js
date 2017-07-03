
(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.role')
        .controller('RoleCtrl', RoleCtrl);

    /** @ngInject */
    function RoleCtrl($scope,$stateParams,$state,RoleService,MenuService) {

        var kt = this;
        kt.role = {};
        if($stateParams.isView){
            kt.isView = true;
        }else{
            kt.isView = false;
        }

        if($stateParams.id){
            RoleService.getInfo({id:$stateParams.id},
                function (data) {
                kt.role = data;
            })
        }else{
            kt.isAdd = true;
        }
        MenuService.getMenuTree({roleId:$stateParams.id},function (data) {
            kt.treeData = data.result;
            kt.treeshow = true;
        });
        kt.save = function () {

            var checked = kt.basicTree.jstree().get_checked(true);
            console.log(checked);
            kt.role.menuTree = [];
            angular.forEach(checked,function (c) {
                kt.role.menuTree.push(c.original);
            })
            RoleService.save(kt.role,function (data) {
                $state.go('sys.role');
            });
        }
        kt.basicConfig = {
            core: {
                check_callback: true,
                worker: true
            },
            'types': {
                'default': {
                    'icon': false
                }
            },
            "checkbox" : {
                "keep_selected_style" : false
            },
            'plugins': ['types',"wholerow",'checkbox'],
            'version': 1
        };

    }

})();
