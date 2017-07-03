
(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.user')
        .controller('UserCtrl', UserCtrl);

    /** @ngInject */
    function UserCtrl($scope,$stateParams,$state,UserService,RoleService,DictService) {

        var kt = this;
        kt.user = {};
        kt.user.rolelist = [];
        kt.statuses = [];

        if($stateParams.isView){
            kt.isView = true;
        }else{
            kt.isView = false;
        }
        if($stateParams.id){
            UserService.getInfo({id:$stateParams.id},
                function (data) {
                kt.user = data;
            })
        }else{
            kt.isAdd = true;
        }
        DictService.getList('USERSTATUS',function (data) {
            kt.statuses = data.result;
            kt.isShowStatus = true;
        });
        RoleService.getList({userId:$stateParams.id},function (data) {
            kt.user.rolelist = data.result;
        })
        kt.save = function () {
            UserService.save(kt.user,function (data) {
                $state.go('sys.user');
            });
        }
        kt.arePasswordsEqual = function () {
            return kt.user.password == kt.password;
        };
    }

})();
