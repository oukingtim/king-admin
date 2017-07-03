/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('KingAdmin.pages.home')
      .directive('homeTodo', homeTodo);

  /** @ngInject */
  function homeTodo() {
    return {
      restrict: 'EA',
      controller: 'TodoControlller',
      templateUrl: 'app/pages/home/todo/todo.html'
    };
  }
})();