/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
    'use strict';

    angular.module('KingAdmin.theme.components')
        .controller('MsgCenterCtrl', MsgCenterCtrl);

    /** @ngInject */
    function MsgCenterCtrl($scope, TodoService, CalendarService) {

        $scope.todoList = [];
        $scope.calendarList = [];
        $scope.refeshTodo = function () {

            TodoService.getList({}, function (data) {
                $scope.todoList = data.result;
            });

        }
        $scope.refeshCalendar = function () {

            CalendarService.getList({}, function (data) {
                $scope.calendarList = data.result;
            });
        }
        $scope.refeshTodo();
        $scope.refeshCalendar();
    }
})();