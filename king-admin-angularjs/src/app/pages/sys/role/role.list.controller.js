(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.role')
        .controller('RoleListCtrl', RoleListCtrl);

    /** @ngInject */
    function RoleListCtrl($scope, RoleService) {

        var kt = this;
        kt.rolelist = [];
        kt.LoadPage = function (tableState) {
            tableState = tableState || kt.tableState;
            tableState.pagination.number = tableState.pagination.number || 5;
            RoleService.getSmartData(tableState,
                function (data) {
                    tableState.pagination.numberOfPages = data.result.pages;
                    tableState.pagination.totalItemCount = data.result.total;
                    kt.tableState = tableState;
                    kt.rolelist = data.result.records;
                });

        };
        //删除
        kt.del = function (id) {
            RoleService.del({id: id},
                function (data) {
                    kt.LoadPage();
                })
        };
        kt.checkboxes = {
            checked: false,
            items: {}
        };
        $scope.$watch('kt.checkboxes.checked', function (value) {
            angular.forEach(kt.rolelist, function (item) {
                kt.checkboxes.items[item.id] = value;
            });
        });
    }

})();
