//controller for Registration
app.controller("registerController", function ($scope, $http) {
    // Customer object    
    $scope.customer = {
        firstName: "",
        lastName: "",
        username: "",
        password: "",
        email: "",
        companyName: "",
        address: "",
        city: "",
        region: "",
        postlaCode: "",
        phone: ""

    }

    //User object
    $scope.user = {
        firstName: "",
        lastName: "",
        email: "",
        username: "",
        password: "",
        address: "",
    }

    // Registration of User
    $scope.registerUser = function () {
        $http({
            method: "POST",
            url: "/api/auth/user/sign-up",
            data: $scope.user
        });
    }

    // Registration of Customer
    $scope.registerCustomer = function () {
        $http({
            method: "POST",
            url: "/api/auth/customer/sign-up",
            data: $scope.customer
        });
    }
});

// controller for product
app.controller("productController", function ($scope, $http) {
    $scope.product = {
        productName: "",
        description: "",
        category: "",
        color: "",
        quantityPerUnit: "",
        unitPrice: "",
        unitWeight: "",
        unitInStock: ""
    }

    $scope.id = {};

    $scope.products = [];

    $scope.create = function () {
        $http({
            method: "POST",
            url: "/api/product/create",
            data: $scope.product
        });
    }

    $scope.page = function () {
        $http({
            method: "GET",
            url: "/api/product/list-products",
        }).then(function successCallback(response) {
            $scope.products = response.data;
            console.log(products)
        });
    }

    $scope.deleteUser = function () {
        $http({
            method: "DELETE",
            url: "/api/product/delete/" + $scope.id,

        })
    }

});

//authController
app.controller("authController", function ($scope, $http) {
    $scope.user = {
        username: "",
        password: "",
    }
    $scope.signIn = function () {
        $http({
            method: "POST",
            url: "/api/auth/sign-in",
            data: $scope.user
        });
    }
});