<?php
	session_start();
	$users = $_SESSION['users'];
?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<h2>
		<?php
		$name = $_GET['name'];
		$lastname = $_GET['lastname'];

		echo "Welcome ". $name. " " . $lastname . " to our site!";
		?>
	</h2>
</body>
</html>