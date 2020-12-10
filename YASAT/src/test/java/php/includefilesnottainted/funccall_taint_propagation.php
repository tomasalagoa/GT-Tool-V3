<?php
include "secondary_function.php";

function first($id)
{

    $sql = "SELECT username FROM users WHERE id =";
    $sql = second(null, $id);
    return mysql_query($sql);
}

