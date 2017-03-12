angular.module('comment', [])
    .controller('CommentController',
    function($scope, $http) {
        $scope.comments = [];

        $scope.form = {
            author : "",
            article : "",
            title : "",
            text : ""
        };
        $scope.form1 = {
            author : "",
            article : "",
            title : "",
            text : "",
            parent: ""
        };
        _refresh();

        $scope.processForm = function() {
            $scope.showTheForm1 = false;
            $scope.showTheForm = true;
        }

        $scope.postComment = function() {
            var method = 'POST';
            var url = 'http://localhost:8082/rest-data/comments/';
            $http({
                method : method,
                url : url,
                data : angular.toJson($scope.form),
                headers : {
                    'Content-Type' : 'application/json'
                }
            }).then(_refresh());
            _cleanForm();

        };

        $scope.postSubComment = function(comment) {
            var method = 'POST';
            var url = 'http://localhost:8082/rest-data/comments/';
            $scope.form1.parent = comment._links.self.href;
            $http({
                method : method,
                url : url,
                data : angular.toJson($scope.form1),
                headers : {
                    'Content-Type' : 'application/json'
                }
            }).then(_refresh());
            _cleanForm1();
        };

        $scope.doRefresh = function() {
            _refresh();
        };


        function _cleanForm(){
            $scope.form = {
                author : "",
                article : "",
                title : "",
                text : ""
            };
        }

        function _cleanForm1(){
            $scope.form1 = {
                author : "",
                article : "",
                title : "",
                text : "",
                parent: ""
            };
        }

        function _refresh() {
            $http({
                method: 'GET',
                url: 'http://localhost:8082/rest-data/comments?sort=path'
            }).then(function successCallback(response) {
                $scope.comments = response.data._embedded.comments;
            });
        }
    });