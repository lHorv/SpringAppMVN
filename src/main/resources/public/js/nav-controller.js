angular.module('navController', [])
	.controller('nav', function($scope, $state) {
		$scope.title = 'Izdelki';

		// returns true if the current router url matches the passed in url
		// so views can set 'active' on links easily
		$scope.isUrl = function(url) {
			if (url === '#') return false;
			return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
		};

		$scope.pages = [
			{
				name: 'Home',
				url: '#/'
			},
			{
				name: 'Izdelki',
				url: '#/izdelki'
			}
		]
	});