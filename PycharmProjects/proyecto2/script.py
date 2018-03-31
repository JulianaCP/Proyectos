import cgi
# Headers
print("Content-Type: text/html")
print()
print("""<html>
<head>
		<meta charset = "UTF-8">
		<title>RPoints</title>
		<link rel="stylesheet" href="{{ asset('bootstrap/css/bootstrap.css') }}">

		<style type="text/css">

		.navImage {
				margin: 1%;
				padding-left: 45%;
			}
		#recuadro{
			padding-top: 50%;
			margin-top: 50%;
		}
		#tituloRegistro{

			text-align: center;
			margin-top: 5%;
			margin-bottom: 5%;
		}

		#subTituloRegistro{
			margin-bottom: 5%;
			text-align: center;
			color: #4458BA;
			font-family: fantasy;
		}

		.informacionObligatoria{
			color: red;
		}
		#customerInformation{
			display:none;
		}
		#commerceInformation{
			display:none;
		}

		#inputFile{
			padding-left: 50%;
		}

		#acceptButton{
			padding-left: 50%;
		}

		</style>


	</head>
	<body>
		<header>

			<nav>
				<ul id="navigation" class="nav nav-pills nav-justified bg-primary" id="flotar">
					<li role="presentation"><img src= "{{ asset('img/imagenLogo.png') }}" class= "navImage img-rounded "></li>
				</ul>
			</nav>

		</header>

		<main>



			<script>
				function check()
				{
				    document.getElementById("customerInformation").style.display = "block";
				    document.getElementById("commerceInformation").style.display = "none";
				}
				function uncheck()
				{
				    document.getElementById("customerInformation").style.display = "none";
				    document.getElementById("commerceInformation").style.display = "block";
				}

			</script>

			<div class="container">
				<h1 id="tituloRegistro"><strong>Registry</strong></h1>
				<h3  id="subTituloRegistro">Enter Data to Create Account</h3>
			 	<div class="panel panel-default">
			  		<div class="panel-body">


						{{ Form::open(array('url' => 'usuarioCreate', 'method' => 'POST','class'=>'form-horizontal')) }}

						<form class="form-horizontal" role="form">
							<fieldset class="scheduler-border">
								<legend>Personal Information</legend><br>



								<div class="form-group">

									<label for="nombreCrearCuenta" class="control-label col-sm-2" >Full Name: <strong class="informacionObligatoria">*</strong>  </label>
									<div class="col-xs-4">
									    <input type="text" class="form-control"  placeholder="Enter your Name" name="fullName">
									</div>

						    	</div>

						    	<div class="form-group">

									<label for="passwordCrearCuenta" class="control-label col-sm-2" >Email:<strong class="informacionObligatoria">*</strong></label>
									<div class="col-xs-4">
									    <input type="text" class="form-control"  placeholder="Enter your Email" name="email">
									</div>

						    	</div>

						    	<div class="form-group">

									<label for="passwordCrearCuenta" class="control-label col-sm-2" >password:<strong class="informacionObligatoria">*</strong> </label>
									<div class="col-xs-4">
									    <input type="password" class="form-control" placeholder="Enter your Password" name="password">
									</div>

						    	</div>

						    	<div class="form-group">

									<label for="passwordCrearCuenta" class="control-label col-sm-2" >Confirm password:<strong class="informacionObligatoria">*</strong> </label>
									<div class="col-xs-4">
									    <input type="password" class="form-control"  placeholder="Enter your Password" name="confirmPassword">
									</div>

						    	</div><br>


						    	<div class="form-group">
									<label for="typeOfUser" class="control-label col-sm-2" >Select a User Type:<strong class="informacionObligatoria">*</strong> </label><br>
									<div class="col-xs-2">

										<input onclick="check()" type="radio" name="typeUser" id="radioButtonClient" value="client"><strong>		Customer<strong><br>
	  									<input onclick="uncheck()" type="radio" name="typeUser" id="radioButtonCommerce" value="commerce">		Commerce<br><br>

									</div>
						    	</div>

							</fieldset>

							<div id="customerInformation">
								<fieldset class="scheduler-border" >
									<legend>Customer information</legend><br>


							    	<div class="form-group">

										<label for="idCrearCuenta" class="control-label col-sm-2" >Identification:<strong class="informacionObligatoria">*</strong></label>
										<div class="col-xs-4">
										    <input type="text" class="form-control"  placeholder="Format: #-####-####" name="customerIdentification">

										</div>

							    	</div><br>

							    	<div class="form-group">
										<label for="genderOfUser" class="control-label col-sm-2" >Select a Gender:<strong class="informacionObligatoria">*</strong> </label>
										<div class="col-xs-2">
											  <input type="radio" name="gender" value="male" checked> Male<br>
											  <input type="radio" name="gender" value="female"> Female<br><br>

										</div>
							    	</div>


							    	<div class="form-group">

										<label for="idCrearCuenta" class="control-label col-sm-2" >Birthdate:<strong class="informacionObligatoria">*</strong></label>


										<div class="col-xs-2">

											<input type="date" class="form-control" name="birthdateCustomer">

										</div>

							    	</div><br>

								</fieldset>

							</div>


							<div id="commerceInformation">
								<fieldset class="scheduler-border" >
									<legend>Commerce information</legend><br>

							    	<div class="form-group">

										<label for="identificationCommerceCrearCuenta" class="control-label col-sm-2" >Identification:<strong class="informacionObligatoria">*</strong> </label>
										<div class="col-xs-4">
										    <input type="text" class="form-control" placeholder="Format: #-###-######" maxlength="12" name="commerceIdentification">
										</div>

							    	</div>
							    	<div class="form-group">

										<label for="PhoneCommerceCrearCuenta" class="control-label col-sm-2" >Phone number:<strong class="informacionObligatoria">*</strong> </label>
										<div class="col-xs-4">
										    <input type="text" class="form-control" placeholder="Format: ####-##-##" maxlength="" name="commercePhoneNumber">
										</div>

							    	</div><br>
							    	<div class="form-group">

										<label for="logoCommerceCrearCuenta" class="control-label col-sm-2" >Insert the logotype: </label><br><br>

										<div class="col-xs-5">
										    <input id="inputFile" name="inputdim1[]" type="file" multiple class="file-loading" accept="image/*" name="commerceLogo">
										</div>
							    	</div><br><br>

								    <div class="form-group">
								        <label class="control-label col-xs-2">Description:</label>
								        <div class="col-xs-5">
								            <textarea rows="3" class="form-control" placeholder="Insert the Description of the Commerce" name="commerceDescription"></textarea>
								        </div>
								    </div>

								</fieldset>

							</div><br><br><br>

							<div class="container" id="acceptButton">
							  <input type="submit"  class="btn btn-primary btn-lg" value="Sign in">
							</div>

						</form>

						 {{ Form::close() }}



			  		</div>
				</div>
			</div>



		</main>

	</body>
</html>""")




