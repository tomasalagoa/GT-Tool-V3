<?php


function first($id)
{

    $sql = "SELECT username FROM users WHERE id =";
    $sql = second($id, null);
    return mysql_query($sql);
}

function second($arg1, $arg2)
{
    return $arg1;
}