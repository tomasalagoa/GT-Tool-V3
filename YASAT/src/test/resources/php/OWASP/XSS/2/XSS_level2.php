<?php
if (isset($_GET["username"])) {
 	$user = str_replace("<script>", "",$_GET["username"]);
	echo "Your name is "."$user";
}
?>