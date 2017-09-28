angular.module('app.controllers', []).controller('IzdelekListController', function($scope, $state, popupService, $window, Izdelek) {
  $scope.izdelki = Izdelek.query(); //fetch all izdelki. Issues a GET to /api/vi/izdelki

  $scope.deleteIzdelek = function(izdelek) { // Delete a izdelek. Issues a DELETE to /api/v1/izdelek/:id
    if (popupService.showPopup('Ste prepričani da želite izbrisati izdelek?')) {
      izdelek.$delete(function() {
        $scope.izdelki = Izdelek.query(); 
        $state.go('izdelki');
      });
    }
  };
}).controller('IzdelekViewController', function($scope, $stateParams, Izdelek) {
  $scope.izdelek = Izdelek.get({ id: $stateParams.id }); //Get a single Izdelek.Issues a GET to /api/v1/izdelki/:id
}).controller('IzdelekCreateController', function($scope, $state, $stateParams, Izdelek) {
  $scope.izdelek = new Izdelek();  //create new izdelek instance. Properties will be set via ng-model on UI

  $scope.addIzdelek = function() { //create a new izdelek. Issues a POST to /api/v1/izdelki
    $scope.izdelek.$save(function() {
      $state.go('izdelki'); // on success go back to the list i.e. izdelki state.
    });
  };
}).controller('IzdelekEditController', function($scope, $state, $stateParams, Izdelek) {
  $scope.updateIzdelek = function() { //Update the edited Izdelek. Issues a PUT to /api/v1/izdelek/:id
    $scope.izdelek.$update(function() {
      $state.go('izdelki'); // on success go back to the list i.e. izdelki state.
    });
  };

  $scope.loadIzdelek = function() { //Issues a GET request to /api/v1/izdelek/:id to get a izdelek to update
    $scope.izdelek = Izdelek.get({ id: $stateParams.id });
  };

  $scope.loadIzdelek(); // Load a Izdelek which can be edited on UI
});
