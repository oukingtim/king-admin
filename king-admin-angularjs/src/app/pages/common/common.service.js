
(function () {
  'use strict';

  angular.module('KingAdmin.pages.common')
      .factory('CommonService', CommonService);

  /** @ngInject */
  function CommonService($uibModal) {
      function show(page, size,controller,items,callbackFunc) {
          $uibModal.open({
              animation: true,
              templateUrl: page,
              controller : controller || 'CommomCtrl',
              size: size || 'sm',
              resolve: {
                  items: function () {
                      return items;
                  }
              }
          }).result.then(function(opParams){
              return callbackFunc(opParams);
          });
      };
      function common(items,callbackFunc,page){
          show(page, 'sm','CommomCtrl',items,callbackFunc)
      }
      function info(items,callbackFunc){
          common(items,callbackFunc,'app/pages/common/modalTemplates/infoModal.html')
      };
      function success(items,callbackFunc){
          common(items,callbackFunc,'app/pages/common/modalTemplates/successModal.html')
      };
      function warning(items,callbackFunc){
          common(items,callbackFunc,'app/pages/common/modalTemplates/warningModal.html')
      };
      function danger(items,callbackFunc){
          common(items,callbackFunc,'app/pages/common/modalTemplates/dangerModal.html')
      };
      return{
          show:show,
          info:info,
          success:success,
          warning:warning,
          danger:danger
      }
  }

})();
