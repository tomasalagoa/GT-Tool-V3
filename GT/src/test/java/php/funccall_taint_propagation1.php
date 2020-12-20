<?php


function first($id)
{

    $sql = "SELECT username FROM users WHERE id =  $id";
    $sql = second(null, $id);
    return mysql_query($sql);
}

function second($arg1, $arg2)
{
    return $arg1;
}