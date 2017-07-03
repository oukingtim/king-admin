(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.user')
        .controller('UserListCtrl', UserListCtrl);

    /** @ngInject */
    function UserListCtrl($scope, $filter, UserService,DictService) {

        var kt = this;
        kt.userlist = [];
        kt.status = [];
        DictService.getList('USERSTATUS',function (data) {
            kt.status = data.result;
        });
        kt.LoadPage = function (tableState) {
            tableState = tableState || kt.tableState;
            tableState.pagination.number = tableState.pagination.number || 5;
            UserService.getSmartData(tableState,
                function (data) {
                    tableState.pagination.numberOfPages = data.result.pages;
                    tableState.pagination.totalItemCount = data.result.total;
                    kt.tableState = tableState;
                    kt.userlist = data.result.records;
                });

        };

        kt.showStatus = function (user) {
            var selected = [];
            if (user.status || user.status == 0) {
                selected = $filter('filter')(kt.status, {code: user.status});
            }
            return selected.length ? selected[0].text : 'Not set';
        };

        //删除
        kt.del = function (id) {
            UserService.del({id: id},
                function (data) {
                    kt.LoadPage();
                })
        };
        kt.checkboxes = {
            checked: false,
            items: {}
        };
        $scope.$watch('kt.checkboxes.checked', function (value) {
            angular.forEach(kt.userlist, function (item) {
                kt.checkboxes.items[item.id] = value;
            });
        });
    }

})();
