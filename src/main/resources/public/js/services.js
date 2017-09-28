angular.module('app.services', []).factory('Izdelek', function($resource) {
  return $resource('/api/v1/izdelki/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
