<?php
function first($id)
{
    $sql = "SELECT username FROM users WHERE id =  $id";
    return mysql_query($sql);
}