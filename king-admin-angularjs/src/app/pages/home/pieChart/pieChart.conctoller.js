/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('KingAdmin.pages.home')
      .controller('PieChartControlller', PieChartControlller);

  /** @ngInject */
  function PieChartControlller($scope, $timeout,$http, baConfig, baUtil) {
      function getMetrics () {
          return $http.get('management/metrics').then(function (response) {
              $scope.metrics = response.data;
              $scope.charts = [
                  {
                      color: pieColor,
                      description: '内存',
                      stats: $scope.metrics['mem'],
                      icon: 'refresh',
                  },{
                      color: pieColor,
                      description: '线程',
                      stats: $scope.metrics['threads'],
                      icon: 'person',
                  }, {
                      color: pieColor,
                      description: '加载类',
                      stats: $scope.metrics['classes'],
                      icon: 'money',
                  }, {
                      color: pieColor,
                      description: '登录次数',
                      stats: $scope.metrics['counter.status.200.api.login'],
                      icon: 'face',
                  }
              ];
          });
      }
      getMetrics()
    var pieColor = baUtil.hexToRGB(baConfig.colors.defaultText, 0.2);


    function getRandomArbitrary(min, max) {
      return Math.random() * (max - min) + min;
    }

    function loadPieCharts() {
      $('.chart').each(function () {
        var chart = $(this);
        chart.easyPieChart({
          easing: 'easeOutBounce',
          onStep: function (from, to, percent) {
            $(this.el).find('.percent').text(Math.round(percent));
          },
          barColor: chart.attr('rel'),
          trackColor: 'rgba(0,0,0,0)',
          size: 84,
          scaleLength: 0,
          animation: 2000,
          lineWidth: 9,
          lineCap: 'round',
        });
      });

      $('.refresh-data').on('click', function () {
        updatePieCharts();
      });
    }

    function updatePieCharts() {
      $('.pie-charts .chart').each(function(index, chart) {
        $(chart).data('easyPieChart').update(getRandomArbitrary(55, 90));
      });
    }

    $timeout(function () {
      loadPieCharts();
      updatePieCharts();
    }, 1000);
  }
})();