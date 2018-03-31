<?php
		session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
</head>
<body>
	<?php

		$name = "";
		$lastname = "";
		$age = 0;
		$username = "";
		$password = "";
	
		if ($_SERVER["REQUEST_METHOD"] == "POST"){

			$valid = true;

			if(isset($_POST['name']))
				$name = $_POST['name'];
			else $valid = false;
				
			if(isset($_POST['lastname']))
				$lastname = $_POST['lastname'];
			else $valid = false;

			if(isset($_POST['age']))
				$age = $_POST['age'];
			else $valid = false;

			if(isset($_POST['username']))
				$username = $_POST['username'];
			else $valid = false;

			if(isset($_POST['password']))
				$password = $_POST['password'];
			else $valid = false;

			//Form is valid to be processed
			if($valid)
			{
				$user = array($name, $lastname, $age, $username, $password);

				insertUser($user);
			}
		}

		function insertUser($user){
			$count = count($_SESSION['users']);
			array_push($_SESSION['users'], $user);

			if($count < count($_SESSION['users'])){
				echo "User was added successfuly! Please go to Login";
			}
		}
	?>

	<h3>Register</h3>

	<form name="register-form" method="post" action="register.php">
		Name : <input type="text" name="name" value=<?php echo $name ?>> <br>
		Lastname : <input type="text" name="lastname" value=<?php echo $lastname ?>> <br>
		Age : <input type="text" name="age" value=<?php echo $age ?>> <br>
		Username : <input type="text" name="username" value=<?php echo $username ?>> <br>
		Password : <input type="password" name="password" value=<?php echo $password ?>> <br>
		<input type="submit" value="Register">
	</form>

	<form name="login" method="post" action="login.php">
		<input type="submit" value="Go to login">
	</form>
</body>
</html>