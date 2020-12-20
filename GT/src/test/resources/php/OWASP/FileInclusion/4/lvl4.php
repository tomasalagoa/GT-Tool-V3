<?php
echo "</br></br>";

if (isset($_GET['file'])) {
    $secure4 = $_GET['file'];

    if ($secure4 != "1.php" && $secure4 != "2.php") {
        $secure4 = substr($secure4, 0, -4);
    }

    if (isset($secure4)) {
        include($secure4);
    }
}
?>
