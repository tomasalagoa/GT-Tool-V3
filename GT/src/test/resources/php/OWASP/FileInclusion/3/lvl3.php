<?php
echo "</br></br>";

if (isset($_GET['file'])) {
    $secure3 = $_GET['file'];
    $secure3 = strtolower($secure3);

    $secure3 = str_replace(array("http://", "https://"), "", $secure3);
    $secure3 = str_replace(array(":", "/", "..\\", "../"), "", $secure3);

    if (isset($secure3)) {
        include($secure3 . ".php");
    }
}
?>




