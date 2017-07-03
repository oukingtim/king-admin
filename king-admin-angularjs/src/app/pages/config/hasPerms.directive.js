

(function () {
  'use strict';

  angular.module('KingAdmin.pages.config')
      .directive('hasPerms', hasPerms);

  /** @ngInject */
  function hasPerms(hasPermsService) {
      return {
          link: function(scope, element, attrs) {
              if(!angular.isString(attrs.hasPerms))
                  throw "hasPerms value must be a string";
              var value = attrs.hasPerms.trim();
              var notPermissionFlag = value[0] === '!';
              if(notPermissionFlag) {
                  value = value.slice(1).trim();
              }

              function toggleVisibilityBasedOnPermission() {
                  var hasPermission = hasPermsService.hasPermission(value);

                  if(hasPermission && !notPermissionFlag || !hasPermission && notPermissionFlag)
                      element.show();
                  else
                      element.hide();
              }
              toggleVisibilityBasedOnPermission();
              scope.$on('permissionsChanged', toggleVisibilityBasedOnPermission);
          }
      };
  }


})();