<?php
echo "</br></br>";

if (isset($_GET['file'])) {
    @include($_GET['file']);
    echo "<div align='center'><b><h5>" . $_GET['file'] . "</h5></b></div> ";
}
?>

