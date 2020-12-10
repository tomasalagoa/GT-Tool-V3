<?php
if (isset($_GET["username"])) {
    $values = array("script", "prompt", "alert", "h1");

 	$user = str_replace($values, " ",$_GET["username"]);
	$user = preg_replace("/<(.*)[S,s](.*)[C,c](.*)[R,r](.*)[I,i](.*)[P,p](.*)[T,t]>/i", "", $_GET["username"]);
	echo "$user";
}

 ?>
