var app = angular.module('App', ['ngRoute']);
app.config(function ($routeProvider) {
    $routeProvider
    .when('/web/sign-in', {
        templateUrl: '/template/login.html',
        controller: "authController"
    })
    .when('/web/customer/sign-up', {
        templateUrl: '/template/customer.html',
        controller: "registerController"
    })
    .when('/web/customer/update', {
        templateUrl: '/template/customer.html',
        controller: "registerController"
    })
    .when('/web/user/sign-up', {
        templateUrl: '/template/user.html',
        controller: "registerController"
    })
    .when('/web/user/update', {
        templateUrl: '/template/user.html',
        controller: "registerController"
    })
    .when('/web/product/create', {
        templateUrl: '/template/product.html',
        controller: 'productController'
    })
    .when('/web/product/get', {
        templateUrl: '/template/page.html',
        controller: "productController"
    })
    .when('/web/product/update', {
        templateUrl: '/template/updateProduct.html',
        controller: "productController"
    })
    .otherwise({
        redirectTo: '',
        templateUrl: '/template/menu.html',
    });
});