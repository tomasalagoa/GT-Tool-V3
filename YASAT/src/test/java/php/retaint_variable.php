<?php

function first($id)
{

    $sql = "SELECT username FROM users WHERE id =  $id";
    $sql = $id;
    return mysql_query($sql);

}