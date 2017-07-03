(function () {
    'use strict';

    angular.module('KingAdmin.pages.dict.dict')
        .controller('DictListCtrl', DictListCtrl);

    /** @ngInject */
    function DictListCtrl($scope,$filter, toastr, DictService,DictClassService) {
        var kt = this;
        kt.dictlist = [];
        kt.dictClassList = [];

        DictClassService.getList({},function (data) {
            kt.dictClassList = data.result;
        });
        kt.showClassCode = function(dictClassId) {
            var selected = [];
            if(dictClassId) {
                selected = $filter('filter')(kt.dictClassList, {id: dictClassId});
            }
            return selected.length ? selected[0].code : '请选择分类';
        };
        kt.addRow = function () {
            kt.inserted = {
                id: null,
                dictClassId:'',
                code: null,
                text: null,
                remark: null,
            };
            kt.dictlist.push(kt.inserted);
        }
        kt.save = function (dict) {
            if (dict.code == null || dict.code == '') {
                toastr.warning('编号不能为空', "提示:", {"progressBar": true,});
                return;
            }
            DictService.save(dict,function (data) {
                kt.LoadPage();
            });
        }

        kt.LoadPage = function (tableState) {
            tableState = tableState || kt.tableState;
            tableState.pagination.number = tableState.pagination.number || 5;
            DictService.getSmartData(tableState,
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
            DictService.del({id: id},
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
