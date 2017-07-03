
(function () {
  'use strict';

  angular.module('KingAdmin.pages.common')
    .directive('pageSelect', pageSelect);

  /** @ngInject */
  function pageSelect () {
      return {
          restrict: 'E',
          template: '<input type="number" min="1"  class="select-page form-control" ng-model="inputPage" ng-change="selectPage(inputPage)">',
          link: function(scope, element, attrs) {
              scope.$watch('currentPage', function(c) {
                  scope.inputPage = c;
              });
          }
      }
    }
})();