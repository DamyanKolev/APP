var app = angular.module('App', ['ngRoute']);
app.config(function ($routeProvider) {
    $routeProvider.when('/web/customer/', {
        templateUrl: '/template/customer.html',
        controller: "registerCustomerController"
    }).when('/web/product/', {
        templateUrl: '/template/product.html',
        controller: 'registerProductController'
    }).when('/web/sign-in', {
        templateUrl: '/template/login.html',
        // controller: "userLogin"
    }).otherwise({
        redirectTo: '',
        templateUrl: '/template/menu.html',
    });
});