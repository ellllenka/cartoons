
app = angular.module('cartoonsApp', []);

app.controller('CartoonsListCtrl', ['$scope', '$http', function($scope, $http) {

    function upd(){
        $scope.cartoons = [];
        var cartoon;
        var categories;
        $http.get('/cartoons').then(function success(responce){
            for(var i=0; i<responce.data.length; i++){
                cartoon = responce.data[i];
                categories = '';
                for(var j=0; j<responce.data[i].categories.length; j++){
                    categories += responce.data[i].categories[j].name+',';
                };
                cartoon.categories = categories;
                cartoon.selected = false;
                $scope.cartoons.push(cartoon);
            }
        });
    }

    $scope.addCartoon = function(){
        var cartoon = {
            name : $scope.name,
            link : $scope.link,
            priority : $scope.priority,
            categories : $scope.categories.split(',')
        };

        $http.post('/cartoon', cartoon).then(function success(responce){
            $scope.cartoons.push(cartoon);
        })
    }

    $scope.deleteCartoon = function(){
        for(var i=0; i<$scope.cartoons.length; i++){
            if ($scope.cartoons[i].selected){
                $http.delete('/cartoon/'+$scope.cartoons[i].id);
            }
        }
        upd();
    }

    $scope.setViewed = function(){
        for(var i=0; i<$scope.cartoons.length; i++){
            if ($scope.cartoons[i].selected){
                $http.put('/cartoon/viewed/'+$scope.cartoons[i].id,[],
                    {
                        params : {viewed : true}
                    });
            }
        }
        upd();
    }

    upd();
}]);
