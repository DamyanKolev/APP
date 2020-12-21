app.controller("registerCustomerController", function ($scope, $http) {
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
    $scope.register = function () {
        $http({
            method: "POST",
            url: "/api/user/",
            data: $scope.customer
        });
    }
});


app.controller("registerProductController", function ($scope, $http) {
    $scope.product = {
        name: "",
        description: "",
        quantityPerUnit: "",
        unitPrice: "",
        unitWeight: "",
        unitInStock: ""
    }
    $scope.register = function () {
        $http({
            method: "POST",
            url: "/api/product/",
            data: $scope.customer
        });
    }
});

app.controller("userLogin", function ($scope, $http) {
    $scope.user = {
        username: "",
        password: "",
    }
    $scope.login = function () {
        $http({
            method: "GET",
            url: "/api/user/login",
            data: $scope.customer
        });
    }
});