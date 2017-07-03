(function () {
    'use strict';

    angular.module('KingAdmin.pages.dict.dictclass')
        .controller('DictClassListCtrl', DictClassListCtrl);

    /** @ngInject */
    function DictClassListCtrl($scope, toastr, DictClassService) {
        var kt = this;
        kt.dictlist = [];
        kt.addRow = function () {
            kt.inserted = {
                id: null,
                code: null,
                remark: null,
            };
            kt.dictlist.push(kt.inserted);
        }
        kt.save = function (dict) {
            if (dict.code == null || dict.code == '') {
                toastr.warning('编号不能为空', "提示:", {"progressBar": true,});
                return;
            }
            DictClassService.save(dict,function (data) {
                kt.LoadPage();
            });
        }

        kt.LoadPage = function (tableState) {
            tableState = tableState || kt.tableState;
            tableState.pagination.number = tableState.pagination.number || 5;
            DictClassService.getSmartData(tableState,
                function (data) {
                    tableState.pagination.numberOfPages = data.result.pages;
                    tableState.pagination.totalItemCount = data.result.total;
                    kt.tableState = tableState;
                    kt.dictlist = data.result.records;
                });
        };

        //删除
        kt.del = function (id) {
            if(id==null){
                kt.LoadPage();
                return;
            }
            DictClassService.del({id: id},
                function (data) {
                    kt.LoadPage();
                })
        };
        kt.checkboxes = {
            checked: false,
            items: {}
        };
        $scope.$watch('kt.checkboxes.checked', function (value) {
            angular.forEach(kt.dictlist, function (item) {
                kt.checkboxes.items[item.id] = value;
            });
        });

    }

})();
