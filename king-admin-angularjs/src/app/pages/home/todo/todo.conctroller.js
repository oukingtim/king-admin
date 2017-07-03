/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
    'use strict';

    angular.module('KingAdmin.pages.home')
        .controller('TodoControlller', TodoControlller);

    /** @ngInject */
    function TodoControlller($scope, baConfig, TodoService) {

        $scope.transparent = baConfig.theme.blur;

        $scope.newTodoText = '';
        $scope.todoList = [];
        TodoService.getList({},function (data) {
            $scope.todoList = data.result;
        });

        $scope.addToDoItem = function (event, clickPlus) {
            if ((clickPlus || event.which === 13) && $scope.newTodoText != '') {
                TodoService.save({text:$scope.newTodoText},function (data) {
                    $scope.todoList.unshift({
                        text: $scope.newTodoText,
                    });
                    $scope.newTodoText = '';
                })
            }
        };
        $scope.deleleTodo = function (item) {
            TodoService.del({id:item.id},function (data) {
                item.deleted = true
            })
        };
    }
})();