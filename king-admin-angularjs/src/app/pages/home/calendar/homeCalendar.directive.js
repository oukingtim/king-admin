/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('KingAdmin.pages.home')
      .directive('homeCalendar', homeCalendar);

  /** @ngInject */
  function homeCalendar() {
    return {
      restrict: 'E',
      controller: 'CalendarControlller',
      templateUrl: 'app/pages/home/calendar/calendar.html'
    };
  }
})();