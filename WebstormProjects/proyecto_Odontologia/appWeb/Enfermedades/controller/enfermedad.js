
angular.module('proyodonto')
    .controller("enfermedadCtrl", function($scope, $location, notificaciones,$http) {
        $scope.infermedades = [];
        $scope.getEnfermedades = function getEnfermedades() {
            console.log("Entra");
            var ur="http://172.24.47.245/Enfermedades";
            $http({
                method: "GET",
                url: ur
            }).then(function mySucces(response) {

                var data=response.data;
                $scope.infermedades=response.data;
            });
        };

        $scope.setEnfermedades =  function setEnfermedades() {
            var name = $("#enfermedad").val();
            var des = $("#descripcion").val();
            var tra = $("#tratamiento").val();

            var datos = "{ 'enfermedad' :'" + name + "', 'descripcion' : '" + des + "', 'tratamiento' : '" + tra + "' }";
            console.log(datos);
            var ur = "http://172.24.46.253/Enfermedades/Enfermedad";
            console.log(ur);
            if (confirm('Está seguro de insertar la Enfermedad?')) {
                $http({
                    method: "POST",
                    url: ur,
                    data: datos
                }).then(function mySucces(response) {
                    console.log("dcndskncncsk")
                });
            }

        };

        $scope.editEnfermedades =  function editEnfermedades(enfermedad) {

            var id = $("#edit-form-id").val();
            var name = $("#edit-form-enfermedad").val();
            var des = $("#edit-form-descripcion").val();
            var tra = $("#edit-form-tratamiento").val();

            var datos = "{ 'idEnfermedad' : '"+id+"','enfermedad' :'" + name + "', 'descripcion' : '" + des + "', 'tratamiento' : '" + tra + "' }";
            console.log(datos);
            var ur = "http://172.24.46.253/Enfermedades2/Enfermedad2";
            console.log(ur);
            if (confirm('Está seguro de editar la Enfermedad?')) {
                $http({
                    method: "POST",
                    url: ur,
                    data: datos
                }).success(function (result) {


                    alert("si ");

                }).error(function(err){
                    alert("No ");
                })
            }

        };


        $scope.deleteEnfermedad = function deleteEnfermedad(variable){
            var id = variable;
            var url = 'http://172.24.46.253/Enfermedades/Enfermedad/'+id;
            console.log(url);
            if (confirm('Seguro de borrar la enfermedad?')) {
                $http({
                    method: 'GET',
                    url: url,

                    success: function (result) {
                        console.log('Deleting enfermedad...');
                    },
                    error: function (err) {
                        console.log(err);
                    }

                });
            }
        };

        $scope.editarEnfermedad = function editarEnfermedad(enfermedad) {

            $('#edit-form-id').val(enfermedad.idEnfermedad);

            $('#edit-form-enfermedad').val(enfermedad.Enfermedad);//($(this).data('enfermedad'));

            $('#edit-form-descripcion').val(enfermedad.descripcion);

            $('#edit-form-tratamiento').val(enfermedad.tratamiento);

        };

        $scope.getEnfermedades();

    });