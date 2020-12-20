<?php


function first($id)
{

    $sql = "SELECT username FROM users WHERE id =  $id";
    $sql = second($id, null);
    return mysql_query($sql);
}

function second($arg1, $arg2)
{
    $arg1 = sanitize($arg1);
    return $arg1;
}