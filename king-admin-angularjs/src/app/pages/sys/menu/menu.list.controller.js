(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.menu')
        .controller('MenuListCtrl', MenuListCtrl);

    /** @ngInject */
    function MenuListCtrl($scope, $state, $timeout, MenuService, DictService) {

        var kt = this;
        kt.menulist = [];
        kt.types = [];
        DictService.getList('MENUTYPE', function (data) {
            kt.types = data.result;
            kt.isShowType = true;
        });
        //删除
        kt.del = function (id) {
            MenuService.del({id: id},
                function (data) {
                    $state.go('sys.menu', null, {reload: true});
                })
        };

        MenuService.getMenuTree({roleId:''}, function (data) {
            kt.treeData = data.result;
            kt.treeshow = true;
            $timeout(function () {
                kt.basicTree.bind("select_node.jstree", function (event, data) {
                    kt.selectNode(data.node);
                })
            }, 500)
        });
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
            "checkbox": {
                "keep_selected_style": false
            },
            'plugins': ['types', "wholerow"],
            'version': 1
        };

        kt.selectNode = function (node) {
            MenuService.getInfo({id: node.original.id},
                function (data) {
                    kt.menu = data;
                    kt.isShowBtn = true;
                    if (node.children.length > 0) {
                        kt.isShowDelBtn = true;
                    } else {
                        kt.isShowDelBtn = false;
                    }
                    if (kt.menu.type == '2') {
                        kt.isShowAddBtn = true;
                    } else {
                        kt.isShowAddBtn = false;
                    }
                })
        };

    }

})();
