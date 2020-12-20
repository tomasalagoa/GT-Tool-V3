<?php
if (isset($_GET["username"])) {
    $user = str_replace("<", "", $_GET["username"]);
    echo "Your name is "."$user";
}
 ?>
