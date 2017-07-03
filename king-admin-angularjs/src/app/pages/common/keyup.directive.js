
(function () {
  'use strict';

  angular.module('KingAdmin.pages.common')
    .directive('inputKeyup', inputKeyup);

  /** @ngInject */
  function inputKeyup () {
      return {
          restrict: 'AE',
          scope: {
              inputKeyup:'=',
          },
          link: function(scope, element, attrs) {
              element.on('keyup',function(e){
                 var keycode = window.event?e.keyCode:e.which
                 if(keycode==13){//回车
                  scope.inputKeyup();
                 }
              })

          }
          
      }
    }
})();