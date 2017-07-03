/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('KingAdmin.pages.home')
      .directive('homePieChart', homePieChart);

  /** @ngInject */
  function homePieChart() {
    return {
      restrict: 'E',
      controller: 'PieChartControlller',
      templateUrl: 'app/pages/home/pieChart/pieChart.html'
    };
  }
})();