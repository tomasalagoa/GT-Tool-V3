<?php
function first($id)
{
    $sql = "SELECT username FROM users WHERE id =  $id";
    $sql = 2;
    return mysql_query($sql);
}