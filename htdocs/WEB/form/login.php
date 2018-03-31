<?php
	session_start();
	$users = array();

	if ($_SERVER["REQUEST_METHOD"] != "POST"){
		//session_unset();
		$_SESSION['users'] = array();
	}
	else
	{	//session_unset();
		global $users;
		$users = $_SESSION['users'];
	}
?>

<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
</head>
<body>
	<?php

		$username = "";
		$password = "";

		if ($_SERVER["REQUEST_METHOD"] == "POST"){

			if(isset($_POST['username']))
				$username = $_POST['username'];

			if(isset($_POST['password']))
				$password = $_POST['password'];

			if(!empty($username) && !empty($password))
			//validate credentials
				validateUser();
		}

		function validateUser(){
			global $users, $username, $password;
			$count = count($users);
			$found = false;

			for ($row=0; $row < $count; $row++) { 
					$user = $users[$row];

					if($user[3] == $username
						&& $user[4] == $password){
						$found = true;
							echo "<script>location.href='main.php?name=".$user[0]."&lastname=".$user[1]."</script>";
							break;
					}
				}

			if(!$found)	{
				echo "<strong>Login error</strong>";
			}
		}
	?>

	<h3>Login</h3>

	<form name="login-form" method="post" action="login.php">
		Username : <input type="text" name="username" value=<?php echo $username ?>> <br>
		Password : <input type="password" name="password" value=<?php echo $password ?>> <br>
		<input type="submit" value="Login">
		
	</form> 

	<form name="register-form" method="post" action="register.php">
		<input type="submit" value="Register">
	</form>
</body>
</html>