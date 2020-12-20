<?php
include "secondary_function.php";

function first($id)
{

    $sql = "SELECT username FROM users WHERE id =";
    $sql = second($id, null);
    return mysql_query($sql);
}

