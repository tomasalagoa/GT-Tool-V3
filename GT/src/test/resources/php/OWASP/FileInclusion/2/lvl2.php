<?php
echo "</br></br>";

if (isset($_GET['file'])) {
    $secure2 = $_GET['file'];

    $secure2 = str_replace(array("..\\", ".\\", " ./", "../"), "", $secure2);
    $secure2 = str_replace(array("http://", "https://"), "", $secure2);

    if (isset($secure2)) {
        @include($secure2);
        echo "<div align='center'><b><h5>" . $secure2 . "</h5></b></div> ";
    }
}
?>
