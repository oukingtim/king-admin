/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('KingAdmin.pages.common', [
      'kt-angular-loading-bar',
      // 'ngAutodisable',
  ])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig(ktCfpLoadingBarProvider) {
      ktCfpLoadingBarProvider.latencyThreshold = 1;
      ktCfpLoadingBarProvider.includeSpinner = false;
  }

})();
