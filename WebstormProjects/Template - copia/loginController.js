var app = angular.module('loginModule',["ngRoute","ngResource","jlareau.pnotify"])
    .controller('loginController', function($scope,notificaciones, $http) {

        // modelo de datos.
        $scope.username = "";
        $scope.password = "";




        $scope.log = function() {


            var user = $("#email").val();
            var passs = $("#pass").val();

            //notificaciones.notificacion2(user,user+" "+passs,"bien");
            var ur = "http://172.24.42.190/estudiantes/estudiante/" + user + "/" + passs;
            $http({
                method: "GET",
                url: ur,
            }).then(function mySucces(response) {

                var datos = response.data;
                console.log("work");
                if (datos.carne != "0") {
                        $(location).attr('href',"http://172.24.42.190:8012/Template/users/MainView.html#/user");
                   // window.location.replace("http://172.24.42.190:8012/Template/users/MainView.html#/user")
                }
                else {
                    notificaciones.notificacion2("Error", "Datos inconsistentes", "ojo");
                }


            });
        }

        /**
         * Ejecuta el inicio de sesión.
         */
        $scope.doLogin = function () {
            $http({
                method: "GET",
                url: 'http://transportec.azurewebsites.net/user/login/web?username={0}&password={1}'
                    .format(Base64.toBase64($scope.username, true).toString(), Base64.toBase64($scope.password, true).toString())
            }).then(function mySucces(response) {
                console.log(response.data);
                var meta = response.data.metadata;
                if (meta.operationResult == "OK") {

                    var content = response.data.content;
                    console.log(content);
                    var userData = content.owner;
                    console.log(userData);
                    saveSession(content);

                    window.location.href = ('{0}/MainView.html'.format(userData.userType == "Customer" ? "users" : "admin"));
                } else {
                    alert("Credenciales incorrectas");
                }
            });
        }

        /**
         * Guarda la sesión en el almacenamiento local del navegador.
         * @param json JSON de origen.
         */
        function saveSession(json) {
            localStorage.setItem("session.token", json.token);
            localStorage.setItem("session.user", JSON.stringify(json.owner));
            console.log("Sesión guardada.");
        }
    });